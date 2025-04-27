package GameController;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import GameController.Interfaces.GameObject;
import GameModel.SpaceInvadersModel;
import GameView.SpaceInvadersView;
import GameModel.GameState;

public class SpaceInvadersController implements KeyListener {
	
	private SpaceInvadersModel model;
	private SpaceInvadersView view;
	
	private Timer timer;
	
	/**
     * Constructs a new SpaceInvadersController object with specified model and view
     * Initializes the timer with the timer interval given in the model and
     * sets up the key listener for the view
     * Starts the timer immediately
     * 
     * @param model The model this controller will interact with
     * @param view 	The view that this model will update and listen to
     */
	public SpaceInvadersController(SpaceInvadersModel model, SpaceInvadersView view) {
		this.model = model;
        this.view = view;
        view.setFocusable(true);
        view.addKeyListener(this);
        this.timer = new Timer(model.getTimeInterval(), this::clockTick);
        timer.start();
	}
	
	/**
     * Updates the game by one tick for every time interval as long as
     * the game state is ACTIVE
     * 
     * @param tick Triggers the clock tick
     */
	private void clockTick(ActionEvent e) {
            model.clockTick();
            updateTimeDelay();
            view.repaint();
    }
	
	/** Updates the timer delay using the interval from the model */
    private void updateTimeDelay() {
        int delay = model.getTimeInterval();
        timer.setDelay(delay);
        timer.setInitialDelay(delay);
    }
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (model.getGameState() == GameState.TITLE_SCREEN) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER -> model.startGame();
			}
		}
		if (model.getGameState() == GameState.ACTIVE_GAME) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> model.moveShipLeft();
                case KeyEvent.VK_RIGHT -> model.moveShipRight();
                case KeyEvent.VK_SPACE -> model.createBullet();
                case KeyEvent.VK_K -> model.killGame();
                }
        }
		
		if (model.getGameState() == GameState.GAME_OVER) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_Y -> model.restartGame();
			case KeyEvent.VK_N -> System.exit(0);
			}
		}
        view.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
