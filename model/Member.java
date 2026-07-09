package LibraryManagement.model;

/*
 * Inheritance:
 * Member extends Person.
 *
 * LSP:
 * A Member can be used wherever a Person is expected.
 */

public class Member extends Person {

    private String phone;

    public Member() {

    }

    public Member(int id, String name, String email, String phone) {
        super(id, name, email);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID : " + getId());
        System.out.println("Name      : " + getName());
        System.out.println("Email     : " + getEmail());
        System.out.println("Phone     : " + phone);
    }
}