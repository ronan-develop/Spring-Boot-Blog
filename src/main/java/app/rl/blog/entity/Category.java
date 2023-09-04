package app.rl.blog.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "Please add a title")
    protected String title;

    protected String slug;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Please add a description")
    protected String description;

    // mappedBy refers to the category property in Post Class
    @OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH })
    private List<Post> posts;

    public void add(Post tempPost) {

        if (posts == null) {
            posts = new ArrayList<>();
        }

        posts.add(tempPost);
        tempPost.setCategory(this);
    }
}
