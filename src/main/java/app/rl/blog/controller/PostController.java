package app.rl.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import app.rl.blog.dao.PostDAO;
import app.rl.blog.entity.Post;
import jakarta.validation.Valid;

@RestController
@EnableAutoConfiguration
public class PostController {

    @Autowired
    private PostDAO postService;

    private final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    /**
     * Create one Post
     * 
     * @param post
     * @return Post
     */
    @PostMapping("/api/posts")
    public Post savePost(@Valid @RequestBody Post post) {

        LOGGER.info("Post being created");
        return postService.savePost(post);
    }

    /**
     * Get All Posts
     * 
     * @return List
     */
    @GetMapping("/api/posts")
    public List<Post> fecthPostsList() {

        LOGGER.info("List for Posts is being generated");
        return postService.fetchPostList();
    }

    /**
     * Get All Posts by CategoryId
     * 
     * @param id
     * @return List
     */
    @GetMapping("/api/category/{id}/post")
    public List<Post> fetchPostsByCategoryId(Long id) {
        LOGGER.info("List for Posts is being generated");
        return postService.fetchPostsByCategoryId(id);
    }

    @DeleteMapping("/api/post/{id}")
    public String deletePostById(@PathVariable("id") Long id) {

        postService.deletePostById(id);
        return "{Post deleted}";
    }

}
