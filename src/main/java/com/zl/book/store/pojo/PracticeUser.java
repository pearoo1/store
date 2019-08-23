package com.zl.book.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = {"mybatisLazyInitializer","handler"},ignoreUnknown = true)
public class PracticeUser implements Serializable {
    private int userId;//用户id,唯一标识
    private String userName;//用户
    private String userPwd;//用户密码
    private List<PracticeBook> practiceBooks ;

    public List<PracticeBook> getList() {
        return practiceBooks;
    }

    public void setList(List<PracticeBook> practiceBooks) {
        this.practiceBooks = practiceBooks;
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
}
