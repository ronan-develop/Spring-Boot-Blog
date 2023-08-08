package app.rl.blog.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.rl.blog.entity.Category;
import app.rl.blog.service.CategoryService;

@RestController
@EnableAutoConfiguration
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    /**
     * Create one category
     * @param category
     * @return Category
     */
    @PostMapping("/api/categories")
    public Category saveCategory(@RequestBody Category category) {

        return categoryService.saveCategory(category);
    }
    
    /**
     * Get all Categories
     * @return List
     */
    @GetMapping("/api/categories")
    public List<Category> fetchCategorylist() {

        return categoryService.fetchCategorylist();
    }
}
