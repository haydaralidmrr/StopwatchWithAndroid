package com.alihaydar.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView textView;
    Button button,button1;
    Runnable runnable;
    Handler handler;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.start);
        button1=findViewById(R.id.pause);
        textView=findViewById(R.id.textView2);
        num=0;



    }
    public void start(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time is:"+num);
                num++;
                textView.setText("Time is:"+num);
                handler.postDelayed(runnable,1000);


            }
        };
        handler.post(runnable);
        button.setEnabled(false);
        button1.setVisibility(View.VISIBLE);

        button1.setEnabled(true);


    }
    public void pause(View view){
        handler.removeCallbacks(runnable);
        button.setEnabled(true);
       button1.setEnabled(false);

    }
    public void reset(View view){
        num=0;
        textView.setText("Time:"+num);

    }
}