package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.NaverSpellChecker;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ExamResultDetailedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result_detailed_page);

        NaverSpellChecker naverSpellCheckParser = new NaverSpellChecker();

        ArrayList<String[]> results;
        try {
            results = naverSpellCheckParser.execute("맞춤법검사기테스트.. 입니다. 무라고헤야 테슽트를 제대로 진헹할 수 있지? 맞춤법어케틀림 아니표준어 의심단어말고 막춤법 성공!").get();
            for(String[] result : results){
                Log.d("NAVER", "color : " + result[0] + " word : " + result[1]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
