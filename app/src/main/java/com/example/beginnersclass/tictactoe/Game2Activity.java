package com.example.beginnersclass.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Game2Activity extends AppCompatActivity {

    boolean player1Turn = true;
    int roundCount;
    Button[][] buttons = new Button[3][3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        for (int i=0; i < 3; i++) {
            for (int j=0; j < 3; j++){
                String buttonID = "button"+i+j;
                int resID =getResources().getIdentifier(buttonID, "id",getPackageName());
                buttons[i][j] = findViewById(resID);
            }
        }
    }
    public void ButtonClick(View view) {
        if (!((Button) view).getText().toString().equals("")){

            return;
        }

        if (player1Turn){
            ((Button) view).setText("X");
        }else {
            ((Button) view).setText("O");
        }

        roundCount++;

        if (checkForWin()){
            if (player1Turn){
                Toast.makeText(this, "Player 1 WINS!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Player 2 WINS!", Toast.LENGTH_SHORT).show();
            }
        } else if(roundCount == 9) {
            Toast.makeText(this, "DRAW!", Toast.LENGTH_SHORT).show();

        }


    }

    public boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i=0; i <3; i++){
            for (int j=0; j <3; j++){
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i=0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) &&
                    field[i][1].equals(field[i][2]) &&
                    !field[i][0].equals("") ) {
                return true;
            }
        }

        for (int i=0; i < 3; i++) {
            if (field[0][i].equals( field[1][i]) &&
                    field[1][i].equals(field[2][i]) &&
                    !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1]) &&
                field[1][1].equals(field[2][2]) &&
                !field[0][0].equals("")) {
            return true;
        }
            if (field[0][2].equals(field[1][1]) &&
                    field[0][2].equals(field[2][0]) &&
                    !field[0][2].equals("")) {
                return true;
            }

            return false;
    }


}
