package com.crystal;

import java.util.Random;

public class License {

    private String LN;
    private String FN;
    private String MN;
    private String DOB;
    private String EXP;
    private String LIC;

    public License(String LN, String FN, String MN, String DOB, String EXP) {

        Random variable = new Random();
        int randomNumber = variable.nextInt(8999) + 1000;
        this.LN = LN;
        this.FN = FN;
        this.MN = MN;
        this.DOB = DOB;
        this.EXP = EXP;
        if (LN.length() < 5) {
            this.LIC = LN + randomNumber;
        } else {
            this.LIC = LN.substring(0, 5) + randomNumber;
        }

    }

    public void setLN(String LN)
    {
        this.LN=LN;
    }

    public String getLN()
    {
        return LN;
    }

    public void setFN(String FN)
    {
        this.FN=FN;
    }

    public String getFN()
    {
        return FN;
    }

    public void setMN(String MN)
    {
        this.MN=MN;
    }

    public String getMN()
    {
        return MN;
    }

    public void setDOB(String DOB)
    {
        this.DOB=DOB;
    }

    public String getDOB()
    {
        return DOB;
    }

    public void setEXP(String EXP)
    {
        this.EXP=EXP;
    }

    public String getEXP()
    {
        return EXP;
    }

    public void setLIC(String LIC)
    {
        this.LIC=LIC;
    }

    public String getLIC()
    {
        return LIC;
    }

    public String toString()
    {
        return("Last Name: " + this.LN + "\nFirst Name: " + this.FN + " \nMiddle Name: " + this.MN + "\nDate of Birth: " + this.DOB + "\nExpiration Date: " + this.EXP);
    }
}