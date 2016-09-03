package figures;

public class King extends Figure {

    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public void print() {
            
        if(isWhite()) {
            System.out.print("K");}
        else {
            System.out.print("k");
        }
                
    }

}

