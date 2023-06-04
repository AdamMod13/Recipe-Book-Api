package com.example.recipeBook.ingredient;

import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void addIngredient(IngredientEntity newIngredient) {
        ingredientRepository.save(newIngredient);
    }
}
