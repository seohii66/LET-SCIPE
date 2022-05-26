package com.example.letscipe;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Fridge.class, Ingredient.class, Recipe.class}, version = 1, exportSchema = false)
public abstract class MyRoomDb extends RoomDatabase {

    private static MyRoomDb INSTANCE = null;

    public abstract FridgeDao fridgeDao();
    public abstract IngredientDao ingredientDao();
    public abstract  RecipeDao recipeDao();

    public synchronized static MyRoomDb getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), MyRoomDb.class, "myroomdb.db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
