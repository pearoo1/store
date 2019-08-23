package com.zl.book.store.dao;

import com.zl.book.store.pojo.Sale;
import com.zl.book.store.provider.SaleSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface SaleDao {

    @InsertProvider(type = SaleSqlProvider.class,method = "insetSale")
    int insertSale(@Param("sale") Sale sale);

    @Results(value = {
            @Result(id = true,property = "saleId",column = "order_id"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property ="bookId",column = "book_id"),
            @Result(property ="bookName",column = "book_name"),
            @Result(property = "bookAmount",column = "book_amount"),
            @Result(property = "bookPrice",column = "book_price"),
            @Result(property = "bookGrade",column = "book_grade"),
            @Result(property = "bookDate2",column = "order_date")
    })
    // 获取所有的信息
    @Select("select * from book_db.sale_table order by sale_id desc")
    List<Sale> getAllSale(int statusCode);

    @Results(value = {
            @Result(id = true,property = "saleId",column = "order_id"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property ="bookId",column = "book_id"),
            @Result(property ="bookName",column = "book_name"),
            @Result(property = "bookAmount",column = "book_amount"),
            @Result(property = "bookPrice",column = "book_price"),
            @Result(property = "bookGrade",column = "book_grade"),
            @Result(property = "bookDate2",column = "order_date")
    })
    // 获取订单详细信息
    @Select("select * from book_db.sale_table where class3_id=#{classId}")
    List<Sale> getSaleByClass(int classId, int statusCode);

    @Results(value = {
            @Result(id = true,property = "saleId",column = "order_id"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property ="bookId",column = "book_id"),
            @Result(property ="bookName",column = "book_name"),
            @Result(property = "bookAmount",column = "book_amount"),
            @Result(property = "bookPrice",column = "book_price"),
            @Result(property = "bookGrade",column = "book_grade"),
            @Result(property = "bookDate2",column = "order_date")
    })
    //@SelectProvider(type = SaleSqlProvider.class,method = "getSaleByDate")
    //获取当日的销售单
    List<Sale>  getSaleByDate(String date, int statusCode);

    //@SelectProvider(type = SaleSqlProvider.class,method = "getSaleMoney")
    //按时间获取销售额:可单日子，可日期区间
    Double  getSaleMoneyByDate(Map<String,String> date, int statusCode);
}
