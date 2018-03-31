package com.mylottery.mylottery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.text.style.ForegroundColorSpan;
import android.text.SpannableStringBuilder;
import android.text.Spannable;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "lottery";

    int[] Quick3 = new int[3];
    private TextView viewQuick3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: a");
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: b");
        getQuick3();
        Log.e(TAG, "onCreate: c");
    }
    protected  void getQuick3() {
        int sum = 0, i = 0;
        String Quick3_S = "Quick3:\n";
        java.util.Random random=new java.util.Random();
        for ( ; i<3; i++) {
            Quick3[i] = random.nextInt(6) + 1;
            sum = sum + Quick3[i];
            Quick3_S = Quick3_S + " " + Quick3[i];
        }
        Quick3_S = Quick3_S + " sum=" + sum + "\n";
        sum = 0;
        for ( i=0; i<3; i++) {
            Quick3[i] = random.nextInt(6) + 1;
            sum = sum + Quick3[i];
            Quick3_S = Quick3_S + " " + Quick3[i];
        }
        Quick3_S = Quick3_S + " sum=" + sum + "\n";
        viewQuick3 = findViewById(R.id.Quick3);
        viewQuick3.setText(Quick3_S);
        Log.e(TAG, "getQuick3: 1 " + Quick3_S + " lengthOfQuick3_S=" + Quick3_S.length());
        Log.e(TAG, "getQuick3: 2 " + viewQuick3.getText().toString() + " lengthOfQuick3_S= " + (viewQuick3.getText().toString()).length());
        SpannableStringBuilder builder = new SpannableStringBuilder(viewQuick3.getText().toString());
        Log.e(TAG, "getQuick3: 1");
        ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.GREEN);
        ForegroundColorSpan blueSpan = new ForegroundColorSpan(Color.BLUE);
        builder.setSpan(blueSpan, 15, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(greenSpan, 28, (Quick3_S.length()-1), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        viewQuick3.setText(builder);
    }
}