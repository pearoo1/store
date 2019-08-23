package com.zl.book.store.dao;

import com.zl.book.store.pojo.Order;
import com.zl.book.store.provider.OrderSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface OrderDao {

    @InsertProvider(type = OrderSqlProvider.class,method = "insertIntoOder")
    int insertBookToOrder(@Param("order") Order order);//插入购车书信息

    // 获取用户订单信息列表：传啥状态得啥数据
    //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
    @Results(value = {
            @Result(id = true,property = "orderId",column = "order_id"),
            @Result(property = "userId",column = "ouser_id"),
            @Result(property ="bookId",column = "obook_id"),
            @Result(property ="addressId",column = "address_id"),
            @Result(property ="bookName",column = "obook_name"),
            @Result(property = "bookAmount",column = "obook_amount"),
            @Result(property = "bookPrice",column = "obook_price"),
            @Result(property = "bookGrade",column = "obook_grade"),
            @Result(property = "bookImage",column = "obook_image"),
            @Result(property = "orderDate",column = "order_date"),
            @Result(property = "orderDate2",column = "order_date2"),
            @Result(property = "total",column = "total"),
            @Result(property = "orderStatus",column = "order_status")
    })
    @Select("select * ,obook_price*obook_amount total from book_db.order_table where ouser_id=#{order.userId} " +
            "and order_status=#{order.orderStatus} order by order_id desc")
    List<Order> getUserOrder(@Param("order") Order order );

    @Results(value = {
            @Result(id = true,property = "orderId",column = "order_id"),
            @Result(property = "userId",column = "ouser_id"),
            @Result(property ="bookId",column = "obook_id"),
            @Result(property ="addressId",column = "address_id"),
            @Result(property ="bookName",column = "obook_name"),
            @Result(property = "bookAmount",column = "obook_amount"),
            @Result(property = "bookPrice",column = "obook_price"),
            @Result(property = "bookGrade",column = "obook_grade"),
            @Result(property = "bookImage",column = "obook_image"),
            @Result(property = "orderDate",column = "order_date"),
            @Result(property = "orderDate2",column = "order_date2"),
            @Result(property = "total",column = "total"),
            @Result(property = "orderStatus",column = "order_status")
    })
    @Select("select * ,obook_price*obook_amount total from book_db.order_table where ouser_id=#{userId} order by order_id desc")
    List<Order> getUserAllOrder(@Param("userId") int userId );

    @Results(value = {
            @Result(id = true,property = "orderId",column = "order_id"),
            @Result(property = "userId",column = "ouser_id"),
            @Result(property ="bookId",column = "obook_id"),
            @Result(property ="addressId",column = "address_id",
            one = @One(select ="OrderDao.getAddressById")),
            @Result(property ="bookName",column = "obook_name"),
            @Result(property = "bookAmount",column = "obook_amount"),
            @Result(property = "bookPrice",column = "obook_price"),
            @Result(property = "bookGrade",column = "obook_grade"),
            @Result(property = "bookImage",column = "obook_image"),
            @Result(property = "orderDate",column = "order_date"),
            @Result(property = "orderDate2",column = "order_date2"),
            @Result(property = "orderStatus",column = "order_status")
    })
    // 获取用户单个订单信息
    @Select("select * from book_db.order_table where ouser_id=#{userId} and order_id=#{orderId}")
    Order getUserOrderById(@Param("userId") int userId,@Param("orderId") int orderId);

    //修改用户的订单的状态
    @UpdateProvider(type = OrderSqlProvider.class,method = "updateOrder")
    int  updateOrder(@Param("order")Order order);//修改订单信息

    //删除订单
    @Delete("delete from book_db.order_table where order_id=#{orderId} and user_id=#{userId}")
    int  deleteOrder(@Param("orderId")int orderId,@Param("userId")int userId);
}
