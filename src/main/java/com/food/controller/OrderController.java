package com.food.controller;
import com.food.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/{id}")
    public String createOrder(@PathVariable String id) {
        return service.placeOrder(id);
    }
}
