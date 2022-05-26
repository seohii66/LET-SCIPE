package com.example.letscipe;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter {

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public DataAdapter(Context context){
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException{
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter open() throws SQLException{
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public ArrayList getIngredientTableData() {
        try {
            String sql = "SELECT * FROM Ingredient";

            ArrayList ingredientList = new ArrayList();

            Ingredient ingredient = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur != null) {
                // 칼럼의 마지막까지
                while (mCur.moveToNext()) {

                    // TODO : 커스텀 모델 생성
                    ingredient = new Ingredient();

                    // TODO : Record 기술
                    // ingredientName, index, id
                    ingredient.setIngredientName(mCur.getString(0));
                    ingredient.setIndex(mCur.getInt(1));
                    ingredient.setId(mCur.getInt(2));

                    // 리스트에 넣기
                    ingredientList.add(ingredient);
                }
            }
            return ingredientList;
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }

    public ArrayList getRecipeTableData() {
        try {
            String sql = "SELECT * FROM Recipe";

            ArrayList recipeList = new ArrayList();

            Recipe recipe = null;

            Cursor mCur = mDb.rawQuery(sql, null);
            if (mCur != null) {
                // 칼럼의 마지막까지
                while (mCur.moveToNext()) {

                    // TODO : 커스텀 모델 생성
                    recipe = new Recipe();

                    // TODO : Record 기술
                    // index, ingredientNum, dishName, linkUrl, imgUrl
                    recipe.setRecipeIndex(mCur.getInt(0));
                    recipe.setIngredientNum(mCur.getInt(1));
                    recipe.setDishName(mCur.getString(2));
                    recipe.setLinkUrl(mCur.getString(3));
                    recipe.setImgUrl(mCur.getString(4));

                    // 리스트에 넣기
                    recipeList.add(recipe);
                }
            }
            return recipeList;
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }
}
