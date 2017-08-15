package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.sign;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.past.CheckPast;

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
            Intent intent = new Intent(this, CheckPast.class);
            startActivity(intent);
        }


        else if (id == R.id.exit) // 종료
        {
            exitOptionsDialog();

        }
        return super.onOptionsItemSelected(item);
    }


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

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.table); // 테이블 id 명

        for (int i = 0; i < 9; i++) {
// Creation row
            final TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));


            for(int j = 0 ; j < 3 ; j++){
                final TextView text = new TextView(this);

                text.setText( "갸갸갹" );
                text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                tableRow.addView(text);
            }

            tableLayout.addView(tableRow);
        }


    }

}
