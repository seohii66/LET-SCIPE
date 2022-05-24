package com.example.letscipe;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IngredientDao {
    @Query("SELECT * FROM ingredient")
    List<Ingredient> getALL();

    @Query("SELECT * FROM ingredient WHERE `ingredient` IN (:ingredientingredients)")
    List<Ingredient> loadAllByIndexes(int[] ingredientingredients);

    @Insert
    void insertAll(Ingredient... ingredients);

    @Delete
    void delete(Ingredient ingredient);
}
