
public class Marker {
	
	/**
	 * This method marks the exam attempt. Essentially when called it compares the supplied answers with the mark scheme answers using if statements, 
	 * if the conditions are met the relevant marks are updated and a print statement will be displayed. 
	 */
	public int markAttempt(Exam examAttempt, Exam markScheme){
		
		int mark1 = examAttempt.getQuestion1().getMark();
		int mark2 = examAttempt.getQuestion2().getMark();
		int mark3 = examAttempt.getQuestion3().getMark();
		int totalMark = examAttempt.getTotalMark();
		
		// Question 1 starts from here.
		if (examAttempt.getQuestion1().getAnswer() == markScheme.getQuestion1().getAnswer()){
			
			 mark1 = markScheme.getQuestion1().getMark();
			 System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			 
		} else if ((examAttempt.getQuestion1().getAnswer() + 1) == markScheme.getQuestion1().getAnswer()){
			
			mark1 = markScheme.getQuestion1().getMark() - 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if ((examAttempt.getQuestion1().getAnswer() - 1) == markScheme.getQuestion1().getAnswer()){
			
			mark1 = markScheme.getQuestion1().getMark() - 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() + 2 == markScheme.getQuestion1().getAnswer()){
			
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() + 3 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() + 4 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() + 5 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() - 2 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() - 3 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() - 4 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else if (examAttempt.getQuestion1().getAnswer() - 5 == markScheme.getQuestion1().getAnswer()){
		
			mark1 = 1;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
			
		} else { 
			
			mark1 = 0;
			System.out.println("Question 1: " + mark1 + " out of " + markScheme.getQuestion1().getMark());
		}
		
		// Question 2 starts here.
		if (examAttempt.getQuestion2().getAnswer() == markScheme.getQuestion2().getAnswer()){
			
			 mark2 = markScheme.getQuestion2().getMark();
			 System.out.println("Question 2: " + mark2 + " out of " + markScheme.getQuestion2().getMark());
			 
		} else {
			
			mark2 = 0;
			System.out.println("Question 2: " + mark2 + " out of " + markScheme.getQuestion2().getMark());
			
		}
		
		// Question 3 starts here.
		if (examAttempt.getQuestion3().getOption1() == markScheme.getQuestion3().getOption1()){
			
			mark3 = mark3 + 1;	
			System.out.println("Question 3: " + mark3 + " out of " + markScheme.getQuestion3().getMark());
			
		}
		
		if (examAttempt.getQuestion3().getOption2() == markScheme.getQuestion3().getOption2()){
			
			mark3 = mark3 + 1;	
			System.out.println("Question 3: " + mark3 + " out of " + markScheme.getQuestion3().getMark());
			
		}
			
		if (examAttempt.getQuestion3().getOption3() == markScheme.getQuestion3().getOption3()){
	
			mark3 = mark3 + 1;	
			System.out.println("Question 3: " + mark3 + " out of " + markScheme.getQuestion3().getMark());
			
		}
		
		// Marks for each questions are total here, this can be used for the users total marks achieved and total marks available.
		totalMark = mark1 + mark2 + mark3;
		System.out.println("Total Mark: " + totalMark + " out of " + (markScheme.getQuestion1().getMark() + markScheme.getQuestion2().getMark() + markScheme.getQuestion3().getMark()));
		return totalMark;
		
	}
	
	
	/**
	 * This method is for converting a supplied mark into a classification, marks required for each classification are set in the driver class.
	 */
	public double convertMarksToClassification(int mark, int firstBoundary, int upperSecondBoundary, int lowerSecondBoundary){
		
		double classification;
		
		if (mark >= firstBoundary){
			
			return classification = 1.1;
			
		} else if (mark < firstBoundary && mark >= upperSecondBoundary){
			
			return classification = 2.1;
			
		} else if (mark < upperSecondBoundary && mark >= lowerSecondBoundary){
			
			return classification = 2.2;
			
		} else {
			
			return classification = 0.0;
			
		}
		
	}

}
