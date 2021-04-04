package view;

import data.model.embeddable.OrderDetailId;
import data.model.embeddable.PaymentId;
import data.model.entity.*;
import utils.ServiceBeanFactory;

import javax.persistence.EmbeddedId;
import java.math.BigDecimal;
import java.util.Scanner;

public class UpdateItem_UI {
    void manageUpdateItemCommand(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - update office");
            System.out.println("2 - update employee");
            System.out.println("3 - update customer");
            System.out.println("4 - update payment");
            System.out.println("5 - update order");
            System.out.println("6 - update order detail");
            System.out.println("7 - update product");
            System.out.println("8 - update product line");
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
                updateProduct(scanner);
                break;
            case "2":
                updateOffice(scanner);
                break;
            case "3":
                updateCustomer(scanner);
                break;
            case "4":
                System.out.println("ACCESS DENIED: Changes to your payments can not be made.\n " +
                        "Please contact our customer service at +1800 00 88 if you have any questions about your payments. \n ");
                break;
            case "5":
                updateOrder(scanner);
                break;
            case "6":
                updateOrderDetail(scanner);
                break;
            case "7":
                updateProduct(scanner);
                break;
            case "8":
                updateProductLine(scanner);
                break;
        }
    }

    private void updateProductLine(Scanner scanner) {

        System.out.println("Enter product line");
        String productLineCode = scanner.nextLine();

        System.out.println("Enter new text description");
        String textDescription = scanner.nextLine();

        System.out.println("Enter new html description");
        String htmlDescription = scanner.nextLine();

        ProductLine productLine = ServiceBeanFactory.getProductLineService().readProductLine(productLineCode);
        if (!textDescription.isEmpty()) {
            productLine.setTextDescription(textDescription);
        }
        if (!htmlDescription.isEmpty()) {
            productLine.setHtmlDescription(htmlDescription);
        }

        ServiceBeanFactory.getProductLineService().updateProductLine(productLine);
        System.out.println(productLine);
    }

    private void updateProduct(Scanner scanner) {

        System.out.println("Enter product code");
        String productCode = scanner.nextLine();

        System.out.println("Enter new product name");
        String productName = scanner.nextLine();

        System.out.println("Enter new product line - (Classic Cars, Motorcycles, Planes, Ships, Trains, Trucks and Buses, Vintage Cars)");
        String productLineCode = scanner.nextLine();

        System.out.println("Enter new product scale");
        String productScale = scanner.nextLine();

        System.out.println("Enter new product vendor");
        String productVendor = scanner.nextLine();

        System.out.println("Enter new product description");
        String productDescription = scanner.nextLine();

        System.out.println("Enter new quantity in stock");
        String quantityInStock = scanner.nextLine();

        System.out.println("Enter new buy price");
        String buyPrice = scanner.nextLine();

        System.out.println("Enter new MSRP");
        String msrp = scanner.nextLine();


        Product product = ServiceBeanFactory.getProductService().readProduct(productCode);

        if (!productName.isEmpty()) {
            product.setProductName(productName);
        }
        if (!productLineCode.isEmpty()) {
            ProductLine productLine = ServiceBeanFactory.getProductLineService().readProductLine(productLineCode);
            product.setProductLine(productLine);
        }
        if (!productScale.isEmpty()) {
            product.setProductScale(productScale);
        }
        if (!productVendor.isEmpty()) {
            product.setProductVendor(productVendor);
        }
        if (!productDescription.isEmpty()) {
            product.setProductDescription(productDescription);
        }
        if (!quantityInStock.isEmpty()) {
            product.setQuantityInStock(Short.valueOf(quantityInStock));
        }
        if (!buyPrice.isEmpty()) {
            product.setBuyPrice(BigDecimal.valueOf(Long.parseLong(buyPrice)));
        }
        if (!msrp.isEmpty()) {
            product.setMsrp(BigDecimal.valueOf(Long.parseLong(msrp)));
        }

        product = ServiceBeanFactory.getProductService().updateProduct(product);
        System.out.println(product);
    }

    private void updateOrderDetail(Scanner scanner) {

        System.out.println("To update your order details:\nPlease enter your order number");
        String orderNumber = scanner.nextLine();

        System.out.println("Please enter your product code");
        String productCode = scanner.nextLine();

        System.out.println("Enter quantity ordered");
        String quanOrd = scanner.nextLine();

        System.out.println("Enter individual price");
        String invdPrice = scanner.nextLine();

        System.out.println("Enter order linenumber");
        String linNumb = scanner.nextLine();

        Order order = ServiceBeanFactory.getOrderService().readOrder(Integer.valueOf(orderNumber));
        Product product = ServiceBeanFactory.getProductService().readProduct(productCode);
        OrderDetail orderDetail = ServiceBeanFactory.getOrderDetailService()
                .readOrderDetail(new OrderDetailId(order, product));

        if (!quanOrd.isEmpty()) {
            orderDetail.setQuantityOrdered(Integer.valueOf(quanOrd));
        }
        if (!invdPrice.isEmpty()) {
            orderDetail.setPriceEach(BigDecimal.valueOf(Long.parseLong(invdPrice)));
        }
        if (!linNumb.isEmpty()) {
            Short.valueOf(linNumb);
        }

        ServiceBeanFactory.getOrderDetailService().updateOrderDetail(orderDetail);
        System.out.println(orderDetail);
    }

    private void updateOrder(Scanner scanner) {

        System.out.println("Enter order number to check status or add a comment");
        String orderNumber = scanner.nextLine();

        System.out.println("Enter new comment");
        String upComment = scanner.nextLine();

        Order order = ServiceBeanFactory.getOrderService().readOrder(Integer.valueOf(orderNumber));
        if (!upComment.isEmpty()) {
            order.setComments(upComment);
        }

        System.out.println("Order updated: " + order);
    }

    private void updateCustomer(Scanner scanner) {

        System.out.println("Enter unique customer number to update its information");
        String customerNumber = scanner.nextLine();

        System.out.println("Enter new UserName");
        String upName = scanner.nextLine();

        System.out.println("Enter new contact Last Name");
        String upLast = scanner.nextLine();

        System.out.println("Enter new contact First Name");
        String upFirst = scanner.nextLine();

        System.out.println("Enter new Phone Number");
        String upPhone= scanner.nextLine();

        System.out.println("Enter new Adressline");
        String upAdress = scanner.nextLine();

        System.out.println("Enter new City");
        String upCity = scanner.nextLine();

        System.out.println("Enter new Country");
        String upCountry = scanner.nextLine();

        System.out.println("Enter new PostalCode");
        String upZip = scanner.nextLine();

        System.out.println("Enter new State");
        String upState = scanner.nextLine();

        System.out.println("Enter new CreditLimit [minimum 45000.00]");
        String upCredit = scanner.nextLine();

        Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(Integer.valueOf(customerNumber));

        if (!upName.isEmpty()) {
            customer.setCustomerName(upName);
        }
        if (!upFirst.isEmpty()) {
            customer.setContactFirstName(upFirst);
        }
        if (!upLast.isEmpty()) {
            customer.setContactLastName(upLast);
        }
        if (!upPhone.isEmpty()) {
            customer.setPhone(upPhone);
        }
        if (!upAdress.isEmpty()) {
            customer.setAddressLine1(upAdress);
        }
        if (!upCity.isEmpty()) {
            customer.setCity(upCity);
        }
        if (!upCountry.isEmpty()) {
            customer.setCountry(upCountry);
        }
        if (!upZip.isEmpty()) {
            customer.setPostalCode(upZip);
        }
        if (!upState.isEmpty()) {
            customer.setState(upState);
        }
        if (!upCredit.isEmpty()) {
            customer.setCreditLimit(BigDecimal.valueOf(Long.parseLong(upCredit)));
        }
        ServiceBeanFactory.getCustomerService().updateCustomer(customer);
        System.out.println("Customer updated: " + customer);
    }

    private void updateOffice(Scanner scanner) {

        System.out.println("Enter unique employee number to update its information");
        String employeeNumber = scanner.nextLine();

        System.out.println("Enter new Last Name");
        String updatedLastName = scanner.nextLine();

        System.out.println("Enter new First Name");
        String updatedFirstName = scanner.nextLine();

        System.out.println("Enter new Extension");
        String updatedExtension = scanner.nextLine();

        System.out.println("Enter new E-mail");
        String updatedMail = scanner.nextLine();

        System.out.println("Got a promotion? Nice! Enter new Jobtitle, congrats dude.");
        String updatedJobTitle = scanner.nextLine();

        Employee employee = ServiceBeanFactory.getEmployeeService().readEmployee(Integer.valueOf(employeeNumber));
        if (!updatedLastName.isEmpty()) {
            employee.setLastName(updatedLastName);
        }
        if (!updatedFirstName.isEmpty()) {
            employee.setFirstName(updatedFirstName);
        }
        if (!updatedExtension.isEmpty()) {
            employee.setExtension(updatedExtension);
        }
        if (!updatedMail.isEmpty()) {
            employee.setEmail(updatedMail);
        }
        if (!updatedJobTitle.isEmpty()) {
            employee.setJobTitle(updatedJobTitle);
        }

        Employee updatedEmployee = ServiceBeanFactory.getEmployeeService().updateEmployee(employee);
        System.out.println("Employee updated: " + updatedEmployee);
    }
}
