package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDao {

    public List<Product> getProductByCategory(int idCategory) {
        List<Product> products = new ArrayList<Product>();

        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * "
                + "FROM product "
                + "WHERE category = ?";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, idCategory);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Product product = new Product();

                product.setIdProduct(rs.getInt("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(rs.getInt("category"));

                products.add(product);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }
    
    public int insertProduct(Product product) {
        int rs = 0;
        
        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "INSERT INTO product(nameProduct, price, category) "
                + "VALUES (?, ?, ?) ";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, product.getNameProduct());
            pstm.setDouble(2, product.getPrice());
            pstm.setInt(3, product.getCategory());
            rs = pstm.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
    public int deleteProduct(int product) {
        int rs = 0;
        
        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "DELETE FROM product "
                + "WHERE idProduct = ? ";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, product);
            rs = pstm.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
