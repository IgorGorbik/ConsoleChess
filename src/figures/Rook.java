package figures;

public class Rook extends Figure {

    public Rook(int x, int y, boolean isWhite){
        super(x, y, isWhite);
    }
	
    @Override
    public void print() {
        
	if(isWhite()) {
            System.out.print("R");
        } else {
            System.out.print("r");
        }
                
    }

}

