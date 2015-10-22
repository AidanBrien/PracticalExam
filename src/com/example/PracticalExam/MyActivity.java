package com.example.PracticalExam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {
    EditText txtValue1;
    EditText txtValue2;
    EditText txtValue3;
    EditText txtValue4;
    EditText txtValue5;
    TextView txtResult;
    TextView txtResult2;
    Button btnCalc;
    Button btnCalc1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtValue1 = (EditText) findViewById(R.id.editText1);
        txtValue2 = (EditText) findViewById(R.id.editText2);
        txtValue3 = (EditText) findViewById(R.id.editText3);
        txtValue4 = (EditText) findViewById(R.id.editText4);
        txtValue5 = (EditText) findViewById(R.id.editText5);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new OnClickListener()

        {
            @Override
            public void onClick(View v) {

                // get values from the UI
                Double v1 = Double.parseDouble(txtValue1.getText().toString());
                Double v2 = Double.parseDouble(txtValue2.getText().toString());
                Double v3 = Double.parseDouble(txtValue3.getText().toString());
                Double v4 = Double.parseDouble(txtValue4.getText().toString());
                Double v5 = Double.parseDouble(txtValue5.getText().toString());


                // create intent to call Activity2
                Intent myIntentA1A2 = new Intent(MyActivity.this,
                        oneActivity.class);
                // create a Bundle (MAP) container to ship data
                Bundle myDataBundle = new Bundle();

                // add <key,value> data items to the container
                myDataBundle.putDouble("val1", v1);
                myDataBundle.putDouble("val2", v2);
                myDataBundle.putDouble("val3", v3);
                myDataBundle.putDouble("val4", v4);
                myDataBundle.putDouble("val5", v5);


                // attach the container to the intent
                myIntentA1A2.putExtras(myDataBundle);

                // call Activity2, tell your local listener to wait a
                // response sent to a listener known as 101
                startActivityForResult(myIntentA1A2, 101);

            }
        });
        btnCalc1 = (Button) findViewById(R.id.btnCalc1);
        btnCalc1.setOnClickListener(new OnClickListener()

        {
            @Override
            public void onClick(View v) {

                Intent myIntentA1A2 = new Intent(MyActivity.this,
                        hardCodedActivity.class);

                startActivityForResult(myIntentA1A2, 102);
            }
        });
    }

//onCreate

//////////////////////////////////////////////////////////////////////////////
// local listener receives callbacks from other activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try	{
             if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                 Bundle myResultBundle = data.getExtras();
                 Double myResult = myResultBundle.getDouble("vresult");
                 txtResult.setText("Sum is " + myResult);
                 //txtResult2.setText("Max is " + myResult2);
            }
        }
        catch (Exception e) {
        txtResult.setText("Problems - " + requestCode + " " + resultCode);
        }
//        try	{
//            if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
//                Bundle myResultBundle2 = data.getExtras();
//                Double myResult2 = myResultBundle2.getDouble("vresult");
//                txtResult2.setText("Max is " + myResult2);
//            }
//        }
//        catch (Exception e) {
//            txtResult2.setText("Problems - " + requestCode + " " + resultCode);
//        }
    }//onActivityResult

}//Activity1
