package New;

interface CollegeRules{
	void attendClass();
	void submitAssignment();
}

class collegeStudent implements CollegeRules {
	
	public void attendClass() {
		System.out.println("Student attends class");
	}
	
	public void submitAssignment() {
		System.out.println("Student submits assignment");
	}
}

public class InterfaceEg {
	public static void main(String [] args ) {
		
		collegeStudent s = new collegeStudent();
		
		s.attendClass();
		s.submitAssignment();
	}
}