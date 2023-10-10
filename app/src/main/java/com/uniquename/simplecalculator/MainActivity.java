package com.uniquename.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mNumberEdit1;
    EditText mNumberEdit2;

    EditText mOperator;

    Button mCalculateBtn;

    TextView mResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFields();
        treatCalculateBtn(mCalculateBtn);
    }

    public void initializeFields(){
        mNumberEdit1=findViewById(R.id.number_1);
        mNumberEdit2=findViewById(R.id.number_2);
        mOperator=findViewById(R.id.operator);
        mCalculateBtn=findViewById(R.id.calculate_btn);
        mResultText=findViewById(R.id.result_text);
    }

    public boolean isNumbersFilled(){
        if(mNumberEdit1.getText().toString().isEmpty() || mNumberEdit2.getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isOperatorValid(){
        if(mOperator.getText().toString().equals("+") || mOperator.getText().toString().equals("-") || mOperator.getText().toString().equals("/") || mOperator.getText().toString().equals("*")){

            return true;
        }
        else{
            return false;
        }
    }

    public int getResult(){
        if(mOperator.getText().toString().equals("+")){
            int number1 = Integer.parseInt(mNumberEdit1.getText().toString());
            int number2 = Integer.parseInt(mNumberEdit2.getText().toString());
            int result =number1 + number2;
            return result;
        }
        if(mOperator.getText().toString().equals("-")){
            int number1 = Integer.parseInt(mNumberEdit1.getText().toString());
            int number2 = Integer.parseInt(mNumberEdit2.getText().toString());
            int result =number1 - number2;
            return result;
        }
        if(mOperator.getText().toString().equals("/")){
            int number1 = Integer.parseInt(mNumberEdit1.getText().toString());
            int number2 = Integer.parseInt(mNumberEdit2.getText().toString());
            if(number2 == 0){
                Toast.makeText(MainActivity.this,"Cannot divide by zero",Toast.LENGTH_SHORT).show();
                return 0;
            }
            int result =number1 / number2;
            return result;
        }
        if(mOperator.getText().toString().equals("*")){
            int number1 = Integer.parseInt(mNumberEdit1.getText().toString());
            int number2 = Integer.parseInt(mNumberEdit2.getText().toString());
            int result =number1 * number2;
            return result;
        }
        return 0;
    }

    public void setResultText(){
        int getCalculatedResult=getResult();
        String resultToString=String.valueOf(getCalculatedResult);
        mResultText.setText(resultToString);
    }

    public void treatCalculateBtn(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNumbersFilled()){
                    if(isOperatorValid()){
                        setResultText();
                    }

                }
                else{
                    Toast.makeText(MainActivity.this,"Les numeros et l'operateur doivent etre valide!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}