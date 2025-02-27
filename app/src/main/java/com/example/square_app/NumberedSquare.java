package com.example.square_app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class NumberedSquare {

    private float squareWidth, squareHeight;

    private Paint paint;
    private RectF bounds;

    public NumberedSquare(float w, float h){

        paint = new Paint();
        paint.setColor(Color.WHITE);

        //10 percent of screen size
        squareWidth = w * 0.1f;
        squareHeight = h * 0.1f;

        // random x y positions on map
        float x = (float) (Math.random() * w);
        float y = (float) (Math.random() * h);

        bounds = new RectF( x, y, squareWidth, squareHeight);
    }


    public void draw(Canvas c){

        c.drawRect(bounds, paint);
    }
}
