package practical5.GoodDesign;

public class StudentRegistrationFacade {

    private final StudentValidator validator;
    private final RollNumberGenerator generator;
    private final StudentRepository repository;
    private final WelcomeService welcome;

    public StudentRegistrationFacade() {
        validator = new StudentValidator();
        generator = new RollNumberGenerator();
        repository = new StudentRepository();
        welcome = new WelcomeService();
    }

    public void registerStudent(String name) {

        validator.validate(name);
        generator.assignRollNo();
        repository.save(name);
        welcome.sendWelcome(name);

    }

}