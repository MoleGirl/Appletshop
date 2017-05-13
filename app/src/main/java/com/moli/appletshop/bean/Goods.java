package com.moli.appletshop.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/4/26.
 */

public class Goods extends BmobObject {

    private String name;//名字
    private String gather;//作者
    private String logoUrl;//logo地址
    private String code;//二维码地址
    private String introduce;//介绍
    private String ask;//要求
    private String category;//类别

    public Goods() {
    }

    public Goods(String name, String logoUrl, String code, String introduce, String ask,String gather,String category ) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.code = code;
        this.introduce = introduce;
        this.ask = ask;
        this.gather = gather;
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGather() {
        return gather;
    }

    public void setGather(String gather) {
        this.gather = gather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }
}
