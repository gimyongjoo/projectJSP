package deliveryController.dao;

import deliveryController.dto.Delivery;
import util.JdbcConnection;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DeliveryDao extends JdbcConnection {
    public int insert(Delivery d) {
        int res = 0;
        try {
            String sql = "insert into delivery(name, address, phone, product_name, request_date)"
                    + "values(?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,d.getName());
            psmt.setString(2, d.getAddress());
            psmt.setString(3, d.getPhone());
            psmt.setString(4,d.getProduct_name());
            psmt.setObject(5, d.getRequest_date());
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public int update(int id) {
        int res = 0;
        try {
            String sql = "update delivery set status = '배송 중' where id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int delete(int id) {
        int res = 0;
        try {
            String sql = "delete from delivery where id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Delivery> selectList() {
        ArrayList<Delivery> dlist = new ArrayList<>();
        try {
            String sql = "select * from delivery";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Delivery d = new Delivery();
                d.setId(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setAddress(rs.getString(3));
                d.setPhone(rs.getString(4));
                d.setProduct_name(rs.getString(5));
                d.setRequest_date(rs.getDate(6).toLocalDate());
                d.setStatus(rs.getString(7));
                dlist.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dlist;
    }
    public void closeResources() {
        close();
    }
}
