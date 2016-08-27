package com.example.anupama.prime;
import java.util.*;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    int i,count,j,r,flag=0,number,check=0;
    int scorrect=0;
    int stotal=0;
    private Button mYesButton;
    private Button mNoButton;
    private Button mNextButton;
    private Button mHintButton;
    private Button mCheatButton;
    private TextView mDisplay;
    private TextView mDisplayScore;
    private TextView mDisp_Question;
    private TextView mQuestionno;
    private static final int REQUEST_CODE_INFO = 1000;
    private static final String sTAG="QuizFinal";
    protected int  rand_no(){
        Random r=new Random();
        i= r.nextInt(999)+1;
        return i;
    }
    protected int prime_check(int num) {
        count=0;
        for(j=2;j<=num/2;j++) {
            if(num%j==0) {
                count++;
                break;
            }
        }
        if(count==0 && num!= 1) i=1;
        else i= 0;
        return i;
    }
    protected void nextnum(){
        mYesButton.setBackgroundResource(R.drawable.button_selector);
        mNoButton.setBackgroundResource(R.drawable.button_selector);

        check=0;
        flag=0;
        mDisplayScore.setText("Score :"+scorrect+"/"+stotal);
        i=rand_no();
        number=i;
       // mDisp_Question.setText("Question :"+stotal);
        mDisplay.setText("Is "+ i +" a Prime Number ?");
        j=prime_check(i);
        mYesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flag=1;
                ++check;
                mNoButton.setBackgroundResource(R.drawable.button_selector2);
                Log.d(sTAG,"Yes Button Clicked");
                mNoButton.setEnabled(false);
                mYesButton.setEnabled(false);
                if(j==1  ) {
                    mYesButton.setBackgroundResource(R.drawable.button_selector4);

                    Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
                    scorrect++;
                }
                else {
                    mYesButton.setBackgroundResource(R.drawable.button_selector3);
                    Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                flag=1;
                ++check;
                mYesButton.setBackgroundResource(R.drawable.button_selector2);

                Log.d(sTAG, "Clicked No Button");
                mYesButton.setEnabled(false);
                mNoButton.setEnabled(false);
                if(j==0  ) {
                    mNoButton.setBackgroundResource(R.drawable.button_selector4);


                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    scorrect++;


                }
                else{
                    mNoButton.setBackgroundResource(R.drawable.button_selector3);
                    Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Log.d(sTAG,"Clicked Next Button");
                if(flag==0) {
                    Toast.makeText(getApplicationContext(), "Answer the Question", Toast.LENGTH_SHORT).show();
                }
                else {


                    mYesButton.setEnabled(true);
                    mNoButton.setEnabled(true);

                    stotal++;
                }

                nextnum();
            }
        });
        mHintButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(sTAG,"Clicked Hint Button");
                Intent hint = new Intent(getApplicationContext(),HintActivity.class);
                Log.d(sTAG,"clicked");
                startActivityForResult(new Intent(getApplicationContext(), HintActivity.class), REQUEST_CODE_INFO);

            }
        });
        mCheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(sTAG,"Clicked Cheat Button");
                Intent cheat = new Intent(getApplicationContext(),CheatActivity.class);
                Log.d(sTAG,"clicked"+number);
                startActivityForResult(new Intent(getApplicationContext(), CheatActivity.class).putExtra("Value1",number), REQUEST_CODE_INFO);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(requestCode == REQUEST_CODE_INFO && resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(),intent.getStringExtra("info"),Toast.LENGTH_SHORT).show();
            return;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(sTAG,"Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mYesButton = (Button) findViewById(R.id.YesButton);
        mNoButton = (Button) findViewById(R.id.NoButton);
        mNextButton = (Button) findViewById(R.id.NextButton);
        mDisplay = (TextView) findViewById(R.id.Display);
        mDisplayScore=(TextView)findViewById(R.id.DisplayScore);
        mHintButton=(Button)findViewById(R.id.HintButton) ;
        mCheatButton=(Button)findViewById(R.id.CheatButton) ;
        mDisp_Question=(TextView) findViewById(R.id.DisplayScore1);
        nextnum();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(sTAG, "Inside OnStart");


    }
    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(sTAG,"Inside OnPause");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(sTAG,"Inside OnResume");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(sTAG, "Inside OnSTop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(sTAG, "Inside OnDestroy");
    }
}
