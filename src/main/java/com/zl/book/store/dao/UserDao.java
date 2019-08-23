package com.zl.book.store.dao;

import com.zl.book.store.pojo.User;
import org.apache.ibatis.annotations.*;
import com.zl.book.store.provider.UserSqlProvider;
import org.springframework.stereotype.Component;


@Mapper
@Component
 //表明它是组件之一，防止出现无法穿透的debug
public interface UserDao {

    //若数据库里面的字段与实体类的属性名不同时配置，相同无需
    //新增用户
    @InsertProvider(type = UserSqlProvider.class,method = "insertUser")
    int insertUser(@Param("user") User user);

    /**
     * 按手机号码/用户名查找用户
     * */
    @Results(value = {
            @Result(property = "userId",id = true,column = "user_id"),
            @Result(property = "userPwd",column = "user_pwd"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userSex",column = "user_sex"),
            @Result(property = "userPhone",column = "user_phone")})
    @SelectProvider(type = UserSqlProvider.class,method ="selectSingleParam")
    User selectUser(@Param("user") User user);

    /*
    * 登录功能：按密码和手机号查询
    * */
    @Select("select user_id from book_db.user_table where user_phone=#{phone} and user_pwd=#{pwd}")
    Integer selectByPhoneAndPwd(@Param("phone")String phone,@Param("pwd")String pwd);

    //按手机号查询:作为判手机号码是否存在
    @Select("select count(*) from book_db.user_table where user_phone=#{phone}")
    int selectByPhone(@Param("phone")String phone);

    /*
    * 修改用户信息
    * */
    @UpdateProvider(type = UserSqlProvider.class,method = "updateUserInfo")
    int updateUserInfo(@Param("user") User user);

}
