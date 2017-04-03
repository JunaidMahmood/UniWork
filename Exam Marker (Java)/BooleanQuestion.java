/**
 * This is the class for the BooleanQuestion;  
 */

public class BooleanQuestion {
	
	private boolean answer;
	private int mark;
	
	public BooleanQuestion (boolean ans, int marks){

		this.answer = ans;
		this.mark = marks;
	}
	
	/**
	 * Getter method for answer. 
	 */
	public boolean getAnswer(){
		
		return answer;
	}
	
	/**
	 * Setter method for answer. 
	 */
	public void setAnswer(boolean ans){
		
		this.answer = ans;
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
