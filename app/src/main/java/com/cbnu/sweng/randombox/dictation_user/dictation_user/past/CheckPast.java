package com.cbnu.sweng.randombox.dictation_user.dictation_user.past;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckPast extends AppCompatActivity {

    @BindView(R.id.spinner2) Spinner s;
    @BindView(R.id.button4) Button btn;

    @OnClick(R.id.button4) void check()
    {
        Toast.makeText(getApplicationContext(), "출력할 문자열", Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkpast);
        ButterKnife.bind(this);



        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
}
