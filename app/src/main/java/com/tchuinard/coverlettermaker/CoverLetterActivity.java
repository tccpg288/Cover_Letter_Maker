package com.tchuinard.coverlettermaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class CoverLetterActivity extends ActionBarActivity {

    Button mContactInfoButton;
    Button mWorkHistoryButton;
    Button mProspectiveJobButton;
    Button mRecruiterInfoButton;
    Button mReviewInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_letter);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int buttonId = view.getId();
                switch (buttonId) {
                    case R.id.contact_information_button:
                        startActivity(new Intent(CoverLetterActivity.this, ContactInformationActivity.class));
                        break;
                    default:
                        Toast.makeText(CoverLetterActivity.this, "Not implemented yet.", Toast.LENGTH_LONG).show();
                }
            }
        };


        mContactInfoButton = (Button) findViewById(R.id.contact_information_button);
        mWorkHistoryButton = (Button) findViewById(R.id.employment_history_button);
        mProspectiveJobButton = (Button) findViewById(R.id.prospective_employment_button);
        mRecruiterInfoButton = (Button) findViewById(R.id.recruiter_button);
        mReviewInfoButton = (Button) findViewById(R.id.recruiter_button);

        mContactInfoButton.setOnClickListener(clickListener);
        mWorkHistoryButton.setOnClickListener(clickListener);
        mProspectiveJobButton.setOnClickListener(clickListener);
        mRecruiterInfoButton.setOnClickListener(clickListener);
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
}
