package New;

class Demo {

    void add(int a) {
        System.out.println(a);
    }

    void add(int a, int b) {
        System.out.println(a + b);
    }
}

public class MethodOverloading {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.add(5);
        d.add(5, 10);
    }
}