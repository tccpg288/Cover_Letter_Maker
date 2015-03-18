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
public class ProspectiveEmploymentActivity extends ActionBarActivity {

    EditText mDesiredPosition;
    EditText mRecruiterName;
    EditText mRecruiterEMail;
    EditText mJobSource;
    EditText mStartDate;

    Button mSaveProspectiveEmployment;

    CoverLetter mCoverLetter;
    CoverLetterService mCoverLetterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_prospective_employment);
        bindViews();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCoverLetterService = new CoverLetterService(getApplicationContext());
        mCoverLetter = mCoverLetterService.loadEntireCoverLetter();

        setViews();

        mSaveProspectiveEmployment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCoverLetter.setDesiredPosition(mCoverLetterService.convertEditTextoString(mDesiredPosition));
                mCoverLetter.setRecruiterName(mCoverLetterService.convertEditTextoString(mRecruiterName));
                mCoverLetter.setRecruiterEmail(mCoverLetterService.convertEditTextoString(mRecruiterEMail));
                mCoverLetter.setJobSource(mCoverLetterService.convertEditTextoString(mJobSource));
                mCoverLetter.setStartDate(mCoverLetterService.convertEditTextoString(mStartDate));
                mCoverLetterService.saveCoverLetter(mCoverLetter);
                finish();
            }
        });

    }

    private void bindViews(){
        mDesiredPosition = (EditText) findViewById(R.id.pe_desired_position);
        mRecruiterName = (EditText) findViewById(R.id.pe_recruiter_name);
        mRecruiterEMail = (EditText) findViewById(R.id.pe_recruiter_email);
        mJobSource = (EditText) findViewById(R.id.pe_job_source);
        mStartDate = (EditText) findViewById(R.id.pe_start_date);
        mSaveProspectiveEmployment = (Button) findViewById(R.id.pe_save_data);
    }

    private void setViews(){
        mDesiredPosition.setText(mCoverLetter.getDesiredPosition());
        mRecruiterName.setText(mCoverLetter.getRecruiterName());
        mRecruiterEMail.setText(mCoverLetter.getRecruiterEmail());
        mJobSource.setText(mCoverLetter.getJobSource());
        mStartDate.setText(mCoverLetter.getStartDate());
    }
}
