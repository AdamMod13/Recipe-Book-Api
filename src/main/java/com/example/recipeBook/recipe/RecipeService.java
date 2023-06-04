package com.example.recipeBook.recipe;

import com.example.recipeBook.ingredient.Ingredient;
import com.example.recipeBook.ingredient.IngredientEntity;
import com.example.recipeBook.ingredient.IngredientRepository;
import com.example.recipeBook.recipeIngredients.RecipeIngredientsEntity;
import com.example.recipeBook.recipeIngredients.RecipeIngredientsId;
import com.example.recipeBook.recipeIngredients.RecipeIngredientsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeIngredientsRepository recipeIngredientsRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, RecipeIngredientsRepository recipeIngredientsRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientsRepository = recipeIngredientsRepository;
    }

    public List<Recipe> getRecipes() {
        List<RecipeEntity> recipeEntityList = new ArrayList<>();
        List<Recipe> recipeList = new ArrayList<>();
        recipeEntityList = recipeRepository.findAll();

        recipeEntityList.forEach(recipeEntity -> {
            List<Ingredient> ingredients = new ArrayList<>();
            recipeEntity.getRecipeIngredientsEntityList().forEach(recipeIngredient -> {
                ingredients.add(
                        new Ingredient(
                                recipeIngredient.getIngredient().getId(),
                                recipeIngredient.getIngredient().getName(),
                                recipeIngredient.getQuantity()
                        )
                );
            });

            recipeList.add(new Recipe(
                    recipeEntity.getId(),
                    recipeEntity.getRecipeName(),
                    recipeEntity.getDescription(),
                    recipeEntity.getCreateDate(),
                    recipeEntity.getImagePath(),
                    recipeEntity.getAuthor(),
                    ingredients
            ));
        });

        return recipeList;
    }

    public void addRecipe(Recipe newRecipe) {
        RecipeEntity recipeEntity = new RecipeEntity(
                newRecipe.recipeName,
                newRecipe.description,
                LocalDate.now(),
                newRecipe.author,
                newRecipe.imagePath
        );

        List<IngredientEntity> ingredientList = new ArrayList<>();
        for (Ingredient ingredient : newRecipe.getRecipeIngredients()) {
            IngredientEntity ingredientEntity = new IngredientEntity(ingredient.getName());
            ingredientList.add(ingredientEntity);
        }

        ingredientList = this.ingredientRepository.saveAll(ingredientList);

        recipeEntity = this.recipeRepository.save(recipeEntity);

        for (int i = 0; i < ingredientList.size(); i++) {
            RecipeIngredientsEntity recipeIngredients = new RecipeIngredientsEntity(
                    new RecipeIngredientsId(recipeEntity.getId(), ingredientList.get(i).getId()),
                    recipeEntity,
                    ingredientList.get(i),
                    newRecipe.getRecipeIngredients().get(i).getQuantity()
            );
            recipeIngredientsRepository.save(recipeIngredients);
        }
    }
}
