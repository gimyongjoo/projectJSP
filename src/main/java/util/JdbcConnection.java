package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnection {

    //db 연결에 필요한 객체
    public Connection con;
    // sql 명령어 실행을 위해 필요한 객체 - select , insert, update, delete 실행
    public PreparedStatement psmt;
    // select 결과를 저장하기 위한 객체
    public ResultSet rs;

    // mysql 서버에 연결 - 기본생성자 이용
    public JdbcConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 접속을 위해 class 파일 메모리에 로드 ( 객체 생성 )
            con = DriverManager.getConnection("jdbc:mysql://localhost/market_db", "root", "0000");
            System.out.println("db 연결 성공 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if(rs!=null)rs.close();
            if(psmt!=null) psmt.close();
            if(con!=null) con.close();
            System.out.println("자원 해제");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
