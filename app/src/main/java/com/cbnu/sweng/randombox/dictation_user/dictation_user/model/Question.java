package com.cbnu.sweng.randombox.dictation_user.dictation_user.model;

import java.io.Serializable;

/**
 * Created by son on 2017-08-19.
 */

public class Question implements Serializable{

    private String id;
    private int number; //문제 번호
    private String sentence; //문장

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

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
