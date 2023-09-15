package app.rl.blog.dao;

import java.util.List;

import app.rl.blog.entity.Post;
import jakarta.validation.Valid;

public interface PostDAO {

    public Post savePost(@Valid Post post);

    public List<Post> fetchPostList();

    public List<Post> fetchPostsByCategoryId(Long id);
    
    public void deletePostById(Long id);

    public Post updatePost(Long id, Post post);
}