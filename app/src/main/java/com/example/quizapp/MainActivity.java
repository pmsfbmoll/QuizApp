package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions;
    private int[] answers;
    protected short qnum;
    protected TextView tv;
    protected short len;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.questions=getResources().getStringArray(R.array.array);
        this.qnum=0;
        this.answers= getResources().getIntArray(R.array.answers);
        len= (short) questions.length;
        tv = (TextView) findViewById(R.id.textView);
        tv.setText(questions[0]);
    }
    public void chooseTrue(View view){
        checkQuestion( 1);
        if(1+qnum<len){
            tv.setText(questions[++qnum]);
        }
    }
    public void chooseFalse(View view){
        checkQuestion(0);
        if(1+qnum<len){
            tv.setText(questions[++qnum]);
        }
    }
    public void prevQuestion(View view){
        if(qnum>0){
            tv.setText(questions[--qnum]);
        }
    }
    public void nextQuestion(View view){
        if(1+qnum<len){
            tv.setText(questions[++qnum]);
        }
    }
    private void checkQuestion(int input){
        String correct;
        if (input==answers[qnum]){
            correct="Correct!";
        }else{
            correct="Wrong";
        }
        Toast.makeText(MainActivity.this,correct, Toast.LENGTH_LONG).show();
    }
}

