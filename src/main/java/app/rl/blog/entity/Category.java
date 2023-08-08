package app.rl.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class Category {
    
    
    protected Long id;
    protected String title;
    protected String slug;
    @Lob
    @Column(columnDefinition = "TEXT")
    protected String description;

    public Category() {
    }

    public Category(Long id, String title, String slug, String description) {

        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
    }


    public Long getId() {

        return this.id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitle() {
        
        return this.title;

    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getSlug() {

        return this.slug;
    }

    public void setSlug(String slug) {

        this.slug = slug;
    }

    public String getDescription() {

        return this.description;
    }

    public void setDescription(String description) {

        this.description = description;
    }
     

}
