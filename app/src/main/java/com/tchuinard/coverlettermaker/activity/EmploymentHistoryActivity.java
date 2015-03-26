package com.tchuinard.coverlettermaker.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tchuinard.coverlettermaker.model.CoverLetter;
import com.tchuinard.coverletterpro.R;

/**
 * Created by tchuinard on 2/27/15.
 */
public class EmploymentHistoryActivity extends AbstractCoverLetterActivity {

    EditText mCurrentEmployer;
    EditText mCurrentPosition;
    EditText mCurrentSalary;
    EditText mCurrent_Responsibility;
    EditText mYearsExperience;

    Button mSaveData;

    public CoverLetter mCoverLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_employment_history);
        bindViews();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCoverLetter = mService.loadEntireCoverLetter();
        setViews();

        mSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCoverLetter.setCurrentEmployer(mService.convertEditTextoString(mCurrentEmployer));
                mCoverLetter.setCurrentPosition(mService.convertEditTextoString(mCurrentPosition));
                mCoverLetter.setCurrentSalary(mService.convertEditTextoString(mCurrentSalary));
                mCoverLetter.setCurrentResponsibility(mService.convertEditTextoString(mCurrent_Responsibility));
                mCoverLetter.setYearsExperience(mService.convertEditTextoString(mYearsExperience));
                mService.saveCoverLetter(mCoverLetter);
                finish();
            }
        });
    }

    public void bindViews(){
        mCurrentEmployer = (EditText) findViewById(R.id.current_employer);
        mCurrentPosition = (EditText) findViewById(R.id.current_position);
        mCurrentSalary = (EditText) findViewById(R.id.current_salary);
        mCurrent_Responsibility = (EditText) findViewById(R.id.current_responsibility);
        mYearsExperience = (EditText) findViewById(R.id.years_experience);
        mSaveData = (Button) findViewById(R.id.employment_history_save_data_button);
    }

    public void setViews(){
        mCurrentEmployer.setText(mCoverLetter.getCurrentEmployer());
        mCurrentPosition.setText(mCoverLetter.getPosition());
        mCurrentSalary.setText(mCoverLetter.getSalary());
        mCurrent_Responsibility.setText(mCoverLetter.getCurrentResponsibility());
        mYearsExperience.setText(mCoverLetter.getYearsExperience());
    }
}
