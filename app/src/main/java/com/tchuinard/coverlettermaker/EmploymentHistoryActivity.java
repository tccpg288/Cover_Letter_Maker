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

    public CoverLetter mCoverLetter;
    public CoverLetterService mCoverLetterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_employment_history);
        bindViews();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCoverLetterService = new CoverLetterService(getApplicationContext());
        mCoverLetter = mCoverLetterService.loadEntireCoverLetter();
        setViews();

        mSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCoverLetter.setCurrentEmployer(mCoverLetterService.convertEditTextoString(mCurrentEmployer));
                mCoverLetter.setCurrentPosition(mCoverLetterService.convertEditTextoString(mCurrentPosition));
                mCoverLetter.setCurrentSalary(mCoverLetterService.convertEditTextoString(mCurrentSalary));
                mCoverLetter.setCurrentResponsibility(mCoverLetterService.convertEditTextoString(mCurrent_Responsibility));
                mCoverLetter.setYearsExperience(mCoverLetterService.convertEditTextoString(mYearsExperience));
                mCoverLetterService.saveCoverLetter(mCoverLetter);
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
