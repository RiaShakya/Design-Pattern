package designpatterns;

//Singleton       -> same object should be returned
//Factory         -> correct object should be created
//Observer        -> subscriber should receive notification
//Strategy        -> selected algorithm should work correctly
//Proxy           -> access should be controlled
//Decorator       -> extra behavior should be added
//State           -> object behavior should change with state
// 1. Singleton Pattern
class CollegeDatabase {
    private static CollegeDatabase instance;

    private CollegeDatabase() {
    }

    public static CollegeDatabase getInstance() {
        if (instance == null) {
            instance = new CollegeDatabase();
        }
        return instance;
    }

    public String connect() {
        return "Connected to college database";
    }
}

// 2. Factory Method Pattern
interface Notification {
    String send();
}

class EmailNotification implements Notification {
    public String send() {
        return "Email notification sent";
    }
}

class SMSNotification implements Notification {
    public String send() {
        return "SMS notification sent";
    }
}

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Invalid notification type");
    }
}

// 3. Abstract Factory Pattern
interface Button {
    String render();
}

interface Checkbox {
    String check();
}

class WindowsButton implements Button {
    public String render() {
        return "Windows button";
    }
}

class WindowsCheckbox implements Checkbox {
    public String check() {
        return "Windows checkbox";
    }
}

class MacButton implements Button {
    public String render() {
        return "Mac button";
    }
}

class MacCheckbox implements Checkbox {
    public String check() {
        return "Mac checkbox";
    }
}

interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// 4. Builder Pattern
class Student {
    private String name;
    private int age;
    private String course;

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.course = builder.course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    static class StudentBuilder {
        private String name;
        private int age;
        private String course;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

// 5. Prototype Pattern
class StudentRecord implements Cloneable {
    private String name;
    private String course;

    public StudentRecord(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getDetails() {
        return name + " studies " + course;
    }

    public StudentRecord clone() {
        try {
            return (StudentRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}