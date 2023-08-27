package app.rl.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.rl.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {   
}
