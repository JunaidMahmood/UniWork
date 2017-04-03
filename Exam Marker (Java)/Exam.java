
public class Exam {
	
	private NumericalQuestion question1; 
	private BooleanQuestion question2;
	private MultipleChoiceQuestion question3;
	private int totalMark;

	public Exam (NumericalQuestion q1, BooleanQuestion q2, MultipleChoiceQuestion q3, int totalMarks){

		this.question1 = q1;
		this.question2 = q2;
		this.question3 = q3;
		this.totalMark = totalMarks;
	}
	
	/**
	 * Getter method for question1. 
	 */
	public NumericalQuestion getQuestion1(){
		
		return question1;
	}
	
	/**
	 * Getter method for question2. 
	 */
	public BooleanQuestion getQuestion2(){
		
		return question2;
	}
	
	/**
	 * Getter method for question3. 
	 */
	public MultipleChoiceQuestion getQuestion3(){
	
		return question3;
	}
	
	/**
	 * Getter method for totalMark. Can be used for users total mark and mark scheme total mark.
	 */
	public int getTotalMark(){
	
		return totalMark;
	}
}


