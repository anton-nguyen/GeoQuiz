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
    private TextView mGradeTextView;
    private TextView mLabelTextView;
    private static final String EXTRA_SCORE = "com.example.student.myapplication.score";
    private static final String EXTRA_GRADE = "com.bignerdranch.android.geoquiz.grade";
    private int mPercent;
    private int mScore;
    private String mGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mLabelTextView = (TextView) findViewById(R.id.label);
        mScoreTextView = (TextView) findViewById(R.id.scoreLabel);
        mScore = getIntent().getIntExtra(EXTRA_SCORE, 0);
        mScoreTextView.setText(mScore + "%");
            if (mScore > 90)
                mGrade = "A";
            else if (mScore > 80)
                mGrade = "B";
            else if (mScore > 70)
                mGrade = "C";
            else if (mScore > 60)
                mGrade = "D";
            else
                mGrade = "F";
        mGradeTextView = (TextView) findViewById(R.id.gradeLabel);
        //mGrade = getIntent().getStringExtra(EXTRA_GRADE);
        mGradeTextView.setText(mGrade);

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

/*    private void setGrade(int grade) {
        Intent data = new Intent();
        data.putExtra(EXTRA_GRADE, grade);
        setResult(RESULT_OK, data);
    } */
}
