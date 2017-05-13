package com.moli.appletshop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.moli.appletshop.App;
import com.moli.appletshop.R;
import com.moli.appletshop.bean.Goods;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * 启动界面
 *
 * @author :smile
 * @project:SplashActivity
 * @date
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        query();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, ShopActivity.class));
                finish();
            }
        }, 3000);

    }


    public void query() {
        BmobQuery<Goods> query = new BmobQuery<Goods>();
        //查询playerName叫“比目”的数据
        //query.addWhereEqualTo("playerName", "比目");
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        //query.setLimit(50);
        //执行查询方法
        query.findObjects(SplashActivity.this, new FindListener<Goods>() {
            @Override
            public void onSuccess(List<Goods> list) {
                //Toast.makeText(SplashActivity.this,"共"+list.size()+"个小程序",Toast.LENGTH_LONG).show();
                App.goods = list;
            }

            @Override
            public void onError(int i, String s) {
                Log.e("查询失败", i + "," + s);
            }
        });

}
}
