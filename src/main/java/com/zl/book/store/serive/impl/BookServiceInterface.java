package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.Book;
import com.zl.book.store.pojo.BookImage;

import java.util.List;
import java.util.Map;

public interface BookServiceInterface {
      Map<String,Object> insertBook(Book book,int statusCode);//三级分类图书列表
      Map<String,Object> getBookByClassId(int bookId,int statusCode);//三级分类图书列表
      Map<String,Object> getBookByName(Book params,int statusCode);//按名字进行模糊查询
      Map<String,Object> getBookByPrice(double minPrice,double maxPrice,int statusCode);//按价格区间查找
      Map<String,Object> getBookById(Book book, int statusCode);//三级分类图书列表
      Map<String,Object> updateBookInfo(Book book,int statusCode);//修改图书信息
      Map<String,Object> getAllBooks(int statusCode);//修改图书信息
      String insertImages(List<BookImage> images);
}

