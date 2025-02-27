package com.example.square_app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;

public class NumberedSquare {

    private float squareWidth, squareHeight;

    private Paint outlinePaint;
    private Paint textPaint;
    private RectF bounds;

    public NumberedSquare(float w, float h){

        // this is for the outline
        outlinePaint = new Paint();
        outlinePaint.setColor(Color.WHITE);
        outlinePaint.setStyle(Paint.Style.STROKE);
        outlinePaint.setStrokeWidth(10f);


        // this is for the text in the center
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50f);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD); // lets see if this typeface stuff does anything

        //10 percent of screen size
        squareWidth = w * 0.25f;
        squareHeight = h * 0.15f;

        // random x y positions on map
        float x = (float) (Math.random() * (w - squareWidth)); // we subtract the squares size to make sure it does not get out of bounds
        float y = (float) (Math.random() * (h - squareHeight));

        bounds = new RectF(x , y, x + squareWidth, y +  squareHeight);

    }


    public void draw(Canvas c){

        c.drawRect(bounds, outlinePaint);
        c.drawText("5", bounds.centerX() - 6f, bounds.centerY() + 1f, textPaint);
    }
}
