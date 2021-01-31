package com.example.bookkeepingpractice.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookkeepingpractice.R;

public class RemarkDialog extends Dialog implements View.OnClickListener {
    EditText et;
    Button cancelBtn, ensureBtn;
    OnEnsureListener onEnsureListener;

    public RemarkDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_remark);
        et = findViewById(R.id.dialog_remark_et);
        cancelBtn = findViewById(R.id.dialog_remark_btn_cancel);
        ensureBtn = findViewById(R.id.dialog_remark_btn_ensure);
        cancelBtn.setOnClickListener(this);
        ensureBtn.setOnClickListener(this);
    }

    public interface OnEnsureListener {
        public void onEnsure();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_remark_btn_cancel:
                cancel();
                break;
            case R.id.dialog_remark_btn_ensure:
                if (onEnsureListener != null) {
                    onEnsureListener.onEnsure();
                }
                break;
        }
    }

}


