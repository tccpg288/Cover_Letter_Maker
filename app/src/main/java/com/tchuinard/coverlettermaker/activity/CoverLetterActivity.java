package com.tchuinard.coverlettermaker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tchuinard.coverlettermaker.model.CoverLetter;
import com.tchuinard.coverletterpro.R;


public class CoverLetterActivity extends AbstractCoverLetterActivity {


    Button mContactInfoButton;
    Button mWorkHistoryButton;
    Button mProspectiveJobButton;
    Button mReviewInfoButton;

    CoverLetter mCoverLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_letter);

        bindViews();

        mCoverLetter = mService.loadEntireCoverLetter();


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int buttonId = view.getId();
                switch (buttonId) {
                    case R.id.contact_information_button:
                        startActivity(new Intent(CoverLetterActivity.this, ContactInformationActivity.class));
                        break;
                    case R.id.employment_history_button:
                        startActivity(new Intent(CoverLetterActivity.this, EmploymentHistoryActivity.class));
                        break;
                    case R.id.prospective_employment_button:
                        startActivity(new Intent(CoverLetterActivity.this, ProspectiveEmploymentActivity.class));
                        break;
                    case R.id.review_information_button:
                        startActivity(new Intent(CoverLetterActivity.this, ReviewInformationActivity.class));
                        break;
                    default:
                        Toast.makeText(CoverLetterActivity.this, "Not implemented yet.", Toast.LENGTH_LONG).show();
                }
            }
        };



        mContactInfoButton.setOnClickListener(clickListener);
        mWorkHistoryButton.setOnClickListener(clickListener);
        mProspectiveJobButton.setOnClickListener(clickListener);
        mReviewInfoButton.setOnClickListener(clickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cover_letter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void bindViews(){
        mContactInfoButton = (Button) findViewById(R.id.contact_information_button);
        mWorkHistoryButton = (Button) findViewById(R.id.employment_history_button);
        mProspectiveJobButton = (Button) findViewById(R.id.prospective_employment_button);
        mReviewInfoButton = (Button) findViewById(R.id.review_information_button);
    }

    /**
     * Created by tchuinard on 3/9/15.
     */

}
