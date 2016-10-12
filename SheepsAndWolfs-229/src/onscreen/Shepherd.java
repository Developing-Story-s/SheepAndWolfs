package onscreen;

import main.*;
import java.awt.*;
import java.awt.event.*;

public class Shepherd extends Characters {
    public Shepherd(Cell location){
        super(location, new Color(0,153,0), new Color(0,255,0), new behaviours.Passive());
    }

    public void mouseClicked(MouseEvent e){
      Stage.getInstance().shepherd = new HighlightedCharacter(Stage.getInstance().shepherd);
    }

}

