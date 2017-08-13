package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.sign;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//17-08-14
public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.etSchoolNameUp) EditText etSchoolNameUp;
    @BindView(R.id.etStudentInfoUp) EditText etStudentInfoUp;
    @BindView(R.id.btSignUp) Button btSignUp;
    @OnClick(R.id.etSchoolNameUp)
    void onClickEtSchoolNameUp(){

    }
    @OnClick(R.id.etStudentInfoUp)
    void onClickEtStudentInfoUp(){
        View mView = getLayoutInflater().inflate(R.layout.dialog_select_student_info, null);
        final Spinner spGrade = ButterKnife.findById(mView, R.id.spGrade);
        final Spinner spClass = ButterKnife.findById(mView, R.id.spClass);
        final Spinner spAttendenceNum = ButterKnife.findById(mView, R.id.spAttendenceNum);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder.setTitle("학년 / 반 / 이름을 선택해주세요.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.d("TAG", spGrade.getSelectedItem().toString() + spClass.getSelectedItem().toString() + spAttendenceNum.getSelectedItem().toString());
            }
        });
        builder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });
        builder.setView(mView);

        ArrayAdapter<String> GradeAdapter = new ArrayAdapter<String>(SignUpActivity.this,
                                                                        android.R.layout.simple_spinner_item,
                                                                        getResources().getStringArray(R.array.strArrayGrade));
        GradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGrade.setAdapter(GradeAdapter);

        ArrayAdapter<String> ClassAdapter = new ArrayAdapter<String>(SignUpActivity.this,
                                                                        android.R.layout.simple_spinner_item,
                                                                        getResources().getStringArray(R.array.strArrayClass));
        ClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spClass.setAdapter(ClassAdapter);

        ArrayAdapter<String> AttendenceNumAdapter = new ArrayAdapter<String>(SignUpActivity.this,
                                                                                android.R.layout.simple_spinner_item,
                                                                                getResources().getStringArray(R.array.strArrayAttendenceNum));
        AttendenceNumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAttendenceNum.setAdapter(AttendenceNumAdapter);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @OnClick(R.id.btSignUp)
    void onClickBtSignUp(){
        Log.d("TAG", "CLICK");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
    }
}
