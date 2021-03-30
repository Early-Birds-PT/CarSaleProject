package app;

import data.model.entity.Customer;
import data.model.entity.Order;
import data.model.entity.Payment;
import service.CustomerService;
import service.PaymentService;
import service.impl.CustomerServiceImpl;
import service.OrderService;
import service.impl.OrderServiceImpl;
import service.impl.PaymentServiceImpl;

public class App {

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.readOrder(10112);
        System.out.println(order);

        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.readCustomer(103);
        System.out.println(customer);

        PaymentService paymentService = new PaymentServiceImpl();
        Payment payment = paymentService.readPayment("HQ336336");
        System.out.println(payment);

    }
}
