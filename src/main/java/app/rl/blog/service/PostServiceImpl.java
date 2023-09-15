package app.rl.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.rl.blog.dao.PostDAO;
import app.rl.blog.entity.Post;
import app.rl.blog.error.PostNotFoundException;
import jakarta.validation.Valid;

@Service
public class PostServiceImpl implements PostService{

    private PostDAO postDAO;

    public PostServiceImpl(PostDAO thePostDAO) {

        postDAO = thePostDAO;
    }

    @Override
    public Post savePost(@Valid Post post) {
        
        return postDAO.savePost(post);
    }

    @Override
    public List<Post> fetchPostList() {
        
        return postDAO.fetchPostList();
    }

    @Override
    public List<Post> fetchPostsByCategoryId(Long id) {

        return postDAO.fetchPostsByCategoryId(id);
    }

    @Override
    public void deletePostById(Long id) {

        postDAO.deletePostById(id);
    }

    @Override
    public Post updatePost(Long id, @Valid Post post) {

        return postDAO.updatePost(id, post);
    }

    @Override
    public Post fetchPostById(Long id) throws PostNotFoundException {

        return postDAO.fetchPostById(id);
    }


        

}
