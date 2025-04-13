package GameView;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameModel.GameState;
import GameModel.Projectile;
import GameModel.Ship;
import GameModel.Aliens.Aliens;
import GameModel.Aliens.redShip;
import GameModel.Interfaces.GridDimension;

public class SpaceInvadersView extends JPanel {
	
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	

	private ViewableSpaceInvadersModel model;
	
	//Sprites
	BufferedImage spriteSheet;
	BufferedImage redShip;
	BufferedImage ship;
	BufferedImage alien;
	
	public SpaceInvadersView(ViewableSpaceInvadersModel model) {
		this.model = model;
		
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setBackground(Color.BLACK);
		
		//Sprites
		this.spriteSheet = Inf101Graphics.loadImageFromResources("sprite.png");
		this.ship = Inf101Graphics.loadImageFromResources("ship.png");
		this.alien = Inf101Graphics.loadImageFromResources("alien.png");
		this.redShip = spriteSheet.getSubimage(214, 224, 48, 20);
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;

	    if (model.getGameState() == GameState.GAME_OVER) {
	        drawGameOver(g2);
	    } else {
	        drawCenteredBoard(g2);
	    }
    }
	
	private void drawCenteredBoard(Graphics2D g2) {
	    // Hent dimensjonene på selve brettet
	    int boardWidth = model.getDimension().size() * model.getDimension().cols();
	    int boardHeight = model.getDimension().size() * model.getDimension().rows();

	    // Kalkuler midtstilling
	    int offsetX = (this.getWidth() - boardWidth) / 2;
	    int offsetY = (this.getHeight() - boardHeight) / 2;

	    // Flytt alt som tegnes inn i dette området
	    g2.translate(offsetX, offsetY);

	    drawShip(g2);
	    drawRedShip(g2);
	    drawAliens(g2);
	    drawBullets(g2);
	    
	    g2.setColor(Color.GRAY);
	    g2.setStroke(new BasicStroke(10));
	    g2.drawRect(0, 0, boardWidth + 5, boardHeight + 5);

	    g2.translate(-offsetX, -offsetY); // Reset transform etterpå, i tilfelle
	    
	}

	
	   private static Dimension getDefaultSize(GridDimension gd) {
	        int width = (int) (gd.size() * gd.cols());
	        int height = (int) (gd.size() * gd.rows());
	        return new Dimension(width, height);
	    }
	
	 private void drawShip(Graphics2D g2) {
		 Ship ship = model.getShip();
		 g2.drawImage(this.ship, ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight(), null);

	 }
	 
	 private void drawRedShip(Graphics g2) {
		 redShip redShip = model.getRedShip();
		 
		 if (redShip.isAlive()) {
			 g2.drawImage(this.redShip, redShip.getX(), redShip.getY(), redShip.getWidth(), redShip.getHeight(), null);
		 }
	 }
	 
	 private void drawAliens(Graphics2D g2) {
		    for (Aliens alien : model.getAliens()) {
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
	 
	 private void drawBullets(Graphics2D g2) {
		 g2.setColor(Color.WHITE);
		 for (int i = 0; i < model.getBullets().size(); i++) {
			 Projectile bullet = model.getBullets().get(i);
			 if (!bullet.isUsed()) {
				 g2.drawRect(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
			 }
		 }
	 }
	 
	 private void drawGameOver(Graphics2D g2) {
	        Rectangle2D box = new Rectangle2D.Double(
	                0,
	                0,
	                this.getWidth(),
	                this.getHeight());
	        g2.setColor(Color.GRAY);
	        g2.fill(box);

	        g2.setColor(Color.WHITE);
	        g2.setFont(new Font("Monospaced", Font.BOLD, 50));
	        Inf101Graphics.drawCenteredString(g2, "GAME OVER", getBounds());
	    }
	
	

}
