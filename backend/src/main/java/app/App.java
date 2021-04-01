package app;

import data.model.entity.*;
import service.*;
import service.impl.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public class App {

    public static void main(String[] args) {


        EmployeeService employeeService = new EmployeeServiceImpl();

     //  employeeService.deleteEmployee(1619);
        // employee.setOffice(office1);
        //employee.setEmployee(null);
      //  employee.setEmployeeNumber(0);

        /*
        employee.setEmail("UPDATED@gmail.com");
        employee = employeeService.updateEmployee(employee);
        System.out.println(employee);

         */




        /*OrderService orderService = new OrderServiceImpl();
        Order order = orderService.readOrder(10112);
        System.out.println(order);*/

        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.readCustomer(103);
        System.out.println(customer);

        customer.setCustomerName("UPDATED");
        customerService.createCustomer(customer);
        System.out.println(customer);

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
        OfficeService officeService = new OfficeServiceImpl();


       // Office office1 = officeService.readOffice("5");
        //System.out.println(office1);
       // officeService.deleteOffice("7");

       // office1.setOfficeCode(String.valueOf(generateUniqueID(officeService)));
        /*office1.setCity("Sivas");
        office1 = officeService.createOffice(office1);
        System.out.println(office1);*/

       //officeService.deleteOffice("4");


        // officeService.updateOffice(office1);





        /*
        Employee(employeeNumber=1702, lastName=Gerard, firstName=Martin, extension=x2312, email=mgerard@classicmodelcars.com, jobTitle=Sales Rep,
        employee=Employee(employeeNumber=1102, lastName=Bondur, firstName=Gerard, extension=x5408, email=gbondur@classicmodelcars.com, jobTitle=Sale Manager (EMEA),
        employee=Employee(employeeNumber=1056, lastName=Patterson, firstName=Mary, extension=x4611, email=mpatterso@classicmodelcars.com, jobTitle=VP Sales,
        employee=Employee(employeeNumber=1002, lastName=Murphy, firstName=Diane, extension=x5800, email=dmurphy@classicmodelcars.com, jobTitle=President,
        employee=null,
        office=Office(officeCode=1, city=San Francisco, phone=+1 650 219 4782, addressLine1=100 Market Street, addressLine2=Suite 300, state=CA, postalCode=94080, country=USA, territory=NA)),
        office=Office(officeCode=1, city=San Francisco, phone=+1 650 219 4782, addressLine1=100 Market Street, addressLine2=Suite 300, state=CA, postalCode=94080, country=USA, territory=NA)),
        office=Office(officeCode=4, city=Paris, phone=+33 14 723 4404, addressLine1=43 Rue Jouffroy D'abbans, addressLine2=null, state=null, postalCode=75017, country=France, territory=EMEA)),
        office=Office(officeCode=4, city=Paris, phone=+33 14 723 4404, addressLine1=43 Rue Jouffroy D'abbans, addressLine2=null, state=null, postalCode=75017, country=France, territory=EMEA))



         */




    }


}
