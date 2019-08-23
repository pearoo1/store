package com.zl.book.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/sale")
//10.156.55.156:8080/sale/select/all
//10.156.55.156:8080/sale/select/class
//10.156.55.156:8080/sale/select/date
public class SaleController {
    @GetMapping("/select/all")
    @ResponseBody
    public Map<String, Object> getAllSale(HttpServletResponse response) {
        return null;
    }

    @PostMapping("/select/class")
    @ResponseBody
    public Map<String, Object> getSaleByClass(@RequestParam("classId") int classId,HttpServletResponse response) {
        return null;
    }
    @PostMapping("/select/date")
    @ResponseBody
    public Map<String, Object> getSaleByDate(@RequestParam("date") String date, HttpServletResponse response) {
        return null;
    }
    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> deteleSale(@RequestParam("id") String orderId, HttpServletResponse response) {
        return null;
    }

}
