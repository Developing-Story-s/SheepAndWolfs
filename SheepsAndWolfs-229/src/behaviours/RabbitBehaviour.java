package behaviours;

import lib.Rabbit;
import main.Stage;
import onscreen.Cell;

public class RabbitBehaviour implements Behaviour{
	Rabbit rab = new Rabbit();
	
	public Cell execute(Cell location){
		location = Stage.getInstance().getAdjacent(location, rab.nextMove());
		switch (rab.nextMove()){
		case 0:
			location = Stage.getInstance().getAdjacent(location, 0);
			break;
		case 1:
			location = Stage.getInstance().getAdjacent(location, 1);
			break;
		case 2:
			location = Stage.getInstance().getAdjacent(location, 2);
			break;
		case 3:
			location = Stage.getInstance().getAdjacent(location, 3);
			break;
		default:
			location = Stage.getInstance().getAdjacent(location, 8);
			break;
		}//end switch()
		return location;
	}

}
