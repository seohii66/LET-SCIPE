// 피그마 화면 6번에 해당하는 자바 파일입니다.
// recipe_list.xml로 레이아웃이 연결됩니다.
package com.example.letscipe;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    //public ArrayList<Recipe> recipeList;
    String linkURL = null;

    SelectRecipeAlgo selectRecipeAlgo = new SelectRecipeAlgo();
    public ArrayList<Recipe> selectedRecipeList;



    MyRoomDb database;
    private RecipeAdapter adapter = new RecipeAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

        database = MyRoomDb.getInstance(this);
        selectedRecipeList = selectRecipeAlgo.selectedRecipeList;

        // home 버튼
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);                ;
                startActivity(intent);
            }
        });

        // recyclerView 초기화
        RecyclerView recyclerView = findViewById(R.id.recycler_view2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //아이템 로드
        adapter.setItems(selectedRecipeList);



        // 아이템 클릭 이벤트
        adapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            @Override
            public void onItemClick(View v, int position) {
                Recipe recipe = selectedRecipeList.get(position);
                linkURL = recipe.getLinkUrl();
                intent.setData(Uri.parse(linkURL)); //동영상 URL link
                startActivity(intent);
            }
        });
    }
}
