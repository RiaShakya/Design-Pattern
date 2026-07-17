package New;

interface A {

    default void show() {
        System.out.println("Interface A");
    }
}

interface B extends A {

    @Override
    default void show() {
        System.out.println("Interface B");
    }
}

interface C extends A {

    @Override
    default void show() {
        System.out.println("Interface C");
    }
}

// Bottom class
class D implements B, C {

    // Must override to resolve ambiguity
    @Override
    public void show() {
        System.out.println("Class D resolves Diamond Problem");
    }
}

// Main class
public class InterfaceInheritance {

    public static void main(String[] args) {

        D obj = new D();
        obj.show();
    }
}