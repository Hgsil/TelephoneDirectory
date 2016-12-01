package com.hgsil.android.telephonedirectory;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/28 0028.
 */

public class CreateActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        TextView createTextinCreateActivity = (TextView) findViewById(R.id.createTextinCreateActivity);
        createTextinCreateActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameIncreateActivity = (EditText)findViewById(R.id.nameinCreateActivity);
                EditText phonenumberIncreateActivity = (EditText)findViewById(R.id.phonenumberinCreateActivity);



            }
        });
    }
}
