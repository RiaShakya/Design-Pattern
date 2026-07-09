package LibraryManagement.model;

/*
 * Inheritance:
 * Librarian extends Person.
 */

public class Librarian extends Person {

    private String position;

    public Librarian() {

    }

    public Librarian(int id, String name, String email, String position) {
        super(id, name, email);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void displayInfo() {
        System.out.println("Librarian ID : " + getId());
        System.out.println("Name         : " + getName());
        System.out.println("Email        : " + getEmail());
        System.out.println("Position     : " + position);
    }
}