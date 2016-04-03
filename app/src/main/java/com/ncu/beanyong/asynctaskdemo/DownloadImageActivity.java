package com.ncu.beanyong.asynctaskdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by BeanYong on 2015/8/23.
 */
public class DownloadImageActivity extends Activity {

    private final String IMG_URL = "http://pic.nipic.com/2007-12-16/20071216111124205_2.jpg";
    private final String IMG_URL_1 = "http://img2.imgtn.bdimg.com/it/u=2162766932,244861494&fm=21&gp=0.jpg";
    private ImageView mImageContainer;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_img_layout);
        mImageContainer = (ImageView) findViewById(R.id.id_iv_image);
        mProgress = (ProgressBar) findViewById(R.id.id_pb_progress);
        new LoadImageTask().execute(IMG_URL);
    }

    class LoadImageTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            return getBitmapFromBufferedInputStream(params[0]);
        }

        @Override
        protected void onPreExecute() {
            mProgress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mProgress.setVisibility(View.GONE);
            if (bitmap != null)
                mImageContainer.setImageBitmap(bitmap);
            else
                Toast.makeText(DownloadImageActivity.this, "sorry!", Toast.LENGTH_SHORT).show();
        }
    }

    private Bitmap getBitmapFromBufferedInputStream(String urlStr) {
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            is = conn.getInputStream();
            bis = new BufferedInputStream(is);
            bitmap = BitmapFactory.decodeStream(bis);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private Bitmap getBitmapFromBufferedReader(String urlStr){
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            is = conn.getInputStream();
            isr = new InputStreamReader(is,"utf-8");
            br = new BufferedReader(isr);
            String result = "";
            String temp = "";
            while ((temp = br.readLine()) != null) {
                result += temp;
            }

            byte[] b = result.getBytes();
            bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}