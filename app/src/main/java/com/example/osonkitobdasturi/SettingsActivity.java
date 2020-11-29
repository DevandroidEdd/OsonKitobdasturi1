package com.example.osonkitobdasturi;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{
    TextView font,size;
    int textsize =18;
    SeekBar seekBar;

@SuppressLint("SetTextI18n")
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        font = findViewById(R.id.font);
        size = findViewById(R.id.size);
        seekBar = findViewById(R.id.seekBar1);

        font.setTextSize(textsize);
        size.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressNew = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            textsize = textsize +(progress - progressNew);
            progressNew = progress;

            font.setTextSize(textsize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                font.setText(progressNew + "/" + seekBar.getMax());
            }
        });
//    float fs = prefs.getFloat("fontsize", 12);
//    seekBar1.setProgress((int)fs);
//tv_test.setTextSize(seekBar1.getProgress());
//    tv_test.setTextSize(TypedValue.COMPLEX_UNIT_PX,seekBar1.getProgress());

}


    @Override
    public void onClick(View v) {

    }
}
