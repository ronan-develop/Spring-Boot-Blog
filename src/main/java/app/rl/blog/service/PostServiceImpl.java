package app.rl.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.rl.blog.entity.Post;
import app.rl.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    public PostRepository postRepository;

    @Override
    public Post savePost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchPostList() {

        return postRepository.findAll();
    }
}
