package app;

import data.model.embeddable.OrderProductPK;
import data.model.entity.*;
import service.*;
import service.impl.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class App {

    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();

        ProductService productService = new ProductServiceImpl();

        Order order = orderService.readOrder(10100);
        Product product = productService.readProduct("S18_1749");


        OrderDetailService orderDetailService = new OrderDetailServiceImpl();

        System.out.println(orderDetailService.createOrderDetail(new OrderDetail(new OrderProductPK(order, product),5,new BigDecimal(10), (short) 5)));


        //OrderDetail orderDetail = orderDetailService.readOrderDetail(new OrderProductPK(order, product));

      // orderDetail.setQuantityOrdered(1000);

        //System.out.println(orderDetailService.updateOrderDetail(orderDetail));
       /* CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.readCustomer(363);
        //System.out.println(customerService.deleteCustomer(103));

        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = orderService.findAllOrdersByCustomer(customer);
        System.out.println(orders);

       /* PaymentService paymentService = new PaymentServiceImpl();
        Payment payment = paymentService.readPayment("HQ336336");
        System.out.println(payment);

        Customer customer1 = new Customer();
        customer1.setCustomerName("Mert Demirok");
        customer1.setContactFirstName("Mert");
        customer1.setContactLastName("Demirok");
        customer1.setCountry("Belgium");
        customer1.setAddressLine1("Straat");
        customer1.setPhone("0458564589");
        customer1.setCreditLimit(BigDecimal.valueOf(1000));
        customer1.setCity("Leuven");*/

       // customerService.createCustomer(customer1);
        //OfficeService officeService = new OfficeServiceImpl();
        /*Office office1 = officeService.readOffice("8");
        System.out.println(office1);*/

       // office1.setOfficeCode(String.valueOf(generateUniqueID(officeService)));
        /*office1.setCity("Sivas");
        office1 = officeService.createOffice(office1);
        System.out.println(office1);*/

        //officeService.deleteOffice("5");


        // officeService.updateOffice(office1);


    }


}
