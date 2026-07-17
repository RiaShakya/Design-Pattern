package New;

class MLPerson {

    String name = "Sam";

    void displayName() {
        System.out.println("Name: " + name);
    }
}

class MLStudent extends MLPerson {

    int semester = 5;

    void displaySemester() {
        System.out.println("Semester: " + semester);
    }
}

class MLGraduateStudent extends MLStudent {

    String project = "AI System";

    void displayProject() {
        System.out.println("Project: " + project);
    }
}

public class MultiInheritance {

    public static void main(String[] args) {

        MLGraduateStudent g = new MLGraduateStudent();

        g.displayName();
        g.displaySemester();
        g.displayProject();
    }
}