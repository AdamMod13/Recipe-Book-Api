package com.example.recipeBook.recipe;

import com.example.recipeBook.author.AuthorEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "recipe")
@Table(name = "recipes")
public class RecipeEntity {

    @Id
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "author_recipe_fk"
            )
    )
    private AuthorEntity author;

    public RecipeEntity(String recipeName, String description, LocalDate createDate, AuthorEntity author) {
        this.recipeName = recipeName;
        this.description = description;
        this.createDate = createDate;
        this.author = author;
    }

    public RecipeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
