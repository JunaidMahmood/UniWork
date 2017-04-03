/**
 * This is the class for the MultipleChoiceQuestion;  
 */

public class MultipleChoiceQuestion {
	
	private boolean option1;
	private boolean option2;
	private boolean option3;
	private int mark;
	
	public MultipleChoiceQuestion (boolean optionOne, boolean optionTwo, boolean optionThree, int marks){

		this.option1 = optionOne;
		this.option2 = optionTwo;
		this.option3 = optionThree;
		this.mark = marks;
	}
	
	/**
	 * Getter method for option1. 
	 */
	public boolean getOption1(){
		
		return option1;
	}
	
	/**
	 * Setter method for option1. 
	 */
	public void setOption1(boolean optionOne){
		
		this.option1 = optionOne;
	}
	
	/**
	 * Getter method for option2. 
	 */
	public boolean getOption2(){
		
		return option2;
	}
	
	/**
	 * Setter method for option2. 
	 */
	public void setOption2(boolean optionTwo){
		
		this.option2 = optionTwo;
	}
	
	/**
	 * Getter method for option3. 
	 */
	public boolean getOption3(){
		
		return option3;
	}
	
	/**
	 * Setter method for option3. 
	 */
	public void setOption3(boolean optionThree){
		
		this.option3 = optionThree;
	}
	
	/**
	 * Getter method for mark. Can be used for users mark and mark scheme mark.
	 */
	public int getMark(){
		
		return mark;
	}
	
	/**
	 * Setter method for mark. 
	 */
	public void setMark(int marks){
		
		this.mark = marks;
	}

}
