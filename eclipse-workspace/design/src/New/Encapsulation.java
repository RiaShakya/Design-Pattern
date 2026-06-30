package New;

class EncStudent {

    private int marks;

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100)
            this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}

public class Encapsulation {

    public static void main(String[] args) {

        EncStudent s = new EncStudent();

        s.setMarks(85);

        System.out.println("Marks: " + s.getMarks());
    }
}