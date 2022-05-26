// 피그마 화면 7번에 해당하는 자바 파일입니다.
// refrige_activity.xml로 레이아웃이 연결됩니다.
package com.example.letscipe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FridgeActivity extends AppCompatActivity {

    public ArrayList<Ingredient> ingredientList;

    RecyclerView recyclerView;

    List<Fridge> dataList = new ArrayList<>();
    List<Recipe> recipeList = new ArrayList<>();
    /*List<String> fridgeIngredientList = new ArrayList<>();
    List<Integer> recipeIndexList = new ArrayList<>();
    List<Integer> recipeIndexList2 = new ArrayList<>();
    List<Recipe> recipeList = new ArrayList<>();*/

    MyRoomDb database;
    FridgeAdapter adapter;

    private void initLoadDb(){
        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        ingredientList = mDbHelper.getIngredientTableData();
        recipeList = mDbHelper.getRecipeTableData();

        mDbHelper.close();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refrige_activity);

        recyclerView = findViewById(R.id.recycler_view);

        database = MyRoomDb.getInstance(this);
        dataList = database.fridgeDao().getALL();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FridgeAdapter(FridgeActivity.this, dataList);
        recyclerView.setAdapter(adapter);

        // home 버튼
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);                ;
                startActivity(intent);
            }
        });

        // 입력창
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("추가할 식재료를 입력해주세요");
        final EditText edit_text = new EditText(this);
        alert.setView(edit_text);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String add_ingredient = edit_text.getText().toString().trim();
                if(!add_ingredient.equals(""))
                {
                    Fridge fridge = new Fridge();
                    fridge.setIngredient(add_ingredient);
                    database.fridgeDao().insert(fridge);

                    edit_text.setText("");

                    dataList.clear();

                    dataList.addAll(database.fridgeDao().getALL());

                    adapter.notifyDataSetChanged();
                }
            }
        });
        alert.setNegativeButton("취소",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        // add 버튼
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                alert.show();
            }
        });

        // 레시피 보기 버튼
        ImageButton recipeBtn = (ImageButton) findViewById(R.id.recipeBtn);
        recipeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // 알고리즘 클래스로 넘기기
                initLoadDb();
                SelectRecipeAlgo selectRecipeAlgo = new SelectRecipeAlgo();
                selectRecipeAlgo.selectRecipe(ingredientList, recipeList);

                Intent intent = new Intent(getApplicationContext(),RecipeActivity.class);                ;
                startActivity(intent);
            }
        });


    }
}
