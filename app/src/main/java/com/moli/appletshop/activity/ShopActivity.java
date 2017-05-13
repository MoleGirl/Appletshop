package com.moli.appletshop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.moli.appletshop.R;
import com.moli.appletshop.adapter.MyGridViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */

public class ShopActivity extends Activity {

    private GridView gdview;
    private Context mContext;
    public final static int RESULT_CODE = 1;
    private String str[]={"全部","社交","音乐","出行","旅游"
            ,"体育","生活","健康","视频","母婴","工具","图像",
            "教育","金融","购物","阅读","办公"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //Fresco.initialize(this);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        mContext = ShopActivity.this;
        gdview = (GridView) findViewById(R.id.gv_gridview);
        initDate();
    }

    private void initDate() {
        List<String> lists = new ArrayList<String>();
        for (int i = 0; i <str.length ; i++) {
            lists.add(str[i]);
        }
        gdview.setAdapter(new MyGridViewAdapter(mContext, lists));
        gdview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(ShopActivity.this, ListActivity.class);
                intent.putExtra("str", str[position]);
                startActivityForResult(intent, RESULT_CODE);
            }
        });
    }
}
