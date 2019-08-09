package com.example.beginnersclass.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game1Activity extends AppCompatActivity {

    int activePlayer = 0; //0=Green 1=Red

    boolean gameIsActive = true;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPostitions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn (View view) {
        ImageView counter = (ImageView) view;

        System.out.println(counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);


            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.green);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(360);

            for (int[] winningPostitions :winningPostitions) {
                if (gameState[winningPostitions[0]]== gameState[winningPostitions[1]] &&
                        gameState[winningPostitions[1]]== gameState[winningPostitions[2]] &&
                        gameState[winningPostitions[0]] != 2){

                    gameIsActive = false;

                    String winner = "Red";

                    if (gameState[winningPostitions[0]] == 0) {

                        winner = "Green";

                    }

                    TextView winnerMessage = findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + "has won!");
                    LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    playAgainLayout.setVisibility(View.VISIBLE);

                } else {
                    boolean gameIsOver = true;
                    for (int counterState: gameState){
                        if (counterState == 2)  gameIsOver = false;


                    }
                    if (gameIsOver) {
                        TextView winnerMessage = findViewById(R.id.winnerMessage);
                        winnerMessage.setText("It's Draw!");
                        LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        playAgainLayout.setVisibility(View.VISIBLE);

                    }
                }

            }
        }

        Button playAgainBtn = (Button) findViewById(R.id.playAgainButton);
        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gameIsActive = true;

                LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
                playAgainLayout.setVisibility(View.INVISIBLE);

                activePlayer = 0;
                for (int i = 0; i < gameState.length; i++) {
                    gameState[i] = 2;
                }

                GridLayout gridLayout = findViewById(R.id.gridLayout);
                for (int i=0; i < gridLayout.getChildCount(); i++) {
                    ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
                }

            }
        });





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
    }
}
