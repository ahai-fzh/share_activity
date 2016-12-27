package com.ahai.demo.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by zhenhai.fzh on 16/12/27.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(listener);
        // 从活动1中取出数据
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pwd = intent.getStringExtra("pwd");
        Log.d("SecondActivity", "name:"+name+", pwd:"+pwd);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_1:

                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("nickname", "james");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
