package figures;

public class NoFigure extends Figure {

    public NoFigure(int x, int y) {
        super(x, y);
    }

    @Override
    public void print() {
        System.out.print(" ");
    }

}

