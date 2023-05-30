package com.example.recipeBook.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public void addIngredient(IngredientEntity newIngredient) {
        ingredientRepository.save(newIngredient);
    }
}
