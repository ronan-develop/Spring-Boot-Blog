package app.rl.blog.controlller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.rl.blog.entity.Category;
import app.rl.blog.service.CategoryService;
import jakarta.validation.Valid;

@RestController
@EnableAutoConfiguration
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    private final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    /**
     * Create one category
     * @param category
     * @return Category
     */
    @PostMapping("/api/categories")
    public Category saveCategory(@Valid @RequestBody Category category) {

        LOGGER.info("A Log Inside saveCategory of CategoryController");
        return categoryService.saveCategory(category);
    }
    
    /**
     * Get all Categories
     * @return List
     */
    @GetMapping("/api/categories")
    public List<Category> fetchCategorylist() {

        LOGGER.info("A Log Inside fetchCategorylist of CategoryController");
        return categoryService.fetchCategorylist();
    }

    /**
     * Get one category by id
     * @param id
     * @return
     */
    @GetMapping("/api/categories/{id}")
    public Category fetchCategoryById(@PathVariable("id") Long id) {

        LOGGER.info("A LogInside fetchCategoryById of CategoryController");
        return categoryService.fetchCategoryById(id);
    }

    /**
     * Delete one Category by id
     * @param id
     * @return
     */
    @DeleteMapping("/api/categories/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id) {

        categoryService.deleteCategoryById(id);
        return "{Category deleted}";
    }


    @PutMapping("/api/categories/{id}")
    public Category updateCategory(
            @PathVariable("id") Long id,
            @RequestBody Category category
    ) {

        return categoryService.updateCategory(id, category);
    }
    
    @GetMapping("/api/categories/title/{title}")
    public Category fetchCategoryByTitle(@PathVariable("title") String title) {

        return categoryService.fetchCategoryByTitle(title);
    }
}
