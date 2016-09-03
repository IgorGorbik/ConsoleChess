package figures;

public abstract class Figure {
    
    private boolean isWhite;
    private int x;
    private int y;
	
    public Figure(int x, int y, boolean isWhite){
            
        setX(x);
        setY(y);
        setWhite(isWhite);
                
    }
	
    public Figure(int x, int y){
            
        setX(x);
        setY(y);
                
    }
	
    public abstract void print();

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
        
}

