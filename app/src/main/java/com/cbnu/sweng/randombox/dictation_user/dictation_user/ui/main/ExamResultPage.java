package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.Util;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.model.QuestionResult;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.model.QuizResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExamResultPage extends AppCompatActivity {

    QuizResult quizResult;
    @BindView(R.id.ivGradeOne) ImageView ivGradeOne;
    @BindView(R.id.ivGradeTwo) ImageView ivGradeTwo;
    @BindView(R.id.ivGradeThree) ImageView ivGradeThree;
    @BindView(R.id.ivGradeFour) ImageView ivGradeFour;
    @BindView(R.id.ivGradeFive) ImageView ivGradeFive;
    @BindView(R.id.ivGradeSix) ImageView ivGradeSix;
    @BindView(R.id.ivGradeSeven) ImageView ivGradeSeven;
    @BindView(R.id.ivGradeEight) ImageView ivGradeEight;
    @BindView(R.id.ivGradeNine) ImageView ivGradeNine;
    @BindView(R.id.ivGradeTen) ImageView ivGradeTen;
    @BindView(R.id.ivScore) ImageView ivScore;

    @OnClick(R.id.btResultOne)
    void onClickBtResultOne(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultTwo)
    void onClickBtResultTwo(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultThree)
    void onClickBtResultThree(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultFour)
    void onClickBtResultFour(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultFive)
    void onClickBtResultFive(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultSix)
    void onClickBtResultSix(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultSeven)
    void onClickBtResultSeven(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultEight)
    void onClickBtResultEight(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultNine)
    void onClickBtResultNine(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }
    @OnClick(R.id.btResultTen)
    void onClickBtResultTen(){
        Util.getInstance().MoveAcitivity(this, ExamResultDetailedPage.class, quizResult);
    }

    @OnClick(R.id.btInResultPage)
    void onClickBtInResultPage(){
        //메인페이지 이동
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result_page);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        quizResult = (QuizResult) intent.getSerializableExtra("OBJECT");

        if(quizResult.getScore() == 0){
            ivScore.setImageResource(R.drawable.score0);
        }
        else if(quizResult.getScore() == 10){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 20){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 30){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 40){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 50){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 60){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 70){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 80){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 90){
            ivScore.setImageResource(R.drawable.score10);
        }
        else if(quizResult.getScore() == 100){
            ivScore.setImageResource(R.drawable.score100);
        }

        for (QuestionResult questionResult : quizResult.getQuestionResults()) {
            if(questionResult.getQuestionNumber() == 1){
                if(questionResult.isCorrect()){
                    ivGradeOne.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeOne.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 2){
                if(questionResult.isCorrect()){
                    ivGradeTwo.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeTwo.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 3){
                if(questionResult.isCorrect()){
                    ivGradeThree.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeThree.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 4){
                if(questionResult.isCorrect()){
                    ivGradeFour.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeFour.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 5){
                if(questionResult.isCorrect()){
                    ivGradeFive.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeFive.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 6){
                if(questionResult.isCorrect()){
                    ivGradeSix.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeSix.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 7){
                if(questionResult.isCorrect()){
                    ivGradeSeven.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeSeven.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 8){
                if(questionResult.isCorrect()){
                    ivGradeEight.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeEight.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 9){
                if(questionResult.isCorrect()){
                    ivGradeNine.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeNine.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 10){
                if(questionResult.isCorrect()){
                    ivGradeTen.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeTen.setImageResource(R.drawable.ic_check_no);
                }
            }
        }
    }
}
