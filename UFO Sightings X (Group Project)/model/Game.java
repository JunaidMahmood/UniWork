/**
 * creating the objects of another classes
 */

package model;

import controller.GameController;
import model.GameModel;
import view.GameFrame;


public class Game {

	private GameModel model2;
	private GameController controller2;
	private GameFrame game;

	public Game() {
		model2 = new GameModel();
		controller2 = new GameController(model2);
		game = new GameFrame(model2, controller2);
		model2.addObserver(game);
	}
}