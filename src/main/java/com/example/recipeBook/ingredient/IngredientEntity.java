package com.example.recipeBook.ingredient;

import com.example.recipeBook.recipeIngredients.RecipeIngredientsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ingredient")
@Table(name = "ingredients")
public class IngredientEntity {

    @Id
    @SequenceGenerator(
            name = "ingredient_sequence",
            sequenceName = "ingredient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredient_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(
            mappedBy = "ingredient",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<RecipeIngredientsEntity> recipeIngredientsEntityList = new ArrayList<>();
}
