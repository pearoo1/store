package com.zl.book.store.provider;

import com.zl.book.store.pojo.User;
import org.apache.ibatis.jdbc.SQL;

import static com.zl.book.store.util.Constants.USER_TABLE;

public class UserSqlProvider {

    //插入用户信息
    public String insertUser(User user) {
        return new SQL() {{
            INSERT_INTO(USER_TABLE);
            if (user.getUserName() != null && !user.getUserName().equals(""))
                VALUES("user_name", "#{user.userName}");

            if (user.getUserPwd() != null && !user.getUserPwd().equals(""))
                VALUES("user_pwd", "#{user.userPwd}");

            if (user.getUserCard() != null && !user.getUserCard().equals(""))
                VALUES("user_card", "#{user.userCard}");

            if (user.getUserSex() != null && !user.getUserPwd().equals(""))
                VALUES("user_sex", "#{user.userSex}");

            if (user.getUserPhone() != null && !user.getUserPhone().equals(""))
                VALUES("user_phone", "#{user.userPhone}");
        }}.toString();
    }

    // 单个条件查询
    public String selectSingleParam(User user) {
        return new SQL() {{
            SELECT("*");
            FROM(USER_TABLE);
            if (user.getUserPhone() != null && !user.getUserPhone().equals("")) {
                WHERE("user_phone=#{user.userPhone}");
            }
            if (user.getUserId()>0) {
                WHERE("user_id=#{user.userId}");
            }
        }}.toString();
    }

    //单条件更新:密码、手机号码
    public String updateUserInfo(User user) {
        return new SQL() {{
            UPDATE(USER_TABLE);
            if (user.getUserId() > 0) {
                //按用户Id修用户手机号码
                if (user.getUserPhone() != null && !user.getUserPhone().equals("")) {
                    SET("user_phone=#{user.userPhone}");
                }
                //按用户Id修改用户性别
                if (user.getUserSex()!=null){
                    if ((int)user.getUserSex()>0) {
                        SET("user_sex=#{user.userSex}");
                    }
                }
                //按用户Id修改用户密码
                if (user.getUserPwd() != null && !user.getUserPwd().equals("")) {
                    SET("user_pwd=#{user.userPwd}");
                }
                //按用户Id修改用户名
                if (user.getUserName() != null && !user.getUserName().equals("")) {
                    SET("user_name=#{user.userName}");
                }
                //按用户Id修改用户身份证
                if(user.getUserCard() != null && !user.getUserCard().equals("")) {
                    SET("user_card=#{user.userCard}");
                }
                WHERE("user_id=#{user.userId}");

            } else if (user.getUserPhone() != null && !user.getUserPhone().equals("")) {//按手机号修改用户信息
                    //按手机号码修改用户性别
                    if (user.getUserSex() != null && !user.getUserSex().equals("")) {
                        SET("user_sex=#{user.userSex}");
                    }
                    //按手机号码修改用户密码
                    if (user.getUserPwd() != null && !user.getUserPwd().equals("")) {
                        SET("user_pwd=#{user.userPwd}");
                    }
                     //按手机号码修改用户名
                    if (user.getUserName() != null && !user.getUserName().equals("")) {
                        SET("user_name=#{user.userName}");
                    }
                     //按手机号码修改用户身份证
                    if(user.getUserCard() != null && !user.getUserCard().equals("")) {
                        SET("user_card=#{user.userCard}");
                    }
                    WHERE("user_phone=#{user.userPhone}");
                }
        }}.toString();
    }
}
