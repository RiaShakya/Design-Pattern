package practical1;

public class CollegeConfigMain {

    public static void main(String[] args) {

        CollegeConfig config1 = CollegeConfig.getInstance();
        CollegeConfig config2 = CollegeConfig.getInstance();

        System.out.println(config1.getCollegeName());
        System.out.println(config2.getCollegeName());

        System.out.println(config1 == config2);
    }
}
