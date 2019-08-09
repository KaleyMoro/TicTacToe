package com.example.beginnersclass.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button version1;
    Button version2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        version1 = findViewById(R.id.game1);
        version2 = findViewById(R.id.game2);

        version1.setOnClickListener(this);
        version2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.game1:
                startActivity(new Intent(this,Game1Activity.class));
                break;

            case R.id.game2:
                startActivity(new Intent(this, Game2Activity.class));
                break;

        }

    }
}
