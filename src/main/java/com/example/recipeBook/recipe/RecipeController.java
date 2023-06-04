package com.example.recipeBook.recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(path = "api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("")
    public List<Recipe> getRecipes() {
        return this.recipeService.getRecipes();
    }

    @PostMapping(value = "addRecipe")
    public void addRecipe(@RequestBody Recipe newRecipe) {
        this.recipeService.addRecipe(newRecipe);
    }
}
