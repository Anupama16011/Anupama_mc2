package com.example.anupama.prime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HintActivity extends AppCompatActivity {
    private Button mBack;
    private  Button mHint;
    private TextView mDisplay_Score;
    private static final String sTAG="QuizFinal";
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(sTAG,"Inside child");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        mBack = (Button) findViewById(R.id.Back);
        mHint = (Button) findViewById(R.id.Hint);
        mDisplay_Score=(TextView) findViewById(R.id.DisplayScore1);
        mBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(sTAG,"Clicked Back Button");
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                if(flag==1)
                setResult(RESULT_OK, getIntent().putExtra("info","Hint Taken !!"));
                finish();

            }
        });
        mHint.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    flag=1;
                    mDisplay_Score.setText("See if the number is divisible by any other Number apart from 1 and itself !!");
                }

        });


    }
}
