package com.example.recipeBook.author;

import com.example.recipeBook.ingredient.IngredientEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public List<AuthorEntity> getAuthors() {
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public void addIngredient(@RequestBody AuthorEntity newAuthor) {
        authorService.addAuthor(newAuthor);
    }
}
