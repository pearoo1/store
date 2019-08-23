package com.zl.book.store.controller;

import com.zl.book.store.pojo.User;
import com.zl.book.store.serive.impl.UserServiceInterface;
import com.zl.book.store.typehandler.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;



@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired UserServiceInterface userService;
    private User user;
    // 注册，插入数据
    //10.156.55.156:8080/user/register?phone=13647187955&pwd=123456(OK)
    @PostMapping(value = "/register",params ={"phone","pwd"})
    @ResponseBody
    public Map<String,Object> registerUser( String phone, String pwd, HttpServletResponse response){
        user=new User();
        user.setUserPhone(phone);
        user.setUserPwd(pwd);
        return  userService.registerUser(user,response.getStatus());
    }


    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> loginUser(@RequestBody User user){
        return null;
    }


    //10.156.55.156:8080/user/login?phone=13647187955 & pwd=123456(OK)
    @PostMapping(value="/login",params = {"phone","pwd"})
    @ResponseBody
    public Map<String,Object> loginUser(String phone, String pwd,HttpServletResponse response){
        user=new User();
        user.setUserPhone(phone);
        user.setUserPwd(pwd);
        return  userService.loginUser(user,response.getStatus());
    }

    //按用户id修改用户的姓名，性别，身份证号
    @PostMapping(value = "/change",params = {"uid","name","sex","card"})
    @ResponseBody
    public Map<String,Object> changUserInfo(int uid,String name,String sex ,String card,HttpServletResponse response){
        user=new User();
        user.setUserId(uid);
        user.setUserName(name);
        user.setUserSex(SexEnum.setSexEnumId(sex));
        user.setUserCard(card);
        return userService.changeUserInfo(user,response.getStatus());
    }

    // 按用户Id修改密码
    @PostMapping(value = "/change",params = {"uid","pwd"})
    @ResponseBody
    public Map<String,Object> changUserPwd(int uid, String pwd,HttpServletResponse response){
        user=new User();
        user.setUserId(uid);
        user.setUserPwd(pwd);
        return userService.changePwd(user,response.getStatus());
    }

    //按用户id修改手机号码
    @PostMapping(value = "/change",params = {"uid","phone"})
    @ResponseBody
    public Map<String,Object> changUserPhone( int uid, String phone,HttpServletResponse response){
        user=new User();
        user.setUserId(uid);
        user.setUserPhone(phone);
        return userService.changePhone(user,response.getStatus());
    }

    // 按用户id修改用户性别
    @PostMapping(value = "/change",params = {"uid","sex"})
    @ResponseBody
    public Map<String,Object> changUserSex(int uid,String sex,HttpServletResponse response) {
        user = new User();
        user.setUserId(uid);
        user.setUserSex(SexEnum.setSexEnumId(sex));
        return userService.changeSex(user, response.getStatus());
    }

    // 按用户id修改用户性别
    @PostMapping(value = "/change",params = {"uid","name"})
    @ResponseBody
    public Map<String,Object> changUserName(int uid,String name,HttpServletResponse response) {
        user = new User();
        user.setUserId(uid);
        user.setUserName(name);
        return userService.changeName(user, response.getStatus());
    }
    // 按用户id修改用户身份证
    @PostMapping(value = "/change",params = {"uid","card"})
    @ResponseBody
    public Map<String,Object> changUserCard(int uid,String card,HttpServletResponse response) {
        user = new User();
        user.setUserId(uid);
        user.setUserCard(card);
        return userService.changeCard(user, response.getStatus());
    }

    //按手机修改用户的姓名，性别，身份证号
    @PostMapping(value = "/change",params = {"phone","name","sex","card"})
    @ResponseBody
    public Map<String,Object> changUserInfo(String phone,String name,String sex ,String card,HttpServletResponse response){
        user=new User();
        user.setUserPhone(phone);
        user.setUserName(name);
        user.setUserSex(SexEnum.setSexEnumId(sex));
        user.setUserCard(card);
        return userService.changeUserInfo(user,response.getStatus());
    }

    // 按手机号修改密码
    @PostMapping(value = "/change",params = {"phone","pwd"})
    @ResponseBody
    public Map<String,Object> changUserPwd(String phone,String pwd,HttpServletResponse response){
        user=new User();
        user.setUserPhone(phone);
        user.setUserPwd(pwd);
        return userService.changePwd(user,response.getStatus());
    }

    // 按手机号修改用户名
    @PostMapping(value = "/change",params = {"phone","name"})
    @ResponseBody
    public Map<String,Object> changUserName(String phone,String name,HttpServletResponse response){
        user=new User();
        user.setUserPhone(phone);
        user.setUserName(name);
        return userService.changeName(user,response.getStatus());
    }

    // 按手机号修改用户性别
    @PostMapping(value = "/change",params = {"phone","sex"})
    @ResponseBody
    public Map<String,Object> changUserSex(String phone,String sex,HttpServletResponse response) {
        user = new User();
        user.setUserPhone(phone);
        user.setUserSex(SexEnum.setSexEnumId(sex));
        return userService.changePwd(user, response.getStatus());
    }

    // 按用户id修改用户身份证
    @PostMapping(value = "/change",params = {"phone","card"})
    @ResponseBody
    public Map<String,Object> changUserCard(String phone,String card,HttpServletResponse response) {
        user = new User();
        user.setUserPhone(phone);
        user.setUserCard(card);
        return userService.changeCard(user, response.getStatus());
    }


    // 按手机号获取用户信息
    @PostMapping(value = "/select",params = {"phone"})
    @ResponseBody
    public Map<String,Object> getUserInfo(String phone,HttpServletResponse response){
        user=new User(phone);
        return userService.getUserInfo(user,response.getStatus());
    }

    // 按用户id获取用户信息
    @PostMapping(value = "/select",params = {"uid"})
    @ResponseBody
    public Map<String,Object> getUserInfo(int uid,HttpServletResponse response){
        user=new User(uid);
        return userService.getUserInfo(user,response.getStatus());
    }
}
