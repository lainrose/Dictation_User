package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.NaverSpellChecker;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import java.util.concurrent.ExecutionException;

public class ExamResultDetailedPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result_detailed_page);

        NaverSpellChecker naverSpellCheckParser = new NaverSpellChecker();

        String result = null;
        try {
            result = naverSpellCheckParser.execute("아버지가방에드러가쉰다. 막춤법 성공!").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("NAVER", result);
    }
}
