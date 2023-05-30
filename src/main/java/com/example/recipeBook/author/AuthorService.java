package com.example.recipeBook.author;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(AuthorEntity newAuthor) {
        authorRepository.save(newAuthor);
    }
}
