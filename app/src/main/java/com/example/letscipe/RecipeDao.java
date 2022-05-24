package com.example.letscipe;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("SELECT * FROM recipe")
    List<Recipe> getALL();

    @Query("SELECT * FROM recipe WHERE `index` IN (:recipeindexes)")
    List<Recipe> loadAllByIndexes(int[] recipeindexes);

    @Insert
    void insertAll(Recipe... recipes);

    @Delete
    void delete(Recipe recipe);
}
