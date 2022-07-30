package com.example.moto_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {
    Button button;
    TextView textview;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        button = (Button)findViewById(R.id.button1);
        textview = (TextView)findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                timer = new CountDownTimerClass(10000, 1000);
                timer.start();

            }
        });

    }
    public class CountDownTimerClass extends CountDownTimer {
        public CountDownTimerClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished/1000);
            textview.setText(Integer.toString(progress));
        }
        @Override
        public void onFinish() {
            textview.setText(" Count Down Finish ");
        }
    }

}