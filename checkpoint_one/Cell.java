import java.awt.*;

class Cell{
	int x;
	int y;

  public Cell(int x, int y){
    this.x = x;
    this.y = y;
  }

  public void draw(Graphics g, Point mouseLoc){
    if (isMouseWithin(mouseLoc)){
      g.setColor(Color.DARK_GRAY);
      g.fillRect(x*35+10,y*35+10,35,35);
    } else {
      g.setColor(Color.GRAY);
      g.fillRect(x*35+10,y*35+10,35,35);
    }
  }

  public boolean isMouseWithin(Point mouseLoc){
    return ((x*35 + 10) < mouseLoc.getX()) && (((x+1)*35 + 10) > mouseLoc.getX()) && ((y*35 + 10) < mouseLoc.getY()) && (((y+1)*35 + 10) > mouseLoc.getY());
  }

  public Point getTopLeft(){
    return new java.awt.Point(x*35+10, y*35+10);
  }

}