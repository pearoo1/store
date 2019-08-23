package com.zl.book.store.serive;

import com.zl.book.store.pojo.Address;
import com.zl.book.store.serive.impl.AddressServiceInterface;
import com.zl.book.store.serive.impl.BookServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddressService implements AddressServiceInterface {
    @Override
    public Map<String, Object> insertUserAddress(Address address) {
        return null;
    }

    @Override
    public Map<String, Object> getUserAddress(int userId, int statusCode) {
        return null;
    }

    @Override
    public Map<String, Object> updateAddress(Address address, int statusCode) {
        return null;
    }

    @Override
    public Map<String, Object> deleteAddress(Address address, int statusCode) {
        return null;
    }
}
