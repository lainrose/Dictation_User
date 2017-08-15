package com.cbnu.sweng.randombox.dictation_user.dictation_user.pastmodel;

/**
 * Created by SAMSUNG on 2017-08-14.
 */

public class PastInfoModel {

    private String date;
    private String score;
    private String rank;

    public void setInfo(String date, String score, String rank)
    {
        this.date = date;
        this.score = score;
        this.rank = rank;
    }

    public String getDate()
    {
        return date;
    }

    public String getScore()
    {
        return score;
    }

    public String getRank()
    {
        return rank;
    }

}

