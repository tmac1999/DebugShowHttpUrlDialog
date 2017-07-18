//package com.cnfol.android.TEhelper;
//
//import android.annotation.SuppressLint;
//import android.app.Dialog;
//import android.content.ClipData;
//import android.content.ClipboardManager;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.LinkedList;
//
///**
// * Created by mrz on 17/6/9.
// */
//
//public class ShowHttpRequestDialog extends Dialog{
//
//    private StringBuilder toBeCopiedText;
//    private String text;
//    public TextView tv_request_info,tv_response_info;
//    private Context context;
//    private LinkedList<String> reqAndRespPairs = new LinkedList<String>();
//    public ShowHttpRequestDialog(Context context) {
//        super(context);
//        this.context = context;
//    }
//
//    public ShowHttpRequestDialog(Context context, int theme) {
//        super(context, theme);
//        this.context = context;
//    }
//    public ShowHttpRequestDialog(Context context, String text) {
//        super(context);
//        this.context = context;
//        StringBuilder toBeCopiedText = new StringBuilder(text);
//        this.text = text;
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_show_httprequest_result);
//        myClipboard = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
//        tv_request_info = (TextView) findViewById(R.id.tv_request_info);
//        tv_response_info = (TextView) findViewById(R.id.tv_response_info);
//        View btn_copy_to_clipboard = findViewById(R.id.btn_copy_to_clipboard);
//        tv_request_info.setText(text);
//
//        btn_copy_to_clipboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                copy();
//            }
//        });
//    }
//
//
//
//    private ClipboardManager myClipboard;
//    private ClipData myClip;
//    public void setResponseInfo(String info){
//        tv_response_info.setText(info);
//        toBeCopiedText.append(info);
//        toBeCopiedText.append(info);
//    }
//
//    @SuppressLint("NewApi")
//    public void copy(){
//       // String text = tv_request_info.getText().toString();
//        myClip = ClipData.newPlainText("text", toBeCopiedText.toString());
//        myClipboard.setPrimaryClip(myClip);
//        Toast.makeText(context, "Text Copied",
//                Toast.LENGTH_SHORT).show();
//    }
//
//}
