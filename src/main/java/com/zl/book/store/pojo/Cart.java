package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

@Alias("cart")
@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Cart implements Serializable {
    private int userId;//用户Id
    private int cartBookId;//图书在购物车表的id
    private int bookId;//图书id
    private String bookName;//图书名
    private int bookAmount;//加入购物车中书的数量
    private double bookPrice;//加入购物车书的价格
    private int bookGrade;//书的新旧程度
    private String bookImage;//图片,只做显示
    //private List<Book> cartBooks;//购物车中的图书集合

    //添加书到购物车
    public Cart(int userId, int bookId, String bookName,
                double bookPrice, int bookAmount, int bookGrade,String bookImage) {
        this.userId = userId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAmount = bookAmount;
        this.bookPrice = bookPrice;
        this.bookGrade = bookGrade;
        this.bookImage = bookImage;
    }

    //获取购物车所有图书信息
    public Cart(int userId, int cartBookId, int bookId, String bookName,
                int bookAmount, double bookPrice, int bookGrade) {
        this.userId = userId;
        this.cartBookId = cartBookId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAmount = bookAmount;
        this.bookPrice = bookPrice;
        this.bookGrade = bookGrade;
    }

    public Cart() {
    }

    public Cart(int userId, int cartBookId) {
        this.userId = userId;
        this.cartBookId = cartBookId;
    }

    public int getCartBookId() {
        return cartBookId;
    }

    public void setCartBookId(int cartBookId) {
        this.cartBookId = cartBookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
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
}
