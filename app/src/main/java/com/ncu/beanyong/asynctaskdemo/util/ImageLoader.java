package com.ncu.beanyong.asynctaskdemo.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by BeanYong on 2015/8/29.
 */
public class ImageLoader {
    public static LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>((int) (Runtime.getRuntime().maxMemory() * 0.25));

    public static Bitmap loadImage(String param) {
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            URL url = new URL(param);
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
        } finally {
            if (conn != null) {
                conn.disconnect();
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }
}
