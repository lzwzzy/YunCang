package com.yuncang.entity;

import java.util.Date;


/**
 * Created by lzw on 2017/5/11.
 * 商品实体
 */
public class GoodsBill {
    private boolean checked;
    private String goodsId;
    private String goodsName;
    private Double goodsPrice;
    private String goodsStock;
    private Date createTime;
    private String remarks;
    private String profferedId;
    private int goodsType;
    private int state;
    private ProfferBill profferBill;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProfferedId() {
        return profferedId;
    }

    public void setProfferedId(String profferedId) {
        this.profferedId = profferedId;
    }


    public ProfferBill getProfferBill() {
        return profferBill;
    }

    public void setProfferBill(ProfferBill profferBill) {
        this.profferBill = profferBill;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "GoodsBill{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsStock='" + goodsStock + '\'' +
                ", createTime=" + createTime +
                ", remarks='" + remarks + '\'' +
                ", profferedId='" + profferedId + '\'' +
                '}';
    }
}
