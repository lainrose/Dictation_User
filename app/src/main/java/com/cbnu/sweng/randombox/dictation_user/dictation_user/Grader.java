package com.cbnu.sweng.randombox.dictation_user.dictation_user;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.model.GraderResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by user on 2017-08-21.
 */

public class Grader {

    ArrayList<GraderResult> result;
    NaverSpellChecker naverSpellCheckParser;
    private int score = 100;

    public void excute(ArrayList<String[]> qnas){

        result = new ArrayList<GraderResult>();
        naverSpellCheckParser = new NaverSpellChecker();

        for(String[] qna : qnas){
            String questionNumber = qna[0];
            final String question = qna[1];
            final String answer = qna[2];
            GraderResult graderResult = new GraderResult();

            if(question.equals(answer)){
                graderResult.setQuestionNumber(Integer.parseInt(questionNumber));
                graderResult.setCorrect(true);
                graderResult.setRectify(new ArrayList<String[]>(){{
                    add(new String[]{"black", answer});
                }});
                graderResult.setQuestion(question);
            }
            else{
                graderResult.setQuestionNumber(Integer.parseInt(questionNumber));
                graderResult.setCorrect(false);
                graderResult.setQuestion(question);

                try {
                    graderResult.setRectify((naverSpellCheckParser.execute(answer).get()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                score -= 10;
            }

            if(graderResult.getQuestionNumber() == 10){
                graderResult.setScore(score);
            }
            result.add(graderResult);
        }
    }
}
