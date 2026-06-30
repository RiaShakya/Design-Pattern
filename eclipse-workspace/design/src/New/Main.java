package New;

class student {

	String name;
	int rollNo;
	private int marks;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public void setMarks (int marks) {
		if (marks >=0 && marks <=100)
			this.marks = marks;
	}
	
	public int getMarks() {
		return marks;
	}

	void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    
}
}

public class Main {
     public static void main(String[] args) {
        student s1 = new student(); // object create
        
        s1.name = "Ria";
        s1.rollNo = 1;
        
        s1.setMarks(85);
        System.out.println("Marks :" +s1.getMarks());
        
        s1.display();              
    }
} 