package app.rl.blog.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.rl.blog.entity.Category;
import app.rl.blog.service.CategoryService;

@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public Category saveCategory(@RequestBody Category category) {

        return categoryService.saveCategory(category);
    }
}
