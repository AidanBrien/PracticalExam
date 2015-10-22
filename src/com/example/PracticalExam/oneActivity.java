package com.example.PracticalExam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by g00289968 on 22/10/2015.
 */
public class oneActivity extends Activity implements OnClickListener{

    EditText dataReceived;
    Button btnDone;
//    private double number1 = 10, number2 = 20, number3 = 30, number4 = 40, number5 =50;
//    //private long mLoanPeriodInMonths = 360; // 30 years = 360 months
//    //private String mCurrencySymbol = "$";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        dataReceived = (EditText) findViewById(R.id.DataReceived);
        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        // pick call made to Activity2 via Intent
        Intent myLocalIntent = getIntent();

        // look into the bundle sent to Activity2 for data items
        Bundle myBundle =  myLocalIntent.getExtras();
        Double v1 = myBundle.getDouble("val1");
        Double v2 = myBundle.getDouble("val2");
        Double v3 = myBundle.getDouble("val3");
        Double v4 = myBundle.getDouble("val4");
        Double v5 = myBundle.getDouble("val5");


        // operate on the input data
        Double vResult =  v1 + v2 + v3 + v4 +v5;

        // for illustration purposes. show data received & result
        dataReceived.setText("Data received is \n"
                + "val1= " + v1 + "\nval2= " + v2  + "\nval3= " + v3 + "\nval4= " + v4  + "\nval5= " + v5
                + "\n\nresult= " + vResult);

        // add to the bundle the computed result
        myBundle.putDouble("vresult", vResult);

        // attach updated bumble to invoking intent
        myLocalIntent.putExtras(myBundle);

        // return sending an OK signal to calling activity
        setResult(Activity.RESULT_OK, myLocalIntent);

        // max calculation****************************************
      /*  Double Max =
        if(v1 < v2 && v1 < v3 && v1 < v4 && v1 < v5){
            Double max = v1;
        }
        else if (v2 < v1 && v2 < v3 && v2 < v4 && v2 < v5)
        {
            Double max = v2;
        }

        dataReceived.setText("Data received is \n"
                + "val1= " + v1 + "\nval2= " + v2  + "\nval3= " + v3 + "\nval4= " + v4  + "\nval5= " + v5
                + "\n\nresult= " + vResult);
        myBundle.putDouble("vresult2", vResult);

        // attach updated bumble to invoking intent
        myLocalIntent.putExtras(myBundle);
        // return sending an OK signal to calling activity
        setResult(Activity.RESULT_OK, myLocalIntent);
        */

    }//onCreate
    @Override
    public void onClick(View v) {

        finish();
    }
}