package app.rl.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.rl.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByTitle(String title);
    public Category findByTitleIgnoreCase(String title);
}