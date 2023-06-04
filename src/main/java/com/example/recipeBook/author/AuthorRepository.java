package com.example.recipeBook.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Boolean existsByEmail(String email);

    AuthorEntity findByEmail(String email);
}
