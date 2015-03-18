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
 * Created by tchuinard on 2/16/15.
 */
public class ContactInformationActivity extends ActionBarActivity {

    EditText mFirstName;
    EditText mLastName;
    EditText mAddress;
    EditText mCityState;
    EditText mZipCode;
    EditText mPhoneNumber;
    EditText mFaxNumber;

    Button mSaveButton;

    CoverLetter mCoverLetter;
    CoverLetterService mCoverLetterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_contact_information);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        bindViews();

        mCoverLetterService = new CoverLetterService(getApplicationContext());
        mCoverLetter = mCoverLetterService.loadEntireCoverLetter();

        setViews();

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCoverLetter.setFirstName(mCoverLetterService.convertEditTextoString(mFirstName));
                mCoverLetter.setLastName(mCoverLetterService.convertEditTextoString(mLastName));
                mCoverLetter.setAddress(mCoverLetterService.convertEditTextoString(mAddress));
                mCoverLetter.setCityState(mCoverLetterService.convertEditTextoString(mCityState));
                mCoverLetter.setZipCode(mCoverLetterService.convertEditTextoString(mZipCode));
                mCoverLetter.setPhoneNumber(mCoverLetterService.convertEditTextoString(mPhoneNumber));
                mCoverLetter.setFaxNumber(mCoverLetterService.convertEditTextoString(mFaxNumber));
                mCoverLetterService.saveCoverLetter(mCoverLetter);
                finish();
               }
        });
    }

    private void bindViews() {
        mFirstName = (EditText) findViewById(R.id.contact_information_first_name_edit);
        mLastName = (EditText) findViewById(R.id.contact_information_last_name_edit);
        mPhoneNumber = (EditText) findViewById(R.id.phone_number);
        mAddress = (EditText) findViewById(R.id.address);
        mCityState = (EditText) findViewById(R.id.city_state);
        mZipCode = (EditText) findViewById(R.id.zip_code);
        mFaxNumber = (EditText) findViewById(R.id.ci_fax_number);
        mSaveButton = (Button) findViewById(R.id.contact_information_save_data_button);

    }

    private void setViews() {
        mFirstName.setText(mCoverLetter.mFirstName);
        mLastName.setText(mCoverLetter.mLastName);
        mPhoneNumber.setText(mCoverLetter.mPhoneNumber);
        mAddress.setText(mCoverLetter.mAddress);
        mCityState.setText(mCoverLetter.mCityState);
        mZipCode.setText(mCoverLetter.mZipCode);
        mFaxNumber.setText(mCoverLetter.mFaxNumber);
    }
}
