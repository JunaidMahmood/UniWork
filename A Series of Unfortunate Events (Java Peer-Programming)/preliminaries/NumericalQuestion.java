package preliminaries;

public class NumericalQuestion extends Question{ // extends from question class, inherits structure 

	private int answer;

	
	public NumericalQuestion(int answer, int mark) {

		super(mark);
		this.answer = answer;
	}
	
	public int lookAtAnswer() {
		
		return answer;
		
	}
	
}
