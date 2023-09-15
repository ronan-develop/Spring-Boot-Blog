// package app.rl.blog.repository;

// import java.sql.Date;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

// import org.junit.jupiter.api.BeforeEach;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
// import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import app.rl.blog.entity.Post;
// import jakarta.persistence.EntityManager;

// @DataJpaTest
// @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
// public class PostRepositoryTest {
    
//     @Autowired
//     private PostRepository postRepository;

//     @Autowired
//     private EntityManager entityManager;

//     @BeforeEach
//     void setup() {

//         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//         LocalDateTime now = LocalDateTime.now();

//         Post post = Post.builder()
//                     .title("Title for test")
//                     .slug("title-for-test")
//                     .content("This is the content")
//                     .createdAt(now)
//                     .category_id();
//     }
// }
