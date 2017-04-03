/**
 * This is the driver class, containing objects of the coordinate, destination and aeroplane classes
 */
public class FlightSimulation {

	public static void main(String[] args) {
		
		//objects of the coordinates class, coordinates of the destinations and aeroplane are passed through
		Coordinates coordinatesDestination1 = new Coordinates(10, 35);
		Coordinates coordinatesDestination2 = new Coordinates(15, 45);
		Coordinates coordinatesDestination3 = new Coordinates(150, 125);
		Coordinates coordinatesPlane = new Coordinates(10, 35);
		
		//objects of the destination class, names and coordinates objects passed through
		Destination destination1 = new Destination("Zurich", coordinatesDestination1 );
		Destination destination2 = new Destination("Doha", coordinatesDestination2 );
		Destination destination3 = new Destination("Tokyo", coordinatesDestination3 );
		
		//aeroplane object, name coordinates and plane details passed through
		Aeroplane aeroplane = new Aeroplane("Wright Flyer", coordinatesPlane, 17, 0, 2000);
		
		//1, 1st flight
		System.out.println("Flight 1");
		System.out.println("Aeroplane name: " + aeroplane.getName());
		System.out.println("Starting destination: " + destination1.getName());
		System.out.println("End destination: " + destination2.getName());
		aeroplane.singleFlight(destination2);
		System.out.println("Current coordinates: (" + coordinatesDestination2.getX() + ", " + coordinatesDestination2.getY() + ")");
		
		//2, 2nd flight
		System.out.println();
		System.out.println("Flight 2");
		System.out.println("Aeroplane name: " + aeroplane.getName());
		System.out.println("Starting destination: " + destination2.getName());
		System.out.println("End destination: " + destination3.getName());
		aeroplane.singleFlight(destination3);
		System.out.println("Current coordinates: (" + coordinatesDestination3.getX() + ", " + coordinatesDestination3.getY() + ")");
		
		//3, 3rd flight
		System.out.println();
		System.out.println("Flight 3");
		System.out.println("Aeroplane name: " + aeroplane.getName());
		System.out.println("Starting destination: " + destination3.getName());
		System.out.println("End destination: " + destination2.getName());
		aeroplane.singleFlight(destination2);
		System.out.println("Current coordinates: (" + coordinatesDestination2.getX() + ", " + coordinatesDestination2.getY() + ")");
		
		//4, 4th flight
		System.out.println();
		System.out.println("Flight 4");
		System.out.println("Aeroplane name: " + aeroplane.getName());
		System.out.println("Starting destination: " + destination2.getName());
		System.out.println("End destination: " + destination1.getName());
		aeroplane.singleFlight(destination1);
		System.out.println("Current coordinates: (" + coordinatesDestination1.getX() + ", " + coordinatesDestination1.getY() + ")");
		
		System.out.println();
		System.out.println();
		//total distance printed
		System.out.println("The total distance travelled is: " + aeroplane.getTotalDistance());
		
		//for loop for repeating daily flight schedule
		int distance = aeroplane.getTotalDistance();
				
		for (int index = 1; index <= 120; index = index + 1){
			
			if (aeroplane.getRepairDistance() >= 2000){
				
				index = index + 7;
				distance = 0;
			}
		}
		
	}

}
