package figures;

public class Pawn extends Figure {

    public Pawn(int x, int y, boolean isWhite) {
	super(x, y, isWhite);
    }

    @Override
    public void print() {
        
	if(isWhite()) {
            System.out.print("P");
        } else {
            System.out.print("p");
        }

    }

}

