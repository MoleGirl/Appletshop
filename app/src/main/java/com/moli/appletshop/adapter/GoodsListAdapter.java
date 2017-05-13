package com.moli.appletshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.moli.appletshop.R;
import com.moli.appletshop.activity.SpaceImageDetailActivity;
import com.moli.appletshop.bean.Goods;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */

public class GoodsListAdapter extends BaseAdapter {

    private Context context;
    private List<Goods> goods;
    private LayoutInflater inflater;
    private ViewHolder vh = null;

    //String data = "http://ojyhagqv7.bkt.clouddn.com/2017/01/11/5875fc33d21ec.jpeg?imageView2/2/w/400";
    //String data1 = "http://ojyhagqv7.bkt.clouddn.com/9cn_201702082c6f1dfac2475b0a27b250c96bd9fb02.jpg?imageView2/2/w/400";
    public GoodsListAdapter(Context context, List<Goods> goods) {
        this.context = context;
        this.goods = goods;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return goods.size();
    }

    @Override
    public Object getItem(int position) {
        return goods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return goods.size();
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {

        if (v == null) {
            //填充一个布局
            v = inflater.inflate(R.layout.list_item, null);
            vh = new ViewHolder();
            vh.imaLeft = (ImageView) v.findViewById(R.id.img_left);
            vh.imgRight = (ImageView) v.findViewById(R.id.img_right);
            vh.name = (TextView) v.findViewById(R.id.name);
            vh.gather = (TextView) v.findViewById(R.id.gather);
            vh.ask = (TextView) v.findViewById(R.id.ask);
            vh.introduce = (TextView) v.findViewById(R.id.introduce);
            v.setTag(vh);
        } else {
            vh = (ViewHolder) v.getTag();
        }
        ImageLoader.getInstance().displayImage(goods.get(position).getLogoUrl(), vh.imaLeft);
        ImageLoader.getInstance().displayImage(goods.get(position).getCode(), vh.imgRight);
        //vh.imgRight.setImageURI(data);
        vh.imaLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "点击了第" + position + "个左边", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SpaceImageDetailActivity.class);
                intent.putExtra("images", goods.get(position).getLogoUrl());
//                intent.putExtra("position", position);
                int[] location = new int[2];
                vh.imaLeft.getLocationOnScreen(location);
                intent.putExtra("locationX", location[0]);
                intent.putExtra("locationY", location[1]);
                intent.putExtra("width", vh.imaLeft.getWidth());
                intent.putExtra("height", vh.imaLeft.getHeight());
                context.startActivity(intent);
                Activity activity = (Activity) context;
                activity.overridePendingTransition(0, 0);


            }
        });
        vh.imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "点击了第" + position + "个右边", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SpaceImageDetailActivity.class);
                intent.putExtra("images", goods.get(position).getCode());
//                intent.putExtra("position", position);
                int[] location = new int[2];
                vh.imaLeft.getLocationOnScreen(location);
                intent.putExtra("locationX", location[0]);
                intent.putExtra("locationY", location[1]);
                intent.putExtra("width", vh.imaLeft.getWidth());
                intent.putExtra("height", vh.imaLeft.getHeight());
                context.startActivity(intent);
                Activity activity = (Activity) context;
                activity.overridePendingTransition(0, 0);
            }
        });

        vh.name.setText(goods.get(position).getName());
        vh.gather.setText("作者:"+goods.get(position).getGather());
        vh.ask.setText("要求:"+goods.get(position).getAsk());
        vh.introduce.setText("介绍:"+goods.get(position).getIntroduce());
        return v;
    }
    class ViewHolder {

        ImageView imaLeft, imgRight;
        TextView name, gather, ask, introduce;


    }


}
