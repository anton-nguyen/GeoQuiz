package com.example.student.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private Button mResetButton;
    private TextView mScoreTextView;
    private static final String EXTRA_SCORE = "com.example.student.myapplication.score";
    private static final String EXTRA_GRADE = "com.bignerdranch.android.geoquiz.grade";
    private int mPercent;
    private int mCurrentIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //mScoreTextView = (TextView) findViewById(R.id.answer_text_view);
        mScoreTextView = (TextView) findViewById(R.id.answer_text_view);
        //String score_toast = "YOUR QUIZ RESULT: " + mPercent + "%";
        mPercent = getIntent().getIntExtra(EXTRA_SCORE,0);

        mResetButton = (Button) findViewById(R.id.reset_button);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this,QuizActivity.class);
                startActivity(intent);
            }
        }
    );

}

    public static Intent newIntent(Context packageContext, int percent) {
        Intent intent = new Intent(packageContext, Score.class);
        intent.putExtra(EXTRA_SCORE, percent);
        return intent;
    }
}
