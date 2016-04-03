package com.ncu.beanyong.asynctaskdemo.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ncu.beanyong.asynctaskdemo.R;
import com.ncu.beanyong.asynctaskdemo.bean.NewsBean;
import com.ncu.beanyong.asynctaskdemo.task.LoadImageTask;
import com.ncu.beanyong.asynctaskdemo.util.ImageLoader;

import java.util.List;

/**
 * Created by BeanYong on 2015/8/29.
 */
public class NewsAdapter extends BaseAdapter {

    private List<NewsBean> mData;
    private LayoutInflater mInflater;

    public NewsAdapter(List<NewsBean> mData, Context context) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_layout, null);
            vh.icon = (ImageView) convertView.findViewById(R.id.id_iv_icon);
            vh.title = (TextView) convertView.findViewById(R.id.id_tv_title);
            vh.desc = (TextView) convertView.findViewById(R.id.id_tv_desc);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.icon.setImageResource(R.mipmap.ic_launcher);
        NewsBean news = mData.get(position);
        Bitmap image = ImageLoader.mCache.get(news.getIconUrl());
        if (image == null) {
            LoadImageTask task = new LoadImageTask(vh.icon);
            task.execute(news.getIconUrl());
        } else{
            vh.icon.setImageBitmap(image);
        }
        vh.title.setText(news.getTitle());
        vh.desc.setText(news.getDesc());
        return convertView;
    }

    static class ViewHolder {
        ImageView icon;
        TextView title, desc;
    }
}
