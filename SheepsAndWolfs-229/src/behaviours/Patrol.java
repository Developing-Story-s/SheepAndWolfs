package behaviours;

import onscreen.Cell;

public class Patrol implements Behaviour{
	 int m = 1;
	public Patrol(){ }
	
	@Override
	public Cell execute(Cell location) {
		return patrol(location);
	}
	
	private Cell patrol(Cell location){
		int x = location.x;
 		if(x < 1)	m = 1;
		else if(x > 18)	m = -1;
		return new Cell(location.x + m, location.y);
	}
	
	
	

}
