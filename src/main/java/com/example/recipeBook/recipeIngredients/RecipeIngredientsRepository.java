package com.example.recipeBook.recipeIngredients;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredientsEntity, RecipeIngredientsId> {
}
