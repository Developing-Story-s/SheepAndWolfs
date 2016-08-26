import java.awt.*;

public abstract class Character {
  protected Cell location;
  protected Color myColour;
  protected Color mySelectedColour;

  public Character(Cell location, Color c, Color sc){
    this.location         = location;
    this.myColour         = c;
    this.mySelectedColour = sc;
  }

  public void draw(Graphics g, Point mouseLoc) {
    if (location.isMouseWithin(mouseLoc)) {
      g.setColor(mySelectedColour);
      g.fillRect(location.getTopLeft().x,location.getTopLeft().y,35,35);
    } else {
      g.setColor(myColour);
      g.fillRect(location.getTopLeft().x,location.getTopLeft().y,35,35);
    }
  }

}


