public class Meal {

	private Dish starter;
	private Dish main;
	private Dish dessert;
	
	/**
	* Calculates the total calories in the dish. Adds starter, main and dessert for each meal.
	*/
	public int calculateCalories(){
		
		return starter.getCal() + main.getCal() + dessert.getCal(); 
	}
	
	public void setDish(Dish s, Dish m, Dish d){
		
		this.starter = s;
		this.main = m;
		this.dessert = d;
	}
	
}
