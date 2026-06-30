package New;

class Person1 {
    void display() {
        System.out.println("This is Person");
    }
}

class MOStudent extends Person1{

    
    void display() {
        System.out.println("This is Student");
    }
}

public class MethodOverriding {

    public static void main(String[] args) {

        MOStudent s = new MOStudent();
        s.display();
    }
}