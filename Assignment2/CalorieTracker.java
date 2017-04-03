 /**
  * This is the Driver class for the program. 
  */

public class CalorieTracker {

	public static void main(String[] args){

	    /**
	     * A new person has been created and there inital calories have been printed.
	     */
		Person junaid = new Person();
		junaid.printCal();
		
		/**
	     * New meal has been created for Pie, calories for each dish in meal are assigned, 
		 * using Eat method the persons total intake increases and this is printed along 
		 * with the meal total. Objects have been created for Meal and Dish. This the meal 
		 * with the lowest calories.
	     */
		Meal Pie = new Meal();
		Dish starter = new Dish();
		starter.dishCal(170);
		Dish main = new Dish();
		main.dishCal(280);
		Dish dessert = new Dish();
		dessert.dishCal(115);
		Pie.setDish(starter, main, dessert);
		System.out.println("Calories in the Pie lunch: " + Pie.calculateCalories());
		junaid.eat(Pie);
		junaid.printCal();
		
		/**
	     * New meal has been created for Omelette, calories for each dish in meal are assigned, 
		 * using Eat method the persons total intake increases and this is printed along 
		 * with the meal total. Objects have been created for Meal and Dish. This is the meal
		 * with 1000 calories.
	     */
		Meal Omelette = new Meal();
		Dish starter2 = new Dish();
		starter.dishCal(250);
		Dish main2 = new Dish();
		main.dishCal(650);
		Dish dessert2 = new Dish();
		dessert.dishCal(100);
		Omelette.setDish(starter, main, dessert);
		System.out.println("Calories in the Omelette breakfast: " + Omelette.calculateCalories());
		junaid.eat(Omelette);
		junaid.printCal();
		
		/**
	     * New meal has been created for Halloumi, calories for each dish in meal are assigned, 
		 * using Eat method the persons total intake increases and this is printed along 
		 * with the meal total. Objects have been created for Meal and Dish. This is the meal
		 * with the highest calories.
	     */
		Meal Halloumi = new Meal();
		Dish starter3 = new Dish();
		starter.dishCal(150);
		Dish main3 = new Dish();
		main.dishCal(720);
		Dish dessert3 = new Dish();
		dessert.dishCal(250);
		Halloumi.setDish(starter, main, dessert);
		System.out.println("Calories in the Halloumi lunch: " + Halloumi.calculateCalories());
		junaid.eat(Halloumi);
		junaid.printCal();
		
		/**
	     * Using the walk method, I have assigned the number of minutes needed to reduce calories
		 * to 2000, which is then printed using the printCal method. 
	     */
		System.out.println("Person goes for a 685 min walk...");
		junaid.walk(685);
		junaid.printCal();
		
	    }
	
}



		