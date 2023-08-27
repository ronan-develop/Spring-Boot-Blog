package app.rl.blog.service;

import java.util.List;

import app.rl.blog.entity.Post;
import jakarta.validation.Valid;

public interface PostService {

    public Post savePost(@Valid Post post);
    public List<Post> fetchPostList();
}