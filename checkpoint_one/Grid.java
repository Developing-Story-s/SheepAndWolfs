import java.awt.*;

class Grid{
	Array2D<Cell> cells = new Array2D<Cell>(20,20);
	public Grid(){
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
				cells.addAt(i, j, new Cell(i,j));
	}

	public void draw(Graphics g, java.awt.Point mouseLoc){
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
				cells.getFrom(i,j).draw(g, mouseLoc);

	}

	public Cell giveMeRandomCell(){
		int x = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, 20);
		int y = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, 20);
		return cells.getFrom(x,y);
	}
}