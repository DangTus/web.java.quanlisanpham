package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TheLoai;

public class TheLoaiDao {

    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> theLoais = new ArrayList<TheLoai>();

        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * "
                + "FROM theloai";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TheLoai theLoai = new TheLoai();

                theLoai.setMaTL(rs.getInt("maTL"));
                theLoai.setTenTL(rs.getString("tenTL"));

                theLoais.add(theLoai);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return theLoais;
    }

}
