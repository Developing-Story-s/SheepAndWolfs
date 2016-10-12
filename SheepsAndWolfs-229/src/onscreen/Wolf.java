package onscreen;


public class Wolf extends Characters {
    public Wolf(Cell location){
        super(location, new java.awt.Color(255,0,0), new java.awt.Color(153,0,0), new behaviours.Patrol());
    }
}
