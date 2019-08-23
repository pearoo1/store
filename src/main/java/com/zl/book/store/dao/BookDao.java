package com.zl.book.store.dao;

import com.zl.book.store.pojo.Book;
import com.zl.book.store.pojo.BookImage;
import com.zl.book.store.pojo.BookGrade;
import com.zl.book.store.provider.BookSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.List;
import java.util.Map;


@Mapper
@Component
public interface BookDao {

    /* 插入数据到book_table
     * @param book
     * */
    @InsertProvider(method ="insertBook",type =BookSqlProvider.class)
    int insertBook(@Param("book") Book book);

    //********************************************查询书本数据************************************************/
    /**
     * 按三级目录Id查询所有书籍信息
     * */
    @Results(value = {
            @Result(property="class3Id",column = "class3_id"),
            @Result(id = true,property="bookId",column = "book_id"),
            @Result(property="bookName",column = "book_name"),
            @Result(property="bookPrice",column = "book_price"),
            @Result(property="bookImage",column = "book_image")//指定图书图片
    })
    @Select("select class3_id, book_id,book_name,book_price,book_image " +
            "from book_db.book_table where class3_Id=#{class3Id}")
    List<Book> getBooksByClass3Id(@Param("class3Id") int class3Id);


    /**
     * 按照bookName进行模糊查询
    * */
    @Results(value = {
            @Result(property="class3Id",column = "class3_Id"),
            @Result(id = true,property="bookId",column = "book_id"),
            @Result(property="bookName",column = "book_name"),
            @Result(property="bookPrice",column = "book_price"),
            @Result(property="bookImage",column = "book_image") //指定图书图片
    })

    //@Select("select * from book_db.book_table where book_name like concat('%',#{bookName},'%')")
    @SelectProvider(type = BookSqlProvider.class,method = "selectBookInfo")
    List<Book> getBookByName(@Param("params")Book params);

    //所以图书信息
    @Results(value = {
            @Result(property="class3Id",column = "class3_Id"),
            @Result(id = true,property="bookId",column = "book_id"),
            @Result(property="bookName",column = "book_name"),
            @Result(property="bookPrice",column = "book_price"),
            @Result(property="bookImage",column = "book_image") //指定图书图片
    })
    @Select("select * from book_db.book_table ")
    List<Book> getAllBooks();

    /**
     * 按照图书价格进行区间查找
     * */
    @Results(value = {
            @Result(property="class3Id",column = "class3_Id"),
            @Result(id = true,property="bookId",column = "book_id"),
            @Result(property="bookName",column = "book_name"),
            @Result(property="bookPrice",column = "book_price"),
            @Result(property="bookImage",column = "book_image") //指定图书图片
    })
    @Select("select * from book_db.book_table where book_price>=#{minPrice}and book_price<=#{maxPrice}")
    List<Book> getBookByPrice(@Param("minPrice")double minPrice,@Param("maxPrice")double maxPrice);

    //按图书Id查询书的准确信息
    @Select("select * from book_db.book_table where book_id=#{bookId}")
    @Results({
            @Result(property="class3Id",column = "class3_id"),
            @Result(id = true,property="bookId",column = "book_id"),
            @Result(property="bookName",column = "book_name"),
            @Result(property="bookGrades",column = "book_id",
                    many = @Many(select = "getBookGrades")),
            @Result(property="bookImages",column = "book_id",
                    many = @Many(select = "getBookImages"))
    })
    Book getBookById(@Param("bookId") int bookId);

    //一本书对应的图片集
    @Select("select image_path from book_db.image_table where book_id=#{bookId}")
    @Results({@Result(property = "imagePath" ,column = "image_path")})
    List<BookImage> getBookImages(@Param("bookId") int bookId);

    //一本书对应的新旧程度集
    @Select("select * from book_db.grade_table where book_id=#{bookId}")
    @Results({
            @Result(property = "gradeNumber",column = "grade_number") ,
            @Result(property = "gradeAmount",column = "grade_amount"),
            @Result(property = "gradePrice",column = "grade_price")
    })
    List<BookGrade> getBookGrades(@Param("bookId") int bookId);

    /********************************************更新数据**********************************************************/
    /*
    * 批量更新book信息
    * @param map
    * */
    int updateBooksInfo(@Param("map")Map map);


    /*批量插入图片*/
    @InsertProvider(type = BookSqlProvider.class,method = "insertImages")
    int insertImages(@Param("images") BookImage images);
}
