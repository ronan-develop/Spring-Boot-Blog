package app.rl.blog.service;


import java.util.List;
import app.rl.blog.entity.Category;

public interface CategoryService {

    public Category saveCategory(Category category);
    public List<Category> fetchCategorylist();
    public Category fetchCategoryById(Long id);    
}
