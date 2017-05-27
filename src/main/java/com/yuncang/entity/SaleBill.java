package com.yuncang.entity;

import java.util.Date;

/**
 * Created by lzw on 2017/5/11.
 * 销售实体
 */
public class SaleBill {
    private String saleId;
    private String goodsId;
    private Long saleCount;
    private Date saleTime;
    private String remarks;
    private GoodsBill goodsBill;


    public GoodsBill getGoodsBill() {
        return goodsBill;
    }

    public void setGoodsBill(GoodsBill goodsBill) {
        this.goodsBill = goodsBill;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    @Override
    public String toString() {
        return "SaleBill{" +
                "saleId='" + saleId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", saleCount=" + saleCount +
                ", saleTime=" + saleTime +
                ", remarks='" + remarks + '\'' +
                ", goodsBill=" + goodsBill +
                '}';
    }
}
