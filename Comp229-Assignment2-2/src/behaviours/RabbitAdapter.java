package behaviours;

import onscreen.Cell;
import onscreen.Characters;
import lib.Rabbit;
import main.Stage;

public class RabbitAdapter extends Characters {
	private Rabbit rab ;

	public RabbitAdapter(Cell location){
		super(location, new java.awt.Color(128,0,128), new java.awt.Color(153,0,0), new behaviours.RabbitBehaviour());
		this.rab = new Rabbit();
	}



}
