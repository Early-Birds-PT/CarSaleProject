package view;

import utils.ServiceBeanFactory;

import java.util.Scanner;

public class UserInterfaceReadAll {
    void handlePrintAllCommands(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - print all customers");
            System.out.println("2 - print all employees");
            System.out.println("3 - print all products");
            System.out.println("X - stop");
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
                ServiceBeanFactory.getCustomerService().getAllCustomers();
                break;
            case "2":
                ServiceBeanFactory.getEmployeeService().getAllEmployees();
                break;
            case "3":
                ServiceBeanFactory.getProductService().getAllProducts();
                break;
        }
    }
}
