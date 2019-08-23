package com.zl.book.store.dao;

import com.zl.book.store.pojo.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
/*
 * Dao层接口使用@Mapper注解，这个接口在编译时会生成相应的实现类
 * Dao层接口的实现类使用@repository注解
 * @Component映射成使用，即把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 */
@Mapper
@Component
public interface AddressDao {

    @Insert("insert into book_db.address_table(user_id,address_path,consignee_phone,address_name)" +
            "values(#{address.userId},#{address.addressPath},#{address.consigneePhone},#{address.consigneeName})")
    int  insertUserAddress(@Param("address") Address address);//创建新地址

    @Select("select * from book_db.address_table where user_id=#{address.userId}")
    @Results({
            @Result(id = true,column = "address_id",property = "addressId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "address_path",property = "addressPath"),
            @Result(column = "consignee_phone",property = "consigneePhone"),
            @Result(column = "address_name",property = "consigneeName")
    })
    //获取用户全部地址信息
    List<Address> getUserAddress(@Param("userId") int userId);//获取用户全部地址信息

    //修改收货人手机号/姓名地址
    int  updateAddress(Address address);

    //删除地址
    @Delete("delete from book_db.address_table where address_id=#{addressId}")
    int deleteAddress(@Param("addressId")int addressId);

    @Select("select * from book_db.address_table where address_id=#{address.addressId}")
    @Results({
            @Result(id = true,column = "address_id",property = "addressId"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "address_path",property = "addressPath"),
            @Result(column = "consignee_phone",property = "consigneePhone"),
            @Result(column = "address_",property = "consigneeName")
    })
    Address getAddressById(@Param("address")Address address);//按地址id查找

}
