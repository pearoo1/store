package com.zl.book.store.provider;

import com.zl.book.store.pojo.Order;
import org.apache.ibatis.jdbc.SQL;

import static com.zl.book.store.util.Constants.ORDER_TABLE;

public class OrderSqlProvider {
    public String insertIntoOder(Order order){
        return new SQL(){{
            INSERT_INTO(ORDER_TABLE);
            if (order.getUserId()>0){
                VALUES("ouser_id","#{order.userId}");
                if (order.getBookName()!=null){
                    VALUES("obook_id","#{order.bookId}");
                }
                if (order.getBookName()!=null){
                    VALUES("obook_name","#{order.bookName}");
                }
                if (order.getOrderDate()!=null){
                    VALUES("order_date","#{order.orderDate}");
                }
                if (order.getBookName()!=null){
                    VALUES("obook_grade","#{order.bookGrade}");
                }
                if (order.getBookPrice()!=null){
                    VALUES("obook_price","#{order.bookPrice}");
                }
                if (order.getOrderStatus()>0){
                    VALUES("order_status","#{order.orderStatus}");
                }
                if (order.getBookAmount()>0){
                    VALUES("obook_amount","#{order.bookAmount}");
                }
                if (order.getBookImage()!=null){
                    VALUES("obook_image","#{order.bookImage}");
                }
                if (order.getAddressId()>0){
                    VALUES("address_id","#{order.addressId}");
                }
            }

        }}.toString();
    }

    public String updateOrder(Order order){
        //@Update("update book_db.order_table set order_status=#{order.OrderStatus} where " +
        //            "order_id=#{order.orderId} and ouser_id=#{order.userId} ")
        return new SQL(){{
            UPDATE(ORDER_TABLE);
            if (order.getUserId()>0 && order.getOrderId()>0){
                if (order.getOrderStatus()>0){
                    SET("order_status=#{order.orderStatus}");
                }
                if (order.getOrderDate2()!=null){
                    SET("order_date2=#{order.orderDate2}");
                }
                WHERE("order_id=#{order.orderId} and ouser_id=#{order.userId}");
            }
        }}.toString();
    }
}
