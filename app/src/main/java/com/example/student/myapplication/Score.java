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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //mScoreTextView = (TextView) findViewById(R.id.score_text_view);

        mResetButton = (Button) findViewById(R.id.check_button);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

/*    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, Score.class);
        return intent;
    } */
}
