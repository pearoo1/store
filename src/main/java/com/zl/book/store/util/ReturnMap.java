package com.zl.book.store.util;

import java.util.HashMap;
import java.util.Map;

 public  class  ReturnMap {
    private static Map<String, Object> map;
    public static Map<String,Object> getMap(Object data,int status,String date,String result){
        map=new HashMap<>();
        map.put("status",status);
        map.put("data",data);
        map.put("result",result);
        map.put("date",date);
        return map;
    }

    public static  Map<String,Object> getMap(int status, String date, String result){
        map=new HashMap<>();
        map.put("status",status);
        map.put("result",result);
        map.put("date",date);
        return map;
    }
}
