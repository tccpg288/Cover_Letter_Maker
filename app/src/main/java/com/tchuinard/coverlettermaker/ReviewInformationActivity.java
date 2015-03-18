package com.tchuinard.coverlettermaker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.tchuinard.coverlettermaker.service.CoverLetterService;
import com.tchuinard.coverletterpro.R;

/**
 * Created by tchuinard on 3/5/15.
 */
public class ReviewInformationActivity extends ActionBarActivity {

    CoverLetter mCoverLetter;
    CoverLetterService mCoverLetterService;

    TextView mSummaryFirstName;
    TextView mSummaryLastName;
    TextView mSummaryAddress;
    TextView mSummaryCityState;
    TextView mSummaryZipCode;
    TextView mSummaryPhoneNumber;
    TextView mSummaryFaxNumber;
    TextView mSummaryCurrentEmployer;
    TextView mSummaryCurrentPosition;
    TextView mSummaryCurrentSalary;
    TextView mSummaryCurrentResponsibility;
    TextView mSummaryYearsExperience;
    TextView mSummaryDesiredPosition;
    TextView mSummaryRecruiterName;
    TextView mSummaryRecruiterEmail;
    TextView mSummaryJobSource;
    TextView mSummaryAvailableStartDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        setContentView(R.layout.activity_review_information);
        bindViews();

        mCoverLetterService = new CoverLetterService(getApplicationContext());
        mCoverLetter = mCoverLetterService.loadEntireCoverLetter();

        setViews();
        }


    private void bindViews() {
        mSummaryFirstName = (TextView) findViewById(R.id.summary_first_name);
        mSummaryLastName = (TextView) findViewById(R.id.summary_last_name);
        mSummaryAddress = (TextView) findViewById(R.id.summary_address);
        mSummaryCityState = (TextView) findViewById(R.id.summary_city_state);
        mSummaryZipCode = (TextView) findViewById(R.id.summary_zip_code);
        mSummaryPhoneNumber = (TextView) findViewById(R.id.summary_phone_number);
        mSummaryFaxNumber = (TextView) findViewById(R.id.summary_fax_number);
        mSummaryCurrentEmployer = (TextView) findViewById(R.id.summary_current_employer);
        mSummaryCurrentPosition = (TextView) findViewById(R.id.summary_current_position);
        mSummaryCurrentSalary = (TextView) findViewById(R.id.summary_current_salary);
        mSummaryCurrentResponsibility = (TextView) findViewById(R.id.summary_current_responsibility);
        mSummaryYearsExperience = (TextView) findViewById(R.id.summary_years_experience);
        mSummaryDesiredPosition = (TextView) findViewById(R.id.summary_desired_position);
        mSummaryRecruiterName = (TextView) findViewById(R.id.summary_recruiter_name);
        mSummaryRecruiterEmail = (TextView) findViewById(R.id.summary_recruiter_email);
        mSummaryJobSource = (TextView) findViewById(R.id.summary_job_source);
        mSummaryAvailableStartDate = (TextView) findViewById(R.id.summary_start_date);
    }

    private void setViews(){
        mSummaryFirstName.setText(mCoverLetter.getFirstName());
        mSummaryLastName.setText(mCoverLetter.getLastName());
        mSummaryAddress.setText(mCoverLetter.getAddress());
        mSummaryCityState.setText(mCoverLetter.getCityState());
        mSummaryZipCode.setText(mCoverLetter.getZipCode());
        mSummaryPhoneNumber.setText(mCoverLetter.getPhoneNumber());
        mSummaryFaxNumber.setText(mCoverLetter.getFaxNumber());
        mSummaryCurrentEmployer.setText(mCoverLetter.getCurrentEmployer());
        mSummaryCurrentPosition.setText(mCoverLetter.getPosition());
        mSummaryCurrentSalary.setText(mCoverLetter.getSalary());
        mSummaryCurrentResponsibility.setText(mCoverLetter.getCurrentResponsibility());
        mSummaryYearsExperience.setText(mCoverLetter.getYearsExperience());
        mSummaryDesiredPosition.setText(mCoverLetter.getDesiredPosition());
        mSummaryRecruiterName.setText(mCoverLetter.getRecruiterName());
        mSummaryRecruiterEmail.setText(mCoverLetter.getRecruiterEmail());
        mSummaryJobSource.setText(mCoverLetter.getJobSource());
        mSummaryAvailableStartDate.setText(mCoverLetter.getStartDate());
    }
}
