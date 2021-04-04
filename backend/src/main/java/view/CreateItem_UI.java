package view;

import data.model.embeddable.PaymentId;
import data.model.entity.*;
import utils.ServiceBeanFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Scanner;

public class CreateItem_UI {
    void manageCreateItemCommand(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - create office");
            System.out.println("2 - create employee");
            System.out.println("3 - create customer");
            System.out.println("4 - create payment");
            System.out.println("5 - create order");
            System.out.println("6 - create order detail");
            System.out.println("7 - create product");
            System.out.println("8 - create product line");
            System.out.println("X - return to main menu");
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            this.manageCommand(command, scanner);
        }
    }

    private void manageCommand(String command, Scanner scanner) {
        switch(command){
            case "1":
                Office office = createOffice(scanner);
                ServiceBeanFactory.getOfficeService().createOffice(office);
                break;
            case "2":
                Employee employee = createEmployee(scanner);
                ServiceBeanFactory.getEmployeeService().createEmployee(employee);
                break;
            case "3":
                Customer customer = createCustomer(scanner);
                ServiceBeanFactory.getCustomerService().createCustomer(customer);
                break;
            case "4":
                Payment payment = createPayment(scanner);
                ServiceBeanFactory.getPaymentService().createPayment(payment);
                break;
            case "5":
                Order order = createOrder(scanner);
                ServiceBeanFactory.getOrderService().createOrder(order);
                break;
            case "6":
                System.out.println("Not implemented yet. Try again later.");
                break;
            case "7":
                System.out.println("Not implemented yet. Try again later.");
                break;
            case "8":
                System.out.println("Not implemented yet. Try again later.");
                break;
        }
    }

    private Order createOrder(Scanner scanner) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter order date - dd/MM/yyyy");
        String orderDateInput = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(orderDateInput, f);
        Date orderDate = Date.valueOf(localDate);

        System.out.println("Enter required date - dd/MM/yyyy");
        String requiredDateInput = scanner.nextLine();
        localDate = LocalDate.parse(requiredDateInput, f);
        Date requiredDate = Date.valueOf(localDate);

        System.out.println("Enter shipped date - dd/MM/yyyy");
        String shippedDateInput = scanner.nextLine();
        localDate = LocalDate.parse(shippedDateInput, f);
        Date shippedDate = Date.valueOf(localDate);

        System.out.println("Enter status of the order - (On_Hold, Shipped" +
                "Resolved, Disputed, In_Process, Cancelled)");
        String status = scanner.nextLine();

        System.out.println("Enter comments");
        String comment = scanner.nextLine();

        System.out.println("Enter customer number");
        int customerNumber = Integer.valueOf(scanner.nextLine());
        Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(customerNumber);

        return new Order(null, orderDate, requiredDate, shippedDate, status, comment, customer);
    }

    private Customer createCustomer(Scanner scanner) {
        System.out.println("Enter customer name");
        String customerName = scanner.nextLine();
        System.out.println("Enter contact last name");
        String contactLastName = scanner.nextLine();
        System.out.println("Enter contact first name");
        String contactFirstName = scanner.nextLine();
        System.out.println("Enter phone number");
        String phone = scanner.nextLine();
        System.out.println("Enter address line 1");
        String addressLine1 = scanner.nextLine();
        System.out.println("Enter address line 2");
        String addressLine2 = scanner.nextLine();
        System.out.println("Enter city");
        String city = scanner.nextLine();
        System.out.println("Enter state");
        String state = scanner.nextLine();
        System.out.println("Enter postal code");
        String postalCode = scanner.nextLine();
        System.out.println("Enter country");
        String country = scanner.nextLine();
        System.out.println("Enter salesRep employee number");
        int salesRepEmployeeNumber= Integer.valueOf(scanner.nextLine());
        System.out.println("Enter credit limit");
        BigDecimal creditLimit = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));

        Employee employee = ServiceBeanFactory.getEmployeeService().readEmployee(salesRepEmployeeNumber);

        return new Customer(null, customerName, contactLastName, contactFirstName,
                phone, addressLine1, addressLine2, city, state, postalCode, country,
                creditLimit, employee);
    }

    private Payment createPayment(Scanner scanner) {
        System.out.println("Enter customer number");

        int customerNumber = Integer.valueOf(scanner.nextLine());
        Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(customerNumber);

        System.out.println("Enter check number");
        String checkNumber = scanner.nextLine();

        PaymentId paymentId = new PaymentId(checkNumber, customer);

        System.out.println("Enter payment date - dd/MM/yyyy");
        String dateInput = scanner.nextLine();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateInput, f);
        Date date = Date.valueOf(localDate);

        System.out.println("Enter amount");
        BigDecimal amount = BigDecimal.valueOf(Long.parseLong(scanner.nextLine()));

        return new Payment(paymentId, customer, date, amount);
    }

    private Employee createEmployee(Scanner scanner) {
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter extension");
        String extension = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter job title");
        String jobTitle = scanner.nextLine();

        System.out.println("Enter office code");
        String officeCode = scanner.nextLine();
        Office office = ServiceBeanFactory.getOfficeService().readOffice(officeCode);

        return new Employee(null, lastName, firstName, extension, email, jobTitle, null, office);
    }

    private Office createOffice(Scanner scanner) {
        System.out.println("Enter city");
        String city = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter address line 1");
        String addressLine1 = scanner.nextLine();
        System.out.println("Enter address line 2");
        String addressLine2 = scanner.nextLine();
        System.out.println("Enter state");
        String state = scanner.nextLine();
        System.out.println("Enter postal code");
        String postalCode = scanner.nextLine();
        System.out.println("Enter country");
        String country = scanner.nextLine();
        System.out.println("Enter territory");
        String territory = scanner.nextLine();

        Office office = new Office(null, city, phone, addressLine1, addressLine2, state, postalCode, country, territory);
        return office;
    }
}
