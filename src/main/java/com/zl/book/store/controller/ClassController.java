package com.zl.book.store.controller;

import com.zl.book.store.pojo.Class1;
import com.zl.book.store.pojo.Class2;
import com.zl.book.store.pojo.Class3;
import com.zl.book.store.serive.impl.ClassServiceInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/*
* @Controller 用于标记在一个类上，使用它标记的类就是一个SpringMVC Controller 对象。分发处理器将会扫描使用了该注解的类的方法。
* 通俗来说，被Controller标记的类就是一个控制器，这个类中的方法，就是相应的动作。
* */
@Controller
@RequestMapping("/class")
//10.156.55.156:8080/class/
public class ClassController {
    /*
    * @Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作，我们也要清楚，
    * @Autowired是根据类型进行自动装配的。
    * */
    @Autowired ClassServiceInterface classService;
    private String result;
    private Class1 class1;
    private Class2 class2;
    private Class3 class3;
    /**************************插入数据*********************************/
    //查询一级分类目录
    @PostMapping(value = "/insert/class1",params = {"name"})
    @ResponseBody
    public Map<String, Object> insertClass1(String name, HttpServletResponse response) {
        try {
            class1=new Class1();
            class1.setClass1Name(name);
        }catch (Exception e){
            e.printStackTrace();
            result="添加一级目录失败";
            return ReturnMap.getMap(response.getStatus(),DateFormat.getDateFormat(),result);
        }
        return classService.insertClass1(class1,response.getStatus());
    }

    //添加查询二级分类目录
    @PostMapping(value = "/insert/class2",params = {"name","id1"})
    @ResponseBody
    public Map<String, Object> insertClass2( String name,int id1, HttpServletResponse response) {
        try{
            class2=new Class2();
            class2.setClass2Name(name);
            class2.setClass1Id(id1);
        }catch (Exception e){
            e.printStackTrace();
            result="添加二级目录失败";
            return ReturnMap.getMap(response.getStatus(),DateFormat.getDateFormat(),result);
        }
        return classService.insertClass2(class2,response.getStatus());
    }

    //添加查询三级分类目录
    @PostMapping(value = "/insert/class3",params = {"name","id2"})
    @ResponseBody
    public Map<String, Object> insertClass3( String name,int id2, HttpServletResponse response) {
        try{
            class3=new Class3();
            class3.setClass3Name(name);
            class3.setClass2Id(id2);
        }catch (Exception e) {
            e.printStackTrace();
            result="添加三级目录失败";
            return ReturnMap.getMap(response.getStatus(),DateFormat.getDateFormat(),result);
        }
        return classService.insertClass3(class3,response.getStatus());
    }

    //获取一级分类目录
    @GetMapping("/select/class1")
    @ResponseBody
    public Map<String, Object> getClass1(HttpServletResponse response) {
        return classService.getClass1(response.getStatus());
    }

    //获取二级分类目录
    @GetMapping("/select/class1-{id1}")
    @ResponseBody
    public Map<String, Object> getClass2(@PathVariable("id1")int class1Id, HttpServletResponse response) {
        try {
            return classService.getClass2(class1Id,response.getStatus());
        }catch (Exception e){
            e.printStackTrace();
            result="二级分类查询失败";
        }
       return ReturnMap.getMap(response.getStatus(),DateFormat.getDateFormat(),result);
    }

    //获取三级级分类目录
    @GetMapping("/select/class2-{id2}")
    @ResponseBody
    public Map<String, Object> getClass3(@PathVariable("id2")int class2Id, HttpServletResponse response) {
        try {
            return classService.getClass3(class2Id,response.getStatus());
        }catch (Exception e){
            e.printStackTrace();
            result="三级分类查询失败";
        }
        return ReturnMap.getMap(response.getStatus(),DateFormat.getDateFormat(),result);
    }
}
