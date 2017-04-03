public class Dish {

	private int calories;
	
	/**
	* Allows us to store the calories in each dish to add to our meal later. 
	*/
	public void dishCal(int cal){
		
		calories = cal;
	}
	
	/**
	* Returns the calories of each dish, which is used in the Meal Class to get the total meal calories.
	*/
	public int getCal(){
		
		return calories;
	}
	
}
