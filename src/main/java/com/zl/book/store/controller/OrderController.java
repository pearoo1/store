package com.zl.book.store.controller;

import com.zl.book.store.pojo.Order;
import com.zl.book.store.serive.impl.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/order")
//10.156.55.156/order/insert
//10.156.55.156/order/select
//10.156.55.156/order/update
//10.156.55.156/order/delete
public class OrderController {
@Autowired OrderServiceInterface orderService;
 /*
    private int  userId;
    private int  orderId;         //订单号
    private int  bookId;          //书本号
    private String bookName;      //书名
    private String orderDate;      //创建日期
    private String orderDate2;     //完成日期
    private Double orderPrice;     //单价
    private int bookAmount;        //购买数量
    private int orderStatus;       //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
    private int bookGrade;       //书的新旧度
    private String bookImage;
    */

    //不经过购物车直接购买
    //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
    @PostMapping(value = ("/insert"),params = {"uid","aid","bid","name","price","amount","grade","type","image"})
    @ResponseBody
    public Map<String, Object> insertBookToOrder(int uid,int aid,int bid,String name, Double price,
                                                int amount,int grade ,int type, String image, HttpServletResponse response) {
        return orderService.insertOrder( new Order(uid,aid,bid,name,price,amount,grade,type,image),response.getStatus());
    }

    //获取用户的各个状态下的订单列表
    //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
    @PostMapping(value ="/select",params = {"uid","type"})
    @ResponseBody
    public Map<String, Object> getUserOrder(int uid,int type,HttpServletResponse response) {
        return  orderService.getUserOrder(new Order(uid,type),response.getStatus());
    }
    @PostMapping(value ="/select",params = {"uid"})
    @ResponseBody
    public Map<String, Object> getUserOrder(int uid,HttpServletResponse response) {
        return  orderService.getUserAllOrder(uid,response.getStatus());
    }

    //获取用户单个订单信息
    @PostMapping(value = "/select",params = {"uid","oid"})
    @ResponseBody
    public Map<String, Object> getOrderById(int uid,int oid, HttpServletResponse response) {
        return orderService.getOrderId(uid,oid,response.getStatus());
    }

    //修改订单状态
    @PostMapping(value = "/update",params = {"uid","oid","type"})
    @ResponseBody
    public Map<String, Object> updateOrder(int uid,int oid,int type, HttpServletResponse response) {
        if (type==5){
            return orderService.completeOrder(new Order(uid,oid,type),response.getStatus());//确认收货
        }else return orderService.updateOrder(new Order(uid,oid,type),response.getStatus());//更改状态
    }

    /*
    * 删除用户订单
    * @param userId  //用户Id
    * @param orderId  //订单号
    * */
    @PostMapping(value = "/delete",params = {"uid","oid"})
    @ResponseBody
    public Map<String, Object> deleteOrder(int userId,int orderId,HttpServletResponse response) {
        return null;
    }
}
