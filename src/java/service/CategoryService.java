package service;

import dao.CategoryDao;
import java.util.List;
import model.Category;

public class CategoryService {

    CategoryDao categoryDao = null;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
