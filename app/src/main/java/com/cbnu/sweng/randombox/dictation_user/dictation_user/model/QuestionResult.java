package com.cbnu.sweng.randombox.dictation_user.dictation_user.model;

import java.io.Serializable;

/**
 * Created by son on 2017-08-19.
 */

public class QuestionResult implements Serializable {

    private String id;
    private int questionNumber; //대응되는 문제의 번호
    private boolean correct;  //정답여부
	//??? wrongPart; //틀린부분
    private String SubmittedAnswer; //학생이 실제 작성한 답안

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getSubmittedAnswer() {
        return SubmittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        SubmittedAnswer = submittedAnswer;
    }
}
