package app.rl.blog.service;


import java.util.List;
import app.rl.blog.entity.Category;
import app.rl.blog.error.CategoryNotFoundException;

public interface CategoryService {

    public Category saveCategory(Category category);
    public List<Category> fetchCategorylist();
    public Category fetchCategoryById(Long id) throws CategoryNotFoundException;
    public Category updateCategory(Long id, Category category);
    public void deleteCategoryById(Long id);
    public Category fetchCategoryByTitle(String title);
}
