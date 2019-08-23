package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.Class1;
import com.zl.book.store.pojo.Class2;
import com.zl.book.store.pojo.Class3;

import java.util.Map;

public interface ClassServiceInterface {
      Map<String,Object> insertClass1(Class1 class1, int statusCode);//获取图书一级分类目录
      Map<String,Object> insertClass2(Class2 class2, int statusCode);//获取图书二级分类目录
      Map<String,Object> insertClass3(Class3 class3, int statusCode);//获取图书三级分类目录
      Map<String,Object> getClass1(int statusCode);//获取图书一级分类目录
      Map<String,Object>  getClass2(int class1Id, int statusCode);//获取图书二级分类目录
      Map<String,Object>  getClass3(int class2Id, int statusCode);//获取图书三级分类目录
}

