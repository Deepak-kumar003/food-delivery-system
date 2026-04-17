package com.food.service;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    private ConcurrentHashMap<String, String> orders = new ConcurrentHashMap<>();

    public String placeOrder(String orderId) {
        if (orders.containsKey(orderId)) return "DUPLICATE";
        orders.put(orderId, "ORDER_PROCESSED");
        return "SUCCESS";
    }
}
