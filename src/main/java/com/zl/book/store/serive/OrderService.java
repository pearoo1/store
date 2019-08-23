package com.zl.book.store.serive;

import com.zl.book.store.dao.OrderDao;
import com.zl.book.store.dao.SaleDao;
import com.zl.book.store.pojo.Order;
import com.zl.book.store.pojo.Sale;
import com.zl.book.store.serive.impl.BookServiceInterface;
import com.zl.book.store.serive.impl.OrderServiceInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService implements OrderServiceInterface {
    @Autowired OrderDao orderDao;
    @Autowired SaleDao saleDao;
    private String result;

    @Override
    public Map<String, Object> insertOrder(Order order, int statusCode) {
        try {
            int count=orderDao.insertBookToOrder(order);
            if (count==1){
                result="订单创建成功";
            }else {
                result="订单创建失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="连接超时";
        }
       return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }

    //获取用户各个状态下的订单
    @Override
    public Map<String, Object> getUserOrder(Order order,int statusCode) {
        List<Order> list=null;
        try{
            list=orderDao.getUserOrder(order);
            if (list.size()>0){
                result="获取用户订单列表成功";
            }else {
                result="获取用户订单列表失败";
            }
        }catch (Exception e){
            result="获取用户订单列表失败";
            e.printStackTrace();
        }
        return ReturnMap.getMap(list,statusCode, DateFormat.getDateFormat(),result);
    }

    //获取用户各个状态下的订单
    @Override
    public Map<String, Object> getUserAllOrder(int userId,int statusCode) {
        List<Order> list=null;
        try{
            list=orderDao.getUserAllOrder(userId);
            if (list.size()>0){
                result="获取用户订单列表成功";
            }else {
                result="获取用户订单列表失败";
            }
        }catch (Exception e){
            result="获取用户订单列表失败";
            e.printStackTrace();
        }
        return ReturnMap.getMap(list,statusCode, DateFormat.getDateFormat(),result);
    }
    //获取用户单个订单信息
    @Override
    public Map<String, Object> getOrderId(int userId,int orderId, int statusCode) {
         Order order=null;
        try{
            order=orderDao.getUserOrderById(userId,orderId);
            if (order!=null){
                result="获取用户单个订单成功";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="获取用户当个订单失败";
            return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
        }
        return ReturnMap.getMap(order,statusCode, DateFormat.getDateFormat(),result);
    }

    //修改订单的状态(只含0,1,2)
    //订单状态号：0 未付款，1 已付款未发货，2 已发货，3 退款 ，4 退货退款，5 确认收货
    @Override
    public Map<String, Object> updateOrder(Order order, int statusCode) {
        try{
            int count=orderDao.updateOrder(order);
            if (count==1){
                result="修改成功";
            }
        }catch (Exception e){
            result="修改失败";
            e.printStackTrace();
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }


    //删除单个订单信息
    @Override
    public Map<String, Object> deleteOrder(int userId,int orderId, int statusCode) {
        try{
            int count=orderDao.deleteOrder(orderId,userId);
            if(count==1){
                result="删除成功";
            }
        }catch (Exception e){
            result="删除失败";
            e.printStackTrace();
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }

    //确认收货，向销售表插入数据,状态5
    @Override
    public Map<String, Object> completeOrder(Order orderBook, int statusCode) {
        try {
            String date2=DateFormat.getDateFormat();
            orderBook.setOrderDate2(date2);
            Order order=orderDao.getUserOrderById(orderBook.getUserId(),orderBook.getOrderId());
            Sale sale=new Sale(order.getUserId(),order.getOrderId(),order.getBookId(),
                    order.getBookName(),order.getBookPrice(),order.getBookAmount(),date2);
            int count=orderDao.updateOrder(orderBook);
            if (count==1){
                if (saleDao.insertSale(sale)==1){
                    result="已确认收货";
                }else {
                    result="未确认收货";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result="未确认收货";
        }
        return null;
    }
}
