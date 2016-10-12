package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import onscreen.Cell;
import onscreen.MouseObserver;
import onscreen.Sheep;
import onscreen.Shepherd;
import onscreen.Wolf;
import behaviours.Chase;
import behaviours.RabbitAdapter;

public class Stage extends    javax.swing.JPanel 
                   implements MouseListener,
                              MouseMotionListener {
	public Grid grid;
	public onscreen.Characters sheep;
	public onscreen.Characters wolf;
	public onscreen.Characters shepherd;
	public onscreen.Characters rabbit;
	public boolean readyToStep;
	public static Stage stageInstance = new Stage();
	
	Point lastMouseLoc = new Point(0, 0);
	Cell mouseWasIn = null;

	List<MouseObserver> observers = new ArrayList<MouseObserver>();

	private Stage() {
		readyToStep = false;
		grid = new Grid();
		
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
				registerMouseObserver(grid.getCell(i,j));
		

		shepherd = new Shepherd(grid.giveMeRandomCell());
		sheep    = new Sheep(grid.giveMeRandomCell());
		wolf     = new Wolf(grid.giveMeRandomCell());
		rabbit 	 = new RabbitAdapter(grid.giveMeRandomCell());
		
		registerMouseObserver(shepherd);

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public static Stage getInstance(){
		return stageInstance;
	}
	
	public void paint(Graphics g) {
		draw(g);
	}

	public void draw(Graphics g) {
		grid.draw(g);
		sheep.draw(g);
		rabbit.draw(g);
		wolf.draw(g);
		shepherd.draw(g);
	
		if (result()){
			g.setColor(Color.BLACK);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
			g.drawString("Game Over!", 200,200);
		}
	}

	public void step() {
		
		if(isCloseTo(sheep.getLocation(), shepherd.getLocation()))
			sheep.setBehaviour(new Chase(shepherd));
		
		if(isCloseTo(wolf.getLocation(), sheep.getLocation()))
			wolf.setBehaviour(new Chase(sheep));

		sheep.act();
		wolf.act();
		rabbit.act();
		readyToStep = false;
	}
	
	public boolean isCloseTo(Cell location, Cell ch){
		int distance = location.distanceTo(ch);
		if(distance > 4) return false;
		else return true;
	}

	public void registerMouseObserver(MouseObserver mo) {
		observers.add(mo);
	}

	public Cell oneCellCloserTo(Cell from, Cell to) {
		int xdiff = to.x - from.x;
		int ydiff = to.y - from.y;
		return grid.getCell(from.x + Integer.signum(xdiff), from.y + Integer.signum(ydiff));
	}
	
	public Cell getAdjacent(Cell cell, int direction){
		switch (direction) {
		case 0:		return grid.getCell(cell.x + 1, cell.y);
		case 1:		return grid.getCell(cell.x, cell.y +1);
		case 2: 	return grid.getCell(cell.x-1, cell.y);
		case 3:		return grid.getCell(cell.x, cell.y-1);
		case 4:		return grid.getCell(cell.x+1, cell.y+1);
		case 5:		return grid.getCell(cell.x-1, cell.y);
		case 6:		return grid.getCell(cell.x-1, cell.y-1);
		case 7:		return grid.getCell(cell.x+1, cell.y-1);
		default:	return cell;
		}//end switch()	
		
	}//end getAdjacent()

	// implementation of MouseListener and MouseMotionListener
	public void mouseClicked(MouseEvent e){
		if (shepherd.getBounds().contains(e.getPoint())){
		  shepherd.mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseMoved(MouseEvent e){
		for (MouseObserver mo : observers) {
			Rectangle bounds = mo.getBounds();
			if(bounds.contains(e.getPoint())) {
				mo.mouseEntered(e);
			} else if (bounds.contains(lastMouseLoc)) {
				mo.mouseLeft(e);
			}
		}
		lastMouseLoc = e.getPoint();
	}

  public boolean result(){
  	if (shepherd.getLocation().equals(wolf.getLocation())){
  		return true;
  	}else if (wolf.getLocation().equals(sheep.getLocation())){
  		return true;
  	} else {
  		return false;
  	}
  }
}
