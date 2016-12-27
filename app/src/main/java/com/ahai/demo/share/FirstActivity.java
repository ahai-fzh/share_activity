package com.ahai.demo.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by zhenhai.fzh on 16/12/27.
 */

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_1:
                    // 结束活动
                    // finish();
                    // 打开打电话活动
                    startTel("10086");
                    break;
            }
        }
    };

    // 弹起toast
    void showToast() {
        Toast.makeText(FirstActivity.this, "我是按钮1", Toast.LENGTH_LONG).show();
    }

    void startSecondActivity() {
        Intent intent = new Intent();
        // 显式启动
        // intent.setClass(this, SecondActivity.class);
        // 隐式启动
        intent.setAction("com.ahai.demo.share.SecondAct");
        // 传入数据
        intent.putExtra("name", "jake");
        intent.putExtra("pwd", "123");
        // 启动活动2 不接收返回结果
        // startActivity(intent);
        // 启动活动2 接收返回结果
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            // 取出活动2的返回结果
            String str = data.getStringExtra("nickname");
            Log.d("FirstActivity", "str:"+str);
        }
    }

    // 打开浏览器活动
    void startBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    // 打开打电话活动
    void startTel(String pn) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+pn));
        startActivity(intent);
    }
}
