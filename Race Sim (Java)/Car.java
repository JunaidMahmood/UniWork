
public class Car {
	
	private int id;
	private int fuel;
	private int lowFuelBoost;
	private int highFuelSlowdown;
	private int fuelConsumptionPerLap;
	private int pitStopTime;
	private int rainSlowdown;
	private int totalTime;

	public Car( int number, int fuelLevel, int lowFuel, int highFuel, int fuelConsumption, int pitStop, int rainSlow, int timeTaken){

		id = number;
		fuel = fuelLevel;
		lowFuelBoost = lowFuel;
		highFuelSlowdown = highFuel;
		fuelConsumptionPerLap = fuelConsumption;
		pitStopTime = pitStop;
		rainSlowdown = rainSlow;
		totalTime = timeTaken;
	}
	
	/**
	 * Completes a lap every time its called. This is carried out by using if and else if statements. 
	 * At the end of the method you will get an altered base time of the track (silverstone) based on the attributes of each car,
	 * which then adds to the totalTime of each car so at the end you can determine the leader of the whole race. 
	 */
	public void completeLap(RaceTrack silverstone){
		
		int averageLapTime = silverstone.getAverageLapTime();
		boolean isRaining = silverstone.getIsRaining();
		
	if (fuel > 50){
		
		averageLapTime = averageLapTime + highFuelSlowdown;
		
	} else if (fuel < 50){
		
		averageLapTime = averageLapTime - lowFuelBoost;
	}

	if (isRaining == true){
		
		averageLapTime = averageLapTime + rainSlowdown;
	}
	
	fuel = fuel - fuelConsumptionPerLap;
	
	if (fuel < fuelConsumptionPerLap){
		
		averageLapTime = averageLapTime + pitStopTime;
		
		fuel = 100;
	}
	
	totalTime = totalTime + averageLapTime;
	
	}
	
	/**
	 * Getter method for totalTime. 
	 */
	public int getTotalTime(){
		
		return totalTime;
	}
	
	/**
	 * Getter method for id. 
	 */
	public int getId(){
		
		return id;
	}
}



























