package todoController.dao;

import todoController.dto.Todo;
import util.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDao extends JdbcConnection {
    JdbcConnection jdbc1 = new JdbcConnection();
    public int insert(Todo t) {
        // 1. 변환값 저장 할 변수 선언
        int res = 0;
        try {
            // 2. sql문 작성
            String sql = "insert into todo(content) values(?)";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setString(1, t.getContent());
            // 5. 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int update(int id) {
        // 1. 변환값 저장 할 변수 선언
        int res = 0;
        try {
            // 2. sql문 작성
            String sql = "update todo set done = true where id = ?";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setInt(1, id);
            // 5. 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int delete(int id) {
        // 1. 변환값 저장 할 변수 선언
        int res = 0;
        try {
            // 2. sql문 작성
            String sql = "delete from todo where id = ?";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            psmt.setInt(1, id);
            // 5. 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Todo> selectList() {
        // 1. 변환값 저장 할 변수 선언
        ArrayList<Todo> tlist = new ArrayList<>();

        try {
            // 2. sql문 작성
            String sql = "select * from todo";
            // 3. psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4. ? 채우기
            // 5. 실행
            rs = psmt.executeQuery();
            while(rs.next()) {
                Todo t = new Todo();
                t.setId(rs.getInt(1));
                t.setContent(rs.getString(2));
                t.setDone(rs.getBoolean(3));
                tlist.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tlist;
    }

    public void closeResources() {
        close();
    }
}
