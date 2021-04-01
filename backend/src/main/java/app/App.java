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


//        CustomerService customerService = new CustomerServiceImpl();
//       // Customer customer = customerService.readCustomer(363);
//        System.out.println(customerService.deleteCustomer(103));

        ProductService productService = new ProductServiceImpl();

        Product product = productService.readProduct("S10_1678");

        product.setProductName("UPDATED");

        System.out.println(productService.updateProduct(product));

        System.out.println(productService.deleteProduct("S10_1678"));







//        OrderService orderService = new OrderServiceImpl();
//        List<Order> orders = orderService.findAllOrdersByCustomer(customer);
//        System.out.println(orders);


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
