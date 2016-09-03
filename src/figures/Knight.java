package figures;

public class Knight extends Figure {

    public Knight(int x, int y, boolean isWhite) {
	super(x, y, isWhite);
    }

    @Override
    public void print() {
        
	if(isWhite()) {
            System.out.print("N");
        } else {
            System.out.print("n");
        }
                
    }

}

