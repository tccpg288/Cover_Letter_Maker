package com.tchuinard.coverlettermaker.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.tchuinard.coverlettermaker.model.CoverLetter;
import com.tchuinard.coverletterpro.R;


/**
 * Created by tchuinard on 2/16/15.
 */
public class ContactInformationActivity extends AbstractCoverLetterActivity {

    EditText mFirstName;
    EditText mLastName;
    EditText mAddress;
    EditText mCityState;
    EditText mZipCode;
    EditText mPhoneNumber;
    EditText mFaxNumber;

    Button mSaveButton;

    CoverLetter mCoverLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_contact_information);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        bindViews();

        mCoverLetter = mService.loadEntireCoverLetter();

        setViews();

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCoverLetter.setFirstName(mService.convertEditTextoString(mFirstName));
                mCoverLetter.setLastName(mService.convertEditTextoString(mLastName));
                mCoverLetter.setAddress(mService.convertEditTextoString(mAddress));
                mCoverLetter.setCityState(mService.convertEditTextoString(mCityState));
                mCoverLetter.setZipCode(mService.convertEditTextoString(mZipCode));
                mCoverLetter.setPhoneNumber(mService.convertEditTextoString(mPhoneNumber));
                mCoverLetter.setFaxNumber(mService.convertEditTextoString(mFaxNumber));
                mService.saveCoverLetter(mCoverLetter);
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
        mFirstName.setText(mCoverLetter.getFirstName());
        mLastName.setText(mCoverLetter.getLastName());
        mPhoneNumber.setText(mCoverLetter.getPhoneNumber());
        mAddress.setText(mCoverLetter.getAddress());
        mCityState.setText(mCoverLetter.getCityState());
        mZipCode.setText(mCoverLetter.getZipCode());
        mFaxNumber.setText(mCoverLetter.getFaxNumber());
    }
}
