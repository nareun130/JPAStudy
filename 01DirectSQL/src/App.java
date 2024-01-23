public class App {
    //! 필드가 1개 추가될 수록 DAO의 메서드 save, find, update 와 Member의 생성자, getter, setter 를 수정해야할 것이 늘어난다.
    public static void main(String[] args) throws Exception {
        MemberDAO dao = new MemberDAO();
        Member member = new Member("nareun130","seongho","010-1111-1111");
        dao.update(member);
        Member getMember = dao.find("nareun130");
        System.out.println(getMember);
        dao.delete("nareun130");
    }
}
