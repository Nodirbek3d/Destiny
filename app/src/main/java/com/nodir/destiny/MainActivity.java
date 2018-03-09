package com.nodir.destiny;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnAnswerOne;
    private Button btnAnswerTwo;
    private TextView storyText;
    private Story currentStory;
    private Story story_t1;
    private Story story_t2;
    private Story story_t3;
    private Story story_t4;
    private Story story_t5;
    private Story story_t6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        story_t1 = new Story(getString(R.string.T1_Story), getString(R.string.T1_Ans1), getString(R.string.T1_Ans2));
        story_t2 = new Story(getString(R.string.T2_Story), getString(R.string.T2_Ans1), getString(R.string.T2_Ans2));
        story_t3 = new Story(getString(R.string.T3_Story), getString(R.string.T3_Ans1), getString(R.string.T3_Ans2));
        story_t4 = new Story(getString(R.string.T4_End), null, null);
        story_t5 = new Story(getString(R.string.T5_End), null, null);
        story_t6 = new Story(getString(R.string.T6_End), null, null);

        story_t1.setNextStoryOnAnswer1(story_t3);
        story_t1.setNextStoryOnAnswer2(story_t2);
        story_t2.setNextStoryOnAnswer1(story_t3);
        story_t2.setNextStoryOnAnswer2(story_t4);
        story_t3.setNextStoryOnAnswer1(story_t6);
        story_t3.setNextStoryOnAnswer2(story_t5);

        btnAnswerOne = findViewById(R.id.btnAnswer_1);
        btnAnswerTwo = findViewById(R.id.btnAnswer_2);
        storyText = findViewById(R.id.textStory);

        currentStory = story_t1;
        storyText.setText(currentStory.getStory());

        btnAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentStory = currentStory.getStoryOn1();
                update();
            }
        });

        btnAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentStory = currentStory.getStoryOn2();
                update();
            }
        });
    }

    private void update() {
        storyText.setText(currentStory.getStory());
        if (currentStory.isEnd()){
            btnAnswerOne.setVisibility(View.INVISIBLE);
            btnAnswerTwo.setVisibility(View.INVISIBLE);
            reset();
        } else {
            btnAnswerOne.setText(currentStory.getButton_1_text());
            btnAnswerTwo.setText(currentStory.getButton_2_text());
        }
    }

    private void reset(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(getString(R.string.alertTitle));
        dialog.setMessage(getString(R.string.alertMessage));
        dialog.setPositiveButton(getString(R.string.alertYes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface anInterface, int i) {
                recreate();
            }
        });
        dialog.setNegativeButton(getString(R.string.alertNo), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface anInterface, int i) {
                finish();
            }
        });
        dialog.show();
    }
}
