package com.example.recipeBook.ingredient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
    public void addIngredient(@RequestBody IngredientEntity ingredient) {
        ingredientService.addIngredient(ingredient);
    }
}
