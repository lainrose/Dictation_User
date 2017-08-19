package com.cbnu.sweng.randombox.dictation_user.dictation_user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by son on 2017-08-19.
 */

public class QuizHistory implements Serializable {

    private String id;
    private Date date; //시험 본 날짜
    private QuizResult[] quizResults; //시험 결과의 집합

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public QuizResult[] getQuizResults() {
        return quizResults;
    }

    public void setQuizResults(QuizResult[] quizResults) {
        this.quizResults = quizResults;
    }
}
