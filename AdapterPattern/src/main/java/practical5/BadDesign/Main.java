package practical5.BadDesign;

public class Main {

    public static void main(String[] args) {

        StudentValidator validator = new StudentValidator();
        RollNumberGenerator generator = new RollNumberGenerator();
        StudentRepository repository = new StudentRepository();
        WelcomeService welcome = new WelcomeService();

        validator.validate("Ria Shakya");
        generator.assignRollNo();
        repository.save("Ria Shakya");
        welcome.sendWelcome("Ria Shakya");

    }

}