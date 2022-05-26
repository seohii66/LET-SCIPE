package com.example.letscipe;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface RecipeDao {
    @Query("SELECT * FROM recipe")
    List<Recipe> getALL();

    @Query("SELECT * FROM recipe WHERE recipeIndex IN (:recipeindexes)")
    List<Recipe> loadRecipeByIndexes(List<Integer> recipeindexes);  // 이거??

    @Query("SELECT ingredientNum FROM recipe WHERE recipeIndex IN (:recipeindexes)")
    List<Integer> ingredientNumByIndexes(List<Integer> recipeindexes);

    @Insert
    void insert(Recipe recipe);

    @Delete
    void delete(Recipe recipe);

    @Query("SELECT * FROM recipe WHERE recipeIndex = :sIndex")
    Recipe selectRecipe(int sIndex);
}
