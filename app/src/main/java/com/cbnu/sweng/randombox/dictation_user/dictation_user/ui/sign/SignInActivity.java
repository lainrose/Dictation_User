package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.sign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn_intent = (Button)findViewById(R.id.button);
        btn_intent.setOnClickListener(this);
//        ButterKnife.bind(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this, BasicActivity.class);
        startActivity(intent);
    }

}
