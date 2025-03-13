package com.example.square_app;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

public class MainView extends View {
    private float screenWidth, screenHeight;
    public boolean gameStarted;

    private List<NumberedSquare> squares;


    private MassiveHandler ticker;

    // We will be making this game in portait mode
    public MainView(Context c){
        super(c);
        gameStarted = false;
        ticker = new MassiveHandler();
        ticker.sendEmptyMessageDelayed(0, 16); // why am i not just calling its method?

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

        // initialized here so that sqaure size is consistent/ wiped when called again
        squares = new ArrayList<>();

        int i = 0;
        // creates as many squares as passed in
        while (i < quantity){
            NumberedSquare tempSquare;
            boolean intersects;

            do { // make sure I create one square before initializing loop

                // do i need to keep track of these?
                tempSquare = new NumberedSquare(screenWidth, screenHeight);
                intersects = false;

                for (NumberedSquare square : squares){
                    //this is wild logic, i cant use intersect on the instance, need to do it on the actual bounds
                    if (tempSquare.getBounds().intersect(square.getBounds())){
                        intersects = true;
                        break;
                    }
                }
            } while (intersects);

            squares.add(tempSquare);
            i++;
        }
    }


    // lets attempt an ontouch event??
    @Override
    public boolean onTouchEvent(MotionEvent event){

        int eventAction = event.getAction();

        if (eventAction == MotionEvent.ACTION_DOWN){
            System.out.println("THE SCREEN WAS PRESSED");
            createSquares(5);
            invalidate(); // used to invoke onDraw again
            System.out.println("here is the square size " + squares.size());
        }
        return false;
    }


    // inner class, i dont really understand this
    private class MassiveHandler extends Handler{

        @Override
        public void handleMessage(Message msg){
            for (NumberedSquare square: squares){
                square.move();
            }
            invalidate();
            sendEmptyMessageDelayed(0, 16); //loop every 16ms
        }
    }
}
