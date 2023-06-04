package com.example.recipeBook.ingredient;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
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
