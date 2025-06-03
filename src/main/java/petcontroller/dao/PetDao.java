package petcontroller.dao;

import petcontroller.dto.Pet;
import util.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class PetDao extends JdbcConnection {
    public int insert(Pet p) {
        int res = 0;
        try {
            String sql = "insert into pet(name, type, age) values(?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, p.getName());
            psmt.setString(2, p.getType());
            psmt.setInt(3, p.getAge());
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public int update(int id) {
        int res = 0;
        try {
            String sql = "update pet set vaccinated = true where id = ?";
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
            String sql = "delete from pet where id = ?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            res = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<Pet> selectList() {
        ArrayList<Pet> plist = new ArrayList<>();
        try {
            String sql = "select * from pet";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Pet p = new Pet();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setType(rs.getString(3));
                p.setAge(rs.getInt(4));
                p.setVaccinated(rs.getBoolean(5));
                plist.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plist;
    }
    public void closeResources() {
        close();
    }
}
