package onscreen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import behaviours.Behaviour;

public abstract class Characters implements MouseObserver {
  protected Cell location;
  protected Color myColour;
  protected Color mySelectedColour;
  protected Color myBorderColour;
  protected Behaviour behaviour;

  public Characters(){}
  public Characters( Cell location, Color c, Color sc, Behaviour behaviour){
    this.location         = location;
    this.myColour         = c;
    this.myBorderColour   = c;  // by default it is the same, it changes when the character is hightlighted
    this.mySelectedColour = sc;
    this.behaviour        = behaviour;
  }

  public Cell getLocation(){return location;}
  public void setLocation(Cell loc){location = loc;}

  public void setBehaviour(Behaviour b) {behaviour = b;}

  public Behaviour getBehaviour() {return behaviour ;}
  
  
  public void draw(Graphics g) {
    g.setColor(myColour);
    g.fillRect(location.getTopLeft().x,location.getTopLeft().y,35,35);
    g.setColor(myBorderColour);
    g.drawRect(location.getTopLeft().x,location.getTopLeft().y,35,35);
  }

  // The argument is the stage on which to act.  Every actor needs a stage
  public void act(){
    location = behaviour.execute(location);
  }

  public void mouseLeft(MouseEvent e){
    myBorderColour = myColour;
  }

  public void mouseEntered(MouseEvent e){
    myBorderColour = mySelectedColour;
  }

  public void mouseClicked(MouseEvent e){
  }

  public Rectangle getBounds(){return location.getBounds();}




}


