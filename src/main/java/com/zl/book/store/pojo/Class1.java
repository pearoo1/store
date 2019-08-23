package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
@Alias("class1")
public class Class1 {
    private int class1Id;
    private String class1Name;
    private List<Class2> class2s;
    public Class1() {
    }

    public int getClass1Id() {
        return class1Id;
    }

    public void setClass1Id(int class1Id) {
        this.class1Id = class1Id;
    }

    public String getClass1Name() {
        return class1Name;
    }

    public void setClass1Name(String class1Name) {
        this.class1Name = class1Name;
    }

    public List<Class2> getClass2s() {
        return class2s;
    }

    public void setClass2s(List<Class2> class2s) {
        this.class2s = class2s;
    }
}
