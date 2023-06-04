package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private Button btrecipes,btuser,btshopping_list,btFav_recipe;
    private EditText etinstructions_recipe,name_edit,phone_edit;
    private   Spinner spCuisine_type_recipe;
    private ListView LVingredients_recipe;

    private TextView Recipes,Edit_profile,shopping_cart;

    private Recipe recipe;
    private User user;
    private ShoppingList Shopping_list;

    private DBHandler dbhandler;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///  Button for Recipes................................................................................................................
        btrecipes=(Button) findViewById(R.id.btn_recipe_main);
        dbhandler = new DBHandler(MainActivity.this);
        btrecipes.setOnClickListener(new View.OnClickListener() {
            Intent intent1 = new Intent(getApplicationContext(),Recipe.class);


            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                Recipes=(TextView) findViewById(R.id.recipes_recipe);
                Recipes.setText(R.layout.recipes);
               Recipes.getResources();
               String ResFav=btFav_recipe.getText().toString();
               String ResIng=LVingredients_recipe.getTextFilter().toString();
               String ResInc=etinstructions_recipe.getText().toString();
                if (ResFav.isEmpty() && ResIng.isEmpty() && ResInc.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbhandler.addNewRecipe(ResFav,ResIng,ResInc);
                Toast.makeText(MainActivity.this, "Recipes has been added.", Toast.LENGTH_SHORT).show();
                btFav_recipe.setText("");
                LVingredients_recipe.setFilterText("");
                etinstructions_recipe.setText("");

               spCuisine_type_recipe=(Spinner) findViewById(R.id.cuisine_type_recipes);
               spCuisine_type_recipe.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                   }
               });

               LVingredients_recipe=(ListView) findViewById(R.id.ingredients_recipes);
               LVingredients_recipe.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                   }
               });

               etinstructions_recipe=(EditText) findViewById(R.id.instructions_recipe);
               etinstructions_recipe.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                   }
               });

            }
        });



        /// Button for Users...................................................................................................................
        btuser=(Button) findViewById(R.id.btn_user_main);
        btuser.setOnClickListener(new View.OnClickListener() {

            Intent intent2 = new Intent(getApplicationContext(), User.class);
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                    String UsrName=name_edit.getText().toString();
                    String UsrPhone=phone_edit.getText().toString();
                    String UsrIng=LVingredients_recipe.getTextFilter().toString();
                    String UsrFav=btFav_recipe.getText().toString();

                if (UsrName.isEmpty() && UsrPhone.isEmpty() && UsrIng.isEmpty() && UsrFav.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }


                   dbhandler.addNewUser(UsrName,UsrPhone,UsrIng,UsrFav);

                Toast.makeText(MainActivity.this, "user has been added.", Toast.LENGTH_SHORT).show();
                name_edit.setText("");
                phone_edit.setText("");
                LVingredients_recipe.setFilterText("");
                btFav_recipe.setText("");


                     Edit_profile=(TextView) findViewById(R.id.editprofile_edit);
                     Edit_profile.setText(R.layout.edit_profile);
                     Edit_profile.getResources();

                     name_edit=(EditText) findViewById(R.id.name_edit);
                     name_edit.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                         }
                     });

                     phone_edit=(EditText) findViewById(R.id.phone_edit);
                     phone_edit.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                         }
                     });

                spCuisine_type_recipe=(Spinner) findViewById(R.id.cuisine_type_edit);
                spCuisine_type_recipe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                btFav_recipe=(Button) findViewById(R.id.favourite_shopping);
                btFav_recipe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });



        /// Button for Shopping List............................................................................................................
        btshopping_list=(Button) findViewById(R.id.btn_shopping_main);
        btshopping_list.setOnClickListener(new View.OnClickListener() {
            int str3= Integer.parseInt(btshopping_list.getText().toString());
            Intent intent=new Intent(getApplicationContext(), ShoppingList.class);
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                     shopping_cart=(TextView) findViewById(R.id.shoppingcart_shopping);
                     shopping_cart.setText(R.layout.shopping);
                     shopping_cart.getResources();

                     btFav_recipe=(Button) findViewById(R.id.favourite_edit);
                     btFav_recipe.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                         }
                     });

                     LVingredients_recipe=(ListView) findViewById(R.id.ingredients);
                     LVingredients_recipe.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {

                         }
                     });
            }
        });
    }

    private void getResources(int recipes) {




    }
}