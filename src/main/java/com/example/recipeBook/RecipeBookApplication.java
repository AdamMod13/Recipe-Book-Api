package com.example.recipeBook;

import com.example.recipeBook.author.AuthorRepository;
import com.example.recipeBook.ingredient.IngredientRepository;
import com.example.recipeBook.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")

@SpringBootApplication
public class RecipeBookApplication {

    @Autowired
    public RecipeRepository recipeRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public IngredientRepository ingredientRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecipeBookApplication.class, args);
    }

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//			Faker faker = new Faker();
//			AuthorEntity author = new AuthorEntity(
//					faker.name().firstName(),
//					faker.name().lastName(),
//					"test8.test7@gmail.com"
//			);
//			author = authorRepository.save(author);
//			RecipeEntity newRecipe = new RecipeEntity(
//					faker.food().dish(),
//					"very very good",
//					LocalDate.now(),
//					author
//			);
//			IngredientEntity ingredient = new IngredientEntity(
//					faker.food().ingredient()
//			);
//			ingredient = ingredientRepository.save(ingredient);
//			newRecipe.addRecipeIngredient(new RecipeIngredientsEntity(
//					new RecipeIngredientsId(1L, 1L),
//					newRecipe,
//					new IngredientEntity(
//							faker.food().ingredient()
//					),
//					(long) faker.number().numberBetween(1, 20)
//			));
//			recipeRepository.save(newRecipe);
//		};
//	}

}
