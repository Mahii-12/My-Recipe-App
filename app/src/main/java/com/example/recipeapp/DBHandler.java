package com.example.recipeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper implements DBHandler2 {


    private static final String DB_name="RecipeDB";
    private static final int DB_version=1;
    private static final String Table_name="User";
    private static final String Name_Col="Name";
    private static final String phone_Col="PhoneNumber";
    private static final String FavRec_Col="Fav_Recipe";
    private static final String Meals_Col="Meals";
    private static final String Ingred_Col="Ingredients";


    private static final String Table_name2="Recipe";
    private static final String FavRec_Col3="Fav_Recipe";
    private static final String Meals_Col4="Meals";
    private static final String Ingred_Col5="Ingredients";
    private static final String Instruct_Col6="Instructions";

    public DBHandler(Context context) {
        super(context,DB_name,null,DB_version);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query1 = "CREATE TABLE " + Table_name + " ("
                + Name_Col + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + phone_Col + " TEXT,"
                + FavRec_Col + " TEXT,"
                + Meals_Col + " TEXT,"
                + Ingred_Col + " TEXT)";

        String query2 = "CREATE TABLE " + Table_name2 + " ("
                + FavRec_Col3 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Instruct_Col6 + " TEXT,"
                + Ingred_Col5 + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query1);
        db.execSQL(query2);
    }


    public void addNewUser(String UsrName,String usrPhnNum,String UsrIng,String FavRec){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put(Name_Col,UsrName);
        values1.put(phone_Col,usrPhnNum);
        values1.put(Ingred_Col,UsrIng);
        values1.put(FavRec_Col,FavRec);

        db1.insert(Table_name,null,values1);
        db1.close();
    }

    public void addNewRecipe(String ResFav,String ResIng, String ResInc){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues values2 = new ContentValues();
        values2.put(FavRec_Col3,ResFav);
        values2.put(Ingred_Col5,ResIng);
        values2.put(Instruct_Col6,ResInc);


        db2.insert(Table_name2,null,values2);
        db2.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, SQLiteDatabase db2, int oldVersion, int newVersion) {
        db1.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db1);
        db2.execSQL("DROP TABLE IF EXISTS " + Table_name2);
        onCreate(db2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //     method for reading all the recipes.........................
    public ArrayList<Recipe> readUser(){
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor cursorRecipes = db1.rawQuery("SELECT * FROM " + Table_name2, null);

        ArrayList<Recipe> NewRecipeArrayList
                = new ArrayList<>();

        if (cursorRecipes.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                NewRecipeArrayList.add(new Recipe(
                        cursorRecipes.getString(1),
                        cursorRecipes.getString(4),
                        cursorRecipes.getString(2),
                        cursorRecipes.getString(3)));
            } while (cursorRecipes.moveToNext());
            // moving our cursor to next.
        }
        cursorRecipes.close();
        return NewRecipeArrayList;
    }

}
