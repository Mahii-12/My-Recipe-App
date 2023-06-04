package com.example.recipeapp;

public class Recipe  {

    private int instructions,cuisine_type, fav_recipe,meals,ingredients;

    public Recipe(String instructions, String cuisinie_type, String fav_recipe, String ingredients) {
        this.fav_recipe= Integer.parseInt(fav_recipe);
        this.meals=meals;
        this.ingredients= Integer.parseInt(ingredients);
        this.instructions = Integer.parseInt(instructions);
        this.cuisine_type = cuisine_type;
    }

    public Recipe(int fav_recipe, int ingredients, int meals, int name, int phone_number, int instructions, int cuisine_type) {
    }


    public int getFav_recipe() {
        return fav_recipe;
    }

    public void setFav_recipe(int fav_recipe) {
        this.fav_recipe = fav_recipe;
    }

    public int getMeals() {
        return meals;
    }

    public void setMeals(int meals) {
        this.meals = meals;
    }

    public int getIngredients() {
        return ingredients;
    }

    public void setIngredients(int ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe(int fav_recipe, int ingredients, int meals, int  instructions, int cuisine_type) {
         this.fav_recipe=fav_recipe;
         this.meals=meals;
         this.ingredients=ingredients;
        this.instructions = instructions;
        this.cuisine_type = cuisine_type;
    }

    public int getInstructions() {
        return instructions;
    }

    public void setInstructions(int instructions) {
        this.instructions = instructions;
    }

    public int getCuisine_type() {
        return cuisine_type;
    }

    public void setCuisine_type(int cuisine_type) {
        this.cuisine_type = cuisine_type;
    }
}
