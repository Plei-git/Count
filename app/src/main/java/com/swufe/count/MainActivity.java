package com.swufe.count;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "Count";
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9,
            btn_clear, btn_delete, btn_plus, btn_minus, btn_mul, btn_div, btn_dot, btn_equal;
    EditText input;


     double n1,n2;
     private String operators = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");


        input = (EditText) findViewById(R.id.input);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);


        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);

        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);

        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);

        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);

        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);

        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);

        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);

        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);

        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);

        btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(this);

        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(this);

        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(this);


        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(this);

        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(this);

        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_dot.setOnClickListener(this);

    }


    @SuppressLint("SetTextI18n")
    public void onClick(View v) {
        Log.i(TAG, "onClick:");
        //获取用户输入内容
        String str = input.getText().toString();

         if(!operators.equals("")) {
            int index = str.lastIndexOf(operators);
            str = str.substring(index+1);
         }


        if (v.getId() == R.id.btn_0) {
            input.setText(str + btn_0.getText());
        } else if (v.getId() == R.id.btn_1) {
            input.setText(str + btn_1.getText());

        } else if (v.getId() == R.id.btn_2) {
            input.setText(str + btn_2.getText());
        } else if (v.getId() == R.id.btn_3) {
            input.setText(str + btn_3.getText());
        } else if (v.getId() == R.id.btn_4) {
            input.setText(str + btn_4.getText());
        } else if (v.getId() == R.id.btn_5) {
            input.setText(str + btn_5.getText());
        } else if (v.getId() == R.id.btn_6) {
            input.setText(str + btn_6.getText());
        } else if (v.getId() == R.id.btn_7) {
            input.setText(str + btn_7.getText());
        } else if (v.getId() == R.id.btn_8) {
            input.setText(str + btn_8.getText());
        } else if (v.getId() == R.id.btn_9) {
            input.setText(str + btn_9.getText());
        } else if (v.getId() == R.id.btn_clear) {
            input.setText("");

        } else if (v.getId() == R.id.btn_delete) {
            input.setText(str.substring(0, str.length() - 1).length() > 0 ? str.substring(0, str.length() - 1) : "");
        }
        if (str.length() == 0) {
            //提示用户输入内容
            Toast.makeText(this, "请输入数据", Toast.LENGTH_SHORT).show();
        } else {
            if (v.getId() == R.id.btn_dot) {
//            if (num1.toString().contains(".") || num1 != null || num2.toString().contains(".")) {
//                input.setText("0.");
//            } else if (num2 == null && !num1.toString().contains(".")) {
//                input.setText(str + btn_dot.getText() + 0);
//            } else if (num1 != null && !input.getText().toString().equals("0") && !input.getText().toString().contains(".")) {
//                num1.append(".");
//            }
            input.setText(str + btn_dot.getText());
            } else if (v.getId() == R.id.btn_div) {
                input.setText(str + btn_div.getText());
                operators = "/";
            } else if (v.getId() == R.id.btn_mul) {
                input.setText(str + btn_mul.getText());
                operators = "*";
            } else if (v.getId() == R.id.btn_minus) {
                input.setText(str + btn_minus.getText());
                operators = "-";
            } else if (v.getId() == R.id.btn_plus) {
                input.setText(str + btn_plus.getText());
                operators = "+";
            } else if (v.getId() == R.id.btn_equal) {
                input.setText(btn_equal.getText() + "\n" + n1);
                operatorResult(str);
                operators = "=";
            }
        }
        Log.i(TAG, "onClick: get str" + str);

    }

      //分别返回计算结果
     public void operatorResult(String operatorNumber){

        if(n2 != 0D){
             if(operators.equals("/"))            {
                 n2 = n2 / Double.parseDouble(operatorNumber);
                 n1 = n1 / n2;

             } else if(operators.equals("*")){
                 n2 = n2 * Double.parseDouble(operatorNumber);
                 n1 = n1 * n2;
             } else if(operators.equals("+")) {
                 n2 = n2 + Double.parseDouble(operatorNumber);
                 n1 = n1 + n2;

             } else if(operators.equals("-")) {
                 n2 = n2 - Double.parseDouble(operatorNumber);
                 n1 = n1 - n2;

             }

            Log.i(TAG,"n1="+ n1);
            Log.i(TAG,"n2="+ n2);
         }
         else{
             if(operators.equals("/")) {
                 n1 = n1 / Double.parseDouble(operatorNumber);
             } else if(operators.equals("*")) {
                 n1 = n1 * Double.parseDouble(operatorNumber);
             } else if(operators.equals("+")) {
                 n1 = n1 + Double.parseDouble(operatorNumber);
             } else if(operators.equals("-")) {
                 n1 = n1 - Double.parseDouble(operatorNumber);
             }

         }

         Log.i(TAG,"n1="+ n1);
    }


}