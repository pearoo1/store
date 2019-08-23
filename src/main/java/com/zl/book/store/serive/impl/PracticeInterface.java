package com.zl.book.store.serive.impl;

import com.zl.book.store.pojo.*;

import java.util.List;

public interface PracticeInterface {
    List<PracticeBook> getBook(int bId);
    List<Class1> getClass1();
    List<Class2> getClass2(int id);
    List<Class3> getClass3(int id);
    PracticeUser getUser(int uId);
    Class3 getClass3Books(int class3Id);
    List<PracticeBook> getClass3Book(int classId);
    int insertUsers(PracticeUser user);
    List<PracticeBook> getBookByName(String bookName);
}
