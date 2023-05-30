package com.example.recipeBook.author;

import com.example.recipeBook.recipe.RecipeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Author")
@Table(name = "authors", uniqueConstraints = {
        @UniqueConstraint(name = "author_email_unique", columnNames = "email")
})
public class AuthorEntity {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<RecipeEntity> recipes = new ArrayList<>();
}
