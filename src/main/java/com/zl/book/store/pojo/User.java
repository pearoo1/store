package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true,value = {"mybatisLazyInitializer","handler "})
@Alias("user_table")
public class User implements Serializable {
    private int userId;//用户id,唯一标识
    private String userName;//用户
    private String userPwd;//用户密码
    private String userPhone;//手机号码
    private Object userSex;// 性别1=女(female),2=男(male)
    private String userCard;//用户身份证号码


    public User() {
    }
    public User(int userId) {
        this.userId = userId;
    }
    public User(String userPhone ) {
        this.userPhone = userPhone;
    }
    public User(int userId, String userName, String userPwd, String userPhone,
                Object userSex, String userCard) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userSex = userSex;
        this.userCard = userCard;
    }
    public User(String userName, String userPwd, String userPhone,
                Object userSex, String userCard) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userPhone = userPhone;
        this.userSex = userSex;
        this.userCard = userCard;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Object getUserSex() {
        return userSex;
    }

    public void setUserSex(Object userSex) {
        this.userSex = userSex;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }
}
