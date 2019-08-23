package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Class3 implements Serializable {
    private int class3Id;
    private String class3Name;
    private String class3Image;
    private int class2Id;
    private List<Book> books;

    public int getClass3Id() {
        return class3Id;
    }

    public void setClass3Id(int class3Id) {
        this.class3Id = class3Id;
    }

    public String getClass3Name() {
        return class3Name;
    }

    public void setClass3Name(String class3Name) {
        this.class3Name = class3Name;
    }

    public String getClass3Image() {
        return class3Image;
    }

    public void setClass3Image(String class3Image) {
        this.class3Image = class3Image;
    }

    public int getClass2Id() {
        return class2Id;
    }

    public void setClass2Id(int class2Id) {
        this.class2Id = class2Id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Class3() {
    }


}
