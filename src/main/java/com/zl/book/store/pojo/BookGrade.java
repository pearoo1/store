package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("grade")
@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class BookGrade implements Serializable {
    private int gradeId;
    private int gradeNumber;
    private int gradeAmount;
    private double gradePrice;
    private int BookId;

    public BookGrade() {
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public int getGradeAmount() {
        return gradeAmount;
    }

    public void setGradeAmount(int gradeAmount) {
        this.gradeAmount = gradeAmount;
    }

    public double getGradePrice() {
        return gradePrice;
    }

    public void setGradePrice(double gradePrice) {
        this.gradePrice = gradePrice;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int gBookId) {
        this.BookId = BookId;
    }
}
