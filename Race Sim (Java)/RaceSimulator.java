/**
 * This is the driver class for the program.  
 */

public class RaceSimulator {
	
	public static void main(String[] args){
		
		/**
		 * An object of RaceTrack is created. The new RaceTrack is silverstone and the averageLapTime is set to
		 * 95 seconds and isRaining is set to false.
		 */
		RaceTrack silverstone = new RaceTrack(95, false);
		
		/**
		 * Three objects of the Car class are created each representing different cars. Supplied values are passed through 
		 * each cars attributes. 
		 */
		Car one = new Car(1, 49, 3, 4, 20, 15, 11, 0);
		Car two = new Car(2, 40, 2, 3, 16, 16, 8, 0);
		Car three = new Car(3, 35, 4, 5, 22, 14, 9, 0);
		
		/**
		 * The completeLap method is called and each car completes one lap. 
		 */
		one.completeLap(silverstone);
		two.completeLap(silverstone);
		three.completeLap(silverstone);
		
		/**
		 * The id of the winner from the first lap is printed. 
		 */
		System.out.println(silverstone.determineRaceLeader(one, two, three));
		
		/**
		 * The completeLap method is called and each car completes another lap. 
		 */
		one.completeLap(silverstone);
		two.completeLap(silverstone);
		three.completeLap(silverstone);
		
		/**
		 * The id of the winner is printed from the race so far. 
		 */
		System.out.println(silverstone.determineRaceLeader(one, two, three));
		
		/**
		 * The isRaining variable is switched to true so now for the final lap it is raining on silverstone. 
		 */
		silverstone.setIsRaining(true);
		
		/**
		 * Once more, the completeLap method is called and the final lap is completed with rain. 
		 */
		one.completeLap(silverstone);
		two.completeLap(silverstone);
		three.completeLap(silverstone);
		
		/**
		 * The id of the winner from the whole race is printed. 
		 */
		System.out.println(silverstone.determineRaceLeader(one, two, three));
	}
}
