package com.example.letscipe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Recipe {
    private int index;
    private int ingredientNum;
    private String dishName;
    private String linkUrl;
    private String imgUrl;

    /*public Recipe(int index, int ingredientNum, String dishName, String linkUrl, String imgUrl){
        this.index = index;
        this.ingredientNum = ingredientNum;
        this.dishName = dishName;
        this.linkUrl = linkUrl;
        this.imgUrl = imgUrl;
    }*/

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
