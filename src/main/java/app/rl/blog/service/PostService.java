package app.rl.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.rl.blog.entity.Post;
import jakarta.validation.Valid;

@Service
public interface PostService {
    
    public Post savePost(@Valid Post post);

    public List<Post> fetchPostList();

    public List<Post> fetchPostsByCategoryId(Long id);
    
    public void deletePostById(Long id);

    public Post updatePost(Long id, @Valid Post post);
}
