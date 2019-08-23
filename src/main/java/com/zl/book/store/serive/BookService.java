package com.zl.book.store.serive;

import com.zl.book.store.dao.BookDao;
import com.zl.book.store.pojo.Book;
import com.zl.book.store.pojo.BookImage;
import com.zl.book.store.serive.impl.BookServiceInterface;
import com.zl.book.store.util.DateFormat;
import com.zl.book.store.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements BookServiceInterface {
    private String result;
    private int count;
    @Autowired
    BookDao bookDao;

    @Override
    public Map<String, Object> insertBook(Book book, int statusCode) {
        try {
            count = bookDao.insertBook(book);
            if (count > 0) {
                result = "图书添加成功";
            } else {
                result = "图书添加失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "连接失败";
        }
        return ReturnMap.getMap(statusCode, DateFormat.getDateFormat(), result);
    }

    /**
     * 按三级目录id查询书籍
     *
     * @param bookId
     * @param statusCode
     */
    @Override
    public Map<String, Object> getBookByClassId(int bookId, int statusCode) {
        Object data = null;
        try {
            List<Book> list = bookDao.getBooksByClass3Id(bookId);
            List<Map<String, Object>> books = new ArrayList<>();
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = new HashMap();
                    map.put("class3Id", list.get(i).getClass3Id());
                    map.put("bookId", list.get(i).getBookId());
                    map.put("bookName", list.get(i).getBookName());
                    map.put("bookImage", list.get(i).getBookImage());
                    books.add(map);
                }
                data = books;
                result = "获取图书列表成功";
            } else {
                result = "获取图书列表失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "连接失败";
        }
        return ReturnMap.getMap(data, statusCode, DateFormat.getDateFormat(), result);
    }

    /**
     * 按书名进行模糊查询书籍
     *
     * @param book
     * @param status
     */
    @Override
    public Map<String, Object> getBookByName(Book book, int status) {
        Object data = null;
        try {
            List<Book> list = bookDao.getBookByName(book);
            List<Map<String, Object>> books = new ArrayList<>();
            if (list.size()>0) {
                for (int i= 0; i < list.size();i++) {
                    Map<String, Object> map = new HashMap();
                    map.put("class3Id", list.get(i).getClass3Id());
                    map.put("bookId", list.get(i).getBookId());
                    map.put("bookName", list.get(i).getBookName());
                    map.put("bookImage",list.get(i).getBookImage());
                    books.add(map);
                }
                data = books;
                result = "获取图书列表成功";
            } else {
                result = "获取图书列表失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "连接失败";
        }
        return ReturnMap.getMap(data, status, DateFormat.getDateFormat(), result);
    }

    /**
     * 按图书价格进行查询
     *
     * @param minPrice
     * @param maxPrice
     * @param status
     */
    @Override
    public Map<String, Object> getBookByPrice(double minPrice, double maxPrice, int status) {
        Object data = null;
        try {
            List<Book> list = bookDao.getBookByPrice(minPrice, maxPrice);
            List<Map<String, Object>> books = new ArrayList<>();
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = new HashMap();
                    map.put("class3Id", list.get(i).getClass3Id());
                    map.put("bookId", list.get(i).getBookId());
                    map.put("bookName", list.get(i).getBookName());
                    map.put("bookPrice", list.get(i).getBookPrice());
                    map.put("bookImage", list.get(i).getBookImage());
                    books.add(map);
                }
                data = books;
                result = "获取图书列表成功";
            } else {
                result = "获取图书列表失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "连接失败";
        }
        return ReturnMap.getMap(data, status, DateFormat.getDateFormat(), result);
    }

    @Override
    public Map<String, Object> getBookById(Book book, int statusCode) {
        Map<String, Object> map = new HashMap();
        try {
            Book bookInfo = bookDao.getBookById(book.getBookId());
            if (book != null) {
                result = "获取图书成功";
                map.put("class3Id", bookInfo.getClass3Id());
                map.put("bookId",bookInfo.getBookId());
                map.put("bookName",bookInfo.getBookName());
               List< Map<String, Object>> grades=new ArrayList<>();
                for (int i=0;i<bookInfo.getBookGrades().size();i++){
                    Map<String, Object> grade = new HashMap();
                    grade.put("gradeNumber",bookInfo.getBookGrades().get(i).getGradeNumber());
                    grade.put("gradeAmount",bookInfo.getBookGrades().get(i).getGradeAmount());
                    grade.put("gradePrice",bookInfo.getBookGrades().get(i).getGradePrice());
                    grades.add(grade);
                }
                map.put("bookGrades",grades);
                Map<String, Object> images = new HashMap();
                for (int i=0;i<bookInfo.getBookImages().size();i++){
                    images.put("image"+(i+1),bookInfo.getBookImages().get(i).getImagePath());
                }
                map.put("bookImages",images);
            } else {
                result = "获取图书失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "连接失败";
        }
        return ReturnMap.getMap(map, statusCode, DateFormat.getDateFormat(), result);
    }

    @Override
    public Map<String, Object> updateBookInfo(Book book, int statusCode) {
        return null;
    }

    @Override
    public Map<String, Object> getAllBooks(int statusCode) {
        List<Map<String,Object>> bookList=new ArrayList<>();
        try {
            List<Book> books=bookDao.getAllBooks();
            if (books.size()>0){
                result="获取图书列表成功";
                for (int i=0;i<books.size();i++){
                    Map<String,Object> map=new HashMap<>();
                    map.put("bookId",books.get(i).getBookId());
                    map.put("bookName",books.get(i).getBookName());
                    map.put("bookPrice",books.get(i).getBookPrice());
                    map.put("bookImage",books.get(i).getBookImage());
                    bookList.add(map);
                }
            }else {
                result="获取图书列表失败";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="连接失败";
        }
        return ReturnMap.getMap(bookList,statusCode,DateFormat.getDateFormat(),result);
    }

    @Override
    public String insertImages(List<BookImage> images) {
        String result=null;
        try {
            for (BookImage image:images){
                int count=bookDao.insertImages(image);
                if (count>=1){
                    result="success";
                }else result="fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            result="fail";
        }
        return result;
    }

}
