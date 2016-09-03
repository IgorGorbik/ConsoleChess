package checkturn;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Parser {

    private Scanner s;
    private String str;

    private ArrayList<ArrayList<Integer>> coord = new ArrayList<>();

    private static Parser p;

    private Parser() {

        coord.add(new ArrayList<>());
        coord.add(new ArrayList<>());
        s = new Scanner(System.in);

    }

    public ArrayList<ArrayList<Integer>> parseMenu() {

        resetParser(coord);

        System.out.print("Пункт меню: ");

        try {
            str = s.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(-1);
        }

        if (str.length() == 1 && Character.isDigit(str.charAt(0))) {

            int i = Integer.parseInt(str);
            switch (i) {
                case 1:
                    coord.get(0).add(101);
                    break;
                case 2:
                    coord.get(0).add(100);
                    break;
                default:
                    resetParser(coord);
                    coord.get(0).add(99);
                    break;
            }

            return coord;

        }

        resetParser(coord);
        coord.get(0).add(99);

        return coord;

    }

    public ArrayList<ArrayList<Integer>> parse() {

        resetParser(coord);

        System.out.print("Координаты: ");

        try {
            str = s.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(-1);
        }

        if (str.length() < 5) {

            resetParser(coord);
            coord.get(0).add(99);
            return coord;

        }

        if (Character.isAlphabetic(str.charAt(0))
                && Character.isDigit(str.charAt(1))
                && Character.isWhitespace(str.charAt(2))
                && Character.isAlphabetic(str.charAt(3))
                && Character.isDigit(str.charAt(4))) {

            coord.get(0).add(8 - Integer.parseInt(str.substring(1, 2)));
            coord.get(1).add(8 - Integer.parseInt(str.substring(4, 5)));

            switch (str.charAt(0)) {
                case 'A':
                case 'a':
                    coord.get(0).add(0);
                    ;
                    break;
                case 'B':
                case 'b':
                    coord.get(0).add(1);
                    ;
                    break;
                case 'C':
                case 'c':
                    coord.get(0).add(2);
                    break;
                case 'D':
                case 'd':
                    coord.get(0).add(3);
                    break;
                case 'E':
                case 'e':
                    coord.get(0).add(4);
                    break;
                case 'F':
                case 'f':
                    coord.get(0).add(5);
                    break;
                case 'G':
                case 'g':
                    coord.get(0).add(6);
                    break;
                case 'H':
                case 'h':
                    coord.get(0).add(7);
                    break;
                default:

                    resetParser(coord);
                    coord.get(0).add(99);

            }

            switch (str.charAt(3)) {
                case 'A':
                case 'a':
                    coord.get(1).add(0);
                    break;
                case 'B':
                case 'b':
                    coord.get(1).add(1);
                    break;
                case 'C':
                case 'c':
                    coord.get(1).add(2);
                    break;
                case 'D':
                case 'd':
                    coord.get(1).add(3);
                    break;
                case 'E':
                case 'e':
                    coord.get(1).add(4);
                    break;
                case 'F':
                case 'f':
                    coord.get(1).add(5);
                    break;
                case 'G':
                case 'g':
                    coord.get(1).add(6);
                    break;
                case 'H':
                case 'h':
                    coord.get(1).add(7);
                    break;
                default:

                    resetParser(coord);
                    coord.get(0).add(99);
                    break;

            }

            if ((coord.get(0).get(0) < 0 || coord.get(0).get(0) > 7)
                    || (coord.get(1).get(0) < 0 || coord.get(1).get(0) > 7)) {
                resetParser(coord);
                coord.get(0).add(99);

            }

        } else {

            resetParser(coord);
            coord.get(0).add(99);

        }

        return coord;

    }

    public void resetParser(ArrayList<ArrayList<Integer>> coor) {

        coor.get(0).clear();
        coor.get(1).clear();

    }

    public static Parser getInstance() {

        if (p == null) {
            p = new Parser();
        }

        return p;

    }

    public void close() {
        s.close();
    }

}

