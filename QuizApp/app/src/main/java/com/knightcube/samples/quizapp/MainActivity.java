package com.knightcube.samples.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton question1OptionA;
    EditText question2Answer;
    CheckBox question3OptionA;
    CheckBox question3OptionB;
    CheckBox question3OptionC;
    CheckBox question3OptionD;
    RadioButton question4OptionC;
    EditText question5Answer;
    CheckBox question6OptionA;
    CheckBox question6OptionB;
    CheckBox question6OptionC;
    CheckBox question6OptionD;
    RadioButton question7OptionB;
    EditText question8Answer;
    CheckBox question9OptionA;
    CheckBox question9OptionB;
    CheckBox question9OptionC;
    CheckBox question9OptionD;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void evaluate(View view) {
        question1OptionA = (RadioButton)findViewById(R.id.question_type_1_option_A);
        if (question1OptionA.isChecked()) {
            score ++;
        }
        question2Answer = (EditText)findViewById(R.id.question_2_answer);
        if(question2Answer.getText()!=null) {
            if (question2Answer.getText().toString().equals("He")) {
                score++;
            }
        }else{
            Toast.makeText(MainActivity.this,"Fill in the blanks of question 2",Toast.LENGTH_LONG).show();
        }
        question3OptionA = (CheckBox)findViewById(R.id.question_type_3_option_A);
        question3OptionB = (CheckBox)findViewById(R.id.question_type_3_option_B);
        question3OptionC = (CheckBox)findViewById(R.id.question_type_3_option_C);
        question3OptionD = (CheckBox)findViewById(R.id.question_type_3_option_D);
        if(question3OptionA.isChecked() && question3OptionB.isChecked() && !question3OptionC.isChecked() && !question3OptionD.isChecked()){
            score++;
        }
        question4OptionC = (RadioButton)findViewById(R.id.question_type_4_option_C);
        if (question4OptionC.isChecked()) {
            score ++;
        }
        question5Answer = (EditText)findViewById(R.id.question_5_answer);
        if(question5Answer.getText()!=null) {
            if (question5Answer.getText().toString().equals("Xe")) {
                score++;
            }
        }else{
            Toast.makeText(MainActivity.this,"Fill in the blanks of question 5",Toast.LENGTH_LONG).show();
        }
        question6OptionA = (CheckBox)findViewById(R.id.question_type_6_option_A);
        question6OptionB = (CheckBox)findViewById(R.id.question_type_6_option_B);
        question6OptionC = (CheckBox)findViewById(R.id.question_type_6_option_C);
        question6OptionD = (CheckBox)findViewById(R.id.question_type_6_option_D);
        if(question6OptionA.isChecked() && question6OptionB.isChecked() && question6OptionC.isChecked() && !question6OptionD.isChecked()){
            score++;
        }
        question7OptionB = (RadioButton)findViewById(R.id.question_type_7_option_B);
        if (question7OptionB.isChecked()) {
            score ++;
        }
        question8Answer = (EditText)findViewById(R.id.question_8_answer);
        if(question8Answer.getText()!=null) {
            if (question8Answer.getText().toString().equals("Ni")) {
                score++;
            }
        }else{
            Toast.makeText(MainActivity.this,"Fill in the blanks of question 8",Toast.LENGTH_LONG).show();
        }
        question9OptionA = (CheckBox)findViewById(R.id.question_type_9_option_A);
        question9OptionB = (CheckBox)findViewById(R.id.question_type_9_option_B);
        question9OptionC = (CheckBox)findViewById(R.id.question_type_9_option_C);
        question9OptionD = (CheckBox)findViewById(R.id.question_type_9_option_D);
        if(!question9OptionA.isChecked() && question9OptionB.isChecked() && question9OptionC.isChecked() && question9OptionD.isChecked()){
            score++;
        }
        Toast.makeText(MainActivity.this,"You answered " + score + " questions correctly out of 9 questions",Toast.LENGTH_LONG).show();
        score = 0;
    }
}
