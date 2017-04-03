/**
 * class for setting and getting the coordinates
 */

package model;


public class Coordinates {

	private int x;
	private int y;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Coordinates(int x, int y) {

		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
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
}
