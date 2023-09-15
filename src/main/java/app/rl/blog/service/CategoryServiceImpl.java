package app.rl.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.rl.blog.dao.CategoryDAO;
import app.rl.blog.entity.Category;

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


}
