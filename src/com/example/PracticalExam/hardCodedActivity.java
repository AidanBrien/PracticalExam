package com.example.PracticalExam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * Created by g00289968 on 22/10/2015.
 */
public class hardCodedActivity extends Activity implements OnClickListener {

    Button  Done;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        Done = (Button) findViewById(R.id.buttonD3);
        Done.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        finish();
    }
}