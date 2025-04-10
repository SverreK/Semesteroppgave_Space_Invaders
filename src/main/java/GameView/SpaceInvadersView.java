package GameView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameModel.Aliens.Aliens;
import GameModel.Ship;
import GameModel.SpaceInvadersBoard;
import GameModel.Interfaces.GridDimension;

public class SpaceInvadersView extends JPanel {
	

	private ViewableSpaceInvadersModel model;
	
	//Sprites
	BufferedImage ship;
	BufferedImage alien;
	
	public SpaceInvadersView(ViewableSpaceInvadersModel model) {
		this.model = model;
		
		setPreferredSize(getDefaultSize(model.getDimension()));
		setBackground(Color.BLACK);
		
		//Sprites
		this.ship = Inf101Graphics.loadImageFromResources("ship.png");
		this.alien = Inf101Graphics.loadImageFromResources("alien.png");
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawShip(g2);
        drawAliens(g2);
    }
	
	   private static Dimension getDefaultSize(GridDimension gd) {
	        int width = (int) (gd.size() * gd.cols());
	        int height = (int) (gd.size() * gd.rows());
	        System.out.println(width);
	        System.out.println(height);
	        return new Dimension(width, height);
	    }
	
	 private void drawShip(Graphics2D g2) {
		 Ship ship = model.getShip();
		 g2.drawImage(this.ship, ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight(), null);
		 System.out.println("Drawing ship");

	 }
	 
	 private void drawAliens(Graphics2D g2) {
		 System.out.println("Antall aliens: " + model.getAliens().size());
		    for (Aliens alien : model.getAliens()) {
		        System.out.println("Tegner alien på (" + alien.getX() + "," + alien.getY() + ")");
		        if (alien.isAlive()) {
		            g2.drawImage(this.alien, 
		                        alien.getX(), 
		                        alien.getY(), 
		                        alien.getWidth(), 
		                        alien.getHeight(), 
		                        null);
		        }
		    }
		 
	 }
	
	

}
