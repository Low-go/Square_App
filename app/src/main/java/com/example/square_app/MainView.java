package com.example.square_app;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainView extends View {
    private float screenWidth, screenHeight;
    public boolean gameStarted;

    private List<NumberedSquare> squares;
    private NumberedSquare testSquare;

    // We will be making this game in portait mode
    public MainView(Context c){
        super(c);
        gameStarted = false;
        squares = new ArrayList<>();
    }


    // will constantly redraw the scene
    public void onDraw(Canvas c){
        c.drawColor(Color.CYAN);

        if (!gameStarted){
            screenWidth = getWidth();
            screenHeight = getHeight();
            gameStarted = true;
            Log.d("test", "Screen Width: " + screenWidth);;
            Log.d("test", "Screen Height: " + screenHeight);
            createSquares(5);
        }

        for (int i = 0; i < squares.size(); i++){
//            NumberedSquare temp = squares.get(i);
//            temp.draw(c, i);
            squares.get(i).draw(c,i); // lets see if both of these are valid or not
        }
    }

    //lets make a function to create squares
    public void createSquares(int quantity){

        // creates as many squares as passed in
        for (int i = 0; i < quantity; i ++ ){

            // do i need to keep track of these?
            squares.add(new NumberedSquare(screenWidth, screenHeight));

        }
    }

}
