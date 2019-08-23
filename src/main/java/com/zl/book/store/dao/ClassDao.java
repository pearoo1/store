package com.zl.book.store.dao;

import com.zl.book.store.pojo.Class1;
import com.zl.book.store.pojo.Class2;
import com.zl.book.store.pojo.Class3;
import org.apache.ibatis.annotations.*;
import com.zl.book.store.provider.ClassSqlProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ClassDao {

    /************************插入分类数据*************************/

    //插入一级分类目录
    @InsertProvider(type = ClassSqlProvider.class,method = "insertClass1" )
    @Options(useGeneratedKeys = true,keyProperty = "class1Id")
    int insertClass1(@Param("class1") Class1 class1);

    // 单条数据插入二级目录
    @InsertProvider(type = ClassSqlProvider.class,method = "insertClass2" )
    @Options(useGeneratedKeys = true,keyProperty = "class2Id")
    int insertClass2(@Param("class2") Class2 class2);

  //单条数据插入三级目录
    @InsertProvider(type = ClassSqlProvider.class,method = "insertClass3" )
    @Options(useGeneratedKeys = true,keyProperty = "class3Id")
    int insertClass3(@Param("class3") Class3 class3);


    /*****************************************查询数据*****************************************/

    /*
    * 查询所有一级目录
    * */
    @Select("select * from book_db.class1_table order by class1_id asc")
    @Results(value = {
            @Result(property ="class1Id",column = "class1_id"),
            @Result(property ="class1Name",column = "class1_name")})
    List<Class1> getClass1();

    /**
     * 按一级目录class1Id 查询所有二级目录
     * */
    @Select("select * from book_db.class1_table where class1_id=#{class1Id} ")
    @Results(value = {
            @Result(property ="class1Name",column = "class1_name"),
            @Result(property ="class1Id",column = "class1_id"),
            @Result(property = "class2s",column = "class1_id",many = @Many(select ="getAllClass2"))
    })
    Class1 getClass2(@Param("class1Id") int class1Id);

    //获取所有的二级菜单上面的方法使用，对应Many配置
    @Select("select * from book_db.class2_table where class1_id=#{class1Id} ")
    @Results(value = {
            @Result(property ="class2Name",column = "class2_name"),
            @Result(property ="class2Id",column = "class2_id"),
            @Result(property ="class1Id",column = "class1_id")
    })
    List<Class2> getAllClass2(@Param("class1Id") int class1Id);

    /**
     * 按二级目录class2Id 查询所有三级目录
     * */
    @Select("select * from book_db.class2_table where class2_id=#{class2Id} order by class2_id asc")
    @Results(value = {
            @Result(property ="class2Id",column = "class2_id"),
            @Result(property ="class2Name",column = "class2_name"),
            @Result(property ="class3s",column = "class2_id",
                    many=@Many(select = "getAllClass3"))
    })
    //在二级目录中封装三级目录
    Class2 getClass3(@Param("class2Id") int class2Id);
    @Select("select * from book_db.class3_table where class2_id=#{class2Id} order by class3_id asc")
    @Results(value = {
            @Result(property ="class3Id",column = "class3_id"),
            @Result(property ="class3Name",column = "class3_name"),
            @Result(property ="class3Image",column = "class3_image"),
            @Result(property ="class2Id",column = "class2_id")
    })
    //查询所有和class2Id对应的三级分类
    List<Class3> getAllClass3(@Param("class3Id") int class2Id);
}
