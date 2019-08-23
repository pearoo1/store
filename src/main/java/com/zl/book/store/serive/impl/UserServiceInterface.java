package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.User;

import java.sql.SQLClientInfoException;
import java.util.Map;

public interface UserServiceInterface {
    Map<String,Object> registerUser(User user,int Status);
    Map<String,Object> loginUser(User user,int Status);
    Map<String,Object> changePwd(User user,int Status);
    Map<String,Object> changePhone(User user,int Status);
    Map<String,Object> changeName(User user,int Status);
    Map<String,Object> changeSex(User user,int Status);
    Map<String,Object> changeCard(User user,int Status);
    Map<String,Object> changeUserInfo(User user,int Status);
    Map<String,Object> getUserInfo(User user,int Status);
}
