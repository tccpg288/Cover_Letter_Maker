package com.tchuinard.coverlettermaker.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.tchuinard.coverlettermaker.model.CoverLetter;

public class CoverLetterService {

    SharedPreferences mPrefs;

    public CoverLetterService(Context context) {
        mPrefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    public String convertEditTextoString(EditText currentEditText){
        String newString = currentEditText.getText().toString();
        return  newString;
    }

    public void saveCoverLetter (CoverLetter coverLetterToSave) {
        saveKeyValue("First_Name", coverLetterToSave.getFirstName());
        saveKeyValue("Last_Name", coverLetterToSave.getLastName());
        saveKeyValue("Address", coverLetterToSave.getAddress());
        saveKeyValue("City_State", coverLetterToSave.getCityState());
        saveKeyValue("Zip_Code", coverLetterToSave.getZipCode());
        saveKeyValue("Phone_Number", coverLetterToSave.getPhoneNumber());
        saveKeyValue("Fax_Number", coverLetterToSave.getFaxNumber());
        saveKeyValue("Current_Employer", coverLetterToSave.getCurrentEmployer());
        saveKeyValue("Current_Position", coverLetterToSave.getPosition());
        saveKeyValue("Current_Salary", coverLetterToSave.getSalary());
        saveKeyValue("Current_Responsibility", coverLetterToSave.getCurrentResponsibility());
        saveKeyValue("Years_Experience", coverLetterToSave.getYearsExperience());
        saveKeyValue("Desired_Position", coverLetterToSave.getDesiredPosition());
        saveKeyValue("Recruiter_Name", coverLetterToSave.getRecruiterName());
        saveKeyValue("Recruiter_Email", coverLetterToSave.getRecruiterEmail());
        saveKeyValue("Job_Source", coverLetterToSave.getJobSource());
        saveKeyValue("Available_Start_Date", coverLetterToSave.getStartDate());
    }

    public CoverLetter loadEntireCoverLetter() {
        String firstName = mPrefs.getString("First_Name", "");
        String lastName = mPrefs.getString("Last_Name", "");
        String address = mPrefs.getString("Address","");
        String cityState = mPrefs.getString("City_State","");
        String zipCode = mPrefs.getString("Zip_Code","");
        String phoneNumber = mPrefs.getString("Phone_Number","");
        String faxNumber = mPrefs.getString("Fax_Number","");
        String currentEmployer = mPrefs.getString("Current_Employer","");
        String currentPosition = mPrefs.getString("Current_Position","");
        String currentSalary = mPrefs.getString("Current_Salary","");
        String currentResponsibility = mPrefs.getString("Current_Responsibility","");
        String yearsExperience = mPrefs.getString("Years_Experience","");
        String desiredPosition = mPrefs.getString("Desired_Position","");
        String recruiterName = mPrefs.getString("Recruiter_Name","");
        String recruiterEmail = mPrefs.getString("Recruiter_Email","");
        String jobSource = mPrefs.getString("Job_Source","");
        String availableStartDate = mPrefs.getString("Available_Start_Date","");
        return new CoverLetter(firstName,
                lastName,
                address,
                cityState, zipCode,
                phoneNumber,
                faxNumber,
                currentEmployer,
                currentPosition,
                currentSalary,
                currentResponsibility,
                yearsExperience,
                desiredPosition,
                recruiterName,
                recruiterEmail,
                jobSource,
                availableStartDate);
    }

    private boolean saveKeyValue(String key, String value) {
        return mPrefs.edit().putString(key, value).commit();
    }
}