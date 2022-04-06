package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Double input_num = 1.0;
    public Double Value1 = 0.0;
    public Double Value2 = 0.0;
    public Double Result_Num = 0.0;
    public Boolean once = true;
    public CharSequence text = "";
    public Integer enzan = 0;
    public boolean enzan_once = true;
    public Double Value4 = 0.0;
    public Integer valLen = 0;
    public String enzanVal = "";
    // 0 = 未設定
    // 1 = +
    // 2 = -
    // 3 = *
    // 4 = /

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this::onClick);
        findViewById(R.id.button2).setOnClickListener(this::onClick);
        findViewById(R.id.button3).setOnClickListener(this::onClick);
        findViewById(R.id.button4).setOnClickListener(this::onClick);
        findViewById(R.id.button5).setOnClickListener(this::onClick);
        findViewById(R.id.button6).setOnClickListener(this::onClick);
        findViewById(R.id.button7).setOnClickListener(this::onClick);
        findViewById(R.id.button8).setOnClickListener(this::onClick);
        findViewById(R.id.button9).setOnClickListener(this::onClick);
        findViewById(R.id.button0).setOnClickListener(this::onClick);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.times).setOnClickListener(this);
        findViewById(R.id.division).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.Clear).setOnClickListener(this);
    }

    public void onClick(View v) {
        TextView textView1 = (TextView) findViewById(R.id.num1);
        TextView textView2 = (TextView) findViewById(R.id.num2);
        TextView enzansi = (TextView) findViewById(R.id.kigou);
        TextView val1 = (TextView) findViewById(R.id.val1);
        TextView val2 = (TextView) findViewById(R.id.val2);
        TextView val3 = (TextView) findViewById(R.id.val3);
        TextView enzansi_tv = (TextView) findViewById(R.id.enzan);

        //後半の数字入力処理
        if (once == false) {

            if(v.getId() == R.id.button1){
                input_num = 1.0;

            }else if(v.getId() == R.id.button2){
                input_num = 2.0;

            }else if(v.getId() == R.id.button3){
                input_num = 3.0;

            }else if(v.getId() == R.id.button4){
                input_num = 4.0;

            }else if(v.getId() == R.id.button5){
                input_num = 5.0;

            }else if(v.getId() == R.id.button6){
                input_num = 6.0;

            }else if(v.getId() == R.id.button7){
                input_num = 7.0;

            }else if(v.getId() == R.id.button8){
                input_num = 8.0;

            }else if(v.getId() == R.id.button9){
                input_num = 9.0;

            }else if(v.getId() == R.id.button0){
                Value2 = 1.0;

            }

            System.out.println(Value2);

            if(Value2 == 0.0){
                Snackbar.make(v,"0.0である",Snackbar.LENGTH_LONG).show();
                Value1 = input_num;
                valLen = 1;

            }else{
                //Value1の長さを計測
                valLen = String.valueOf(Value2).length();

                //-2は小数点切り捨ての処理、文字列とし.0を切り捨てている
                valLen = valLen - 2;

                //桁用の計算Value1が1の場合1を10にして押された数字を足す
                //1 →　10 →　11
                Value2 = (Value2 * 10) + input_num;
            }
            CharSequence kari = textView1.getText();
            kari = kari + String.valueOf(Value2);
            textView1.setText(String.valueOf(Value2));
            val2.setText(String.valueOf(Value2));
        }

//前半の数字入力処理
        else if (once) {

            if(v.getId() == R.id.button1){
                input_num = 1.0;

            }else if(v.getId() == R.id.button2){
                input_num = 2.0;

            }else if(v.getId() == R.id.button3){
                input_num = 3.0;

            }else if(v.getId() == R.id.button4){
                input_num = 4.0;

            }else if(v.getId() == R.id.button5){
                input_num = 5.0;

            }else if(v.getId() == R.id.button6){
                input_num = 6.0;

            }else if(v.getId() == R.id.button7){
                input_num = 7.0;

            }else if(v.getId() == R.id.button8){
                input_num = 8.0;

            }else if(v.getId() == R.id.button9){
                input_num = 9.0;

            }else if(v.getId() == R.id.button0){
                input_num = 0.0;
            }
            System.out.println(input_num);

            if(Value1 == 0.0){
                Snackbar.make(v,"0.0である",Snackbar.LENGTH_LONG).show();
                Value1 = input_num;
                valLen = 1;

            }else{
                //Value1の長さを計測
                valLen = String.valueOf(Value1).length();

                //-2は小数点切り捨ての処理、文字列とし.0を切り捨てている
                valLen = valLen - 2;

                //桁用の計算Value1が1の場合1を10にして押された数字を足す
                //1 →　10 →　11
                Value1 = (Value1 * 10) + input_num;
            }

            CharSequence kari = textView1.getText();
            kari = kari + String.valueOf(Value1);
            textView1.setText(String.valueOf(Value1));
            val1.setText(String.valueOf(Value1));
        }

            //enzan
            // 0 = 未設定
            // 1 = +
            // 2 = -
            // 3 = *
            // 4 = /

        if (v.getId() == R.id.equal) {
            textView1.setText(String.valueOf(""));
            once = true;
            if (enzan == 1) {
                Result_Num = Value1 + Value2;
            } else if (enzan == 2) {
                Result_Num = Value1 - Value2;
            } else if (enzan == 3) {
                Result_Num = Value1 * Value2;
            } else if (enzan == 4) {
                Result_Num = Value1 / Value2;
            }
            textView1.setText(String.valueOf(Result_Num));
            return;
        }


        if (v.getId() == R.id.plus) {
                enzan = 1;
                enzanVal = " + ";

        } else if (v.getId() == R.id.minus) {
                enzan = 2;
                enzanVal = " - ";

        } else if (v.getId() == R.id.times) {
                enzan = 3;
                enzanVal = " × ";

        } else if (v.getId() == R.id.division) {
                enzan = 4;
                enzanVal = " ÷ ";

        }

        once = false;
        CharSequence kari = textView1.getText();
        kari = kari + enzanVal;
        textView1.setText(kari);
        return;

        if (v.getId() == R.id.Clear) {
                //演算データ
                Value1 = 0.0;
                Value2 = 0.0;
                once = true;

                //上部のテキストビュー
                textView1.setText(String.valueOf(0.0));
                enzansi.setText("");
                textView2.setText("");

                //下部の数値表示
                val1.setText("Null");
                val2.setText("Null");
                val3.setText("Null");
                enzansi_tv.setText("Null");
            } else {
                return;
            }


        }
    }