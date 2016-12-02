package com.hgsil.android.telephonedirectory;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                String nameKeeper = null;
                String phonenumberKeeper = null;
                EditText nameIncreateActivity = (EditText) findViewById(R.id.nameinCreateActivity);
                EditText phonenumberIncreateActivity = (EditText) findViewById(R.id.phonenumberinCreateActivity);
                if (!nameIncreateActivity.getText().toString().isEmpty()) {
                    nameKeeper = nameIncreateActivity.getText().toString();
                    phonenumberKeeper = phonenumberIncreateActivity.getText().toString();

                    ContentValues values = new ContentValues();
                    try {
                        Uri rawContactUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
                        long rawContactId = ContentUris.parseId(rawContactUri);
                        values.clear();

                        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                        // 内容类型
                        values.put(ContactsContract.Data.MIMETYPE,
                                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                        // 联系人名字
                        values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, nameKeeper);
                        // 向联系人URI添加联系人名字
                        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
                        values.clear();

                        values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                        values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                        // 联系人的电话号码
                        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phonenumberKeeper);
                        // 电话类型
                        values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                        // 向联系人电话号码URI添加电话号码
                        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
                        values.clear();
                        //将上个Activity传过来的数据改掉
                        Intent intent = new Intent();
                        intent.putExtra("name", nameKeeper);
                        intent.putExtra("phonenumber", phonenumberKeeper);
                        setResult(RESULT_OK, intent);
                        finish();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else{
                    Toast.makeText(CreateActivity.this,"用户不能为空",Toast.LENGTH_SHORT);

                    finish();
                }
            }

        });
    }

}
