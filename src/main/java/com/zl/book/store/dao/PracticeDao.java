package com.zl.book.store.dao;

import com.zl.book.store.pojo.*;
import com.zl.book.store.provider.BookSqlProvider;
import com.zl.book.store.provider.ClassSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


//@Mapper
//@Component
public interface PracticeDao {
    //若数据库里面的字段与实体类的属性名不同时配置，相同无需
    @Results(id = "practice", value = {
            @Result(property ="bId" ,column = "book_id"),
            @Result(property ="bName" ,column = "book_name"),
            @Result(property ="bGrade" ,column = "book_grade"),
            @Result(property ="uId" ,column = "user_id"),
            @Result(property = "class3Id",column ="class3_id")
    })
    @Select("select * from user_db.book_table where user_id=#{uId}")
    List<PracticeBook> getBookInfo(@Param("uId") int uId);

    @Results(value = {
            @Result(id = true,property = "userId" ,column = "user_id"),
            @Result(property = "userName" ,column = "user_name"),
            @Result(property = "userPwd" ,column = "user_pwd"),
            @Result(property = "practiceBooks" ,column = "user_id",
                    many = @Many(select = "getBookInfo")),
    })
    @Select("select * from user_db.user_table where user_id=#{uId}")
    PracticeUser getUserInfo(@Param("uId") int uId);


    @Results(value = {
            @Result(property ="bId" ,column = "book_id"),
            @Result(property ="bName" ,column = "book_name"),
            @Result(property ="bGrade" ,column = "book_grade"),
            @Result(property ="uId" ,column = "user_id"),
            @Result(property = "class3Id",column ="class_id"),
            @Result(property = "images",column = "book_id",
                    many =@Many(select ="getBookImages" ) )
    })
    @Select("select * from user_db.book_table where class3_id=#{class3Id}")
    List<PracticeBook> getClass3Books(@Param("class3Id") int class3Id);

    @Results(value = {
            @Result(property ="imageId" ,column = "image_id"),
            @Result(property ="imagePath" ,column = "image_path"),
            @Result(property ="iBookId" ,column = "book_id")
    })
    @Select("select * from user_db.image_table where book_id=#{bookId}")
    List<BookImage> getBookImages(@Param("bookId") int bookId);

    @Results(value = {
            @Result(id = true,property = "catalogue3Id" ,column = "class3_id"),
            @Result(property = "catalogue3Name" ,column = "class3_name"),
            @Result(property = "practiceBooks" ,column = "class3_id",
                    many = @Many(select = "getClass3Books")),
    })
    @Select("select * from user_db.class3_table where class3_id=#{class3Id}")
    Class3 getClass3Info(@Param("class3Id") int class3Id);

    @Results(value = {
            @Result(id = true,property = "catalogue1Id" ,column = "class1_id"),
            @Result(property = "catalogue1Name" ,column = "class1_name")
    })
    @Select("select * from user_db.class1_table ")
    List<Class1> getClass1();

    @Results(value = {
            @Result(id = true,property = "catalogue2Id" ,column = "class2_id"),
            @Result(property = "catalogue2Name" ,column = "class2_name"),
            @Result(property = "catalogue1Id" ,column = "class1_id"),
    })
    @Select("select * from user_db.class2_table where class1_id=#{id}")
    List<Class2> getClass2(@Param("id")int id);

    @Results(value = {
            @Result(id = true,property = "catalogue3Id" ,column = "class3_id"),
            @Result(property = "catalogue3Name" ,column = "class3_name"),
            @Result(property = "catalogue2Id" ,column = "class2_id"),
    })
    @Select("select * from user_db.class3_table where class2_id=#{id}")
    List<Class3> getClass3(@Param("id")int id);

    //@Options(useGeneratedKeys = true,keyProperty = "userId")
    /*@Insert({
            "<script>",
            "insert into tb_area(id, name, pid,level) values ",
            "<foreach collection='areaLists' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.name}, #{item.pid}, #{item.level} )",
            "</foreach>",
            "</script>"
    })*/
    //int insertAreas(@Param(value = "areaLists") List<Area> areaLists);
    @InsertProvider(type = ClassSqlProvider.class ,method ="insertUsers" )
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    int insertUsers(@Param("user")PracticeUser user);

    /**
     * 按照bookName进行模糊查询
     * */
    @Results(value = {
            @Result(property ="bId" ,column = "book_id"),
            @Result(property ="bName" ,column = "book_name"),
            @Result(property ="bGrade" ,column = "book_grade"),
            @Result(property ="uId" ,column = "user_id"),
            @Result(property = "class3Id",column ="class3_id")
    })
    @Select("select * from user_db.book_table where book_name like concat(concat('%',#{bookName},'%'))")
    List<PracticeBook> getBookByName(@Param("bookName") String bookName);
}

