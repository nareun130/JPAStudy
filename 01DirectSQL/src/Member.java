public class Member {
    
    private String memberId;
    private String name;
    private String tel;

    public Member(String memberId, String name, String tel) {
        this.memberId = memberId;
        this.name = name;
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public Member(){

    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", tel=" + tel + "]";
    }
    
}
