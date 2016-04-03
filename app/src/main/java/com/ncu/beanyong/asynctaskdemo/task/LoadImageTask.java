package com.ncu.beanyong.asynctaskdemo.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.ImageView;

import com.ncu.beanyong.asynctaskdemo.util.ImageLoader;

/**
 * Created by BeanYong on 2015/8/29.
 */
public class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView mTarget;

    public LoadImageTask(ImageView mTarget) {
        this.mTarget = mTarget;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = ImageLoader.loadImage(params[0]);
        if(bitmap!=null) {//将图片加入缓存
            ImageLoader.mCache.put(params[0], bitmap);
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null)
            mTarget.setImageBitmap(bitmap);
    }
}
