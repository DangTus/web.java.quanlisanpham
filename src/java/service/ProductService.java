package service;

import dao.ProductDao;
import java.util.List;
import model.Product;

public class ProductService {

    ProductDao productDao = null;

    public ProductService() {
        productDao = new ProductDao();
    }

    public List<Product> getProductByCategory(int idCategory) {
        return productDao.getProductByCategory(idCategory);
    }
    
    public int insertProduct(Product product) {
        return productDao.insertProduct(product);
    }
    
    public int deleteProduct(int product) {
        return productDao.deleteProduct(product);
    }
}
