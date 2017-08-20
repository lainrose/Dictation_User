package com.cbnu.sweng.randombox.dictation_user.dictation_user;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by user on 2017-08-21.
 */

public class Grader {

    public void excute(){
        NaverSpellChecker naverSpellCheckParser = new NaverSpellChecker();
        ArrayList<String[]> results = null;
        try {
            results = naverSpellCheckParser.execute("맞춤법검사기테스트.. 입니다. 무라고헤야 테슽트를 제대로 진헹할 수 있지? 맞춤법어케틀림 아니표준어 의심단어말고 막춤법 성공!").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (String[] result : results) {
            Log.d("NAVER", "color : " + result[0] + " word : " + result[1]);
        }
    }

}
