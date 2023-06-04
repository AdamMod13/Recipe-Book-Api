package com.example.recipeBook.recipe;

import com.example.recipeBook.author.AuthorEntity;
import com.example.recipeBook.ingredient.Ingredient;

import java.time.LocalDate;
import java.util.List;

public class Recipe {
    public Long id;
    public String recipeName;
    public String description;
    public LocalDate createDate;
    public String imagePath;
    public AuthorEntity author;
    public List<Ingredient> recipeIngredients;

    public Recipe(Long id, String recipeName, String description, LocalDate createDate, String imagePath, AuthorEntity author, List<Ingredient> recipeIngredients) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.createDate = createDate;
        this.imagePath = imagePath;
        this.author = author;
        this.recipeIngredients = recipeIngredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public List<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}
