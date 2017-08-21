package com.cbnu.sweng.randombox.dictation_user.dictation_user.ui.main;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.ApiRequester;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.BuildConfig;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.R;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.model.Question;
import com.cbnu.sweng.randombox.dictation_user.dictation_user.model.Quiz;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.myscript.atk.sltw.SingleLineWidget;
import com.myscript.atk.sltw.SingleLineWidgetApi;
import com.myscript.atk.text.CandidateInfo;
import com.myscript.certificate.MyCertificate;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ExamActivity extends AppCompatActivity implements
        SingleLineWidgetApi.OnConfiguredListener,
        SingleLineWidgetApi.OnTextChangedListener,
        CustomEditText.OnSelectionChanged,
        SingleLineWidgetApi.OnUserScrollBeginListener,
        SingleLineWidgetApi.OnUserScrollEndListener,
        SingleLineWidgetApi.OnUserScrollListener

{

    private static final String TAG = "SingleLineDemo";

    private SingleLineWidgetApi widget;
    private CustomEditText mTextField;
    private int isCorrectionMode;
    String getEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseMessaging.getInstance().subscribeToTopic("hmu");
        FirebaseInstanceId.getInstance().getToken();

        setContentView(R.layout.activity_exam);

        mTextField = (CustomEditText) findViewById(R.id.textField);

        mTextField.setOnSelectionChangedListener(this);
        widget = (SingleLineWidget) findViewById(R.id.widget);
        if (!widget.registerCertificate(MyCertificate.getBytes())) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please use a valid certificate.");
            dlgAlert.setTitle("Invalid certificate");
            dlgAlert.setCancelable(false);
            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //dismiss the dialog
                }
            });
            dlgAlert.create().show();
            return;
        }

        widget.setOnConfiguredListener(this);
        widget.setOnTextChangedListener(this);
        widget.setOnUserScrollBeginListener(this);
        widget.setOnUserScrollEndListener(this);
        widget.setOnUserScrollListener(this);

        widget.setBaselinePosition(getResources().getDimension(R.dimen.baseline_position));
        widget.setWritingAreaBackgroundResource(R.drawable.sltw_bg_pattern);
        widget.setScrollbarResource(R.drawable.sltw_scrollbar_xml);
        widget.setScrollbarMaskResource(R.drawable.sltw_scrollbar_mask);
        widget.setScrollbarBackgroundResource(R.drawable.sltw_scrollbar_background);
        widget.setLeftScrollArrowResource(R.drawable.sltw_arrowleft_xml);
        widget.setRightScrollArrowResource(R.drawable.sltw_arrowright_xml);
        widget.setCursorResource(R.drawable.sltw_text_cursor_holo_light);

        // references assets directly from the APK to avoid extraction in application
        // file system
        widget.addSearchDir("zip://" + getPackageCodePath() + "!/assets/conf");

        // The configuration is an asynchronous operation. Callbacks are provided to
        // monitor the beginning and end of the configuration process and update the UI
        // of the input method accordingly.
        //
        // "en_US" references the en_US bundle name in conf/en_US.conf file in your assets.
        // "cur_text" references the configuration name in en_US.conf
        widget.configure("ko_KR", "cur_text");

        widget.setText(mTextField.getText().toString());
        isCorrectionMode = 0;

        ApiRequester apiRequester = new ApiRequester();

        try {
            apiRequester.getTeachersQuizzes(new ApiRequester.UserCallback<List<Quiz>>() {
                @Override
                public void onSuccess(List<Quiz> result) {
                    for(Quiz quiz : result){
                        for(Question ques : quiz.getQuestions()){
                            String number = String.valueOf(ques.getNumber());
                            String question = ques.getSentence();
                        }
                    }
                }

                @Override
                public void onFail() {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        widget.setOnTextChangedListener(null);
        widget.setOnConfiguredListener(null);

        super.onDestroy();
    }

    public void onSpaceButtonClick(View v) {
        int index = widget.getCursorIndex();
        boolean replaced = widget.replaceCharacters(index, index, " ");
        if (replaced) {
            widget.setCursorIndex(index + 1);
            isCorrectionMode++;
        }
    }

    public void onDeleteButtonClick(View v) {
        int index = widget.getCursorIndex();
        CandidateInfo info = widget.getCharacterCandidates(widget.getCursorIndex() - 1);
        boolean replaced = widget.replaceCharacters(info.getStart(), info.getEnd(), null);
        if (replaced) {
            widget.setCursorIndex(index - (info.getEnd() - info.getStart()));
            isCorrectionMode++;
        }
    }

    public void onCheckButtonClick(View v) {
        getEdit = mTextField.getText().toString(); // 텍스트 변수 저장
        Toast.makeText(getApplicationContext(), getEdit, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConfigured(SingleLineWidgetApi widget, boolean success) {
        if (!success) {
            Toast.makeText(getApplicationContext(), widget.getErrorString(), Toast.LENGTH_LONG).show();
            Log.e(TAG, "Unable to configure the Single Line Widget: " + widget.getErrorString());
            return;
        }
        Toast.makeText(getApplicationContext(), "Single Line Widget Configured", Toast.LENGTH_SHORT).show();
        if (BuildConfig.DEBUG)
            Log.d(TAG, "Single Line Widget configured!");
    }

    @Override
    public void onTextChanged(SingleLineWidgetApi widget, String text, boolean intermediate) {
//        Toast.makeText(getApplicationContext(), "Recognition update", Toast.LENGTH_SHORT).show();
//        if(BuildConfig.DEBUG)
//        {
//            Log.d(TAG, "Single Line Widget recognition: " + widget.getText());
//        }
        Log.d(TAG, "Text changed to \"" + text + "\" (" + (intermediate ? "intermediate" : "stable") + ")");
        // temporarily disable selection changed listener to prevent spurious cursor jumps
        mTextField.setOnSelectionChangedListener(null);
        mTextField.setTextKeepState(text);
        if (isCorrectionMode == 0) {
            mTextField.setSelection(text.length());
            mTextField.setOnSelectionChangedListener(this);
            widget.setCursorIndex(mTextField.length());
        } else {
            mTextField.setSelection(widget.getCursorIndex());
            mTextField.setOnSelectionChangedListener(this);
            isCorrectionMode--;
        }
    }

    @Override
    public void onSelectionChanged(EditText editText, int selStart, int selEnd) {
        Log.d(TAG, "Selection changed to [" + selStart + "-" + selEnd + "]");
        if (widget.getCursorIndex() != selEnd) {
            widget.setCursorIndex(selEnd);
            if (selEnd == widget.getText().length()) {
                widget.scrollTo(selEnd);
            } else {
                widget.centerTo(selEnd);
            }
        }
    }

    @Override
    public void onUserScrollBegin(SingleLineWidgetApi w) {
        Log.d(TAG, "User scroll begin");
    }

    @Override
    public void onUserScrollEnd(SingleLineWidgetApi w) {
        Log.d(TAG, "User scroll end");
    }

    @Override
    public void onUserScroll(SingleLineWidgetApi w) {
        Log.d(TAG, "User scroll");
        if (widget.moveCursorToVisibleIndex()) {
            // temporarily disable selection changed listener
            mTextField.setOnSelectionChangedListener(null);
            mTextField.setSelection(widget.getCursorIndex());
            mTextField.setOnSelectionChangedListener(this);
        }
    }
}