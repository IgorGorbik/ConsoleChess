package figures;

public class Bishop extends Figure {

    public Bishop(int x, int y, boolean isWhite) {
	super(x, y, isWhite);
    }

    @Override
    public void print() {
        
	if(isWhite()) {
            System.out.print("B");
        } else {
            System.out.print("b");
        }
                
    }

}
