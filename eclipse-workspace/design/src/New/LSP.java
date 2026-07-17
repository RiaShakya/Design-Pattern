package New;

class Bird {
	void eat () {
		System.out.println("Bird eats");
	}
}

class FlyingBird extends Bird {
	void fly () {
		System.out.println("Flying bird can fly");
	}
}

class Penguin extends Bird {
	void swim() {
		System.out.println("penguin swims");
	}
}

public class LSP {
	public static void main (String [] args) {
		
		Bird b1 = new FlyingBird();
		Bird b2 = new Penguin();
		
		b1.eat();
		b2.eat();
	}
}