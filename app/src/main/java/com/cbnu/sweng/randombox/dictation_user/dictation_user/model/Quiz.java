package com.cbnu.sweng.randombox.dictation_user.dictation_user.model;

import java.io.Serializable;

/**
 * Created by son on 2017-08-19.
 */

public class Quiz implements Serializable {

    private String id;
    private int number; //시험 번호
    private Question[] questions; //문제들의 집합

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
