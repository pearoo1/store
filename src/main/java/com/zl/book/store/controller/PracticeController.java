package com.zl.book.store.controller;

import com.zl.book.store.pojo.*;
import com.zl.book.store.serive.impl.PracticeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@Controller
public class PracticeController {
    @Autowired
    PracticeInterface practiceInterface;
    @RequestMapping("/books")
    @ResponseBody
   public List<PracticeBook> getBooks(@RequestParam("uId")int uId){
        return practiceInterface.getBook(uId);
    }

    @RequestMapping("/user")
    @ResponseBody
    public PracticeUser getUser(@RequestParam("bId")int uId){
        return practiceInterface.getUser(uId);
    }

    @RequestMapping("/book")
    @ResponseBody
    public List<PracticeBook> getClass3Books(@RequestParam("id")int class3Id){
        return practiceInterface.getClass3Book(class3Id);
    }

    @RequestMapping("/class/1.json")
    @ResponseBody
    public List<Class1> getClass1(){
        return practiceInterface.getClass1();
    }
    @RequestMapping("/class/2.json")
    @ResponseBody
    public List<Class2> getClass2(@RequestParam("id")int id){
        return practiceInterface.getClass2(id);
    }

    @RequestMapping("/class/3.json")
    @ResponseBody
    public List<Class3> getClass3(@RequestParam("id")int id){
        return practiceInterface.getClass3(id);
    }
   /* @RequestMapping("/insertUsers")
    @ResponseBody
    public int  getClassBooks(@RequestParam("user")String userName, @RequestParam("pwd")String userPwd,
                              HttpServletResponse response){
        int status=response.getStatus();
        List<PracticeUser> list=new ArrayList<>();
        for (int i=0;i<3;i++){
            PracticeUser user=new PracticeUser();
            user.setUserName(userName+i);
            user.setUserPwd(userPwd);
        }
        if (status==200){
            return practiceInterface.insertUsers(list);
        }
       return status;
    }*/

    @RequestMapping("/bookbyname")
    @ResponseBody
    public List<PracticeBook> getBookByName(@RequestParam("bookName")String bookName){
        return practiceInterface.getBookByName(bookName);
    }

    @RequestMapping("/users")
    @ResponseBody
    public Map getClassBooks(@RequestBody Map map) {
        return  map;
    }
}
