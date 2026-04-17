package com.food;
import com.food.service.OrderService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    OrderService service = new OrderService();

    @Test
    void testOrderFlow() {
        assertEquals("SUCCESS", service.placeOrder("1"));
        assertEquals("DUPLICATE", service.placeOrder("1")); // Test duplication logic
    }
}
