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
            testSquare = new NumberedSquare(screenWidth, screenHeight);
        }

        testSquare.draw(c);
    }

}
