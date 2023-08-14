package app.rl.blog.controlller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import app.rl.blog.entity.Category;
import app.rl.blog.service.CategoryService;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

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
    void testDeleteCategoryById() {

    }

    @Test
    void testFetchCategoryById() throws Exception {

        Mockito.when(categoryService.fetchCategoryById(1L))
                .thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(category.getTitle()));
    }

    @Test
    void testFetchCategoryByTitle() {

    }

    @Test
    void testFetchCategorylist() {

    }

    @Test
    void testSaveCategory() throws Exception {

        Category input = Category.builder()
                .title(null)
                .slug(null)
                .description(null)
                .build();

        Mockito.when(categoryService.saveCategory(input)).thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/categories").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + //
                        "    \"title\" : \"Title\",\n" + //
                        "    \"slug\" : \"title\",\n" + //
                        "    \"description\" : \"first test connected to database\"\n" + //
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUpdateCategory() {

    }
}
