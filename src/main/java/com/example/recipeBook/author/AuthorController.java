package com.example.recipeBook.author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(path = "/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public List<AuthorEntity> getAuthors() {
        return this.authorService.getAuthors();
    }

    @PostMapping(value = "sign-in/{email}")
    public ResponseEntity<AuthorEntity> signIn(@PathVariable String email) {
        AuthorEntity author = this.authorService.signIn(email);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @PostMapping(value = "addAuthor")
    public ResponseEntity<AuthorEntity> addAuthor(@RequestBody AuthorEntity newAuthor) {
        AuthorEntity author = this.authorService.addAuthor(newAuthor);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }
}
