/**
 * This class stores destination name and coordinates by accesing the coordinates class
 */
public class Destination {

	private String name;
	private Coordinates coordinates;
	
	public Destination(String name, Coordinates coordinates){
		
		this.name = name;
		this.coordinates = coordinates; 
	}
	
	/**
	 * getter method for the name of the destination
	 */
	public String getName(){
		
		return name;
	}
	
	/**
	 * getter method for coordinates, to retrieve coordinates from the coordinates class
	 */
	public Coordinates getCoordinates(){
		
		return coordinates;
	}
	
}
