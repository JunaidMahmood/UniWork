
public class RaceTrack {
	
	private int averageLapTime;
	private boolean isRaining;

	/**
	 * Allows other classes to access the variables. 
	 */
	public RaceTrack (int avgLapTime, boolean rain){

		averageLapTime = avgLapTime;
		isRaining = rain;
	}
	
	/**
	 * Getter method for averageLapTime. 
	 */
	public int getAverageLapTime(){
		
		return averageLapTime;
	}
	
	/**
	 * Setter method for averageLapTime. 
	 */
	public void setAverageLapTime(int avgLapTime){
		
		averageLapTime = avgLapTime;
	}
	
	/**
	 * Getter method for isRaining. 
	 */
	public boolean getIsRaining(){
		
		return isRaining;
	}
	
	/**
	 * Setter method for isRaining. 
	 */
	public void setIsRaining(boolean rain){
		
		isRaining = rain;
	}
	
	/**
	 * Determines the race leader. This can be done at the end of each lap which prints out the id of the leading car,
	 * using if statements and getting the total time at the end of each lap.  
	 */
	public int determineRaceLeader(Car one, Car two, Car three){
	
	if (one.getTotalTime() < two.getTotalTime() && one.getTotalTime() < three.getTotalTime()){

		return one.getId();

	} else if (two.getTotalTime() < one.getTotalTime() && two.getTotalTime() < three.getTotalTime()){

		return two.getId();

	} else {
		
		return three.getId();
	}
	}
}
