package New;

class HPerson {
    String college = "PCPS College";
}

class HStudent extends HPerson {
    void showStudent() {
        System.out.println("I am a Student of " + college);
    }
}

class HTeacher extends HPerson {
    void showTeacher() {
        System.out.println("I am a Teacher of " + college);
    }
}

public class HierarchialInheritance {

    public static void main(String[] args) {

        HStudent s = new HStudent();
        HTeacher t = new HTeacher();

        s.showStudent();
        t.showTeacher();
    }
}