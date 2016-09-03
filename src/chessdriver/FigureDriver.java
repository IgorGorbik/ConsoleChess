package chessdriver;

import figures.Figure;
import figures.NoFigure;

public class FigureDriver {

    public static void moveKing(int fx, int fy, int lx, int ly, Figure cb[][]) {

        if (fx > 7 || fx < 0 || fy > 7 || fy < 0 || lx > 7 || lx < 0 || ly > 7 || ly < 0) {
            System.out.println("Неправильный ход!");
        } else if (cb[lx][ly].getClass() == NoFigure.class && ((lx - fx == 1
                && ly == fy) || (lx == fx && ly - fy == 1) || (fx - lx == 1
                && ly == fy) || (lx == fx && fy - ly == 1)
                || (lx == fx + 1 && ly == fy + 1) || (lx == fx - 1 && ly == fy - 1)
                || (lx == fx - 1 && ly == fy + 1)
                || (lx == fx + 1 && ly == fy - 1))) {

            cb[lx][ly] = cb[fx][fy];
            cb[fx][fy] = new NoFigure(fx, fy);

        } else {
            System.out.println("Неправильный ход!");
        }

    }

    public static void moveQueen(int fx, int fy, int lx, int ly, Figure cb[][]) {

        if (fx > 7 || fx < 0 || fy > 7 || fy < 0 || lx > 7 || lx < 0 || ly > 7 || ly < 0) {
            System.out.println("Неправильный ход!");
        } else {

            int count = 1;
            int i = 1;

            if (lx == fx) {

                i = Math.abs(ly - fy);

                if (lx == fx && ly == fy + i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx][fy + k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx && ly == fy - i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx][fy - k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else if (fy == ly) {

                i = Math.abs(lx - fx);

                if (lx == fx + i && ly == fy) {

                    for (int k = 1; k < i; k++) {
                        if (cb[fx + k][fy].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx - i && ly == fy) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx - k][fy].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else if (Math.abs(lx - fx) == Math.abs(ly - fy)) {

                i = Math.abs(lx - fx);

                if (lx == fx + i && ly == fy + i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx + k][fy + k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx - i && ly == fy + i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx - k][fy + k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx + i && ly == fy - i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx + k][fy - k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx - i && ly == fy - i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx - k][fy - k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                }
            } else {
                System.out.println("Неправильный ход!");
            }

        }

    }

    public static void moveRook(int fx, int fy, int lx, int ly, Figure cb[][]) {

        if (fx > 7 || fx < 0 || fy > 7 || fy < 0 || lx > 7 || lx < 0 || ly > 7 || ly < 0) {
            System.out.println("Неправильный ход!");
        } else {

            int count = 1;
            if (lx == fx) {

                int i = Math.abs(ly - fy);

                if (lx == fx && ly == fy + i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx][fy + k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx && ly == fy - i) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx][fy - k].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else {
                    System.out.println("Неправильный ход!");
                }
            } else if (fy == ly) {

                int i = Math.abs(lx - fx);

                if (lx == fx + i && ly == fy) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx + k][fy].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else if (lx == fx - i && ly == fy) {

                    for (int k = 1; k < i; k++) {

                        if (cb[fx - k][fy].getClass() == NoFigure.class) {
                            count++;
                        } else {
                            break;
                        }

                    }

                    if (count == i) {

                        cb[lx][ly] = cb[fx][fy];
                        cb[fx][fy] = new NoFigure(fx, fy);

                    } else {
                        System.out.println("Неправильный ход!");
                    }

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else {
                System.out.println("Неправильный ход!");
            }

        }

    }

    public static void moveKnight(int fx, int fy, int lx, int ly, Figure cb[][]) {

        if (fx > 7 || fx < 0 || fy > 7 || fy < 0 || lx > 7 || lx < 0 || ly > 7
                || ly < 0) {
            System.out.println("Неправильный ход!");
        } else if (((lx == fx + 1 && ly == fy + 2) || (lx == fx + 1 && ly == fy - 2)
                || (lx == fx - 1 && ly == fy - 2) || (lx == fx - 1
                && ly == fy + 2) || (lx == fx + 2 && ly == fy + 1)
                || (lx == fx - 2 && ly == fy + 1) || (lx == fx + 2
                && ly == fy - 1) || (lx == fx - 2 && ly == fy - 1))) {

            cb[lx][ly] = cb[fx][fy];
            cb[fx][fy] = new NoFigure(fx, fy);

        } else {
            System.out.println("Неправильный ход!");
        }

    }

    public static void moveBishop(int fx, int fy, int lx, int ly, Figure cb[][]) {

        if (fx > 7 || fx < 0 || fy > 7 || fy < 0 || lx > 7 || lx < 0 || ly > 7 || ly < 0) {
            System.out.println("Неправильный ход!");
        } else {

            int count = 1;
            int i = Math.abs(lx - fx);

            if (lx == fx + i && ly == fy + i) {

                for (int k = 1; k < i; k++) {

                    if (cb[fx + k][fy + k].getClass() == NoFigure.class) {
                        count++;
                    } else {
                        break;
                    }

                }

                if (count == i) {

                    cb[lx][ly] = cb[fx][fy];
                    cb[fx][fy] = new NoFigure(fx, fy);

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else if (lx == fx - i && ly == fy + i) {

                for (int k = 1; k < i; k++) {

                    if (cb[fx - k][fy + k].getClass() == NoFigure.class) {
                        count++;
                    } else {
                        break;
                    }

                }

                if (count == i) {

                    cb[lx][ly] = cb[fx][fy];
                    cb[fx][fy] = new NoFigure(fx, fy);

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else if (lx == fx + i && ly == fy - i) {

                for (int k = 1; k < i; k++) {

                    if (cb[fx + k][fy - k].getClass() == NoFigure.class) {
                        count++;
                    } else {
                        break;
                    }

                }

                if (count == i) {

                    cb[lx][ly] = cb[fx][fy];
                    cb[fx][fy] = new NoFigure(fx, fy);

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else if (lx == fx - i && ly == fy - i) {

                for (int k = 1; k < i; k++) {
                    if (cb[fx - k][fy - k].getClass() == NoFigure.class) {
                        count++;
                    } else {
                        break;
                    }

                }

                if (count == i) {

                    cb[lx][ly] = cb[fx][fy];
                    cb[fx][fy] = new NoFigure(fx, fy);

                } else {
                    System.out.println("Неправильный ход!");
                }

            } else {
                System.out.println("Неправильный ход!");
            }
        }

    }

    public static void movePawn(int fx, int fy, int lx, int ly, Figure cb[][]) {

        if (fx > 7 || fx < 0 || fy > 7 || fy < 0 || lx > 7 || lx < 0 || ly > 7 || ly < 0) {
            System.out.println("Неправильный ход!");
        } else if (fx == 6 && fx - lx <= 2 && fx - lx > 0) {

            if (fx - lx == 1 && (fy - ly == 1 || ly - fy == 1) && cb[lx][ly].getClass() != NoFigure.class) {

                cb[lx][ly] = new NoFigure(lx, ly);
                cb[lx][ly] = cb[fx][fy];
                cb[fx][fy] = new NoFigure(fx, fy);

            } else if (fy == ly && ((fx - lx == 1 && cb[lx][ly].getClass() == NoFigure.class)
                    || (fx - lx == 2 && cb[lx][ly].getClass() == NoFigure.class
                    && cb[lx + 1][ly].getClass() == NoFigure.class))) {

                cb[lx][ly] = cb[fx][fy];
                cb[fx][fy] = new NoFigure(fx, fy);

            } else {
                System.out.println("Неправильный ход!");
            }

        } else if (fx - lx == 1) {

            if ((fy - ly == 1 || ly - fy == 1) && cb[lx][ly].getClass() != NoFigure.class) {

                cb[lx][ly] = new NoFigure(lx, ly);
                cb[lx][ly] = cb[fx][fy];
                cb[fx][fy] = new NoFigure(fx, fy);

            } else if (fy == ly && cb[lx][ly].getClass() == NoFigure.class) {

                cb[lx][ly] = cb[fx][fy];
                cb[fx][fy] = new NoFigure(fx, fy);

            } else {
                System.out.println("Неправильный ход!");
            }

        } else {
            System.out.println("Неправильный ход!");
        }
    }

}
