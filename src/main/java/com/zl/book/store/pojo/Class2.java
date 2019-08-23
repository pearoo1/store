package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Class2 implements Serializable {
    private int class2Id;      //二级目录id
    private String class2Name; //二级目录名称
    private int class1Id;      //一级目录id
    private List<Class3> class3s;//三级列表

    public Class2() {
    }

    public int getClass2Id() {
        return class2Id;
    }

    public void setClass2Id(int class2Id) {
        this.class2Id = class2Id;
    }

    public String getClass2Name() {
        return class2Name;
    }

    public void setClass2Name(String class2Name) {
        this.class2Name = class2Name;
    }

    public int getClass1Id() {
        return class1Id;
    }

    public void setClass1Id(int class1Id) {
        this.class1Id = class1Id;
    }

    public List<Class3> getClass3s() {
        return class3s;
    }

    public void setClass3s(List<Class3> class3s) {
        this.class3s = class3s;
    }

}