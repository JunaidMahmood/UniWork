/**
 * This is the class for the NumericalQuestion;  
 */

public class NumericalQuestion {
	
	private int answer;
	private int mark;
	
	public NumericalQuestion (int ans, int marks){

		this.answer = ans;
		this.mark = marks;
	}
	
	/**
	 * Getter method for answer. 
	 */
	public int getAnswer(){
		
		return answer;
	}
	
	/**
	 * Setter method for answer. 
	 */
	public void setAnswer(int ans){
		
		this.answer = ans;
	}
	
	/**
	 * Getter method for mark. Can be used for users mark and mark scheme mark.
	 */
	public int getMark(){
		
		return mark;
	}
	
	/**
	 * Setter method for marks. 
	 */
	public void setMark(int marks){
		
		this.mark = marks;
	}

}
