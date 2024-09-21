package com.example.colorsetter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRed, textViewGreen, textViewBlue, colorPreview;
    private int red = 255, green = 206, blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);

        textViewRed = findViewById(R.id.textViewRed);
        textViewGreen = findViewById(R.id.textViewGreen);
        textViewBlue = findViewById(R.id.textViewBlue);
        colorPreview = findViewById(R.id.colorPreview);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        updateColor();
    }

    @SuppressLint("SetTextI18n")
    private void updateColor() {
        textViewRed.setText("Red : " + red);
        textViewGreen.setText("Green : " + green);
        textViewBlue.setText("Blue : " + blue);

        int color = Color.rgb(red, green, blue);
        colorPreview.setBackgroundColor(color);

        int invertedRed = 255 - red;
        int invertedGreen = 255 - green;
        int invertedBlue = 255 - blue;
        int invertedColor = Color.rgb(invertedRed, invertedGreen, invertedBlue);

        colorPreview.setText("(" + red + "," + green + "," + blue + ")");
        colorPreview.setTextColor(invertedColor);
    }
}
