package com.example.recipeBook.recipeIngredients;


import com.example.recipeBook.ingredient.IngredientEntity;
import com.example.recipeBook.recipe.RecipeEntity;

import javax.persistence.*;

@Entity(name = "RecipeIngredients")
@Table(name = "recipe_ingredients")
public class RecipeIngredientsEntity {

    @EmbeddedId
    private RecipeIngredientsId id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;

    @Column(name = "quantity", nullable = false)
    private Number quantity;

    public RecipeIngredientsEntity(RecipeIngredientsId id, RecipeEntity recipe, IngredientEntity ingredient, Number quantity) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public RecipeIngredientsEntity() {
    }
}
