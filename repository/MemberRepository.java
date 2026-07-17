package LibraryManagement.repository;

import java.util.ArrayList;
import java.util.List;

import LibraryManagement.model.Member;

/*
 * SRP (Single Responsibility Principle)
 * This class only manages Member objects.
 */

public class MemberRepository {

    private List<Member> members;

    public MemberRepository() {
        members = new ArrayList<>();
    }

    // ---------------- Add Member ----------------

    public void addMember(Member member) {

        members.add(member);

        System.out.println("Member registered successfully.");

    }

    // ---------------- View All Members ----------------

    public List<Member> getAllMembers() {
        return members;
    }

    // ---------------- Search by ID ----------------

    public Member searchMemberById(int memberId) {

        for (Member member : members) {

            if (member.getId() == memberId) {

                return member;

            }

        }

        return null;

    }

    // ---------------- Search by Name ----------------

    public List<Member> searchMemberByName(String name) {

        List<Member> result = new ArrayList<>();

        for (Member member : members) {

            if (member.getName().equalsIgnoreCase(name)) {

                result.add(member);

            }

        }

        return result;

    }

    // ---------------- Update ----------------

    public boolean updateMember(int id,
                                String name,
                                String email,
                                String phone) {

        Member member = searchMemberById(id);

        if (member == null) {

            return false;

        }

        member.setName(name);
        member.setEmail(email);
        member.setPhone(phone);

        return true;

    }

    // ---------------- Delete ----------------

    public boolean deleteMember(int id) {

        Member member = searchMemberById(id);

        if (member != null) {

            members.remove(member);

            return true;

        }

        return false;

    }

    // ---------------- Display ----------------

    public void displayMembers() {

        if (members.isEmpty()) {

            System.out.println("No members found.");

            return;

        }

        for (Member member : members) {

            System.out.println("----------------------------");
            member.displayInfo();

        }

    }

}