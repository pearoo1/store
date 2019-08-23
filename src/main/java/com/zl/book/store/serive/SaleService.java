package com.zl.book.store.serive;

import com.zl.book.store.serive.impl.BookServiceInterface;
import com.zl.book.store.serive.impl.SaleServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SaleService implements SaleServiceInterface {

    @Override
    public Map<String, Object> getAllSale(int statusCode) {

        return null;
    }

    @Override
    public Map<String, Object> getSaleByClass(int classId, int statusCode) {
        return null;
    }

    @Override
    public Map<String, Object> getSaleByDate(String date, int statusCode) {
        return null;
    }
}
