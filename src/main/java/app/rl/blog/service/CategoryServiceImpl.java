package app.rl.blog.service;

import java.util.List;

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
}
