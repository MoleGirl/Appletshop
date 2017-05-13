package com.moli.appletshop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moli.appletshop.App;
import com.moli.appletshop.R;
import com.moli.appletshop.adapter.GoodsListAdapter;
import com.moli.appletshop.bean.Goods;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */

public class ListActivity extends Activity implements View.OnClickListener {

    private String data[] = {"全部", "社交", "音乐", "出行", "旅游"
            , "体育", "生活", "健康", "视频", "母婴", "工具", "图像",
            "教育", "金融", "购物", "阅读", "办公"};
    private List<Goods> goods;


    private ImageView img;
    private TextView title;
    private ListView list;
    public static DisplayImageOptions mNormalImageOptions;
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().toString();
    public static final String IMAGES_FOLDER = SDCARD_PATH + File.separator + "demo" + File.separator + "images" + File.separator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        img = (ImageView) findViewById(R.id.img);
        title = (TextView) findViewById(R.id.title);
        list = (ListView) findViewById(R.id.list);
        img.setOnClickListener(this);
        initDate();
        initImageLoader(this);
    }

    private void initDate() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        for (int i = 0; i < data.length; i++) {
            if (str.equals(data[i])) {
                title.setText(data[i]);
            }
        }

        goods = new ArrayList<>();


        if (str.equals("全部")) {
            goods = App.goods;
        } else {
            int a = 0;
            for (int i = 0; i < App.goods.size(); i++) {
                if (str.equals(App.goods.get(i).getCategory()) || App.goods.get(i).getCategory().contains(str)) {
                    goods.add(App.goods.get(i));
                    a++;
                }
            }
            //Toast.makeText(this, "符合的条数" + a, Toast.LENGTH_LONG).show();
        }

        list.setAdapter(new GoodsListAdapter(this, goods));

    }


    private void initImageLoader(Context context) {
        int memoryCacheSize = (int) (Runtime.getRuntime().maxMemory() / 5);
        MemoryCacheAware<String, Bitmap> memoryCache;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            memoryCache = new LruMemoryCache(memoryCacheSize);
        } else {
            memoryCache = new LRULimitedMemoryCache(memoryCacheSize);
        }

        mNormalImageOptions = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisc(true)
                .resetViewBeforeLoading(true).build();

        // This
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).defaultDisplayImageOptions(mNormalImageOptions)
                .denyCacheImageMultipleSizesInMemory().discCache(new UnlimitedDiscCache(new File(IMAGES_FOLDER)))
                // .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .memoryCache(memoryCache)
                // .memoryCacheSize(memoryCacheSize)
                .tasksProcessingOrder(QueueProcessingType.LIFO).threadPriority(Thread.NORM_PRIORITY - 2).threadPoolSize(3).build();

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                finish();
                break;
        }

    }
}
