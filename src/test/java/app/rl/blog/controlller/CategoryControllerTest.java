package app.rl.blog.controlller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.rl.blog.controller.CategoryController;
import app.rl.blog.entity.Category;
import app.rl.blog.repository.CategoryRepository;
import app.rl.blog.service.CategoryService;


/**
 * Test Class for the {@link CategoryController}
 * 
 * @author Ronan Lenouvel - https://github.com/ronan-develop
 */
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired private MockMvc mockMvc;

    @Autowired private ObjectMapper objectMapper;

    @MockBean private CategoryService categoryService;
    
    @MockBean private CategoryRepository categoryRepository;

    private Category category;


    @BeforeEach
    void setUp() {

        // in database
        category = Category.builder()
                .id(1L)
                .title("title")
                .slug("title")
                .description("description")
                .build();
    }

    @Test
    void testDeleteCategoryById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/categories/{id}", category.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void testFetchCategoryById() throws Exception {

        Mockito.when(categoryService.fetchCategoryById(category.getId()))
                .thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/{id}", category.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(category.getTitle()));
    }

    @Test
    void testFetchCategoryByTitle() throws Exception {

        Mockito.when(categoryService.fetchCategoryByTitle("title"))
                .thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/title/title")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(category.getTitle()));
    }

    /* from here refacto */
    @Test
    void testFetchCategoryListReturn200StatusOk() throws Exception {

        List<Category> categories = new ArrayList<>();

        Category firstCategory = Category.builder()
                                .id(1L)
                                .title("title 1")
                                .slug("tilte1")
                                .description("description 1")
                                .build();

        categories.add(0, firstCategory);

        Category secondCategory = Category.builder()
                                .id(2L)
                                .title("title 2")
                                .slug("title-2")
                                .description("description 2")
                                .build();

        categories.add(1, secondCategory);

        when(categoryRepository.findAll()).thenReturn(categories);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories"))
            .andExpect(MockMvcResultMatchers.status().isOk());

        AssertionsForClassTypes.assertThat(categories.size() == 2);
    }

    @Test
    void testSaveCategoryReturn200StatusOk() throws Exception {

        String requestBody = objectMapper.writeValueAsString(category);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories").contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateCategoryShouldReturn400BadRequest() throws Exception {

        Category wrongFormat = Category.builder()
                .title(null)
                .slug(null)
                .description("description")
                .build();
        
        String requestBody = objectMapper.writeValueAsString(wrongFormat);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testUpdateCategoryShouldReturn200StatusOk() throws Exception {

        String requestBody = objectMapper.writeValueAsString(category);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testSaveCategoryShouldReturn400BadRequest() throws Exception {

        Category wrongFormat = Category.builder()
        .title(null)
        .description(null)
        .build();

        String requestBody = objectMapper.writeValueAsString(wrongFormat);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories")
        .contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andDo(MockMvcResultHandlers.print());
    }
}
