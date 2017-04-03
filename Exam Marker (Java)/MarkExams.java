/**
 * This is the driver class for the program. 
 */

public class MarkExams {
	
	public static void main(String[] args){
		
		// New objects created of the three different question types with supplied values of correct answers and max marks.
		NumericalQuestion nqMarkScheme = new NumericalQuestion(124, 5);
		BooleanQuestion bqMarkScheme = new BooleanQuestion(false, 1);
		MultipleChoiceQuestion mcqMarkScheme = new MultipleChoiceQuestion(true, false, true, 3);
		
		// Exam object for the mark scheme, questions and total marks are passed through.
		Exam markScheme = new Exam(nqMarkScheme, bqMarkScheme, mcqMarkScheme, 9);
		
		// New objects created of the three different question types with supplied values of users answers with makers set to zero and the attempt has not yet been marks.
		NumericalQuestion nqAttempt = new NumericalQuestion(256, 0);
		BooleanQuestion bqAttempt = new BooleanQuestion(false, 0);
		MultipleChoiceQuestion mcqAttempt = new MultipleChoiceQuestion(true, true, false, 0);
		
		// Exam object for the mark scheme, questions and initial total marks are passed through.
		Exam examAttempt = new Exam(nqAttempt, bqAttempt, mcqAttempt, 0);
		
		// Marker object created so the markAttempt method can be called.
		Marker exam = new Marker();
		
		// markAttempt method called, examAttempt and markScheme will be compared.
		exam.markAttempt(examAttempt, markScheme);
		
		System.out.println("Classification: " + (exam.convertMarksToClassification(examAttempt.getTotalMark(), 7, 6, 5)));
		
	}

}
