/**
 * This is the coordinates class which has been imported from CW5. it is being used to get the x value of the plane
 */
package CW5;

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

    /**
     * this is the getter method for the x coordinate
     */
	public int getX() {
		
		return x;
	}

    /**
     * this is the getter method for the y coordinate
     */
	public int getY() {

		return y;
	}

    /**
     * this is the setter method for the x coordinate
     */
	public void setX(int x) {
		
		this.x = x;
	}

    /**
     * this is the setter method for the y coordinate
     */
	public void setY(int y) {

		this.y = y;
	}
	
}
