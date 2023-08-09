package app.rl.blog.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.rl.blog.entity.Category;
import app.rl.blog.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public Category saveCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> fetchCategorylist() {

        return categoryRepository.findAll();
    }

    @Override
    public Category fetchCategoryById(Long id) {

        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategoryById(Long id) {

        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Long id, Category category) {

        // Buffer Object
        Category catDB = categoryRepository.findById(id).get();

        if (Objects.nonNull(category.getTitle()) &&
                !"".equalsIgnoreCase(category.getTitle())) {

            catDB.setTitle(category.getTitle());
        }

        if (Objects.nonNull(category.getDescription()) &&
                !"".equalsIgnoreCase(category.getDescription())) {

            catDB.setDescription(category.getDescription());
        }

        if (Objects.nonNull(category.getSlug()) &&
                !"".equalsIgnoreCase(category.getSlug())) {

            catDB.setSlug(category.getSlug());
        }
        
        // Write Buffer Object in database
        return categoryRepository.save(catDB);
    }
}
