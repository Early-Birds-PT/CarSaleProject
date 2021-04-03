package view;

import data.model.entity.Customer;
import data.model.entity.Employee;
import data.model.entity.Product;
import utils.ServiceBeanFactory;

import java.util.List;
import java.util.Scanner;

public class ReadAll_UI {
    void managePrintAllCommand(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - print all customers");
            System.out.println("2 - print all employees");
            System.out.println("3 - print all products");
            System.out.println("X - return to main menu");
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            this.manageCommand(command);
        }
    }

    private void manageCommand(String command) {
        switch(command){
            case "1":
                List<Customer> customers = ServiceBeanFactory.getCustomerService().getAllCustomers();
                customers.forEach(customer -> System.out.println(customer));
                break;
            case "2":
                List<Employee> employees = ServiceBeanFactory.getEmployeeService().getAllEmployees();
                employees.forEach(employee -> System.out.println(employee));
                break;
            case "3":
                List<Product> products = ServiceBeanFactory.getProductService().getAllProducts();
                products.forEach(product -> System.out.println(product));
                break;
        }
    }
}
