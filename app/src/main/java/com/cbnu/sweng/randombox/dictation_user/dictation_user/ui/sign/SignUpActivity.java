package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.sign;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.etSchoolNameUp) EditText etSchoolNameUp;
    @BindView(R.id.etStudentInfoUp) EditText etStudentInfoUp;
    @BindView(R.id.btSignUp) Button btSignUp;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        etSchoolNameUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new SweetAlertDialog(SignUpActivity.this)
                        .setTitleText("Here's a message!")
                        .setContentText("It's pretty, isn't it?")
                        .show();
            }
        });

        etStudentInfoUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new SweetAlertDialog(SignUpActivity.this)
                        .setTitleText("Here's a message!")
                        .setContentText("It's pretty, isn't it?")
                        .show();
            }
        });

        btSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("TAG", "CLICK");
            }
        });

    }
}

