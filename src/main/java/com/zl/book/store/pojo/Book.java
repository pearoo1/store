package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Alias("book")//方便在配置xml映射文件时使用
@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Book implements Serializable {
    private int class3Id;//三级分类id
    private int bookId;//书的唯一id
    private String bookName;//书名
    private Double bookPrice;//书的最低价
    private String bookAuthor;//书的作者
    private String bookPublish;//出版社
    private String bookImage;//图片
    private String bookDate;//图书入库时间
    private List<BookGrade> bookGrades;//书的新旧程度(10:全新 依次递减)
    private List<BookImage> bookImages;//图片集

    public Book() {
    }

    public Book(int bookId) {
        this.bookId = bookId;
    }

    public int getClass3Id() {
        return class3Id;
    }

    public void setClass3Id(int class3Id) {
        this.class3Id = class3Id;
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

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public List<BookGrade> getBookGrades() {
        return bookGrades;
    }

    public void setBookGrades(List<BookGrade> bookGrade) {
        this.bookGrades = bookGrade;
    }

    public List<BookImage> getBookImages() {
        return bookImages;
    }

    public void setBookImages(List<BookImage> bookImages) {
        this.bookImages = bookImages;
    }
}
