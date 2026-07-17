package New;
import java.util.Scanner;

class Student {
	String name; 
	int marks;
    
	Student (String name, int marks){
		this.name = name;
		this.marks = marks;
	}
}

class GradeService {
	void calculateGrade (Student s) {
		if (s.marks >= 50)
			System.out.println(s.name + " Passed");
		else
			System.out.println(s.name + " Failed");
	}
}

class StudentRepository {
	void save (Student s) {
		System.out.println("Saving " + s.name + " to database...");
	}
}

class ReportPrinter {
	void print(Student s) {
		System.out.println("Report: " + s.name + " scored " + s.marks);
	}
}

public class CohesionEg {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student name: ");
		String name = sc.nextLine();
		System.out.println("Enter marks: ");
		int marks = sc.nextInt();
		Student s = new Student (name, marks);
		new GradeService().calculateGrade(s);
		new StudentRepository().save(s);
		new ReportPrinter().print(s);
		sc.close();
		
	}
}