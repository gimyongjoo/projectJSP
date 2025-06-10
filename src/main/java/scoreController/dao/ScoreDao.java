package scoreController.dao;

import scoreController.dto.Score;
import scoreController.dto.Student;
import util.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreDao extends JdbcConnection {
    public int insert(Student s) {
        // 1) 반환 값 저장 할 변수 선언
        int res = 0;
        try {
            // 2) sql문 작성
            String sql = "insert into student(name, math, eng, kor) values(?, ?, ?, ?)";
            // 3) psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4) ? 채우기
            psmt.setString(1, s.getName());
            psmt.setInt(2, s.getMath());
            psmt.setInt(3, s.getEng());
            psmt.setInt(4, s.getKor());
            // 5) 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int delete(int num) {
        // 1) 반환 값 저장 할 변수 선언
        int res = 0;
        try {
            // 2) sql문 작성
            String sql = "delete from student where num = ?";
            // 3) psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4) ? 채우기
            psmt.setInt(1, num);
            // 5) 실행
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Student> selectlist() {
        // 1) 반환 값 저장 할 변수 선언
        ArrayList<Student> slist = new ArrayList<>();
        try {
            // 2) sql문 작성
            String sql = "select num, name, math, eng, kor, eng+kor+math, (eng+kor+math)/3 from student";
            // 3) psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4) ? 채우기
            // 5) 실행
            rs = psmt.executeQuery();
            while(rs.next()) {
                Student s = new Student();
                s.setNum(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setMath(rs.getInt(3));
                s.setEng(rs.getInt(4));
                s.setKor(rs.getInt(5));
                s.setTotal(rs.getInt(6));
                s.setAvg(rs.getDouble(7));
                slist.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slist;
    }
    public ArrayList<Score> selectScore() {
        // 1) 반환 값 저장 할 변수 선언
        ArrayList<Score> slist = new ArrayList<>();
        try {
            // 2) sql문 작성
            String sql = "select count(*), sum(math), avg(math), sum(eng), avg(eng), sum(kor), avg(kor) from student";
            // 3) psmt 객체 생성
            psmt = con.prepareStatement(sql);
            // 4) ? 채우기
            // 5) 실행
            rs = psmt.executeQuery();
            while(rs.next()) {
                Score s = new Score();
                s.setCnt(rs.getInt(1));
                s.setTotalMath(rs.getInt(2));
                s.setAvgMath(rs.getDouble(3));
                s.setTotalEng(rs.getInt(4));
                s.setAvgEng(rs.getDouble(5));
                s.setTotalKor(rs.getInt(6));
                s.setAvgKor(rs.getDouble(7));
                slist.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slist;
    }
    public void closeResources() {
        close();
    }
}
