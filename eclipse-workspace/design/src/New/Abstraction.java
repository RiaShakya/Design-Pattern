package New;

abstract class Person{
	abstract void work();
}

class Student1 extends Person {
	void work() {
		System.out.println("Student studies");
	}
}

class Teacher extends Person {
	void work() {
		System.out.println("Teacher teaches");
	}
}

public class Abstraction {
	public static void main(String [] args) {
		
		Person p1 = new Student1();
		Person p2 = new Teacher();
		
		p1.work();
		p2.work();
	}
}