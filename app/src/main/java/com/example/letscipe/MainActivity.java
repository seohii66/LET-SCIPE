package com.example.letscipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레시피 버튼
        ImageButton imageButton_recipe = (ImageButton) findViewById(R.id.imageButton_recipe);
        imageButton_recipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),RecipeActivity.class);                ;
                startActivity(intent);
            }
        });
        // 카메라 버튼
        ImageButton imageButton_cam = (ImageButton) findViewById(R.id.imageButton_cam);
        imageButton_cam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),CamActivity.class);
                startActivity(intent);
            }
        });

        // 냉장고 버튼
        ImageButton imageButton_ref = (ImageButton) findViewById(R.id.imageButton_ref);
        imageButton_ref.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),FridgeActivity.class);
                startActivity(intent);
            }
        });
    }
}