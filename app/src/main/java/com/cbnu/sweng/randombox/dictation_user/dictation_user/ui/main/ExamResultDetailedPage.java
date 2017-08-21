package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.main;

import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.NaverSpellChecker;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExamResultDetailedPage extends AppCompatActivity {


    @BindView(R.id.tvTable1) TextView tvTable1;
    @BindView(R.id.tvTable2) TextView tvTable2;
    @BindView(R.id.tvTable3) TextView tvTable3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_exam_result_detailed_page);

        ButterKnife.bind(this);

        tvTable1.setPaintFlags(tvTable1.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        tvTable2.setPaintFlags(tvTable1.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        tvTable3.setPaintFlags(tvTable1.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);

    }
}
