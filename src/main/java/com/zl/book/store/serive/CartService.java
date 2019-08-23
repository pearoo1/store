package com.zl.book.store.serive;

import com.zl.book.store.dao.CartDao;
import com.zl.book.store.dao.OrderDao;
import com.zl.book.store.pojo.Cart;
import com.zl.book.store.pojo.Order;
import com.zl.book.store.serive.impl.BookServiceInterface;
import com.zl.book.store.serive.impl.CartServiceInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
public class CartService implements CartServiceInterface {
    @Autowired CartDao  cartDao;
    @Autowired OrderDao orderDao;
    private String result;
    @Override
    public Map<String, Object> insertBookToCart(Cart cart,int statusCode) {
        try {
            Integer cartId=cartDao.selectCartBook(cart);
            if (cartId!=null){
                cart.setCartBookId(cartId);
                int c=cartDao.updateCartBookInfo(cart);
                if (c==1){
                    result="向购物车添加成功";
                }else {
                    result="向购物车添加失败";
                }
            }else {
             int c= cartDao.insertCartBookInfo(cart);
                if (c==1){
                    result="向购物车添加成功";
                }else {
                    result="向购物车添加失败";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result="连接超时";
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }

    @Override
    public Map<String, Object> getByCartByUserId(int userId, int statusCode) {
        List<Cart> list=null;
        try {
           list=cartDao.getCartByUserId(userId);
           if (list.size()>0){
               result="获取成功";
           }else {
               result="购物车中暂无数据";
           }
        }catch (Exception e){
            e.printStackTrace();
            result="获取失败";
            return ReturnMap.getMap(statusCode,DateFormat.getDateFormat(),result);
        }
        return ReturnMap.getMap(list,statusCode,DateFormat.getDateFormat(),result);
    }

    @Override
    public Map<String, Object> updateCartBook(Cart cart, int statusCode) {
        try {
            Integer cartId=cartDao.selectCartBook(cart);
            if (cartId!=null){
                cart.setCartBookId(cartId);
                int c=cartDao.updateCartBookInfo(cart);
                if (c==1){
                    result="修改成功";
                }else {
                    result="修改失败";
                }
            }else {
             int c=cartDao.insertCartBookInfo(cart);
             if (c==1){
                 result="修改成功";
             }else {
                 result="修改失败";
             }
            }
        }catch (Exception e){
            e.printStackTrace();
            result="修改失败";
        }
        return ReturnMap.getMap(statusCode,DateFormat.getDateFormat(),result);
    }

    //删除购物车单个图书信息
    @Override
    public Map<String, Object> deleteCartBook(Cart cart, int statusCode) {
        try {
            int count=cartDao.deleteCartBook(cart);
            if (count==1){
                result="删除成功";
            }else {
                result="删除失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="删除失败";
        }
        return ReturnMap.getMap(statusCode,DateFormat.getDateFormat(),result);
    }


    //确认付款，将购物车信息删除，添加商品到订单表中
    @Override
    public Map<String, Object> completeOrderBook(Cart cartBook,int addressId, int statusCode) {
        try {
            Cart cart=cartDao.selectBookToOrder(cartBook);
            if (cartBook!=null){
                if (cart!=null){
                    //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
                    Order order=new Order(cart.getUserId(),addressId,cart.getBookId(),cart.getBookName(),cart.getBookPrice(),
                            cart.getBookAmount(),cart.getBookGrade(),1,cartBook.getBookImage());
                    int count= orderDao.insertBookToOrder(order);
                    if (count==1){
                        result="付款成功";
                        int count1=cartDao.deleteCartBook(cartBook);
                    }else {
                        result="付款失败";
                    }
                }else {
                    result="不存在商品";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result="连接异常";
        }
        return ReturnMap.getMap(statusCode,DateFormat.getDateFormat(),result);
    }

}
