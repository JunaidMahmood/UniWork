/**
 * frame for the game
 */

package view;

import controller.GameController;
import model.GameModel;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements Observer {
	private GamePanel gamePanel;
	private GameModel gameModel;
	private GameController gameController;

	/**
	 * Constructor
	 * @param gameModel
	 * @param gameController
	 */
	public GameFrame(GameModel gameModel, GameController gameController) { 
		this.gameModel = gameModel;
		this.gameController = gameController;
		gamePanel = new GamePanel(gameModel, gameController);
		gameModel.addObserver(gamePanel);
		addKeyListener(gameController); //adding listener
		add(gamePanel);
		setSize(950, 655); 
		setVisible(true); //making sure it appears
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}