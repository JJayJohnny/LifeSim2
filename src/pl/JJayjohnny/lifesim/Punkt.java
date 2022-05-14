package pl.JJayjohnny.lifesim;

public class Punkt {
    public int x, y;
    public Punkt(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+y+","+x+")";
    }
}
