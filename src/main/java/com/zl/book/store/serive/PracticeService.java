package com.zl.book.store.serive;

import com.zl.book.store.dao.PracticeDao;
import com.zl.book.store.pojo.*;
import com.zl.book.store.serive.impl.PracticeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


 //@Service
public class PracticeService implements PracticeInterface {
    @Autowired
    PracticeDao practiceDao;
    public List<PracticeBook> getBook(int bId) {
        return  practiceDao.getBookInfo(bId);
    }

    @Override
    public List<Class1> getClass1() {
         return practiceDao.getClass1();
    }

    @Override
    public List<Class2> getClass2(int id) {
         return practiceDao.getClass2(id);
    }

    @Override
    public List<Class3> getClass3(int id) {
        return practiceDao.getClass3(id);
    }

    @Override
    public PracticeUser getUser(int uId) {
        return practiceDao.getUserInfo(uId);
    }

    @Override
    public Class3 getClass3Books(int class3Id) {
        return practiceDao.getClass3Info(class3Id);
    }

    @Override
    public List<PracticeBook> getClass3Book(int classId) {
        return practiceDao.getClass3Books(classId);
    }

    @Override
    public int  insertUsers(PracticeUser user) {
        return practiceDao.insertUsers(user);
    }

    @Override
    public List<PracticeBook> getBookByName(String bookName) {
        return practiceDao.getBookByName(bookName);
    }

}
