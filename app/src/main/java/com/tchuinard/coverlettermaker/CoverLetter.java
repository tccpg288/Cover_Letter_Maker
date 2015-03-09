package com.tchuinard.coverlettermaker;

/**
 * Created by tchuinard on 3/9/15.
 */
public class CoverLetter {

    String mFirstName;
    String mLastName;
    String mAddress;
    String mCityState;
    String mZipCode;
    String mPhoneNumber;
    String mFaxNumber;
    String mCurrentEmployer;
    String mCurrentPosition;
    String mCurrentSalary;
    String mCurrentResponsibility;
    String mYearsExperience;
    String mDesiredPosition;
    String mRecruiterName;
    String mRecruiterEmail;
    String mJobSource;
    String mStartDate;

    public CoverLetter(
            String clFirstName,
            String clLastName,
            String clAddress,
            String clCityState,
            String clZipCode,
            String clPhoneNumber,
            String clFaxNumber,
            String clCurrentEmployer,
            String clCurrentPosition,
            String clCurrentSalary,
            String clCurrentResponsibility,
            String clYearsExperience,
            String clDesiredPosition,
            String clRecruiterName,
            String clRecruiterEmail,
            String clJobSource,
            String clStartDate)
    {
        this.mFirstName = clFirstName;
        this.mLastName = clLastName;
        this.mAddress = clAddress;
        this.mCityState = clCityState;
        this.mZipCode = clZipCode;
        this.mPhoneNumber = clPhoneNumber;
        this.mFaxNumber = clFaxNumber;
        this.mCurrentEmployer = clCurrentEmployer;
        this.mCurrentPosition = clCurrentPosition;
        this.mCurrentSalary = clCurrentSalary;
        this.mCurrentResponsibility = clCurrentResponsibility;
        this.mYearsExperience = clYearsExperience;
        this.mDesiredPosition = clDesiredPosition;
        this.mRecruiterName = clRecruiterName;
        this.mRecruiterEmail = clRecruiterEmail;
        this.mJobSource = clJobSource;
        this.mStartDate = clStartDate;

    }

    public String getFirstName(){
        return mFirstName;
    }

    public String getLastName(){
        return mLastName;
    }

    public String getAddress(){
        return mAddress;
    }

    public String getCityState(){
        return mCityState;
    }

    public String getZipCode(){
        return mZipCode;
    }

    public String getPhoneNumber (){
        return mPhoneNumber;
    }

    public String getFaxNumber (){
        return mFaxNumber;
    }

    public String getCurrentEmployer (){
        return mCurrentEmployer;
    }

    public String getPosition(){
        return mCurrentPosition;
    }

    public String getSalary(){
        return mCurrentSalary;
    }

    public String getCurrentResponsibility(){
        return mCurrentResponsibility;
    }

    public String getYearsExperience(){
        return mYearsExperience;
    }

    public String getDesiredPosition(){
        return mDesiredPosition;
    }

    public String getRecruiterName(){
        return mRecruiterName;
    }

    public String getRecruiterEmail(){
        return mRecruiterEmail;
    }

    public String getJobSource(){
        return mJobSource;
    }

    public String getStartDate(){
        return mStartDate;
    }

    public void setFirstName(String firstName){
        this.mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public void setAddress (String address) {
        this.mAddress = address;
    }

    public void setCityState (String CityState){
        this.mCityState = CityState;
    }

    public void setZipCode (String ZipCode){
        this.mZipCode = ZipCode;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public void setFaxNumber (String FaxNumber) {
        this.mFaxNumber = FaxNumber;
    }

    public void setCurrentEmployer (String CurrentEmployer) {
        this.mCurrentEmployer = CurrentEmployer;
    }

    public void setCurrentPosition (String CurrentPosition) {
        this.mCurrentPosition = CurrentPosition;
    }

    public void setCurrentSalary(String CurrentSalary) {
        this.mCurrentSalary = CurrentSalary;
    }

    public void setCurrentResponsibility (String CurrentResponsibility) {
        this.mCurrentResponsibility = CurrentResponsibility;
    }

    public void setYearsExperience (String CurrentYearsExperience){
        this.mYearsExperience = CurrentYearsExperience;
    }

    public void setDesiredPosition(String DesiredPosition) {
        this.mDesiredPosition = DesiredPosition;
    }

    public void setRecruiterName (String RecruiterName) {
        this.mRecruiterName = RecruiterName;
    }

    public void setRecruiterEmail (String RecruiterEmail) {
        this.mRecruiterEmail = RecruiterEmail;
    }

    public void setStartDate (String StartDate) {
        this.mStartDate = StartDate;
    }

    public void setJobSource (String JobSource) {
        this.mJobSource = JobSource;
    }


}
