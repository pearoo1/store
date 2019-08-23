package com.zl.book.store.controller;

import com.zl.book.store.pojo.Book;
import com.zl.book.store.pojo.Cart;
import com.zl.book.store.serive.impl.BookServiceInterface;
import com.zl.book.store.serive.impl.CartServiceInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired CartServiceInterface cartService;
    @Autowired BookServiceInterface bookService;
    private Cart cart;
    private String result;

    //添加到购物车
    @PostMapping(value = "/insert",params = {"uid","bid","name","price","amount","grade","image"})
    @ResponseBody
    public Map<String, Object> insertBookToCart(int uid,int bid,String name,Double price,int amount
            ,int grade,String image, HttpServletResponse response) {
        try {
            cart=new Cart(uid, bid,name,price,amount,grade,image);
        }catch (Exception e){
            e.printStackTrace();
            result="添加到购物车失败";
        }
        return cartService.insertBookToCart(cart,response.getStatus());
    }

    //获取用户购物车中的所有书本信息
    @PostMapping(value = "/select",params = {"uid"})
    @ResponseBody
    public Map<String, Object> getByCartByUserId(int uid, HttpServletResponse response ) {
        return cartService.getByCartByUserId(uid,response.getStatus());
    }

    //购物车点击跳转到详情图书详情页面
    @PostMapping(value = "/select",params = {"bid"})
    @ResponseBody
    public Map<String, Object> getByCartByBookId(int bid, HttpServletResponse response ) {
        Book book=new Book(bid);
        return bookService.getBookById(book,response.getStatus());
    }

    //修改购物车中的图书信息
    @PostMapping(value = "/update",params = {"uid","bid","name","price","amount","grade","image"})
    @ResponseBody
    public Map<String, Object> updateCartBook(int uid,int bid,String name,Double price,int amount
            ,int grade,String image, HttpServletResponse response) {
        try {
            cart=new Cart(uid, bid,name,price,amount,grade,image);
        }catch (Exception e){
            e.printStackTrace();
            result="修改购物车失败";
            return ReturnMap.getMap(response.getStatus(), DateFormat.getDateFormat(),result);
        }
        return cartService.updateCartBook(cart,response.getStatus());
    }

    //删除购物车的图书
    @PostMapping(value = "/delete",params = {"uid","cid"})
    @ResponseBody
    public Map<String, Object> deleteCartBook(int uid,int cid, HttpServletResponse response) {
        cart=new Cart(uid,cid);
        return cartService.deleteCartBook(cart,response.getStatus());
    }

    //提交购物车的图书订单
    @PostMapping(value = "/submit",params = {"uid","cid","aid"})
    @ResponseBody
    public Map<String, Object> submitOrder(int uid,int cid, int aid,HttpServletResponse response) {
        cart=new Cart(uid,cid);
        return cartService.completeOrderBook(cart,aid,response.getStatus());
    }
}
