package builder;

public class Member {

    private String memberId;
    private String name;
    private String email;
    private String phone;
    private String address;

    private Member(MemberBuilder builder){

        this.memberId = builder.memberId;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static class MemberBuilder{

        private String memberId;
        private String name;
        private String email;
        private String phone;
        private String address;

        public MemberBuilder setMemberId(String memberId){
            this.memberId = memberId;
            return this;
        }

        public MemberBuilder setName(String name){
            this.name = name;
            return this;
        }

        public MemberBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public MemberBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }

        public MemberBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public Member build(){
            return new Member(this);
        }

    }

}