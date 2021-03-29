package app;

import data.model.entity.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

public class App {

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.readOrder(10112);
        System.out.println(order);

    }
}
