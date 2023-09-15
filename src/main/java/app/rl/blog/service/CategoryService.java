package app.rl.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.rl.blog.entity.Category;

@Service
public interface CategoryService {

    public List<Category> fetchCategorylist();
}
