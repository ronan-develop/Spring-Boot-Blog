package app.rl.blog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import app.rl.blog.entity.Category;
import app.rl.blog.repository.CategoryRepository;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {

        Category category = Category.builder()
                            .id(1L)
                            .title("Category_Unit_Test title")
                            .slug("category-unit-test-title")
                .description("Description of Category_Unit_Test title")
                .build();
        
        Mockito.when(categoryRepository.findByTitleIgnoreCase("Category_Unit_Test title"))
        .thenReturn(category);
    }

    @Test
    public void whenValidCategoryName_thenCategoryShouldFound() {

        String categoryName = "Category_Unit_Test title";
        Category found = categoryService.fetchCategoryByTitleIgnoreCase(categoryName);

        assertEquals(categoryName, found.getTitle());
    }
}
