/**
 * holds the whole logic for the GamePanel
 */

package model;

import java.util.Observable;


public class GameModel extends Observable {

	private Coordinates leftPlayer = new Coordinates(1, 275);
	private Coordinates rightPlayer = new Coordinates(875, 275);
	private int x, y;
	private int velX, velY;
	private String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
	private int scoreNumberLeft, scoreNumberRight;
	private boolean winP1 = false, winP2 = false;
	private String scoreLeft = "src/numberImages/" + numbers[scoreNumberLeft] + ".png";
	private String scoreRight = "src/numberImages/" + numbers[scoreNumberRight] + ".png";

	public GameModel() {

		x = 460;
		y = 300;
		velX = 1;
		velY = 1;
	}
	
	/**
	 * moving the players and the ball to the left and right
	 */
	public void move() {

		if (winP1 == false && winP2 == false) {

			//setting condition below for x and y axis
			if (y > leftPlayer.getY() && y <= leftPlayer.getY() + 110) {

				if (x < 50) {

					velX = -velX;
				}
			}

			x = x + velX;

			//another condition
			if (y > rightPlayer.getY() && y <= rightPlayer.getY() + 110) {

				if (x > 870) {

					velX = -velX;
				}
			}

			x = x + velX; //moving the x axis
		}

		if (y < 0 || y > 590) {

			velY = -velY;
		}

		y = y + velY;

		if (x > 920) {

			x = 460;
			y = 300;
			if (scoreNumberLeft != 10) { //if the score is not equal 10
				scoreNumberLeft++;  
			}

			scoreRight = "src/numberImages/" + numbers[scoreNumberLeft] + ".png"; //images
		}

		if (x < 0) {

			x = 460;
			y = 300;

			if (scoreNumberRight != 10) {
				scoreNumberRight++;
			}

			scoreLeft = "src/numberImages/" + numbers[scoreNumberRight] + ".png";
		}

		if (scoreNumberRight == 10 && winP2 == false) {
			winP2 = true;
			velY = 0;
			velX = 0;
		}

		if (scoreNumberLeft == 10 && winP1 == false) {  //condition for winning
			winP1 = true;
			velY = 0;
			velX = 0;
		}

		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @return
	 */
	public boolean getWinP1() {

		return winP1;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getWinP2() {

		return winP2;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getX() {

		return x;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getY() {

		return y;
	}
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {

		this.y = y;

		setChanged();
		notifyObservers();
	}
	/**
	 * moving the right player
	 * @param direction
	 */
	public void setRightPlayerMove(String direction) {
		if (direction.equals("up")) {
			if (getYposRightPlayer() > 30) {  //do this when moving up
				setYposRightPlayer(getYposRightPlayer() - 75);
			}
		}
		if (direction.equals("down")) {
			if (getYposRightPlayer() < 490) { //moving down
				setYposRightPlayer(getYposRightPlayer() + 75);
			}
		}

		setChanged(); //notifying observers
		notifyObservers();
	}
	
	/**
	 * moving the left player
	 * @param direction
	 */
	public void setLeftPlayerMove(String direction) {
		if (direction.equals("up")) {
			if (getYposLeftPlayer() > 30) {
				setYposLeftPlayer(getYposLeftPlayer() - 75);
			}
		}

		if (direction.equals("down")) {
			if (getYposLeftPlayer() < 490) {
				setYposLeftPlayer(getYposLeftPlayer() + 75);
			}
		}

		setChanged();
		notifyObservers();
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setYposLeftPlayer(int y) {
		leftPlayer.setY(y);
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setYposRightPlayer(int y) {
		rightPlayer.setY(y);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getYposLeftPlayer() {
		return leftPlayer.getY();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getXposLeftPlayer() {
		return leftPlayer.getX();
	}

	/**
	 * 
	 * @return
	 */
	public int getYposRightPlayer() {
		return rightPlayer.getY();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getXposRightPlayer() {
		return rightPlayer.getX();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getScoreLeft() {
		return scoreLeft;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getScoreRight() {
		return scoreRight;
	}
}