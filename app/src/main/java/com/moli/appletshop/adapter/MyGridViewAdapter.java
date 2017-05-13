package com.moli.appletshop.adapter;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moli.appletshop.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */

public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> data;// 显示的数据
    private int[] colors = { R.color.item1, R.color.item2, R.color.item3,
            R.color.item4, R.color.item5, R.color.item6, R.color.item7,
            R.color.item8, R.color.item9, R.color.item10, R.color.item11,
            R.color.item12 ,R.color.item13,R.color.item14,R.color.item15,
            R.color.item16,R.color.item17
    };// 颜色色值id数组

    private int[] id = { R.mipmap.all, R.mipmap.gam, R.mipmap.muc,
            R.mipmap.go, R.mipmap.tour, R.mipmap.sport, R.mipmap.life,
            R.mipmap.health, R.mipmap.move, R.mipmap.mum, R.mipmap.tool,
            R.mipmap.image ,R.mipmap.educate,R.mipmap.bank,R.mipmap.shop,
            R.mipmap.read,R.mipmap.office
    };


    public MyGridViewAdapter(Context mContext, List<String> data) {
        super();
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_griview, null);
            holder.tv_item = (TextView) convertView.findViewById(R.id.tv_item);
            holder.lin_item = (LinearLayout) convertView.findViewById(R.id.lin_item);
            holder.img_item = (ImageView) convertView.findViewById(R.id.img_item);
            holder.lin_item.setBackgroundResource(R.drawable.circle);
            holder.img_item.setImageResource(id[position]);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String item = (String) getItem(position);
        holder.tv_item.setText(item);
        // 获取背景颜色，并且改变颜色
        GradientDrawable myGrad = (GradientDrawable) holder.lin_item
                .getBackground();
        myGrad.setColor(mContext.getResources().getColor(getColor(position)));
        return convertView;
    }

    /**
     *
     * @方法名称:getColor
     * @描述: TODO
     * @创建人：yang
     * @创建时间：2014年9月30日 下午3:06:04
     * @备注：获取背景的颜色的色值
     * @param position
     * @return
     * @返回类型：int
     */
    public int getColor(int position) {
        if (position < colors.length) {
            return colors[position];
        } else {
            return colors[position % colors.length];
        }
    }

    class ViewHolder {
        TextView tv_item;
        LinearLayout lin_item;
        ImageView img_item;
    }


}
