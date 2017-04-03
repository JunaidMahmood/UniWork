public class Person {

	private int calories;
	
	/**
	* Records the total calories of the person after eating. Adds the total meal calories.
	*/
	public void eat(Meal Meal) {

		calories = calories + Meal.calculateCalories();
	}
	
	/**
	* Prints the total calories of the person after eating a meal or going for a walk.
	*/
	public void printCal() {
		
		System.out.println("Total calories of the person: " + calories);
	}

	/**
	* Reduces the total calories by the number of minutes walked. 
	*/
	public void walk(int minute) {
		
		calories = calories - minute;
	}

}
