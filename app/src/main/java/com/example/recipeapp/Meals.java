package com.example.recipeapp;

public class Meals extends Recipe{

   private int cuisine_type,fav_recipe;


    public Meals(int fav_recipe, int ingredients, int meals, int name, int phone_number, int instructions, int cuisine_type) {
        super(fav_recipe, ingredients, meals, name, phone_number, instructions, cuisine_type);
    }
}
