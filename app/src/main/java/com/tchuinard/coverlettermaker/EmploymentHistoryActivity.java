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
public class EmploymentHistoryActivity extends ActionBarActivity {

    EditText mCurrentEmployer;
    EditText mCurrentPosition;
    EditText mCurrentSalary;
    EditText mCurrent_Responsibility;
    EditText mYearsExperience;

    Button mSaveData;

    SharedPreferences mSharedPreferences;
    public static final String MYPreferences = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_employment_history);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mSharedPreferences = getSharedPreferences("employment_prefs",MODE_PRIVATE);
        mCurrentEmployer = (EditText) findViewById(R.id.current_employer);
        mCurrentPosition = (EditText) findViewById(R.id.current_position);
        mCurrentSalary = (EditText) findViewById(R.id.current_salary);
        mCurrent_Responsibility = (EditText) findViewById(R.id.current_responsibility);
        mYearsExperience = (EditText) findViewById(R.id.years_experience);
        mSaveData = (Button) findViewById(R.id.employment_history_save_data_button);


        mSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editorObject = mSharedPreferences.edit();
                editorObject.putString("Current_Employer", mCurrentEmployer.getText().toString());
                editorObject.putString("Current_Position", mCurrentPosition.getText().toString());
                editorObject.putString("Current_Salary", mCurrentSalary.getText().toString());
                editorObject.putString("Current_Responsibility", mCurrent_Responsibility.getText().toString());
                editorObject.putString("Current_Years_Experience", mYearsExperience.getText().toString());
                editorObject.commit();
                finish();
            }
        });

        String currentEmployer = mSharedPreferences.getString("Current_Employer", "");
        mCurrentEmployer.setText(currentEmployer);
        String currentPosition = mSharedPreferences.getString("Current_Position", "");
        mCurrentPosition.setText(currentPosition);
        String currentSalary = mSharedPreferences.getString("Current_Salary", "");
        mCurrentSalary.setText(currentSalary);
        String currentResponsibility = mSharedPreferences.getString("Current_Responsibility", "");
        mCurrent_Responsibility.setText(currentResponsibility);
        String currentYearsExperience = mSharedPreferences.getString("Current_Years_Experience", "");
        mYearsExperience.setText(currentYearsExperience);

    }
}
