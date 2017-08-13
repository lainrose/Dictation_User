package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.sign;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;

public class BasicActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.modify_info) // 개인정보 수정
        {
            return true;
        }

        else if (id == R.id.check_past) // 지난성적 보기
        {
            Intent intent = new Intent(this, Check_Past.class);
            startActivity(intent);
        }

        else if (id == R.id.log_out) // 로그아웃
        {
            Toast.makeText(getApplicationContext(), "로그아웃 완료", Toast.LENGTH_LONG).show();
        }

        else if (id == R.id.exit) // 종료
        {
            exitOptionsDialog();

        }
        return super.onOptionsItemSelected(item);
    }

//    private void openOptionsDialog() {
//        new AlertDialog.Builder(this)
//                .setTitle(R.string.modify_info)
//                .setMessage(R.string.app_about_message)
//                .setPositiveButton(R.string.str_ok,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(
//                                    DialogInterface dialoginterface, int i) {
//                            }
//                        }).show();
//    }

    private void exitOptionsDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.exit)
                .setMessage("종료하시겠습니까?")
                .setNegativeButton(R.string.str_no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialoginterface, int i) {
                            }
                        })
                .setPositiveButton(R.string.str_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialoginterface, int i) {
                                moveTaskToBack(true);
                                finish();
                                android.os.Process.killProcess(android.os.Process.myPid());

                            }
                        }).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

    }
}
