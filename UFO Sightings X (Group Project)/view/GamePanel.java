/**
 * view for GamePanel
 */
package view;

import model.GameModel;
import controller.GameController;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


public class GamePanel extends JPanel implements Observer {

	private GameModel gameModel;
	private GameController gameController;
	private Timer gameTimer;
	private JLabel p1Label, p2Label;
	private JDialog p1Dialog, p2Dialog;
	private boolean showStatus;

	/**
	 * Constructor
	 * @param gameModel
	 * @param gameController
	 */
	public GamePanel(GameModel gameModel, GameController gameController) {
		this.gameModel = gameModel;
		this.gameController = gameController;

		// win message for player 1
		p1Label = new JLabel(new ImageIcon("src/images/statusimage.gif"));
		p1Dialog = new JDialog();
		p1Dialog.setUndecorated(false);
		p1Dialog.add(p1Label);
		p1Dialog.pack();

		//win message for player 2
		p2Label = new JLabel(new ImageIcon("src/images/statusimage2.gif"));
		p2Dialog = new JDialog();
		p2Dialog.setUndecorated(false);
		p2Dialog.add(p2Label);
		p2Dialog.pack();

		// boolean variable to check if message has already been displayed
		showStatus = false;

		gameTimer = new Timer(5, gameController);

		setLayout(new BorderLayout());
		setVisible(true);
	}

	/**
	 * paints the images
	 */
	public void paintComponent(Graphics m) {

		super.paintComponents(m);

		// image icons for the background, icons and scores
		ImageIcon backgroundImage = new ImageIcon("src/images/finalBackground.png");
		ImageIcon rocketLeft = new ImageIcon("src/images/alienLeft.png");
		ImageIcon rocketRight = new ImageIcon("src/images/alienRight.png");
		ImageIcon scoreRight = new ImageIcon(gameModel.getScoreLeft());
		ImageIcon scoreLeft = new ImageIcon(gameModel.getScoreRight());
		ImageIcon planetImage = new ImageIcon("src/images/mars.png");

		// adding image icons and setting positions
		backgroundImage.paintIcon(this, m, 0, 0);
		scoreRight.paintIcon(this, m, 505, 70);
		scoreLeft.paintIcon(this, m, 395, 70);
		rocketLeft.paintIcon(this, m, gameModel.getXposLeftPlayer(), gameModel.getYposLeftPlayer());
		rocketRight.paintIcon(this, m, gameModel.getXposRightPlayer(), gameModel.getYposRightPlayer());
		planetImage.paintIcon(this, m, gameModel.getX(), gameModel.getY());

		gameTimer.start();
	}

	@Override
	public void update(Observable o, Object arg) {

		// checks if the player 1 has won and displays pop up message
		if (showStatus == false) {

			if (gameModel.getWinP1() == true) {
				System.out.println("ones2");
				p1Dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				p1Dialog.setVisible(true);
				showStatus = true;
			}
		}

		// checks if player 2 has won and displays pop up message
		if (showStatus == false) {

			if (gameModel.getWinP2() == true) {
				System.out.println("ones");
				p2Dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				p2Dialog.setVisible(true);
				showStatus = true;
			}
		}

		revalidate();
		repaint();
	}
}