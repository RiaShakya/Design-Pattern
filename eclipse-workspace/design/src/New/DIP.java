package New;

interface Keyboard {
    void type();
}

// Concrete implementation 1
class WiredKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing using wired keyboard");
    }
}

// Concrete implementation 2
class WirelessKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing using wireless keyboard");
    }
}

// Computer depends on abstraction
class Computer {
    Keyboard keyboard; 

    // Constructor injection
    Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    void start() {
        keyboard.type();
    }
}

// Main class
public class DIP {
    public static void main(String[] args) {
        
        Keyboard k1 = new WiredKeyboard();
        Computer c1 = new Computer(k1);
        c1.start();

        Keyboard k2 = new WirelessKeyboard();
        Computer c2 = new Computer(k2);
        c2.start();
    }
}
