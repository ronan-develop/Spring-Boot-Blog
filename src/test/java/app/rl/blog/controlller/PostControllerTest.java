package app.rl.blog.controlller;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import app.rl.blog.controller.PostController;
import app.rl.blog.entity.Category;
import app.rl.blog.entity.Post;
import app.rl.blog.repository.PostRepository;
import app.rl.blog.service.PostService;

/**
 * Test Class for the {@link PostController}
 * 
 * @author Ronan Lenouvel - https://github.com/ronan-develop
 */
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testFetchPostListReturn200StatusOk() throws Exception {

        List<Post> posts = new ArrayList<>();

        Category category = new Category(
                1L,
                "title",
                "title",
                "This is the description",
                posts);

        Post post1 = Post.builder()
                .id(1l)
                .category(category)
                .slug("post-1")
                .title("Post 1")
                .content("content 1")
                .createdAt(LocalDateTime.now())
                .build();
        posts.add(post1);
        when(postRepository.findAll()).thenReturn(posts);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
