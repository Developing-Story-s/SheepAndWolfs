import java.awt.*;

public class Main extends Canvas {

	static Stage stage;
	
	long lastStartTime = System.currentTimeMillis(); // used only for visualising frame rate

	public void gameLoop(){
		while(true){
			// these two lines give me a visualisation of frame rate.  On my machine it is pretty good but not locked on 20ms
			int thisLoopMillis = java.lang.Math.min(100,(int)(System.currentTimeMillis() - lastStartTime));
			System.out.println("                                                                                                             ".substring(thisLoopMillis) + ".");
			lastStartTime = System.currentTimeMillis();
			this.repaint();
		}
	}

	private Point subtractPoints(Point a, Point b){
		java.awt.Point p = new java.awt.Point();
		p.setLocation(a.getX() - b.getX(), a.getY() - b.getY());
		return p;
	}

	public void paint(Graphics g){
		java.awt.Point mouseLoc = subtractPoints(MouseInfo.getPointerInfo().getLocation(), this.getLocationOnScreen());
		stage.draw(g, mouseLoc);
	}

	public static void main(String[] args){
		System.out.println("Sheep and Wolves");
		stage = new Stage();

    Main p = new Main();
    p.setPreferredSize(new Dimension(1280,720));
		javax.swing.JFrame frame = new javax.swing.JFrame("Sheep and Wolves");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();

		p.gameLoop();
	}
}