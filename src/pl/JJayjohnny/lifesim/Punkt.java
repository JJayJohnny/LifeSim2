package pl.JJayjohnny.lifesim;

public class Punkt {
    int x, y;
    Punkt(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+y+","+x+")";
    }
}