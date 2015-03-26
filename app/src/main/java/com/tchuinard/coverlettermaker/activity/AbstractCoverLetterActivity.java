package com.tchuinard.coverlettermaker.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.tchuinard.coverlettermaker.service.CoverLetterService;

/**
 * Created by tchuinard on 3/25/15.
 */
public abstract class AbstractCoverLetterActivity extends ActionBarActivity {

    public CoverLetterService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mService = new CoverLetterService(getApplicationContext());
    }
}




