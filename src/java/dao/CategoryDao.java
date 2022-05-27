package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

public class CategoryDao {

    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<Category>();

        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * "
                + "FROM category";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Category category = new Category();

                category.setIdCaetgory(rs.getInt("idCategory"));
                category.setNameCategory(rs.getString("nameCategory"));

                categories.add(category);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categories;
    }  
}
