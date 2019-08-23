package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.Address;

import java.util.Map;

public interface AddressServiceInterface {
      Map<String,Object> insertUserAddress(Address address);//创建新地址
      Map<String,Object> getUserAddress(int userId, int statusCode);//获取用户全部地址信息
      Map<String,Object> updateAddress(Address address, int statusCode);//修改收货人手机号/姓名地址
      Map<String,Object> deleteAddress(Address address, int statusCode);//删除地址
}

