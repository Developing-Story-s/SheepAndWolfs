package onscreen;

import main.*;

public class Wolf extends Character {
    public Wolf(Stage stage, Cell location){
        super(stage, location, new java.awt.Color(255,0,0), new java.awt.Color(153,0,0), new behaviours.Chase(stage.sheep));
    }
}
