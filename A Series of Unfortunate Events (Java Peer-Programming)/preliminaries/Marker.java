package preliminaries;

public class Marker {

	public int markAttempt(Exam examAttempt, Exam markScheme) {
		
		if ( examAttempt.lookAnswer() == markScheme.lookAnswer() ) { // this is were we have adhered to the law of demeter, by using another method in the Exam class
			
			examAttempt.lookAtQuestion1().giveMark(markScheme.lookAtQuestion1().readMark());
			
		} else if ( examAttempt.lookAtQuestion1().lookAtAnswer() == markScheme.lookAtQuestion1().lookAtAnswer() - 1 
				 || examAttempt.lookAtQuestion1().lookAtAnswer() == markScheme.lookAtQuestion1().lookAtAnswer() + 1  ) {
			
			examAttempt.lookAtQuestion1().giveMark(markScheme.lookAtQuestion1().readMark() - 1);
			
		} else if ( examAttempt.lookAtQuestion1().lookAtAnswer() >= markScheme.lookAtQuestion1().lookAtAnswer() - 5 
				 && examAttempt.lookAtQuestion1().lookAtAnswer() <= markScheme.lookAtQuestion1().lookAtAnswer() + 5  ) {
		
			examAttempt.lookAtQuestion1().giveMark(1);
		
		} else {
			
			examAttempt.lookAtQuestion1().giveMark(0);
			
		}
		
		if ( examAttempt.lookAtQuestion2().lookAtAnswer() == markScheme.lookAtQuestion2().lookAtAnswer() ) {
			
			examAttempt.lookAtQuestion2().giveMark(markScheme.lookAtQuestion2().readMark());
			
		} else {
			
			examAttempt.lookAtQuestion2().giveMark(0);
			
		}
		
		if ( examAttempt.lookAtQuestion3().lookAtOption1Answer() == markScheme.lookAtQuestion3().lookAtOption1Answer() ) {
			
			examAttempt.lookAtQuestion3().giveMark(examAttempt.lookAtQuestion3().readMark() + 1);
	
		}
		
	    if ( examAttempt.lookAtQuestion3().lookAtOption2Answer() == markScheme.lookAtQuestion3().lookAtOption2Answer() ) {
			
			examAttempt.lookAtQuestion3().giveMark(examAttempt.lookAtQuestion3().readMark() + 1);
			
		}
		
	    if ( examAttempt.lookAtQuestion3().lookAtOption3Answer() == markScheme.lookAtQuestion3().lookAtOption3Answer() ) {
			
			examAttempt.lookAtQuestion3().giveMark(examAttempt.lookAtQuestion3().readMark() + 1);
			
		}
	    
	    int totalMark = examAttempt.lookAtQuestion1().readMark() + examAttempt.lookAtQuestion2().readMark() + examAttempt.lookAtQuestion3().readMark();
	    		
	    examAttempt.writeTotalMark(totalMark);
	    
	    return totalMark;
	    
	}
	
	public double convertMarksToClassification(int mark, int firstBoundary, int upperSecondBoundary, int lowerSecondBoundary) {
		
		if ( mark >= firstBoundary ) {
			
			return 1.1;
			
		} else if ( mark >= upperSecondBoundary ) {
			
			return 2.1;
			
		} else if ( mark >= lowerSecondBoundary ) {
			
			return 2.2;
			
		} else {
			
			return 0.0;
			
		}
	
	}
	
}
