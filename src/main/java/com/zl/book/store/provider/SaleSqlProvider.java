package com.zl.book.store.provider;

import com.zl.book.store.pojo.Sale;
import org.apache.ibatis.jdbc.SQL;

import static com.zl.book.store.util.Constants.SALE_TABLE;

public class SaleSqlProvider {
    public String insetSale(Sale sale){
        return new SQL(){{
            INSERT_INTO(SALE_TABLE);
            if (sale.getUserId()>0){
                VALUES("user_id","sale.userId");
            }
            if (sale.getUserId()>0){
                VALUES("order_id","sale.orderId");
            }
            if (sale.getBookId()>0){
                VALUES("user_id","sale.getBookId");
            }
            if (sale.getSaleBookName()!=null){
                VALUES("book_name","sale.saleBookName");
            }
            if (sale.getSaleDate()!=null){
                VALUES("sale_date","sale.saleDate");
            }
            if (sale.getSalePrice()!=null){
                VALUES("sale_price","sale.salePrice");
            }
            if (sale.getSaleAmount()>0){
                VALUES("sale_amount","sale.saleAmount");
            }
        }}.toString();
    }
}
