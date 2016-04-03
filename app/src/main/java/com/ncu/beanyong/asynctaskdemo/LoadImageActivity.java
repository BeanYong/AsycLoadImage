package com.ncu.beanyong.asynctaskdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ncu.beanyong.asynctaskdemo.adapter.NewsAdapter;
import com.ncu.beanyong.asynctaskdemo.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BeanYong on 2015/8/23.
 */
public class LoadImageActivity extends Activity {
    private final String[] IMG_URLS = {
            "http://e.hiphotos.baidu.com/image/pic/item/cdbf6c81800a19d8a8af25e337fa828ba71e46a3.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/79f0f736afc379316bb527cfefc4b74542a91172.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/6d81800a19d8bc3ea485a72c868ba61ea9d34542.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/359b033b5bb5c9eaaa7ea205d139b6003bf3b343.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/bba1cd11728b471096f05c2ac7cec3fdfd03237c.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/8326cffc1e178a82d3c9de46f203738da877e85b.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/dc54564e9258d109be6a0854d558ccbf6d814d4e.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/b2de9c82d158ccbf3a8dd1b01bd8bc3eb1354102.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/810a19d8bc3eb13568f6d331a41ea8d3fd1f4402.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/bba1cd11728b4710cd1e9946c1cec3fdfc032302.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/f31fbe096b63f6249ea25c898544ebf81b4ca3b9.jpg",
            "http://g.hiphotos.baidu.com/image/pic/item/9e3df8dcd100baa193cc106d4310b912c9fc2e07.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/1f178a82b9014a9012ca6888ac773912b31bee0b.jpg",
            "http://imga1.pic21.com/bizhi/131119/04079/s08.jpg",
            "http://a.hiphotos.baidu.com/zhidao/pic/item/7dd98d1001e9390179ba994778ec54e736d1960a.jpg",
            "http://www.6188.com/upload_6188s/flashAll/s800/20120903/1346635344G8hLc7.jpg",
            "http://www.6188.com/upload_6188s/flashAll/s800/20120928/1348795147pnQDQH.jpg",
            "http://imga1.pic21.com/bizhi/131119/04079/s06.jpg",
            "http://img.tuwan.com/v2/thumb/all/ODEwMSw4MDEsMjAwLDQsMywxLC0xLDEs/u/img.tuwan.com/static/default/201408/1-14081302385510.jpg",
            "http://www.6188.com/upload_6188s/flashAll/s800/20120907/13469819947dzDL8.jpg",
            "http://b.zol-img.com.cn/desk/bizhi/image/4/960x600/1387880566676.jpg",
            "http://www.cnsc8.com/res/tupian_201401/Big_Pic/FbJRkFk5pE.jpg",
            "http://www.bz55.com/uploads/allimg/150106/139-150106095J1.jpg",
            "http://imga1.pic21.com/bizhi/131119/04080/s06.jpg",
            "http://imga1.pic21.com/bizhi/131119/04079/s18.jpg"};
    private String[] titles = {"title_01", "title_02", "title_03", "title_04", "title_05", "title_06",
            "title_07", "title_08", "title_09", "title_10", "title_11", "title_12", "title_13", "title_02",
            "title_03", "title_04", "title_05", "title_06", "title_07", "title_08", "title_09", "title_10",
            "title_11", "title_12", "title_13"};
    private String[] descs = {"desc_01", "desc_02", "desc_03", "desc_04", "desc_05", "desc_06", "desc_07",
            "desc_08", "desc_09", "desc_10", "desc_11", "desc_12", "desc_13", "desc_02", "desc_03", "desc_04",
            "desc_05", "desc_06", "desc_07", "desc_08", "desc_09", "desc_10", "desc_11", "desc_12", "desc_13"};
    private ListView mListView;
    private List<NewsBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_image_layout);
        getData();
        mListView = (ListView) findViewById(R.id.id_lv_loadJson);
        mListView.setAdapter(new NewsAdapter(mData, this));
    }

    private void getData() {
        mData = new ArrayList<NewsBean>();
        for (int i = 0; i < IMG_URLS.length; i++) {
            NewsBean news = new NewsBean(IMG_URLS[i], titles[i], descs[i]);
            mData.add(news);
        }
    }
}