package com.zl.book.store.serive;

import com.zl.book.store.dao.ClassDao;
import com.zl.book.store.pojo.Class1;
import com.zl.book.store.pojo.Class2;
import com.zl.book.store.pojo.Class3;
import com.zl.book.store.serive.impl.ClassServiceInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassService implements ClassServiceInterface {
    @Autowired ClassDao classDao;
    private int count;
    private String result;
    /*************************************插入数据****************************************/
    @Override
    public Map<String, Object> insertClass1(Class1 class1, int statusCode) {
        try{
            count= classDao.insertClass1(class1);
            if (count==1){
                result="一级目录添加成功";
            }else {
                result="一级目录添加失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="一级目录添加失败";
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }

    @Override
    public Map<String, Object> insertClass2(Class2 class2, int statusCode) {
        try{
            count= classDao.insertClass2(class2);
            if (count==1){
                result="二级目录添加成功";
            }else {
                result="二级目录添加失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="二级目录添加失败";
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }

    @Override
    public Map<String, Object> insertClass3(Class3 class3, int statusCode) {
        try{
            count= classDao.insertClass3(class3);
            if (count==1){
                result="三级目录添加成功";
            }else {
                result="三级目录添加失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="三级目录添加失败";
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(),result);
    }

    /*************************************查询数据******************************************/
    @Override
    public Map<String, Object> getClass1(int statusCode) {
        Object data=null;
        try{
            List<Class1> class1s=classDao.getClass1();
            List<Map<String,Object>> class1=new ArrayList<>();
            Map<String,Object> map;
            if (class1s.size()>0){
                for (int i=0;i<class1s.size();i++){
                    map=new HashMap<>();
                    map.put("class1Id",class1s.get(i).getClass1Id());
                    map.put("class1Name",class1s.get(i).getClass1Name());
                    class1.add(map);
                }
                data=class1;
                result="一级目录获取成功";
            }else {
                result="一级目录获取失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="一级目录获取失败";
        }
        return ReturnMap.getMap(data,statusCode,DateFormat.getDateFormat(),result);
    }

    @Override
    public Map<String, Object> getClass2(int class1Id, int statusCode) {
        Object data=null;
        Class1 class1=classDao.getClass2(class1Id);
        try{
            if (class1!=null){
                data= class1;
                result="二级目录获取成功";
            }else {
                result="二级目录获取失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="二级目录获取失败";
        }
        return ReturnMap.getMap(data,statusCode,DateFormat.getDateFormat(),result);
    }

    @Override
    public Map<String, Object> getClass3(int class2Id, int statusCode) {
        Object data=null;
        Class2 class2=classDao.getClass3(class2Id);
        try{
            if (class2!=null){
                Map<String,Object> map=new HashMap<>();
                map.put("class2Id",class2.getClass2Id());
                map.put("class2Name",class2.getClass2Name());
                map.put("class3s",class2.getClass3s());
                data= map;
                result="三级目录获取成功";
            }else {
                result="三级目录获取失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="三级目录获取失败";
        }
        return ReturnMap.getMap(data,statusCode,DateFormat.getDateFormat(),result);
    }
}
