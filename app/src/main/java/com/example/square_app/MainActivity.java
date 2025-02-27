package com.example.square_app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private MainView mv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        mv = new MainView(this);
        setContentView(mv);

    }
}