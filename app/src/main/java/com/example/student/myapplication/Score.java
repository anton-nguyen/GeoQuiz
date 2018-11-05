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
    private TextView scoreLabel;
    private TextView gradeLabel;
    private static final String EXTRA_SCORE = "com.example.student.myapplication.score";
    private static final String EXTRA_GRADE = "com.bignerdranch.android.geoquiz.grade";
    private int mPercent;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mScoreTextView = (TextView) findViewById(R.id.answer_text_view);
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        gradeLabel = (TextView) findViewById(R.id.gradeLabel);
        Intent data = new Intent();

        //TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        //TextView gradeLabel = (TextView) findViewById(R.id.gradeLabel);
        //score = getIntent().getIntExtra(EXTRA_SCORE, 0);
        //scoreLabel.setText(score);

        //mPercent = getIntent().getIntExtra(EXTRA_SCORE,0);
        //String score = getIntent().getStringExtra("score");

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

    public static Intent newIntent(Context packageContext, int score) {
        Intent intent = new Intent(packageContext, Score.class);
        intent.putExtra(EXTRA_SCORE, score);
        return intent;
    }

    private void setGrade(int grade) {
        Intent data = new Intent();
        data.putExtra(EXTRA_GRADE, grade);
        setResult(RESULT_OK, data);
    }
}
