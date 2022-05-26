package com.example.letscipe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient")
public class Ingredient {

    @ColumnInfo(name="ingredientName")
    public String ingredientName;

    @ColumnInfo(name="recipeIndex")
    public int recipeIndex;

    @PrimaryKey(autoGenerate = true)
    public int ingredientId;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIndex() {
        return recipeIndex;
    }

    public void setIndex(int index) {
        this.recipeIndex = index;
    }

    public int getId() {
        return ingredientId;
    }

    public void setId(int id) {
        this.ingredientId = id;
    }
}
