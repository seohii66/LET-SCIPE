package com.example.letscipe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

@Entity(tableName = "fridge")
public class Fridge {
    @PrimaryKey(autoGenerate = true)
    public int fridgeId;

    @ColumnInfo(name="ingredient")
    public String ingredient;

    public int getId() { return fridgeId;}

    public void setId(int id) {
        this.fridgeId = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
