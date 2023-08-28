package app.rl.blog.entity;

import java.sql.Date;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "createdAt")
    private Date createdAt;

    @NotBlank(message = "Please add a title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "category_id")
    private Category category;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Please add a content")
    private String content;
    private String slug;
}
