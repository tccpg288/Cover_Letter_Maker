package com.tchuinard.coverlettermaker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tchuinard.coverlettermaker.service.CoverLetterService;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_employment_history);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCurrentEmployer = (EditText) findViewById(R.id.current_employer);
        mCurrentPosition = (EditText) findViewById(R.id.current_position);
        mCurrentSalary = (EditText) findViewById(R.id.current_salary);
        mCurrent_Responsibility = (EditText) findViewById(R.id.current_responsibility);
        mYearsExperience = (EditText) findViewById(R.id.years_experience);

        mSaveData = (Button) findViewById(R.id.employment_history_save_data_button);

        mSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoverLetter mCoverLetter = new CoverLetter();
                CoverLetterService mCoverLetterService = new CoverLetterService();
                mCoverLetter.setCurrentEmployer(mCurrentEmployer.getText().toString());
                mCoverLetter.setCurrentPosition(mCurrentPosition.getText().toString());
                mCoverLetter.setCurrentSalary(mCurrentSalary.getText().toString());
                mCoverLetter.setCurrentResponsibility(mCurrent_Responsibility.getText().toString());
                mCoverLetter.setYearsExperience(mYearsExperience.getText().toString());
                mCoverLetterService.saveCoverLetter(mCoverLetter);

            }

        });



    }
}
