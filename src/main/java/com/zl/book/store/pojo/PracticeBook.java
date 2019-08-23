package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("practiceBook")
@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "} )
public class PracticeBook {
    private int bId;//书的唯一id
    private String bName;//书名
    private int bGrade;//书的新旧程度(10:全新 依次递减)
    private int uId;//用户id,唯一标识
    private int Class3Id;
    private List<BookImage> images;

    public int getClass3Id() {
        return Class3Id;
    }

    public void setClass3Id(int class3id) {
        Class3Id = Class3Id;
    }

    public int getBId() {
        return bId;
    }

    public void setBId(int bId) {
        this.bId = bId;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public int getBGrade() {
        return bGrade;
    }

    public void setBGrade(int bGrade) {
        this.bGrade = bGrade;
    }

    public int getUId() {
        return uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }
    public List<BookImage> getImages() {
        return images;
    }

    public void setImages(List<BookImage> images) {
        this.images = images;
    }
}
