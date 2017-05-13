package com.moli.appletshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.sackcentury.shinebuttonlib.ShineButton;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    ShineButton shineButton;
    ShineButton porterShapeImageView1;
    ShineButton porterShapeImageView2;
    ShineButton porterShapeImageView3;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shineButton = (ShineButton) findViewById(R.id.po_image0);
        porterShapeImageView1 = (ShineButton) findViewById(R.id.po_image1);
        porterShapeImageView2 = (ShineButton) findViewById(R.id.po_image2);
        porterShapeImageView3 = (ShineButton) findViewById(R.id.po_image3);
        linearLayout = (LinearLayout) findViewById(R.id.wrapper);
        if (shineButton != null)
            shineButton.init(this);
        if (porterShapeImageView1 != null)
            porterShapeImageView1.init(this);
        if (porterShapeImageView2 != null)
            porterShapeImageView2.init(this);
        if (porterShapeImageView3 != null)
            porterShapeImageView3.init(this);
        porterShapeImageView3.setShineTurnAngle(1);
        //监听事件
        shineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "click1");
            }
        });
        shineButton.setOnCheckStateChangeListener(new ShineButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View view, boolean checked) {
                Log.e(TAG, "click2 " + checked);
            }
        });

        porterShapeImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "click3");
            }
        });
        porterShapeImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "click4");
            }
        });
    }
}
