package behaviours;

import java.util.Random;

import main.Stage;
import onscreen.Cell;

public class RandomBehaviour implements Behaviour{
	int r ;
	int move = 1;
	@Override
	public Cell execute(Cell location) {
		location = Stage.getInstance().getAdjacent(location, new Random().nextInt(7));
		return (location);
	}

}
