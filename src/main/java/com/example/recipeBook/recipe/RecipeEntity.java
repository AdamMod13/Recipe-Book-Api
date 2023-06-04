package com.example.recipeBook.recipe;

import com.example.recipeBook.author.AuthorEntity;
import com.example.recipeBook.recipeIngredients.RecipeIngredientsEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Recipe")
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

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "author_recipe_fk"
            )
    )
    @JsonIgnoreProperties("recipes")
    private AuthorEntity author;
    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("recipe")
    private List<RecipeIngredientsEntity> recipeIngredientsEntityList = new ArrayList<>();

    public RecipeEntity() {
    }

    public RecipeEntity(String recipeName, String description, LocalDate createDate, AuthorEntity author, String imagePath) {
        this.recipeName = recipeName;
        this.description = description;
        this.createDate = createDate;
        this.author = author;
        this.imagePath = imagePath;
    }

    public RecipeEntity(Long id, String recipeName, String description, LocalDate createDate, String imagePath, AuthorEntity author) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.createDate = createDate;
        this.imagePath = imagePath;
        this.author = author;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public List<RecipeIngredientsEntity> getRecipeIngredientsEntityList() {
        return recipeIngredientsEntityList;
    }

    public void setRecipeIngredientsEntityList(List<RecipeIngredientsEntity> recipeIngredientsEntityList) {
        this.recipeIngredientsEntityList = recipeIngredientsEntityList;
    }

    public void addRecipeIngredient(RecipeIngredientsEntity recipeIngredient) {
        if (!recipeIngredientsEntityList.contains(recipeIngredient)) {
            recipeIngredientsEntityList.add(recipeIngredient);
        }
    }

    public void removeRecipeIngredient(RecipeIngredientsEntity recipeIngredient) {
        recipeIngredientsEntityList.remove(recipeIngredient);
    }
}
