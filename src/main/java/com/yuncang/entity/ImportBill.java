package com.yuncang.entity;

import java.util.Date;


/**
 * Created by lzw on 2017/5/11.
 * 进货实体
 */
public class ImportBill {
    private String importId;
    private String goodsId;
    private String profferedId;
    private Double importPrice;
    private Long importCount;
    private Date importTime;
    private String remarks;
    private GoodsBill goodsBill;
    private ProfferBill profferBill;

    public GoodsBill getGoodsBill() {
        return goodsBill;
    }

    public void setGoodsBill(GoodsBill goodsBill) {
        this.goodsBill = goodsBill;
    }

    public ProfferBill getProfferBill() {
        return profferBill;
    }

    public void setProfferBill(ProfferBill profferBill) {
        this.profferBill = profferBill;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getProfferedId() {
        return profferedId;
    }

    public void setProfferedId(String profferedId) {
        this.profferedId = profferedId;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public Long getImportCount() {
        return importCount;
    }

    public void setImportCount(Long importCount) {
        this.importCount = importCount;
    }

    public Date getImportTime() {
        return importTime;
    }

    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ImportBill{" +
                "importId='" + importId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", profferedId='" + profferedId + '\'' +
                ", importPrice=" + importPrice +
                ", importCount=" + importCount +
                ", importTime=" + importTime +
                ", remarks='" + remarks + '\'' +
                ", goodsBill=" + goodsBill +
                ", profferBill=" + profferBill +
                '}';
    }
}
