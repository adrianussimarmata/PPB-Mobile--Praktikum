package com.example.homefan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggeButton;
    ImageView imageView;
    ObjectAnimator rotateAnimator;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0, 5000, 3000, 1000};
    GradientDrawable gd = new GradientDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView4);
        toggeButton = (ToggleButton) findViewById(R.id.toggleButton);
        switchButton = (Switch) findViewById(R.id.switch1);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);

        rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
        rotateAnimator.setDuration(1000);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setInterpolator(new LinearInterpolator());

        toggeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    rotateAnimator.setDuration(SPEED[seekBar.getProgress()]);
                    rotateAnimator.start();
                } else {
                    rotateAnimator.end();
                }
            }
        });

        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gd.setGradientRadius(330);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gd.setColors(new int[] {Color.CYAN, Color.TRANSPARENT});
                    imageView.setBackground(gd);
                } else {
                    imageView.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rotateAnimator.setDuration(SPEED[seekBar.getProgress()]);
                rotateAnimator.start();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}