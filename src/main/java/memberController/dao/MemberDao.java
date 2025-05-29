package memberController.dao;

import memberController.dto.Member;
import util.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao extends JdbcConnection {
    // insert, update, delete -> executeUpdate()
    // int - 처리된 행의 수 리턴

    // select -> executeQuery()
    // rs -> 조회된 결과 저장
    // rs.next() - 다음 행으로 이동, 더이상 데이터가 없으면 false 리턴
    // rs.getString(1) - 조회 했을 때 첫번 째 열의 값을 가지고 옴
    public Member select(String id) {
        // 1. 반환값을 저장 할 변수 선언
        Member m = null;
        try {
            // 2. sql문 작성
            String sql = "select * from member where id = ?";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setString(1, id);
            // 5. 실행
            rs = psmt.executeQuery();
            if(rs.next()) {
                m = new Member();
                m.setId(rs.getString(1));
                m.setPwd(rs.getString(2));
                m.setName(rs.getString(3));
                m.setEmail(rs.getString(4));
                m.setRegDate(rs.getTimestamp(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    // select
    public ArrayList<Member> selectList() {
        // 1. 반환값을 저장 할 변수 선언
        ArrayList<Member> mlist = new ArrayList<>();
        try {
            // 2. sql문 작성
            String sql = "select * from member";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            // 5. 실행
            rs = psmt.executeQuery();
            while(rs.next()) {
                Member m = new Member();
                m.setId(rs.getString(1));
                m.setPwd(rs.getString(2));
                m.setName(rs.getString(3));
                m.setEmail(rs.getString(4));
                m.setRegDate(rs.getTimestamp(5));
                mlist.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mlist;
    }
    // insert
    public int insert(Member m) {
        // 1. 반환값을 저장 할 변수 선언
        int res = 0;
        try {
            // 2. sql문 작성
            String sql = "insert into member(id, pwd, name, email) values(?, ?, ?, ?)";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setString(1, m.getId());
            psmt.setString(2, m.getPwd());
            psmt.setString(3, m.getName());
            psmt.setString(4, m.getEmail());
            // 5. 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    // update
    public int update(Member m) {
        // 1. 반환값을 저장 할 변수 선언
        int res = 0;
        try {
            // 2. sql문 작성
            String sql = "update member set pwd = ?, name = ?, email = ? where id = ?";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setString(1, m.getPwd());
            psmt.setString(2, m.getName());
            psmt.setString(3, m.getEmail());
            psmt.setString(4, m.getId());
            // 5. 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    // delete
    public int delete(String id) {
        // 1. 반환값을 저장 할 변수 선언
        int res = 0;
        try {
            // 2. sql문 작성
            String sql = "delete from member where id = ?";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setString(1, id);
            // 5. 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
