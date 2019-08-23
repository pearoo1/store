package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.Order;

import java.util.Map;

public interface SaleServiceInterface {
      //Map<String,Object>  insertOrderToSale(Order order);//插入销售信息使用触发器插入
      Map<String,Object>  getAllSale(int statusCode);// 获取用户订单信息
      Map<String,Object>  getSaleByClass(int classId, int statusCode);// 获取订单详细信息
      Map<String,Object>  getSaleByDate(String date, int statusCode);//修改订单信息
}

