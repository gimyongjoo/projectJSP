package inventoryController.dao;

import inventoryController.dto.Product;
import util.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao extends JdbcConnection {
    public int insert(Product p) {
        int res = 0;
        try {
            String sql = "insert into product(name, quantity, price) values(?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, p.getName());
            psmt.setInt(2, p.getQuantity());
            psmt.setInt(3, p.getPrice());
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Product> selectList() {
        ArrayList<Product> plist = new ArrayList<>();
        try {
            String sql = "select * from product";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setQuantity(rs.getInt(3));
                p.setPrice(rs.getInt(4));
                plist.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plist;
    }
    public int update(int id, int changeAmt) {
        int res = 0;
        try {
            String selectSql = "select quantity from product where id = ?";
            psmt = con.prepareStatement(selectSql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if(rs.next()) {
                int currentQty = rs.getInt("quantity");
                int newQty = currentQty + changeAmt;

                if(newQty < 0) {
                    System.out.println("재고 부족으로 출고 할 수 없습니다.");
                    return -1;
                }

                String updateSql = "update product set quantity = ? where id = ?";
                psmt = con.prepareStatement(updateSql);
                psmt.setInt(1, newQty);
                psmt.setInt(2, id);
                res = psmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int delete(int id) {
        int res = 0;
        try {
            String sql = "delete from product where id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public void closeResources() {
        close();
    }
}
