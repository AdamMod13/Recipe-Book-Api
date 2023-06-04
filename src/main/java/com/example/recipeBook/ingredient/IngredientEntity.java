package com.example.recipeBook.ingredient;

import com.example.recipeBook.recipeIngredients.RecipeIngredientsEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ingredient")
@Table(name = "ingredients")
public class IngredientEntity {

    @Id
    @SequenceGenerator(
            name = "ingredient_sequence",
            sequenceName = "ingredient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredient_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(
            mappedBy = "ingredient",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    @JsonIgnoreProperties("ingredient")
    private List<RecipeIngredientsEntity> recipeIngredientsEntityList = new ArrayList<>();

    public IngredientEntity() {
    }

    public IngredientEntity(String name) {
        this.name = name;
    }

    public void addRecipeIngredient(RecipeIngredientsEntity recipeIngredient) {
        if (!recipeIngredientsEntityList.contains(recipeIngredient)) {
            recipeIngredientsEntityList.add(recipeIngredient);
        }
    }

    public void removeRecipeIngredient(RecipeIngredientsEntity recipeIngredient) {
        recipeIngredientsEntityList.remove(recipeIngredient);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredientsEntity> getRecipeIngredientsEntityList() {
        return recipeIngredientsEntityList;
    }

    public void setRecipeIngredientsEntityList(List<RecipeIngredientsEntity> recipeIngredientsEntityList) {
        this.recipeIngredientsEntityList = recipeIngredientsEntityList;
    }
}
