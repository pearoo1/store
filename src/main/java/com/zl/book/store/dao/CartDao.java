package com.zl.book.store.dao;

import com.zl.book.store.pojo.Cart;
import com.zl.book.store.provider.CartSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CartDao {

    //加入图书到购物车中
    @InsertProvider(type = CartSqlProvider.class,method = "insertCartBookInfo")
    int insertCartBookInfo(@Param("cart") Cart cart);

    /*
     * 按userId查找该用户所以的购物车商品
     * */
    @Results(value = {
            @Result(id = true,property = "cartBookId" ,column = "cart_id"),
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "bookId",column = "book_id"),
            @Result(property = "bookName",column = "book_name"),
            @Result(property = "bookAmount",column = "book_amount"),
            @Result(property = "bookPrice",column = "book_price"),
            @Result(property = "bookGrade",column = "book_grade"),
            @Result(property = "bookImage",column = "book_image")
    })
    @Select("select * from book_db.cart_table where user_id=#{userId}")
    List<Cart> getCartByUserId(@Param("userId")int userId);

    //加入购物车之前先判断是否已经存在该商品，存在修改调用updateCartBookInfo()方法，不存在调用插入方法。
    @Results(value = {
            @Result(id = true,property = "cartBookId" ,column = "cart_id"),
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "bookId",column = "book_id"),
            @Result(property = "bookName",column = "book_name"),
            @Result(property = "bookAmount",column = "book_amount"),
            @Result(property = "bookPrice",column = "book_price"),
            @Result(property = "bookGrade",column = "book_grade"),
            @Result(property = "bookImage",column = "book_image")
    })
    @Select("select cart_id from book_db.cart_table where " +
            "user_id=#{cart.userId} and book_grade=#{cart.bookGrade } and book_id=#{cart.bookId}")
    Integer selectCartBook(@Param("cart") Cart cart);

    @Results(value = {
            @Result(id = true,property = "cartBookId" ,column = "cart_id"),
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "bookId",column = "book_id"),
            @Result(property = "bookName",column = "book_name"),
            @Result(property = "bookAmount",column = "book_amount"),
            @Result(property = "bookPrice",column = "book_price"),
            @Result(property = "bookGrade",column = "book_grade"),
            @Result(property = "bookImage",column = "book_image")
    })
    @Select("select * from book_db.cart_table where user_id=#{cart.userId} and cart_id=#{cart.cartBookId}")
    Cart selectBookToOrder(@Param("cart") Cart cart);

    //修改购物车中单个商品的信息
    @UpdateProvider(type = CartSqlProvider.class,method = "updateCartBookInfo")
    int updateCartBookInfo(@Param("cart")Cart cart);

    //确定够买付款，删除购物车信息，插入数据到订单表
    //删除购物车物品
    @Delete("delete from book_db.cart_table where cart_id=#{cart.cartBookId} and user_id=#{cart.userId}")
    int deleteCartBook(@Param("cart")Cart cart);

}
