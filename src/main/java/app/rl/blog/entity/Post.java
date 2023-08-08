package app.rl.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;
    private String slug;

    public Post() {
    }

    public Post(Long id, Long userId, String title, String content, String slug) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Post{" +
                " id='" + getId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", title='" + getTitle() + "'" +
                ", content='" + getContent() + "'" +
                ", slug='" + getSlug() + "'" +
                "}";
    }

    public Long getId() {

        return this.id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getUserId() {

        return this.userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getContent() {

        return this.content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public String getSlug() {

        return this.slug;
    }

    public void setSlug(String slug) {

        this.slug = slug;
    }
}
