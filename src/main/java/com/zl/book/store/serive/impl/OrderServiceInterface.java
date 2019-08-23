package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.Order;
import java.util.Map;
public interface OrderServiceInterface {
      Map<String,Object>  insertOrder(Order order,int statusCode);// 获取用户订单信息
      Map<String,Object>  getUserOrder(Order order,int statusCode);// 获取用户订单信息
      Map<String,Object>  getOrderId(int userId,int orderId, int statusCode);// 获取用户单个订单详细信息
      Map<String,Object>  updateOrder(Order order ,int statusCode);//修改订单信息
      Map<String,Object>  deleteOrder(int userId,int orderId, int statusCode);//删除订单
      Map<String,Object>  completeOrder(Order order, int statusCode);//删除订单
      Map<String, Object> getUserAllOrder(int userId,int statusCode);//获取用户的全部订单
}

