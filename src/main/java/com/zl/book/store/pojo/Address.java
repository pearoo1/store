package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;


@Alias("address")
@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
public class Address implements Serializable {
    private int addressId;
    private int userId;
    private String addressPath;
    private String consigneeName;
    private String consigneePhone;

    public Address() {
    }

    public Address(int addressId, int userId, String addressPath, String consigneeName, String consigneePhone) {
        this.addressId = addressId;
        this.userId = userId;
        this.addressPath = addressPath;
        this.consigneeName = consigneeName;
        this.consigneePhone = consigneePhone;
    }
}
