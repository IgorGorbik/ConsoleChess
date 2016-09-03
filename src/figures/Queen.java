package figures;

public class Queen extends Figure {

    public Queen(int x, int y, boolean isWhite) {
	super(x, y, isWhite);
    }

    @Override
    public void print() {
        
	if(isWhite()) {
            System.out.print("Q");
        } else {
            System.out.print("q");
        }
                
    }

}

