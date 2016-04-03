package com.ncu.beanyong.asynctaskdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mDownloadImage, mLoadJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDownloadImage = (Button) findViewById(R.id.id_btn_downloadImg);
        mDownloadImage.setOnClickListener(this);
        mLoadJson = (Button) findViewById(R.id.id_btn_loadJson);
        mLoadJson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_downloadImg:
                startActivity(new Intent(this, DownloadImageActivity.class));
                break;
            case R.id.id_btn_loadJson:
                startActivity(new Intent(this, LoadImageActivity.class));
                break;
        }
    }
}
