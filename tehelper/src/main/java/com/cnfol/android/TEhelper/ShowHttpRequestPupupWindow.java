package com.cnfol.android.TEhelper;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

/**
 * Created by mrz on 17/6/9.
 */
/**
 * <li>Description: 1.0.3 增加了一个展示单个结果的透明activity
 * 1.0.4 change name of ResultActivity layout
 * <li>Author: zhengpeng
 * <li>Date: 17/7/24 下午3:06
*/
public class ShowHttpRequestPupupWindow extends Dialog {
    public static class ResponseAndResqust {
        public ResponseAndResqust(String request, String response) {
            this.request = request;
            this.response = response;
        }

        String request;
        String response;
    }

    private static ResponseAndResqust latestPair;
    private Context context;
    private static LinkedList<ResponseAndResqust> reqAndRespPairs = new LinkedList<>();


    public static void setMaxPairsNum(int maxPairsNum) {
        ShowHttpRequestPupupWindow.maxPairsNum = maxPairsNum;
    }

    private static int maxPairsNum = 5;
    private static ShowHttpRequestPupupWindow instance;

    public static ShowHttpRequestPupupWindow getInstance(Context context) {
        if (instance == null) {
            instance = new ShowHttpRequestPupupWindow(context);
        }
        return instance;
    }

    private ShowHttpRequestPupupWindow(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  View contentView = View.inflate(context, R.layout.dialog_show_httprequest_result, null);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_show_httprequest_result);
        findViewById(R.id.tv_dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        ListView lv_request_info = (ListView) findViewById(R.id.lv_request_info);
        lv_request_info.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return reqAndRespPairs.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = View.inflate(context, R.layout.item_request_info, null);
                final ResponseAndResqust responseAndResqust = reqAndRespPairs.get(position);
                TextView tv_request_info = (TextView) view.findViewById(R.id.tv_request_info);
                TextView tv_response_info = (TextView) view.findViewById(R.id.tv_response_info);
                View btn_copy_to_clipboard = view.findViewById(R.id.btn_copy_to_clipboard);
                tv_request_info.setText(responseAndResqust.request);
                tv_response_info.setText(responseAndResqust.response);
                btn_copy_to_clipboard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        copy(responseAndResqust);
                    }
                });
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ResultActivity.class);
                        intent.putExtra(ResultActivity.EXTRA_REQUEST_TEXT,responseAndResqust.request);
                        intent.putExtra(ResultActivity.EXTRA_RESPONSE_TEXT,responseAndResqust.response);
                        context.startActivity(intent);
                    }
                });
                return view;
            }
        });
        // getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        myClipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

    }

    private ClipboardManager myClipboard;
    private ClipData myClip;

    public static void addReqAndRespPairs(ResponseAndResqust info) {
        reqAndRespPairs.add(info);
        if (reqAndRespPairs.size() > maxPairsNum) {
            reqAndRespPairs.removeFirst();
        }
        latestPair = info;
    }

    @SuppressLint("NewApi")
    public void copy(ResponseAndResqust bean) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("request:" + bean.request + "\nresponse:" + bean.response);

        myClip = ClipData.newPlainText("text", stringBuilder.toString());
        myClipboard.setPrimaryClip(myClip);
        Toast.makeText(context, "Text Copied",
                Toast.LENGTH_SHORT).show();
    }

}
