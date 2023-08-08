package app.rl.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Post {

    @Id
    private Long id;
    private Long userId;
    private String title;
    @Lob
    @Column(columnDefinition="TEXT")
    private String content;
}
