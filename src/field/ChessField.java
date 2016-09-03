package field;

import figures.Figure;
import figures.Bishop;
import figures.King;
import figures.Rook;
import figures.Queen;
import figures.Pawn;
import figures.NoFigure;
import figures.Knight;
import java.util.ArrayList;
import checkturn.Parser;
import chessdriver.FigureDriver;

public class ChessField {

    private final boolean white = true;
    private final boolean black = false;
    private boolean isRotated;

    private Figure rotateTemp;
    private Figure[][] chessBoard;

    private static ChessField cb;

    private static boolean turn;

    private static final int DIM = 8;

    private ChessField() {

        turn = white;
        isRotated = false;
        chessBoard = new Figure[8][8];

        for (int i = 0; i < DIM; ++i) {

            Figure[] r = chessBoard[i];

            switch (i) {
                case 0:
                    r[0] = new Rook(i, 0, black);
                    r[1] = new Knight(i, 1, black);
                    r[2] = new Bishop(i, 2, black);
                    r[3] = new Queen(i, 3, black);
                    r[4] = new King(i, 4, black);
                    r[5] = new Bishop(i, 5, black);
                    r[6] = new Knight(i, 6, black);
                    r[7] = new Rook(i, 7, black);
                    break;
                case 7:
                    r[0] = new Rook(i, 0, white);
                    r[1] = new Knight(i, 1, white);
                    r[2] = new Bishop(i, 2, white);
                    r[3] = new Queen(i, 3, white);
                    r[4] = new King(i, 4, white);
                    r[5] = new Bishop(i, 5, white);
                    r[6] = new Knight(i, 6, white);
                    r[7] = new Rook(i, 7, white);
                    break;
                case 1:
                    for (int j = 0; j < DIM; ++j) {
                        r[j] = new Pawn(i, j, black);
                    }
                    break;
                case 6:
                    for (int j = 0; j < DIM; ++j) {
                        r[j] = new Pawn(i, j, white);
                    }
                    break;
                default:
                    for (int j = 0; j < DIM; ++j) {
                        r[j] = new NoFigure(i, j);
                    }
                    break;
            }
        }
    }

    public void rotate() {

        for (int i = 0; i < DIM / 2; ++i) {
            for (int j = 0; j < DIM; ++j) {

                rotateTemp = chessBoard[i][j];
                chessBoard[i][j] = chessBoard[7 - i][7 - j];
                chessBoard[7 - i][7 - j] = rotateTemp;

            }
        }

    }

    public void printBoard() {

        System.out.println();

        if (isRotated) {
            System.out.println("      H   G   F   E   D   C   B   A");
        } else {
            System.out.println("      A   B   C   D   E   F   G   H");
        }

        System.out.println("    ---------------------------------");

        for (int i = 0; i < DIM; ++i) {

            if (isRotated) {
                System.out.print("  " + (i + 1) + " |");
            } else {
                System.out.print("  " + (8 - i) + " |");
            }

            for (int j = 0; j < DIM; ++j) {
                System.out.print(" ");
                chessBoard[i][j].print();
                System.out.print(" ");
                System.out.print("|");
            }

            if (!isRotated) {
                System.out.println(" " + (i + 1) + "\n    ---------------------------------");
            } else {
                System.out.println(" " + (8 - i) + "\n    ---------------------------------");
            }

        }

        if (isRotated) {
            System.out.println("      H   G   F   E   D   C   B   A");
        } else {
            System.out.println("      A   B   C   D   E   F   G   H");
        }

        System.out.println("\n  ************************************");

    }

    public boolean makeMove(ArrayList<Integer> from, ArrayList<Integer> to) {

        int x1 = from.get(0),
                y1 = from.get(1),
                x2 = to.get(0),
                y2 = to.get(1);

        Figure c1 = chessBoard[x1][y1];

        if (c1.getClass() == NoFigure.class) {
            return false;
        }

        if (c1.getClass() == Pawn.class) {
            FigureDriver.movePawn(x1, y1, x2, y2, chessBoard);
        } else if (c1.getClass() == Rook.class) {
            FigureDriver.moveRook(x1, y1, x2, y2, chessBoard);
        } else if (c1.getClass() == Knight.class) {
            FigureDriver.moveKnight(x1, y1, x2, y2, chessBoard);
        } else if (c1.getClass() == Bishop.class) {
            FigureDriver.moveBishop(x1, y1, x2, y2, chessBoard);
        } else if (c1.getClass() == Queen.class) {
            FigureDriver.moveQueen(x1, y1, x2, y2, chessBoard);
        } else if (c1.getClass() == King.class) {
            FigureDriver.moveKing(x1, y1, x2, y2, chessBoard);
        }

        if (turn == white) {
            turn = black;
        } else {
            turn = white;
        }

        return true;

    }

    public boolean isRotated() {
        return isRotated;
    }

    public static boolean whoseTurn() {
        return turn;
    }

    public void start() {

        int control = 0;
        boolean moveCont;

        Parser p = Parser.getInstance();

        ArrayList<ArrayList<Integer>> m;

        ArrayList<ArrayList<Integer>> mR = new ArrayList<>();
        mR.add(new ArrayList<>());
        mR.add(new ArrayList<>());

        init(p, control);

        while (true) {

            printBoard();
            m = p.parse();
            control = m.get(0).get(0);

            if (control == 99) {
                continue;
            }

            if (control == 10);
            if (control == 20);
            if (control == 30) {
                break;
            }

            if (whoseTurn() == black) {
                p.resetParser(mR);
                mR.get(0).add(7 - m.get(0).get(0));
                mR.get(0).add(7 - m.get(0).get(1));
                mR.get(1).add(7 - m.get(1).get(0));
                mR.get(1).add(7 - m.get(1).get(1));
                moveCont = makeMove(mR.get(0), mR.get(1));
            } else {
                moveCont = makeMove(m.get(0), m.get(1));
            }

            if (!moveCont) {
                continue;
            }

            isRotated = !isRotated;
            rotate();

        }

        cb = null;
        p.close();

    }

    private void init(Parser p, int control) {

        System.out.println("Начало игры");
        System.out.println("1 - начать\n2 - выход");

        OUTER:
        while (true) {
            control = p.parseMenu().get(0).get(0);
            switch (control) {
                case 99:
                    continue;
                case 101:
                    break OUTER;
                case 100:
                    p.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    public static ChessField getInstance() {

        if (cb == null) {
            cb = new ChessField();
        }

        return cb;

    }

}
