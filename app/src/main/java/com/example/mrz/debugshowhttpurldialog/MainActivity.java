package com.example.mrz.debugshowhttpurldialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cnfol.android.TEhelper.SensorManagerHelper;
import com.cnfol.android.TEhelper.ShowHttpRequestPupupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManagerHelper sensorHelper = new SensorManagerHelper(this);
        sensorHelper.setOnShakeListener(new SensorManagerHelper.OnShakeListener() {

            @Override
            public void onShake() {
                Log.i("=MainActivity==","shake========================");
                //Toast.makeText(BaseActivity.this, "你在摇哦", Toast.LENGTH_SHORT).show();
                ShowHttpRequestPupupWindow.getInstance(MainActivity.this).show();
            }
        });
        ShowHttpRequestPupupWindow.addReqAndRespPairs(new ShowHttpRequestPupupWindow.ResponseAndResqust("https://leetcode.com/","       请求的结果:"+"{\"flag\":10000,\"info\":\"成功\",\"data\":[{\"bannerPicAddr\":\"\",\"bannerPicId\":1,\"flag\":0,\"url\":\"http://licai.test.cnfol.com/activity/mbroker/receivetask.html\"}]}"));
        ShowHttpRequestPupupWindow.addReqAndRespPairs(new ShowHttpRequestPupupWindow.ResponseAndResqust("http://blog.csdn.net/editor1994/article/details/50394560","       请求的结果:"+"{\"flag\":10000,\"info\":\"成功\",\"data\":[{\"bannerPicAddr\":\"\",\"bannerPicId\":1,\"flag\":0,\"url\":\"http://licai.test.cnfol.com/activity/mbroker/receivetask.html\"}]}"));
        ShowHttpRequestPupupWindow.addReqAndRespPairs(new ShowHttpRequestPupupWindow.ResponseAndResqust("https://www.quora.com/With-China-banning-VPN-whats-the-alternative","       请求的结果:"+"{\"flag\":10000,\"info\":\"成功\",\"data\":[{\"bannerPicAddr\":\"\",\"bannerPicId\":1,\"flag\":0,\"url\":\"http://licai.test.cnfol.com/activity/mbroker/receivetask.html\"}]}"));
        ShowHttpRequestPupupWindow.addReqAndRespPairs(new ShowHttpRequestPupupWindow.ResponseAndResqust("http://www.jianshu.com/p/ddd23bb06a67","       请求的结果:"+"{\"flag\":10000,\"info\":\"成功\",\"data\":[{\"bannerPicAddr\":\"\",\"bannerPicId\":1,\"flag\":0,\"url\":\"http://licai.test.cnfol.com/activity/mbroker/receivetask.html\"}]}"));
        ShowHttpRequestPupupWindow.addReqAndRespPairs(new ShowHttpRequestPupupWindow.ResponseAndResqust("https://leetcode.com/problemset/all/","       请求的结果:"+"{\"flag\":10000,\"info\":\"成功\",\"data\":[{\"bannerPicAddr\":\"\",\"bannerPicId\":1,\"flag\":0,\"url\":\"http://licai.test.cnfol.com/activity/mbroker/receivetask.html\"}]}"));


    }
}
