package com.example.letscipe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    public int recipeId;

    @ColumnInfo(name="recipeIndex")
    private int recipeIndex;

    @ColumnInfo(name="ingredientNum")
    private int ingredientNum;

    @ColumnInfo(name="dishName")
    private String dishName;

    @ColumnInfo(name="linkUrl")
    private String linkUrl;

    @ColumnInfo(name="imgUrl")
    private String imgUrl;

    /*public Recipe(int index, int ingredientNum, String dishName, String linkUrl, String imgUrl){
        this.recipeIndex = index;
        this.ingredientNum = ingredientNum;
        this.dishName = dishName;
        this.linkUrl = linkUrl;
        this.imgUrl = imgUrl;
    }*/
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getRecipeIndex() {
        return recipeIndex;
    }

    public void setRecipeIndex(int recipeIndex) {
        this.recipeIndex = recipeIndex;
    }

    public int getIngredientNum() {
        return ingredientNum;
    }

    public void setIngredientNum(int ingredientNum) {
        this.ingredientNum = ingredientNum;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
