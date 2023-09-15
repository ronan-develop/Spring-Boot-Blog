package app.rl.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.rl.blog.dao.CategoryDAO;
import app.rl.blog.entity.Category;
import app.rl.blog.error.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO theCategoryDAO) {

        categoryDAO = theCategoryDAO;
    }

    @Override
    public List<Category> fetchCategorylist() {

        return categoryDAO.fetchCategorylist();
    }

    @Override
    public Category saveCategory(Category category) {
        
        return categoryDAO.saveCategory(category);
    }

    @Override
    public Category fetchCategoryById(Long id) throws CategoryNotFoundException {

        return categoryDAO.fetchCategoryById(id);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        
        return categoryDAO.updateCategory(id, category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        
        categoryDAO.deleteCategoryById(id);
    }

    @Override
    public Category fetchCategoryByTitle(String title) {

        return categoryDAO.fetchCategoryByTitle(title);
    }

    @Override
    public Category fetchCategoryByTitleIgnoreCase(String title) {
        
        return categoryDAO.fetchCategoryByTitleIgnoreCase(title);
    }


}
