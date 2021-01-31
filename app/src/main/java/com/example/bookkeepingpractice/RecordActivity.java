package com.example.bookkeepingpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bookkeepingpractice.db.AccountRecord;
import com.example.bookkeepingpractice.db.DBManager;
import com.example.bookkeepingpractice.utils.KeyBoardUtils;
import com.example.bookkeepingpractice.utils.RemarkDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener{
    KeyboardView keyboardView;
    EditText titleET;
    EditText amountEt;
    TextView timeTv;
    TextView remarkTv;
    AccountRecord accountRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        initView();
        accountRecord = new AccountRecord();
        accountRecord.setTitle("花钱");
        setInitTime();
    }

    public void initView() {
        keyboardView = findViewById(R.id.record_keyboard);
        titleET = findViewById(R.id.record_ev_title);
        amountEt = findViewById(R.id.record_ev_amount);
        timeTv = findViewById(R.id.record_tv_time);
        remarkTv = findViewById(R.id.record_tv_remark);
        remarkTv.setOnClickListener(this);
        timeTv.setOnClickListener(this);
        KeyBoardUtils boardUtils = new KeyBoardUtils(keyboardView, amountEt);
        boardUtils.showKeyboard();
        boardUtils.setOnEnsureListener(new KeyBoardUtils.OnEnsureListener() {
            @Override
            public void onEnsure() {
                String amountSrt = amountEt.getText().toString();
                if (TextUtils.isEmpty(amountSrt) || amountSrt.equals("0")) {
                   finish();
                   return;
                }
                float amount = Float.parseFloat(amountSrt);
                accountRecord.setAmount(amount);
                saveAccountToDB();
                finish();
            }
        });
    }

    public void setInitTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String time = sdf.format(date);
        timeTv.setText(time);
        accountRecord.setTime(time);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        accountRecord.setYear(year);
        accountRecord.setMonth(month);
        accountRecord.setDay(day);
    }


    public void saveAccountToDB() {
        DBManager.insertItemToAccounttb(accountRecord);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.record_iv_back:
                finish();
                break;
        }
        switch (view.getId()) {
            case R.id.record_tv_time:
                break;
            case R.id.record_tv_remark:
                showRemarkDialog();
                break;

        }
    }

    public void showRemarkDialog() {
        RemarkDialog dialog = new RemarkDialog(getBaseContext());
        dialog.show();

        dialog.setOnEnsureListener
    }

}

