package com.hgsil.android.telephonedirectory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView ;
    private ArrayList<String> mNames;
    private ArrayList<String> mPhonenumber;
    private NameAdapter  nameAdapter;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNames();
        mRecyclerView = (RecyclerView)findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameAdapter = new NameAdapter(mNames,mPhonenumber,i);
        mRecyclerView.setAdapter(nameAdapter);



        TextView createinMainActivity = (TextView) findViewById(R.id.createinMainActivity);
        createinMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,CreateActivity.class));

            }
        });
    }
    protected void initNames(){
        mNames = new ArrayList<>();
        mPhonenumber = new ArrayList<>();
        Cursor cursor =null;
            try {
                cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,null,null,null);
                while (cursor.moveToNext()) {

                    mNames.add(cursor.getString(cursor.
                            getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                    mPhonenumber.add(cursor.getString(cursor.
                            getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (cursor !=null){
                    i = mNames.size();
                    cursor.close();
                }
            }

    }
    /*private void addViews(@LayoutRes int res, ViewGroup parent){
        View view = View.inflate(this,res,null);
        TextView textView = (TextView)view.findViewById(R.id.nameitem);
        SharedPreferences pefId = getSharedPreferences("name",MODE_PRIVATE);
        textView.setText(pefId.getString(id+"",""));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InformationActivity.class));
            }
        });

    }*/



}
