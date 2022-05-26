package com.example.letscipe;

import java.util.ArrayList;
import java.util.List;

public class SelectRecipeAlgo {
    List<String> fridgeIngredientList = new ArrayList<>();
    List<Integer> ingredientRecipeIndexList = new ArrayList<>();
    List<Integer> indexCount = new ArrayList<>();
    List<Integer> ingredientNumList = new ArrayList<>();
    ArrayList<Recipe> selectedRecipeList = new ArrayList<>();

    MyRoomDb database;

    public ArrayList selectRecipe(List<Ingredient> ingredientList, List<Recipe> recipeList){

        fridgeIngredientList = database.fridgeDao().getALLIngredient();
        ingredientRecipeIndexList = database.ingredientDao().loadRecipeIndexByIngredientNames(fridgeIngredientList);
        countIndex(ingredientRecipeIndexList);
        ingredientNumList = database.recipeDao().ingredientNumByIndexes(ingredientRecipeIndexList);
        selectRecipeList(indexCount, ingredientNumList);
        return selectedRecipeList;
    }

    public List countIndex(List<Integer> ingredientRecipeIndexList){
        //List<Recipe> recipeList = new ArrayList<>();
        int count1 = 0, count2= 0, count3= 0, count4= 0, count5= 0, count6 = 0;
        for(int i=0; i<ingredientRecipeIndexList.size(); i++){
            if(ingredientRecipeIndexList.get(i) == 1){
                count1=count1+1;
            }else if(ingredientRecipeIndexList.get(i) == 2){
                count2=count2+1;
            }
            else if(ingredientRecipeIndexList.get(i) == 3){
                count3=count3+1;
            }
            else if(ingredientRecipeIndexList.get(i) == 4){
                count4=count4+1;
            }
            else if(ingredientRecipeIndexList.get(i) == 5){
                count5=count5+1;
            }
            else if(ingredientRecipeIndexList.get(i) == 6){
                count6=count6+1;
            }
        }
        indexCount.add(count1);
        indexCount.add(count2);
        indexCount.add(count3);
        indexCount.add(count4);
        indexCount.add(count5);
        indexCount.add(count6);

        return indexCount;
    }

    public ArrayList selectRecipeList(List<Integer> indexCount, List<Integer> ingredientNumList){
        for(int i = 0; i<6; i++){
            switch (indexCount.get(i) - ingredientNumList.get(i)){
                case 0:
                    database.recipeDao().selectRecipe(i+1); //add 써야할거같은디
                    selectedRecipeList.clear();
                    selectedRecipeList.addAll(database.recipeDao().getALL());
                    break;
                case 1:
                    database.recipeDao().selectRecipe(i+1); //add 써야할거같은디
                    selectedRecipeList.clear();
                    selectedRecipeList.addAll(database.recipeDao().getALL());
                    break;
                case 2:
                    database.recipeDao().selectRecipe(i+1); //add 써야할거같은디
                    selectedRecipeList.clear();
                    selectedRecipeList.addAll(database.recipeDao().getALL());
                    break;
            }
        }
        return selectedRecipeList;
    }

}
