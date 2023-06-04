package com.example.recipeapp;

public class User {

    private int Fav_recipe,Ingredients,meals,name,phone_number;

    public User(int fav_recipe, int ingredients, int meals, int name, int phone_number) {
        Fav_recipe = fav_recipe;
        Ingredients = ingredients;
        this.meals = meals;
        this.name = name;
        this.phone_number = phone_number;
    }

    public int getFav_recipe() {
        return Fav_recipe;
    }

    public void setFav_recipe(int fav_recipe) {
        Fav_recipe = fav_recipe;
    }

    public int getIngredients() {
        return Ingredients;
    }

    public void setIngredients(int ingredients) {
        Ingredients = ingredients;
    }

    public int getMeals() {
        return meals;
    }

    public void setMeals(int meals) {
        this.meals = meals;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
