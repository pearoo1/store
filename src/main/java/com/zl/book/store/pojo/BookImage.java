package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value={"mybatisLazyInitializer","handler"})
public class BookImage implements Serializable {
    private int imageId;
    private String imagePath;
    private int iBookId;

    public BookImage() {
    }

    public BookImage(String imagePath, int iBookId) {
        this.imagePath = imagePath;
        this.iBookId = iBookId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getIBookId() {
        return iBookId;
    }

    public void setIBookId(int iBookId) {
        this.iBookId = iBookId;
    }

}
