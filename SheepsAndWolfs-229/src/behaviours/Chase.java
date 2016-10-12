package behaviours;
import main.*;
import onscreen.*;

public class Chase implements Behaviour {
  onscreen.Characters target;
  
  public Chase(onscreen.Characters target){this.target = target;}

  public Cell execute(Cell location){
    return Stage.getInstance().oneCellCloserTo(location, target.getLocation());
  }

}