package app.rl.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.rl.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByTitle(String title);
    public Category findByTitleIgnoreCase(String title);
}