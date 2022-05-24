package com.example.letscipe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient")
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="ingredient")
    public String ingredient;

    @ColumnInfo(name="index")
    public int index;

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
