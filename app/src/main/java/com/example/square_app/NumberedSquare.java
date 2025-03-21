package com.example.square_app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;

public class NumberedSquare {

    private float squareWidth, squareHeight;
    private Paint outlinePaint;
    private Paint textPaint;
    private RectF bounds;
    private PointF velocity;

    private float right;
    private float bottom;

    private float screenWidth;
    private float screenHeight;

    public NumberedSquare(float w, float h) {

        // this is for the outline
        outlinePaint = new Paint();
        outlinePaint.setColor(Color.RED);
        outlinePaint.setStyle(Paint.Style.STROKE);
        outlinePaint.setStrokeWidth(10f);

        // this is for the text in the center
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50f);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD); // lets see if this typeface stuff does anything

        //10 percent of screen size
        squareWidth = w * 0.22f;
        squareHeight = h * 0.12f;

        //screen sized saved for later
        screenWidth = w;
        screenHeight = h;

        // random x y positions on map
        float x = (float) (Math.random() * (w - squareWidth)); // we subtract the squares size to make sure it does not get out of bounds
        float y = (float) (Math.random() * (h - squareHeight));


        right = x + squareWidth;
        bottom = y + squareHeight;
        bounds = new RectF(x, y, right, bottom);


        // this is for velocity
        float velX = (float) (1 + (Math.random() * 9)); //keeping it between 0.1-1
//        float velY = (float) (1 + (Math.random() * 9));


        velocity = new PointF(velX, velX);

    }


    public void draw(Canvas c, int number) {

        String numberText = String.valueOf(number + 1); // number that will be displayed
        c.drawRect(bounds, outlinePaint);
        c.drawText(numberText, bounds.centerX() - 9f, bounds.centerY() + 1.8f, textPaint);
    }

    public void move() {

        //hmm not really sure how

        bounds.offset(velocity.x, velocity.y);

        if (bounds.left < 0 || bounds.right > screenWidth) {
            velocity.x = -velocity.x; //reverse it
        }
        if (bounds.top < 0 || bounds.bottom > screenHeight) {
            velocity.y = -velocity.y;
        }


    }

    // getter
    public RectF getBounds() {
        return bounds;
    }

}