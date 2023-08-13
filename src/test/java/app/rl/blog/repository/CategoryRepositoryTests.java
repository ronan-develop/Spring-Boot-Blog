package app.rl.blog.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import app.rl.blog.entity.Category;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void CategoryRepository_SaveAll_ReturnSavedCategory() {

        Category category = Category.builder()
                .id(1L)
                .title("title")
                .description("description")
                .slug("title").build();

        Category savedCategory = categoryRepository.save(category);

        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isPositive();
    }

    @Test
    public void CategoryRepository_GetAll_ReturnMoreThanOneCategory() {

        Category category1 = Category.builder()
                .id(1L)
                .title("category-1")
                .slug("category-1")
                .description("description")
                .build();
        
        Category category2 = Category.builder()
                .id(2L)
                .title("titre-2")
                .slug("titre-2")
                .description("description")
                .build();
        
            categoryRepository.save(category1);
            categoryRepository.save(category2);

        List<Category> categoryList = categoryRepository.findAll();

        Assertions.assertThat(categoryList).hasSize(2);
    }

    @Test
    public void CategoryRepository_FindByID_ReturnCategory() {

        Category category = Category.builder()
                .id(1L)
                .title("title")
                .slug("title")
                .description("description")
                .build();

        categoryRepository.save(category);

        Category savedCategory = categoryRepository.findById(category.getId()).get();

        Assertions.assertThat(savedCategory.getId()).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isSameAs(category.getId());
    }

    @Test
    public void FindByTitleReturnCategoryNotNull() {
     
        Category category = Category.builder()
                .id(1L)
                .title("Title")
                .slug("title")
                .description("description")
                .build();
        
        categoryRepository.save(category);

        Category found = categoryRepository.findByTitle("Title").get();

        Assertions.assertThat(found).isNotNull();
    }

    @Test
    void testFindByTitleIgnoreCase() {
     
        Category category = Category.builder()
                .id(1L)
                .title("Title")
                .slug("title")
                .description("description")
                .build();
        
        categoryRepository.save(category);
        String title = category.getTitle().toLowerCase();

        final Category found = categoryRepository.findByTitleIgnoreCase(title);

        Assertions.assertThat(found).isEqualTo(category);
    }
    
}
