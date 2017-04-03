package preliminaries;

public class BooleanQuestion extends Question { // extends from question class, inherits structure 

	private boolean answer;

	
	public BooleanQuestion(boolean answer, int mark) {

		super(mark);
		this.answer = answer;

	}
	
	public boolean lookAtAnswer() {
		
		return answer;
		
	}
	

	

	
}
