package com.zl.book.store.provider;

import com.zl.book.store.pojo.Book;
import com.zl.book.store.pojo.BookImage;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

import static com.zl.book.store.util.Constants.BOOK_IMAGE;
import static com.zl.book.store.util.Constants.BOOK_TABLE;

public class BookSqlProvider {

    public String insertBook(Book book){
      return  new SQL(){{
          if (book!=null){
              INSERT_INTO(BOOK_TABLE);
              if (book.getBookAuthor()!=null){
                  VALUES("book_author","#{book.bookAuthor}");
              }
              if (book.getBookDate()!=null){
                  VALUES("book_date","#{book.bookDate}");
              }
              if (book.getBookName()!=null){
                  VALUES("book_name","#{book.bookName}");
              }
              if (book.getBookPrice()!=null){
                  VALUES("book_price","#{book.bookPrice}");
              }
              if (book.getBookPublish()!=null){
                  VALUES("book_publish","#{book.bookPublish}");
              }
              if (book.getClass3Id()>0){
                  VALUES("class3_id","#{book.class3Id}");
              }
          }
      }}.toString();
    }

    public String insertImages(BookImage images){
        return  new SQL(){{
            INSERT_INTO(BOOK_IMAGE);
                VALUES("image_path","#{images.imagePath}");
                VALUES("book_id", "#{images.iBookId}");
        }}.toString();
    }

    public String selectBookInfo(Book params){
        return new SQL(){{
            SELECT("*");
            FROM(BOOK_TABLE);
            //按三级目录查询
            if (params.getClass3Id()>0)
                WHERE("class3_id=#{params.class3Id }");

             //按图书id进行准确查询
             if(params.getBookId()>0)
                 WHERE("book_id=#{params.bookId}");

            //按名字进行模糊查询
             if(params.getBookName()!=null)
                 WHERE("book_name like concat('%',#{params.bookName},'%')");
        }}.toString();
    }
}
