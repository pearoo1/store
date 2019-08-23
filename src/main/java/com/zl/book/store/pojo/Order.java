package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zl.book.store.util.DateFormat;

@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Order {
    private int  orderId;         //订单号
    private int  userId;
    private int addressId;        //地址Id
    private int  bookId;          //书本号
    private String bookName;      //书名
    private String orderDate;      //创建日期
    private String orderDate2;      //完成日期
    private Double bookPrice;     //单价
    private int bookAmount;        //购买数量
    private int orderStatus;       //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
    private int bookGrade;   //书的新旧度
    private String bookImage;
    private Double total;

    public Order() {

    }

    public Order(int userId) {
        this.userId = userId;
    }

    public Order(int userId, int orderStatus) {
        this.userId = userId;
        this.orderStatus = orderStatus;
    }

    public Order(int userId, int orderId, int orderStatus) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public Order(int userId,int addressId, int bookId, String bookName, Double bookPrice, int bookAmount,
                 int bookGrade, int orderStatus, String bookImage) {
        this.userId = userId;
        this.addressId = addressId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAmount = bookAmount;
        this.bookGrade = bookGrade;
        this.orderStatus = orderStatus;
        this.orderDate= DateFormat.getDateFormat();
        this.bookImage = bookImage;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate2() {
        return orderDate2;
    }

    public void setOrderDate2(String orderDate2) {
        this.orderDate2 = orderDate2;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getBookGrade() {
        return bookGrade;
    }

    public void setBookGrade(int bookGrade) {
        this.bookGrade = bookGrade;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /*
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/
}
