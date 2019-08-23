package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zl.book.store.util.DateFormat;

@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Sale {
    private int userId;          //销售号
    private int saleId;          //销售号
    private int  orderId;        //订单号
    private int  bookId;         //书本号
    private String saleBookName; //书名
    private String saleClassName;//类名
    private String saleDate2;      //日期
    private Double salePrice;     //单价
    private int saleAmount;           //销售数量
    private Double saleTotal;     //销售总价

    public Sale(int userId,int orderId, int bookId, String saleBookName, Double salePrice, int saleAmount,String saleDate2) {
        this.userId = userId;
        this.orderId = orderId;
        this.bookId = bookId;
        this.saleBookName = saleBookName;
        this.saleDate2 = saleDate2;
        this.salePrice = salePrice;
        this.saleAmount = saleAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getSaleBookName() {
        return saleBookName;
    }

    public void setSaleBookName(String saleBookName) {
        this.saleBookName = saleBookName;
    }

    public String getSaleClassName() {
        return saleClassName;
    }

    public void setSaleClassName(String saleClassName) {
        this.saleClassName = saleClassName;
    }

    public String getSaleDate() {
        return saleDate2;
    }

    public void setSaleDate(String saleDate2) {
        this.saleDate2 = saleDate2;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(Double saleTotal) {
        this.saleTotal = saleTotal;
    }
}
