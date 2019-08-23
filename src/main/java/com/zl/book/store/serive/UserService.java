package com.zl.book.store.serive;

import com.zl.book.store.dao.UserDao;
import com.zl.book.store.pojo.User;
import com.zl.book.store.serive.impl.UserServiceInterface;
import com.zl.book.store.typehandler.SexEnum;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements UserServiceInterface {
    @Autowired UserDao userDao;
    private String result;
    private Object data;

    @Override
    public Map<String, Object> registerUser(User user,int status){
        try {
            Integer count=userDao.selectByPhone(user.getUserPhone());
            if (count==1){
                result="该用户已存在";
            }else {
                count= userDao.insertUser(user);//获取插入数据返回结果
                if (count>=1 && status>=200){
                    result="注册成功";
                }else
                    result="注册失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="连接超时";
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //登录功能
    @Override
    public Map<String, Object> loginUser(User user,int status) {
        Map<String,Object> data=new HashMap<>();
        try {
            Integer userId=userDao.selectByPhoneAndPwd(user.getUserPhone(),user.getUserPwd());
            if (userId!=null && userId>0 && status>=200){
                result="登录成功";
                data.put("userId",userId);
                data.put("userPhone",user.getUserPhone());
            }else {
                userId=userDao.selectByPhone(user.getUserPhone());
                if (userId!=null && userId>0){
                    result="密码错误";
                }else {
                    result="用户不存在";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result="连接超时";
        }
        return ReturnMap.getMap(data,status,DateFormat.getDateFormat(),result);
    }

    //修改用户密码：手机号/用户ID
    @Override
    public Map<String, Object> changePwd(User user,int status) {
       try{
           Integer count= userDao.updateUserInfo(user);
            if (count!=null&count==1){
                result="修改密码成功";
            }else {
                result="修改密码失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="修改密码失败";
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //按用户Id修改手机号码
    @Override
    public Map<String, Object> changePhone(User user,int status) {
        try{
            Integer  count= userDao.selectByPhone(user.getUserPhone());
            if (count==1){
                result="该用户已经被注册";
            }else {
                   count=userDao.updateUserInfo(user);
                if (count==1){
                    result="修改手机号码成功";
                }else {
                    result = "修改手机号码失败";
                }
            }
        }catch (Exception e){
            result="修改手机号码失败";
            e.printStackTrace();
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //修改用化名名：手机号/用户ID
    @Override
    public Map<String, Object> changeName(User user,int status) {
        try{
            Integer count= userDao.updateUserInfo(user);
            if (count==1){
                result="用户名修改成功";
            }else {
                result="用户名修改失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="用户名修改失败";
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //修改用户性别
    @Override
    public Map<String, Object> changeSex(User user,int status) {
        try{
            Integer count= userDao.updateUserInfo(user);
            if (count==1){
                result="性别修改成功";
            }else {
                result="性别修改失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="性别修改失败";
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //修改用户身份证号
    @Override
    public Map<String, Object> changeCard(User user,int status) {
        try{
            Integer  count= userDao.updateUserInfo(user);
            if (count==1){
                result="身份证号修改成功";
            }else {
                result="身份证号改失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="身份证号改失败";
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //整体修改sex、card、name
    @Override
    public Map<String, Object> changeUserInfo(User user,int status) {
        try{
            Integer count= userDao.updateUserInfo(user);
            if (count==1){
                result="用户信息修改成功";
            }else {
                result="用户信息修改失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="用户信息修改失败";
        }
        return ReturnMap.getMap(status,DateFormat.getDateFormat(),result);
    }

    //获取用户信息
    @Override
    public Map<String, Object> getUserInfo(User user, int status) {
        try {
            User u=userDao.selectUser(user);
            Map<String,Object> map=new HashMap();
           if(u!=null){
               map.put("uid",u.getUserId());
               map.put("sex",SexEnum.getSexEnumId((int) u.getUserSex()));
               map.put("name",u.getUserName());
               result="获取用户信息成功";
               data=map;
            }else {
               result="获取用户信息失败";
           }
        }catch (Exception e){
            e.printStackTrace();
            result="获取用户信息失败";
        }
        return ReturnMap.getMap(data,status,DateFormat.getDateFormat(),result);
    }
}
