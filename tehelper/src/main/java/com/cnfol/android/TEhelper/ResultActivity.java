package com.cnfol.android.TEhelper;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultActivity extends Activity {

    public static final String EXTRA_REQUEST_TEXT = "EXTRA_REQUEST_TEXT";
    public static final String EXTRA_RESPONSE_TEXT = "EXTRA_RESPONSE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search_dialog);
        setTranslucentStatus(true);
        String req = getIntent().getStringExtra(EXTRA_REQUEST_TEXT);
        String resp = getIntent().getStringExtra(EXTRA_RESPONSE_TEXT);
        findViewById(R.id.fl_mask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView tv_request_info = (TextView) findViewById(R.id.tv_request_info);
        TextView tv_response_info = (TextView) findViewById(R.id.tv_response_info);
        tv_request_info.setText(req);
        tv_response_info.setText(resp);
    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.dialog_in, R.anim.dialog_out);
    }
}
