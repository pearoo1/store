package com.zl.book.store.provider;

import com.zl.book.store.pojo.Cart;
import org.apache.ibatis.jdbc.SQL;
import static com.zl.book.store.util.Constants.CART_TABLE;

public class CartSqlProvider {
    //插入图书信息到购物车表
    public String insertCartBookInfo(Cart cart){
        return new SQL(){{
            INSERT_INTO(CART_TABLE);
            if (cart.getUserId()>0){
                VALUES("user_id","#{cart.userId}");
            }
            if (cart.getBookId()>0){
                VALUES("book_id","#{cart.bookId}");
            }
            if (cart.getBookGrade()>0){
                VALUES("book_grade","#{cart.bookGrade}");
            }
            if (cart.getBookName()!=null){
                VALUES("book_name","#{cart.bookName}");
            }
            if (cart.getBookPrice()>0){
                VALUES("book_price","#{cart.bookPrice}");
            }
            if (cart.getBookAmount()>0){
                VALUES("book_amount","#{cart.bookAmount}");
            }
            if (cart.getBookImage()!=null){
                VALUES("book_image","#{cart.bookImage}");
            }
        }}.toString();
    }

        public String updateCartBookInfo(Cart cart) {
            return new SQL() {{
                UPDATE(CART_TABLE);
                if (cart.getUserId()>0){
                    if (cart.getCartBookId()>0){
                        if (cart.getBookAmount()>0){
                            SET("book_amount=#{cart.bookAmount}+book_amount");
                        }
                        if (cart.getBookPrice()>0){
                            SET("book_price=#{cart.bookPrice}");
                        }
                        if (cart.getBookGrade()>0){
                            SET("book_grade=#{cart.bookGrade}");
                        }
                        WHERE("cart_id=#{cart.cartBookId}");
                    }
                    WHERE("user_id=#{cart.userId}");
                }
            }}.toString();
        }
}
