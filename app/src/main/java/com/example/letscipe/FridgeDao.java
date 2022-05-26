package com.example.letscipe;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FridgeDao {
    @Query("SELECT * FROM fridge")
    List<Fridge> getALL();

    @Query("SELECT ingredient FROM fridge")
    List<String> getALLIngredient();

    @Insert
    void insert(Fridge fridge);

    @Delete
    void delete(Fridge fridge);

    @Delete
    void reset(List<Fridge> fridges);

    @Query("UPDATE fridge SET ingredient = :sText WHERE fridgeId = :sID")
    void update(int sID, String sText);
}
