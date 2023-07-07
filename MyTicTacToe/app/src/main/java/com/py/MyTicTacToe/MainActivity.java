package com.py.MyTicTacToe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0 - O;
    //1 - X;

    boolean gameactive = true;


    int activePlayer =0;

    int [] gameState = {2,2,2,2,2,2,2,2,2};
    //0 - O
    //1 - X
    //2 - null
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    public static int counter = 0 ;



    public void playerTap(View view){
        ImageView img = (ImageView)view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gameReset(view);
        }
        if (gameState[tappedImage]==2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            counter++;
            if (activePlayer == 0) {
                activePlayer = 1;
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.status);
                status.setText("O's turn - Tap to play !!");
            } else {
                activePlayer = 0;
                img.setImageResource(R.drawable.xx);
                TextView status = findViewById(R.id.status);
                status.setText("x's turn - Tap to play !!");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
            if (counter == 9) {
                gameactive = false;
            }
        int flag = 0;
        //check if somebody won
        for (int [] winposition:winningPositions){
            if(gameState[winposition[0]]==gameState[winposition[1]]&&gameState[winposition[1]]==gameState[winposition[2]]&& gameState[winposition[0]]!=2) {
                String winstr;
                flag =1;

                if (gameState[winposition[0]] == 0) {
                    winstr = "O has won !!";
                }
                else {
                    winstr = "X has won !!";
                }
                //update the status bar
                TextView status = findViewById(R.id.status);
                status.setText(winstr);
                gameactive=false;
            }}
        if (counter==0 &&flag==0){
            TextView status = findViewById(R.id.status);
            status.setText("Match draw");
        }
    }

    public void gameReset(View view){
        activePlayer = 0;

         gameState = new int[]{2,2,2,2,2,2,2,2,2};
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText ("O's turn - Tap to play !!");
        gameactive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}