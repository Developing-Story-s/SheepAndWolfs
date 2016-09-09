package onscreen;

import main.*;

public class Sheep extends Character {
    public Sheep(Stage stage, Cell location){
        super(stage, location, new java.awt.Color(255,255,255), new java.awt.Color(224, 224, 224), new behaviours.Chase(stage.shepherd));
    }
}
