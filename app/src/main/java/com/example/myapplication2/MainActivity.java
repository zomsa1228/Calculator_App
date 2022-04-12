package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;

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
    public CharSequence textviewdata = "";
    public Double Pis = 0.0;

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
        findViewById(R.id.plus).setOnClickListener(this::enzan);
        findViewById(R.id.minus).setOnClickListener(this::enzan);
        findViewById(R.id.times).setOnClickListener(this::enzan);
        findViewById(R.id.division).setOnClickListener(this::enzan);
        findViewById(R.id.equal).setOnClickListener(this::equal);
        findViewById(R.id.Clear).setOnClickListener(this::Clear);

    }

    //関数電卓用：平方根
    public void root(View root){


    }

    //関数電卓用：円周率表示プログラム
    public void pi(View pi) {
        findViewById(R.id.pi).setOnClickListener(this::pi);
        TextView textView1 = (TextView) findViewById(R.id.num1);

        //変数Pisに円周率を入れる
        Pis = (Double)Math.PI;

        //textview1の表示内容を消す
        textView1.setText("");

        //textviewにPisを代入
        textView1.setText(String.valueOf(Pis));
        return;
    }

    //関数電卓用：べき乗計算プログラム
    public void power(View power){
        findViewById(R.id.XY).setOnClickListener(this::power);
        TextView textView1 = (TextView) findViewById(R.id.num1);
        if (power.getId() == R.id.XY){
            enzan = 5;
            enzanVal = " ^ ";
            once = false;

            //文字を入れるためのkari変数を用意
            //textView1のデータを取得する
            textviewdata = textView1.getText();

            //取得したデータに入っている文字に、Value2の数値を文字連結する
            textviewdata = textviewdata + String.valueOf(enzanVal);

            //テキストビューにデータを上書き
            textView1.setText(textviewdata);
            return;
        }
    }

    //関数電卓用：２乗プログラム
    public void power2(View power2){
        findViewById(R.id.XY2).setOnClickListener(this::power2);
        TextView textView1 = (TextView) findViewById(R.id.num1);
        if (power2.getId() == R.id.XY2){
            if(Result_Num == 0.0){
                //Value1を２乗しResult_Numに格納する
                Result_Num = Math.pow(Value1,2);

            }else if (Result_Num != 0.0){
             Result_Num = Math.pow(Result_Num,2);
            }

            //textview1の表示内容を消す
            textView1.setText("");

            //textviewにPisを代入
            textView1.setText(String.valueOf(Result_Num));
            return;
        }
    }

    public void power3(View power3){
        findViewById(R.id.XY3).setOnClickListener(this::power3);
        TextView textView1 = (TextView) findViewById(R.id.num1);
        if (power3.getId() == R.id.XY3){
            if(Result_Num == 0.0){
                //Value1を２乗しResult_Numに格納する
                Result_Num = Math.pow(Value1,3);

            }else if (Result_Num != 0.0){
                Result_Num = Math.pow(Result_Num,3);
            }

            //textview1の表示内容を消す
            textView1.setText("");

            //textviewにPisを代入
            textView1.setText(String.valueOf(Result_Num));
            return;
        }
    }

    //演算子 +-/*を押したときの処理
    public void enzan(View button){
        TextView textView1 = (TextView) findViewById(R.id.num1);

        if (button.getId() == R.id.plus) {
            enzan = 1;
            enzanVal = " + ";

        } else if (button.getId() == R.id.minus) {
            enzan = 2;
            enzanVal = " - ";

        } else if (button.getId() == R.id.times) {
            enzan = 3;
            enzanVal = " × ";

        } else if (button.getId() == R.id.division) {
            enzan = 4;
            enzanVal = " ÷ ";
        }
        once = false;

        //文字を入れるためのkari変数を用意
        //textView1のデータを取得する
        textviewdata = textView1.getText();

        //取得したデータに入っている文字に、Value2の数値を文字連結する
        textviewdata = textviewdata + String.valueOf(enzanVal);

        //テキストビューにデータを上書き
        textView1.setText(textviewdata);

        return;

    }

    //=を押したときの処理
    public void equal(View equal){
        TextView textView1 = (TextView) findViewById(R.id.num1);

        if (equal.getId() == R.id.equal) {
            once = true;
            textView1.setText(String.valueOf(""));
            if (enzan == 1) {
                Result_Num = Value1 + Value2;
            } else if (enzan == 2) {

                Result_Num = Value1 - Value2;
            } else if (enzan == 3) {

                Result_Num = Value1 * Value2;
            } else if (enzan == 4) {

                Result_Num = Value1 / Value2;
            } else if (enzan == 5) {

                Result_Num = Math.pow(Value1, Value2);
            }

            //Value1をtextView1に上書きする
            textView1.setText(String.valueOf(Result_Num));
        }
    }

    public void Clear(View Clear){
        if (Clear.getId() == R.id.Clear) {
            TextView textView1 = (TextView) findViewById(R.id.num1);
            //演算データ
            Value1 = 0.0;
            Value2 = 0.0;
            Result_Num = 0.0;
            once = true;

            //上部のテキストビュー
            textView1.setText(String.valueOf(0.0));
        }
    }

    public void onClick(View v) {
        TextView textView1 = (TextView) findViewById(R.id.num1);
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
                input_num = 0.0;
            }

            //Value2 == 0.0と言うのはいわゆるデータ上は何もまだ入力されていない状態、初回入力
            if(Value2 == 0.0){
                Value2 = input_num;
                textviewdata = String.valueOf(input_num);
                valLen = 1;

                //0.0以外のデータが入っている場合、いわゆる何かしらデータが入っているとき
            }else{

                //Value2の長さを計測
                valLen = String.valueOf(Value2).length();

                //-2は小数点切り捨ての処理、文字列とし.0を切り捨てている
                valLen = valLen - 2;

                //桁用の計算Value1が1の場合1を10にして押された数字を足す
                //1 →1*10→　10　→10+1→　11
                Value2 = (Value2 * 10) + input_num;
            }

            //Value1をtextView1に上書きする
            textView1.setText(String.valueOf(Value2));
            return;

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
                Value1 = input_num;
                textviewdata = String.valueOf(input_num);
                valLen = 1;

            }else{
                //Value1の長さを計測
                valLen = String.valueOf(Value1).length();

                //-2は小数点切り捨ての処理、文字列とし.0を切り捨てている
                valLen = valLen - 2;

                //桁用の計算Value1が1の場合1を10にして押された数字を足す
                //1 →1*10→　10 →10+1→　11
                Value1 = (Value1 * 10) + input_num;

            }
            //Value1をtextView1に上書きする
            textView1.setText(String.valueOf(Value1));
            return;
        }

    }

}