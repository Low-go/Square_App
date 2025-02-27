package com.example.square_app;

import android.graphics.Color;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

public class MainView extends View {
    private float screenWidth, screenHeight;
    public boolean gameStarted;

    // We will be making this game in portait mode
    public MainView(Context c){
        super(c);
        gameStarted = false;


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
        }
    }

}
