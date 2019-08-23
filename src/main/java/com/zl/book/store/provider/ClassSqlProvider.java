package com.zl.book.store.provider;

import com.zl.book.store.pojo.Class1;
import com.zl.book.store.pojo.Class2;
import com.zl.book.store.pojo.Class3;
import com.zl.book.store.pojo.PracticeUser;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

import static com.zl.book.store.util.Constants.*;

public class ClassSqlProvider {

    /***********************插入操作************************/
    //单条插入一级分类
    public String insertClass1(Class1 class1) {
        return new SQL() {
            {
                INSERT_INTO(USER_CLASS1);//String tableName
                if (class1 != null) {
                    VALUES("class1_name", "#{class1.class1Name}");
                }
            }
        }.toString();
    }

    //插入二级分类
    public String insertClass2(Class2 class2) {
        return new SQL() {
            {
                INSERT_INTO(USER_CLASS2);
                    if (class2!= null) {
                        VALUES("class2_name", "#{class2.class2Name}");
                        VALUES("class1_id", "#{class2.class1Id}");
                    }
            }
        }.toString();
    }
    //单条插入三级分类目录
    public String insertClass3(Class3 class3) {
        return new SQL() {
            {
                INSERT_INTO(USER_CLASS3);
                    if (class3.getClass3Name() != null) {
                        VALUES("class3_name", "#{class3.class3Name}");
                        VALUES("class2_id", "#{class3.class2Id}");
                    }
            }
        }.toString();
    }

    /***************************查询操作***************************/

}
