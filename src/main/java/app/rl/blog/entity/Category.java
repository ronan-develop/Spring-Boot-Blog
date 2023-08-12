package app.rl.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
    @GeneratedValue
    protected Long id;
    @NotBlank(message = "Please add a title")
    protected String title;
    protected String slug;
    @Lob
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Please add a description")
    protected String description;    
}
