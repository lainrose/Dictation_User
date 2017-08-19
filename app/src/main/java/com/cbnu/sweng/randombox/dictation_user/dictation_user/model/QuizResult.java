package com.cbnu.sweng.randombox.dictation_user.dictation_user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by son on 2017-08-19.
 */

public class QuizResult implements Serializable {

    private String id;
    private int quizNumber; //대응되는 시험의 번호
    private Date date; //날짜
    private String studentName; //시험 본 학생 이름
    private int score; //점수
    private QuestionResult[] questionResults; //문제 결과들의 집합


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public void setQuizNumber(int quizNumber) {
        this.quizNumber = quizNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public QuestionResult[] getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(QuestionResult[] questionResults) {
        this.questionResults = questionResults;
    }
}
