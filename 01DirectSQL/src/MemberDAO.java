import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDAO {
    private Connection conn;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    private void  connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false","root","dlfgkwk9!!!");
            stmt = conn.createStatement();
        } catch (Exception e){
            System.err.println("jdbc 드라이버 not found");
        }
    }
    public Member find(String member_id){
        String sql = "SELECT MEMBER_ID, NAME, TEL FROM MEMBER M WHERE MEMBER_ID = ?";
        connect();
        Member member = new Member();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,member_id);
            ResultSet rs =  pstmt.executeQuery();
            
            while(rs.next()){
                String memberId = rs.getString("MEMBER_ID");
                String name = rs.getString("NAME");
                String tel = rs.getString("TEL");
                member.setMemberId(memberId);
                member.setName(name);
                member.setTel(tel);
            }
            terminal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return member;
    }

    public void save(Member member){
        String sql = "INSERT INTO MEMBER(MEMBER_ID, NAME) VALUES (?, ?)";
        connect();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getName());
            pstmt.executeUpdate();
            terminal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        

    }

    public void update (Member member) {
        String sql = "UPDATE MEMBER SET NAME = ?, TEL = ? WHERE MEMBER_ID = ? ";
        connect();
        try {   
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getTel());
            pstmt.setString(3, member.getMemberId());
            pstmt.executeUpdate();
            terminal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete (String member_id) {
        String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ? ";
        connect();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member_id);
            pstmt.executeUpdate();
            terminal();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void terminal(){
        try {
            conn.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            conn = null;
            stmt = null;
        }
    }
    
}
