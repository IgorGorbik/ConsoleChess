package finishcontroll;

import figures.Figure;
import figures.Bishop;
import figures.King;
import figures.Rook;
import figures.Queen;
import figures.Pawn;
import figures.NoFigure;
import figures.Knight;

public class CheckMate {

    public static boolean isCheckMate(int fx, int fy, King k, Figure cb[][]) {

        boolean colour = k.isWhite();

        int i = fx;
        int j = fy;

        if (i + 2 < 8 && j + 1 < 8 && cb[i + 2][j + 1].getClass() == Knight.class && cb[i + 2][j + 1].isWhite() != colour) {
            return true;
        } else if (i + 2 < 8 && j - 1 >= 0 && cb[i + 2][j - 1].getClass() == Knight.class && cb[i + 2][j - 1].isWhite() != colour) {
            return true;
        } else if (i - 2 >= 0 && j + 1 < 8 && cb[i - 2][j + 1].getClass() == Knight.class && cb[i - 2][j + 1].isWhite() != colour) {
            return true;
        } else if (i - 2 >= 0 && j - 1 >= 0 && cb[i - 2][j - 1].getClass() == Knight.class && cb[i - 2][j - 1].isWhite() != colour) {
            return true;
        } else if (i + 1 < 8 && j + 2 < 8 && cb[i + 1][j + 2].getClass() == Knight.class && cb[i + 1][j + 2].isWhite() != colour) {
            return true;
        } else if (i + 1 < 8 && j - 2 >= 0 && cb[i + 1][j - 2].getClass() == Knight.class && cb[i + 1][j - 2].isWhite() != colour) {
            return true;
        } else if (i - 1 >= 0 && j + 2 < 8 && cb[i - 1][j + 2].getClass() == Knight.class && cb[i - 1][j + 2].isWhite() != colour) {
            return true;
        } else if (i - 1 >= 0 && j - 2 >= 0 && cb[i - 1][j - 2].getClass() == Knight.class && cb[i - 1][j - 2].isWhite() != colour) {
            return true;
        }

        if (i + 1 < 8 && j - 1 >= 0 && cb[i + 1][j - 1].isWhite() != colour && (cb[i + 1][j - 1].getClass() == Pawn.class)) {
            return true;
        } else if (i - 1 >= 0 && j - 1 >= 0 && cb[i - 1][j - 1].isWhite() != colour && (cb[i + 1][j - 1].getClass() == Pawn.class)) {
            return true;
        }

        while (i + 1 < 8 && j + 1 < 8) {
            if (cb[i + 1][j + 1].isWhite() != colour && (cb[i + 1][j + 1].getClass() == Queen.class || cb[i + 1][j + 1].getClass() == Bishop.class)) {
                return true;
            } else if (cb[i + 1][j + 1].getClass() != NoFigure.class) {
                break;
            }
            i++;
            j++;
        }
        i = fx;
        j = fy;

        while (i + 1 < 8 && j - 1 >= 0) {
            if (cb[i + 1][j - 1].isWhite() != colour && (cb[i + 1][j - 1].getClass() == Queen.class || cb[i + 1][j - 1].getClass() == Bishop.class)) {
                return true;
            } else if (cb[i + 1][j - 1].getClass() != NoFigure.class) {
                break;
            }
            i++;
            j--;
        }
        i = fx;
        j = fy;

        while (i - 1 >= 0 && j + 1 < 8) {
            if (cb[i - 1][j + 1].isWhite() != colour && (cb[i - 1][j + 1].getClass() == Queen.class || cb[i - 1][j + 1].getClass() == Bishop.class)) {
                return true;
            } else if (cb[i - 1][j + 1].getClass() != NoFigure.class) {
                break;
            }
            i--;
            j++;
        }
        i = fx;
        j = fy;

        while (i - 1 >= 0 && j - 1 >= 0) {
            if (cb[i - 1][j - 1].isWhite() != colour && (cb[i - 1][j - 1].getClass() == Queen.class || cb[i + 1][j + 1].getClass() == Bishop.class)) {
                return true;
            } else if (cb[i - 1][j - 1].getClass() != NoFigure.class) {
                break;
            }
            i--;
            j--;
        }

        i = fx;
        j = fy;

        while (j - 1 >= 0) {
            if (cb[i][j - 1].isWhite() != colour && (cb[i][j - 1].getClass() == Queen.class || cb[i + 1][j + 1].getClass() == Rook.class)) {
                return true;
            } else if (cb[i][j - 1].getClass() != NoFigure.class) {
                break;
            }
            j--;
        }

        j = fy;

        while (j + 1 < 8) {
            if (cb[i][j + 1].isWhite() != colour && (cb[i][j + 1].getClass() == Queen.class || cb[i + 1][j + 1].getClass() == Rook.class)) {
                return true;
            } else if (cb[i][j + 1].getClass() != NoFigure.class) {
                break;
            }
            j++;
        }
        j = fy;

        while (i - 1 >= 0) {
            if (cb[i - 1][j].isWhite() != colour && (cb[i - 1][j].getClass() == Queen.class || cb[i + 1][j + 1].getClass() == Rook.class)) {
                return true;
            } else if (cb[i - 1][j].getClass() != NoFigure.class) {
                break;
            }
            i--;
        }

        i = fx;

        while (i + 1 < 8) {
            if (cb[i + 1][j].isWhite() != colour && (cb[i + 1][j].getClass() == Queen.class || cb[i + 1][j + 1].getClass() == Rook.class)) {
                return true;
            } else if (cb[i + 1][j].getClass() != NoFigure.class) {
                break;
            }
            i++;
        }
        i = fx;

        return false;
    }
}

