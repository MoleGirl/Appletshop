package com.moli.appletshop;

import android.app.Application;

import com.moli.appletshop.bean.Goods;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by Administrator on 2017/4/26.
 */

public class App extends Application {


    public static List<Goods> goods = new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "abc5ea3cb3d5c105eccac0bd6965b4b2");

        //初始化Bmob
//        BmobConfig config =new BmobConfig.Builder(this)
//                //设置appkey
//                .setApplicationId("abc5ea3cb3d5c105eccac0bd6965b4b2")
//                //请求超时时间（单位为秒）：默认15s
//                .setConnectTimeout(30)
//                //文件分片上传时每片的大小（单位字节），默认512*1024
//                .setUploadBlockSize(1024*1024)
//                //文件的过期时间(单位为秒)：默认1800s
//                .setFileExpiration(2500)
//                .build();
//        Bmob.initialize(config);
    }
}
