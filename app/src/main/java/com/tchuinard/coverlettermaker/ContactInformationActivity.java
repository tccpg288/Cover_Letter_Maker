package com.tchuinard.coverlettermaker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by tchuinard on 2/16/15.
 */
public class ContactInformationActivity extends ActionBarActivity {
    EditText mFirstName;
    EditText mLastName;
    EditText mAddress;
    EditText mCityState;
    EditText mZipCode;
    EditText mPhoneNumber;

    Button mSaveButton;

    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);
        mPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        mSaveButton = (Button) findViewById(R.id.contact_information_save_data_button);
        mFirstName = (EditText) findViewById(R.id.contact_information_first_name_edit);
        mLastName = (EditText) findViewById(R.id.contact_information_last_name_edit);

        mFirstName.setText(mPreferences.getString("First_Name", ""));
        mLastName.setText(mPreferences.getString("Last_Name", ""));

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreferences.edit()
                        .putString("First_Name", mFirstName.getText().toString())
                        .putString("Last_Name", mLastName.getText().toString())
                        .commit();
            }
        });
    }
}
