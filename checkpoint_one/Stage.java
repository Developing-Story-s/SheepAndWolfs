import java.awt.*;

public class Stage {
    Grid grid;
    Sheep sheep;
    Wolf wolf;
    Shepherd shepherd;

    public Stage(){
        grid     = new Grid();
        sheep    = new Sheep(grid.giveMeRandomCell());
        wolf     = new Wolf(grid.giveMeRandomCell());
        shepherd = new Shepherd(grid.giveMeRandomCell());
    }

    public void draw(Graphics g, Point mouseLoc){
        grid    .draw(g, mouseLoc);
        sheep   .draw(g, mouseLoc);
        wolf    .draw(g, mouseLoc);
        shepherd.draw(g, mouseLoc);
    }

}
