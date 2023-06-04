package com.example.recipeBook.author;

import com.example.recipeBook.exception.AlreadyExistsException;
import com.example.recipeBook.exception.NotFoundException;
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

    public AuthorEntity addAuthor(AuthorEntity newAuthor) {
        if (!this.authorRepository.existsByEmail(newAuthor.getEmail())) {
            return authorRepository.save(newAuthor);
        } else {
            throw new AlreadyExistsException("Email already exists");
        }
    }

    public AuthorEntity signIn(String email) {
        if (this.authorRepository.existsByEmail(email)) {
            return this.authorRepository.findByEmail(email);
        } else {
            throw new NotFoundException("Email not found: " + email);
        }
    }
}
