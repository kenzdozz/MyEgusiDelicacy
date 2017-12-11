package com.ahtaya.chidozie.myegusidelicacy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.layout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
    }

    public void startQuiz(View view){
        EditText nameField = findViewById(R.id.name);
        name = nameField.getText().toString();
        if (name.isEmpty()){
            Toast.makeText(this, "Name is required!", Toast.LENGTH_SHORT).show();
            return;
        }
        setContentView(R.layout.activity_quiz);
    }

    public void submitQuiz(View view){
        int score = calculateScore();
        setContentView(R.layout.activity_done);
        TextView scoreView = findViewById(R.id.score);
        scoreView.setText("" + score + "/8");
    }

    private int calculateScore(){

        int score = 0;

        RadioGroup queOneField = findViewById(R.id.question_one);
        int queOneId = queOneField.getCheckedRadioButtonId();
        if (queOneId != -1) {
            RadioButton ansOneField = findViewById(queOneId);
            String ansOne = ansOneField.getText().toString();
            if (ansOne.equalsIgnoreCase("Africa")) {
                score += 1;
            }
        }

        EditText queTwoField = findViewById(R.id.question_two);
        String ansTwo = queTwoField.getText().toString();
        if (ansTwo.equalsIgnoreCase("Melon")){
            score += 1;
        }

        CheckBox queThreeAField = findViewById(R.id.question_three_a);
        Boolean ansThreeA = queThreeAField.isChecked();
        CheckBox queThreeBField = findViewById(R.id.question_three_b);
        Boolean ansThreeB = queThreeBField.isChecked();
        CheckBox queThreeCField = findViewById(R.id.question_three_c);
        Boolean ansThreeC = queThreeCField.isChecked();
        CheckBox queThreeDField = findViewById(R.id.question_three_d);
        Boolean ansThreeD = queThreeDField.isChecked();
        if (ansThreeA && ansThreeD && !ansThreeB && !ansThreeC){
            score += 1;
        }

        RadioGroup queFourField = findViewById(R.id.question_four);
        int queFourId = queFourField.getCheckedRadioButtonId();
        if (queFourId != -1) {
            RadioButton ansFourField = findViewById(queFourId);
            String ansFour = ansFourField.getText().toString();
            if (ansFour.equalsIgnoreCase("Bitter leaf")) {
                score += 1;
            }
        }

        RadioGroup queFiveField = findViewById(R.id.question_five);
        int queFiveId = queFiveField.getCheckedRadioButtonId();
        if (queFiveId != -1) {
            RadioButton ansFiveField = findViewById(queFiveId);
            String ansFive = ansFiveField.getText().toString();
            if (ansFive.equalsIgnoreCase("Red oil")) {
                score += 1;
            }
        }

        EditText queSixField = findViewById(R.id.question_six);
        String ansSix = queSixField.getText().toString();
        if (ansSix.equalsIgnoreCase("Igbo")){
            score += 1;
        }

        EditText queSevenField = findViewById(R.id.question_seven);
        String ansSeven = queSevenField.getText().toString();
        if (ansSeven.equalsIgnoreCase("Nigeria")){
            score += 1;
        }

        CheckBox queEightAField = findViewById(R.id.question_eight_a);
        Boolean ansEightA = queEightAField.isChecked();
        CheckBox queEightBField = findViewById(R.id.question_eight_b);
        Boolean ansEightB = queEightBField.isChecked();
        CheckBox queEightCField = findViewById(R.id.question_eight_c);
        Boolean ansEightC = queEightCField.isChecked();
        if (ansEightA && !ansEightB && ansEightC){
            score += 1;
        }
        return score;
    }
}
