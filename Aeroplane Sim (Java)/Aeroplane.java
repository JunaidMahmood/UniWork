/**
 * This class stores all the details about the aeroplane and contains the singleFlight method
 */
public class Aeroplane {
	
	private String name;
	private Coordinates coordinates;
	private int speed;
	private int totalDistance = 0;
	private int repairDistance;
	
	/**
	 * constructor to allow access to the fields from other classes
	 */
	public Aeroplane(String name, Coordinates coordinates, int speed, int totalDistance, int repairDistance){
		
		this.name = name;
		this.coordinates = coordinates;
		this.speed = speed;
		this.totalDistance = totalDistance;
		this.repairDistance = repairDistance;
	}
	
	/**
	 * getter method for the name of the aeroplane
	 */
	public String getName(){
		
		return name;
	}
	
	/**
	 * getter method for the coordinates of the aeroplane
	 */
	public Coordinates getCoordinates(){
		
		return coordinates;
	}
	
	/**
	 * getter method for the totalDistance travelled by the plane
	 */
	public int getTotalDistance(){
		
		return totalDistance;
	}
	
	/**
	 * getter method for the repairDistance
	 */
	public int getRepairDistance(){
		
		return repairDistance;
	}
	
	/**
	 * This is the singleFlight method, allows the plane to move towards the supplied destination. The plane can travel in 4 directions, forwards , backwards, left and right.
	 */
	public int singleFlight(Destination destination){
		
		int time = 0;
		int singleDistance = 0;
		int planeCoordinatesX = coordinates.getX();
		int planeCoordinatesY = coordinates.getY();
		int destinationX = destination.getCoordinates().getX();
		int destinationY = destination.getCoordinates().getY();
		int distanceX = 0;
		int distanceY = 0;
		
		while(planeCoordinatesX != destinationX || planeCoordinatesY != destinationY){
			
			//if the planes x coordinates are greater than the destinations the distance is calculated
			if (planeCoordinatesX > destinationX){
				
				distanceX = planeCoordinatesX - destinationX;
			
			//if the planes x coordinates smaller than the destinations the distance is calculated
			} else if (planeCoordinatesX < destinationX){
				
				distanceX = planeCoordinatesX - destinationX ;
			}
			
			//if the planes y coordinates are greater than the destinations the distance is calculated
			if (planeCoordinatesY > destinationY){
				
				distanceY = planeCoordinatesY - destinationY;
			
			//if the planes y coordinates smaller than the destinations the distance is calculated	
			} else if (planeCoordinatesY < destinationY){
				
				distanceY =  planeCoordinatesY - destinationY;	
			}
			
			//if the distance of x coordinates is smaller than speed then x coordinates of plane become destination x coordinates
			if (distanceX <= speed){
				
				planeCoordinatesX = destinationX;
			
			//if the distance of x coordinates is greater than the speed then the plane coordinates are reduced or incremented by speed respectively
			} else if (distanceX > speed){
				
				planeCoordinatesX = planeCoordinatesX - speed;
				
			} else {
				
				planeCoordinatesX = planeCoordinatesX + speed;
				
			}
			
			//if the distance of y coordinates is smaller than speed then y coordinates of plane become destination y coordinates
			if (distanceY <= speed){
				
				planeCoordinatesY = destinationY; 
			
			//if the distance of y coordinates is greater than the speed then the plane coordinates are reduced or incremented by speed respectively	
			} else if (distanceY > speed){
				
				planeCoordinatesY = planeCoordinatesY - speed;
				
			} else {
				
				planeCoordinatesY = planeCoordinatesY + speed;
			
			}
			
			break;
			
			}
			
			//single distance on each journey
			singleDistance = Math.abs(distanceX) + Math.abs(distanceY);
			totalDistance = totalDistance + singleDistance;
			System.out.println("The single distance of this journey is: " + singleDistance);
			System.out.println("The total distance so far is: " + totalDistance);
			
			//time being incremented every time after the plane moves
			time++;
			//the x coordinate in coordinates class is set to the new position of the plane
			coordinates.setX(planeCoordinatesX);
			//the y coordinate in coordinates class is set to the new position of the plane
			coordinates.setY(planeCoordinatesY);
			return totalDistance;
	}
}