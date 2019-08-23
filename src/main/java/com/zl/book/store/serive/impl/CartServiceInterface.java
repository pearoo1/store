package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.Cart;

import java.util.Map;

public interface CartServiceInterface {
    Map<String,Object> insertBookToCart(Cart cart,int statusCode);//插入购车书信息
    Map<String,Object>  getByCartByUserId(int userId, int statusCode);// 获取购物车书的信息
    Map<String,Object>  updateCartBook(Cart cart, int statusCode);//修改购车书的数量
    Map<String,Object>  deleteCartBook(Cart cart, int statusCode);//修改购物车新旧度
    Map<String,Object>  completeOrderBook(Cart cart,int address, int statusCode);//修改购物车新旧度
}
