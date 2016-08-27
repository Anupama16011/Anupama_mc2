package com.example.anupama.prime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class CheatActivity extends AppCompatActivity {
    private Button mBack;
    private Button mCheat;
    private TextView mdisplay;
    int flag=0;
    int j,number,count,i;
    private static final String sTAG="QuizFinal";
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mBack=(Button)findViewById(R.id.Back1);
        mCheat=(Button)findViewById(R.id.Cheat);
        mdisplay=(TextView)findViewById(R.id.DisplayScore1);
         number=getIntent().getIntExtra("Value1",0);

        mBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(sTAG,"Clicked Back Button");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                if(flag==1)
                    setResult(RESULT_OK, getIntent().putExtra("info","You Cheated !!"));
                finish();

            }
        });
        mCheat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                int k=prime_check(number);
                if(k==1)
                    mdisplay.setText(number +" is a Prime No!!");
                else
                   mdisplay.setText(number+" Not A Prime No !!");
                flag=1;

            }

        });

    }
}
