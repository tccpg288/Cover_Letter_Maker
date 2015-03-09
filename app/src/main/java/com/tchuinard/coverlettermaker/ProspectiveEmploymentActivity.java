package com.tchuinard.coverlettermaker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tchuinard.coverletterpro.R;

/**
 * Created by tchuinard on 2/27/15.
 */
public class ProspectiveEmploymentActivity extends ActionBarActivity {

    SharedPreferences peSharedPreferences;

    EditText mDesiredPosition;
    EditText mRecruiterName;
    EditText mRecruiterEMail;
    EditText mJobSource;
    EditText mStartDate;

    Button mSaveProspectiveEmployment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_prospective_employment);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        peSharedPreferences = getSharedPreferences("PESharedPrefs",MODE_PRIVATE);

        mDesiredPosition = (EditText) findViewById(R.id.pe_desired_position);
        mRecruiterName = (EditText) findViewById(R.id.pe_recruiter_name);
        mRecruiterEMail = (EditText) findViewById(R.id.pe_recruiter_email);
        mJobSource = (EditText) findViewById(R.id.pe_job_source);
        mStartDate = (EditText) findViewById(R.id.pe_start_date);

        mSaveProspectiveEmployment = (Button) findViewById(R.id.pe_save_data);
        mSaveProspectiveEmployment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor peEditorObject = peSharedPreferences.edit();
                peEditorObject.putString("Desired_Position", mDesiredPosition.getText().toString());
                peEditorObject.putString("Recruiter_Name", mRecruiterName.getText().toString());
                peEditorObject.putString("Recruiter_Email", mRecruiterEMail.getText().toString());
                peEditorObject.putString("Job_Source", mJobSource.getText().toString());
                peEditorObject.putString("Start_Date", mStartDate.getText().toString());
                peEditorObject.commit();
                finish();
            }
        });

        String savedDesiredPosition = peSharedPreferences.getString("Desired_Position","");
        String savedRecruiterName = peSharedPreferences.getString("Recruiter_Name","");
        String savedRecruiterEmail = peSharedPreferences.getString("Recruiter_Email","");
        String savedJobSource = peSharedPreferences.getString("Job_Source","");
        String savedStartDate = peSharedPreferences.getString("Start_Date","");
        mDesiredPosition.setText(savedDesiredPosition);
        mRecruiterName.setText(savedRecruiterName);
        mRecruiterEMail.setText(savedRecruiterEmail);
        mJobSource.setText(savedJobSource);
        mStartDate.setText(savedStartDate);

    }
}
