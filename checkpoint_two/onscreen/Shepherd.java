package onscreen;

import main.*;
import java.awt.*;
import java.awt.event.*;

public class Shepherd extends Character {
    public Shepherd(Stage stage, Cell location){
        super(stage, location, new Color(0,153,0), new Color(0,255,0), new behaviours.Passive());
    }

    public void mouseClicked(MouseEvent e){
      stage.shepherd = new HighlightedCharacter(stage.shepherd);
    }

}

