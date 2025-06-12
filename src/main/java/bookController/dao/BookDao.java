package bookController.dao;

import bookController.dto.Book;
import util.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao extends JdbcConnection {
    public int insert(Book b) {
        int res = 0;
        try {
            String sql = "insert into book(title, author) values(?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, b.getTitle());
            psmt.setString(2, b.getAuthor());
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Book> select() {
        ArrayList<Book> blist = new ArrayList<>();
        try {
            String sql = "select * from book";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(rs.getString(3));
                blist.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blist;
    }
    public void closeResources() {
        close();
    }
}
