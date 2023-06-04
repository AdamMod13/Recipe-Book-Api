package com.example.recipeBook.recipeIngredients;


import com.example.recipeBook.ingredient.IngredientEntity;
import com.example.recipeBook.recipe.RecipeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "RecipeIngredients")
@Table(name = "recipe_ingredients")
public class RecipeIngredientsEntity {

    @EmbeddedId
    private RecipeIngredientsId id;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    @JsonIgnore
    private RecipeEntity recipe;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    @JsonIgnore
    private IngredientEntity ingredient;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    public RecipeIngredientsEntity(RecipeEntity recipe, IngredientEntity ingredient, Long quantity) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public RecipeIngredientsEntity() {
    }

    public RecipeIngredientsEntity(RecipeIngredientsId id, RecipeEntity recipe, IngredientEntity ingredient, Long quantity) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public RecipeIngredientsId getId() {
        return id;
    }

    public void setId(RecipeIngredientsId id) {
        this.id = id;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
