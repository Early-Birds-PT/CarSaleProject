package app;

import data.model.embeddable.OrderProductPK;
import data.model.entity.*;
import service.*;
import service.impl.*;

public class App {

    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();
        OrderDetailService orderDetailService = new OrderDetailServiceImpl();
        Order order = orderService.readOrder(10100);
        ProductService productService = new ProductServiceImpl();
        Product product = productService.readProduct("S18_1749");

        System.out.println(order);
        System.out.println(product);

        OrderProductPK orderProductPK = new OrderProductPK(order,product);

        OrderDetail orderDetails = orderDetailService.readOrderDetails(orderProductPK);
        System.out.println(orderDetails);


       /* OrderService orderService = new OrderServiceImpl();
        Order order = orderService.readOrder(10112);
        System.out.println(order);

        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.readCustomer(103);
        System.out.println(customer);

        PaymentService paymentService = new PaymentServiceImpl();
        Payment payment = paymentService.readPayment("HQ336336");
        System.out.println(payment);

        */

    }
}
