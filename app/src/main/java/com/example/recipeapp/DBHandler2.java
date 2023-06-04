package com.example.recipeapp;

import android.database.sqlite.SQLiteDatabase;

public interface DBHandler2 {
    void onUpgrade(SQLiteDatabase db1, SQLiteDatabase db2, int oldVersion, int newVersion);
}
