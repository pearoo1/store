package com.zl.book.store.controller;

import com.zl.book.store.pojo.Book;
import com.zl.book.store.pojo.BookImage;
import com.zl.book.store.pojo.Order;
import com.zl.book.store.serive.impl.BookServiceInterface;
import com.zl.book.store.serive.impl.OrderServiceInterface;
import com.zl.book.store.serive.impl.PracticeInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Controller
@RequestMapping("/book")
//10.156.55.156:8080/book/insert
//10.156.55.156:8080/book/select?id3=//按三级分类id获取所有书籍
//10.156.55.156:8080book/select?name=//按名字模糊查询
//10.156.55.156:8080//book/select?price1=&price2=//价格区间
//10.156.55.156:8080/book/update
//10.156.55.156:8080/book/delete
public class BookController {
    @Autowired BookServiceInterface bookService;
    private Book book;
    private String result;
    //三级分类图书列表

    @PostMapping(value = "/insert",params = {"id3","name","price"})
    @ResponseBody
    Map<String,Object> insertBook(int id3,String name,Double price, HttpServletResponse response){
        Map<String,Object> map=null;
        try {
          book=new Book();
          book.setBookDate(DateFormat.getDateFormat());
          book.setBookName(name);
          book.setBookPrice(price);
          book.setClass3Id(id3);
          map= bookService.insertBook(book,response.getStatus());
        }catch (Exception e){
            e.printStackTrace();
            result="图书添加失败";
            ReturnMap.getMap(response.getStatus(),DateFormat.getDateFormat(),result);
        }
        return map;
    }

    @PostMapping(value = "/select",params = {"id3"})
    @ResponseBody
    //三级分类图书列表
    Map<String,Object> getBookByClassId( int id3, HttpServletResponse response){
        return  bookService.getBookByClassId(id3,response.getStatus());
    }

    @PostMapping(value = "/select" ,params = {"name"})
    @ResponseBody
     //按名字进行模糊查询
    Map<String,Object> getBookByName( String name, HttpServletResponse response){
        book=new Book();
        book.setBookName(name);
        return bookService.getBookByName(book,response.getStatus());
    }

    @PostMapping(value = "/select",params = {"price1","price2"})
    @ResponseBody
    //按价格区间查找
    Map<String,Object> getBookByPrice(double price1, double price2, HttpServletResponse response){
        return bookService.getBookByPrice(price1,price2,response.getStatus());
    }

    //按book的id查询图书详情(加入购物页面)
    @PostMapping(value = "/select",params = {"bid"})
    @ResponseBody
    Map<String,Object> getBookByBookId(int  bid, HttpServletResponse response){
      book=new Book();
      book.setBookId(bid);
      return bookService.getBookById(book,response.getStatus());
    }


    @GetMapping(value = "/books")
    @ResponseBody
    Map<String,Object> getAllBooks(HttpServletResponse response){
        return bookService.getAllBooks(response.getStatus());
    }

    //单文件上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> upLoad(@RequestParam("name") String name, @RequestParam("images") MultipartFile images, HttpServletResponse response/*,HttpServletRequest request*/){
        if (!images.isEmpty()){
            String fileName=DateFormat.getDate();//获取当前时间为文件名
            //String imageName=images.getOriginalFilename();//获取上传文件的文件名,包含扩展名
            //String path="F:/JavaProject/store/src/main/resources/static/images";//文件存放的绝对路径
            //File file1=new File(path,fileName+".jpg");//路径和文件名
            File file2=new File(fileName+".jpg");//图片保存为jpg格式
            try {
                /*方法一：使用流*/
               /* byte[] bytes=images.getBytes();
                BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(file1));
                outputStream.write(bytes);//写入文件
                outputStream.close();//关闭输出流
                System.out.println(file);*/

                /*方法二：配置文件*/
                //前提是在application.properties文件中配置了文件保存的路径
                //#默认上传文件存储位置
                //spring.servlet.multipart.location=F:/JavaProject/store/src/main/resources/static/images
                images.transferTo(file2);//将上传文件保存到目录文件

            }catch (Exception e){
                e.printStackTrace();
                return ReturnMap.getMap(response.getStatus(),DateFormat.getDate(),"上传失败!");
            }
            return ReturnMap.getMap(response.getStatus(),DateFormat.getDate(),"上传成功!");
        }
        return ReturnMap.getMap(response.getStatus(),DateFormat.getDate(),"文件不存在!");
    }

    //多文件上传
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> upLoads(@RequestParam("images") MultipartFile[] images, HttpServletResponse response){
        if (images.length>0){
            try {
                for (int i=0;i<images.length;i++){
                    File file2=new File(images[i].getOriginalFilename());//图片保存为jpg格式
                    images[i].transferTo(file2);//将上传文件保存到目录文件
                }
            }catch (Exception e){
                e.printStackTrace();
                //e.getMessage();
                return ReturnMap.getMap(response.getStatus(),DateFormat.getDate(),"上传失败!");
            }
            return ReturnMap.getMap(response.getStatus(),DateFormat.getDate(),"上传成功!");
        }
        return ReturnMap.getMap(response.getStatus(),DateFormat.getDate(),"文件不存在!");

    }

    @PostMapping("/update")
    @ResponseBody
    //修改图书信息
    Map<String,Object> updateBookInfo(@RequestBody Book book, HttpServletResponse response){
        return null;
    }

    @PostMapping("/delete")
    @ResponseBody
        //修改图书信息
    Map<String,Object> deleteBookInfo(@RequestParam("id") int  bookId, HttpServletResponse response){
        return null;
    }



    @GetMapping("/image")
    @ResponseBody
    String insertImages(){
        List<BookImage> list=new ArrayList<>();
        final String herd="192.168.3.32:8080/images/";
        for (int i=0;i<5;i++){
            list.add(new BookImage(herd+"git.jpg",1));
        }
        return bookService.insertImages(list);
    }

}
