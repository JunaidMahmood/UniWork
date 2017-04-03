/**
 * This class stores the coordinates for the destinations and the aeroplane.
 */
public class Coordinates {

	private int x;
	private int y;
	
	public Coordinates(int x, int y){
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter method for the x coordinate
	 */
	public int getX(){
		
		return x;
	}
	
	/**
	 * Setter method for the x coordinate, used to set the x coordinate after travelling
	 */
	public void setX(int xx){
		
		this.x = xx;
	}
	
	/**
	 * Getter method for the y coordinate
	 */
	public int getY(){
	
		return y;
	}
	
	/**
	 * setter method for y coordinate, used to set the y coordinate after travelling
	 */
	public void setY(int yy){
		
		this.y = yy;
	}
}
