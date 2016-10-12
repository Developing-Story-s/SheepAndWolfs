package behaviours;

import java.util.Random;

import main.Stage;
import onscreen.Cell;

public class RandomBehaviour implements Behaviour{
	int r ;
	@Override
	public Cell execute(Cell location) {
		r = new Random().nextInt(40);

		if(r>=0 && r <= 10){
			location.x ++;
			location.y ++;
		}
		if(r>10 && r <= 20){
			location.x ++;
			location.y --;
		}
		if(r>20 && r <= 30){
			location.x --;
			location.y ++;
		}
		if(r>30 && r <= 40){
			Stage.getInstance().grid.getCell(location.x -1, location.y-1);
		}
		return (location);
	}
	
	private boolean isOutOfBounds(Cell loc){
		int x = loc.x;
		if(x < 1)	
			return true;
		else if(x > 18)	
			return false;
		else return false;
	}
	
	private Cell randomRun(Cell location){



		return null;
	}

}
