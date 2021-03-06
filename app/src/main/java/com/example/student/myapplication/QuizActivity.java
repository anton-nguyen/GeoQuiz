package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String MYTAG = "quizactivity";
    private static final String KEY_INDEX = "index";
    private static final String KEY_SCORE = "score";
    private Button mTrueButton;
    private Button mFalseButton;
    /* private Button mNextButton; */
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_samerica, false),
            new Question(R.string.question_baghdad, false),
            new Question(R.string.question_desert, true),
            new Question(R.string.question_tatooine, false)
    };
    private int mCurrentIndex = 0;
    private int mCurrentScore = 0;


    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        saveInstanceState.putInt(KEY_SCORE, mCurrentScore);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(MYTAG, "called onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(MYTAG, "called onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(MYTAG, "called onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(MYTAG, "called onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MYTAG, "called onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
            mCurrentScore = savedInstanceState.getInt(KEY_SCORE, 0);
        }
        Log.d(MYTAG,"called onCreate");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTrueButton.setEnabled(true);
                checkAnswer(true);
                mTrueButton.setEnabled(false);
                mFalseButton.setEnabled(false);
                if (mCurrentIndex < 9){
                    mCurrentIndex++;
                    updateQuestion();
                    mTrueButton.setEnabled(true);
                    mFalseButton.setEnabled(true);
                }
                else {
                    showScore();
                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFalseButton.setEnabled(true);
                checkAnswer(false);
                mTrueButton.setEnabled(false);
                mFalseButton.setEnabled(false);
                if (mCurrentIndex < 9){
                    mCurrentIndex++;
                    updateQuestion();
                    mTrueButton.setEnabled(true);
                    mFalseButton.setEnabled(true);
                }
                else {
                    showScore();
                }
            }
        });

        /* mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex++;
                updateQuestion();
                mTrueButton.setEnabled(true);
                mFalseButton.setEnabled(true);
            }
        }); */
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
                mCurrentScore += 1;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void showScore() {
        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
        int percent = (int) (((double)mCurrentScore/mQuestionBank.length)*100);
        String score_toast = "YOUR QUIZ RESULT: " + percent + "%";
        Toast.makeText(QuizActivity.this, score_toast, Toast.LENGTH_LONG).show();
        mCurrentScore = 0;
    }

}
