package TestCases;

import builder.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void testBuilder() {

        Member member = new Member.MemberBuilder()
                .setMemberId("M001")
                .setName("Ria")
                .setEmail("ria@gmail.com")
                .setPhone("9800000000")
                .setAddress("Kathmandu")
                .build();

        assertEquals("M001", member.getMemberId());
        assertEquals("Ria", member.getName());
        assertEquals("ria@gmail.com", member.getEmail());
    }

}
