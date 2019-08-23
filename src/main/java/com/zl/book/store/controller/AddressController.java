package com.zl.book.store.controller;

import com.zl.book.store.pojo.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
//@RequestMapping("/address")
//10.156.55.156:8080/address/insert
//10.156.55.156:8080/address/select
//10.156.55.156:8080/address/update
//10.156.55.156:8080/address/delete
public class AddressController {

    @PostMapping("/insert")
    @ResponseBody
    public Map<String, Object> insertUserAddress(@RequestBody Address address, HttpServletResponse response) {
        return null;
    }

    @PostMapping("/select")
    @ResponseBody
    public Map<String, Object> getUserAddress(@RequestParam("userId") int userId, HttpServletResponse response) {
        return null;
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateAddress(@RequestBody Address address, HttpServletResponse response) {
        return null;
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAddress(@RequestBody Address address, HttpServletResponse response) {
        return null;
    }
}
