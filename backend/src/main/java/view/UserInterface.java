package view;

import utils.ServiceBeanFactory;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ProgramManager programManager;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.programManager = programManager;
    }

    public void start(){
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - print all offices");
            System.out.println("2 - print all employees");
            System.out.println("3 - print all customers");
            System.out.println("4 - print all payments");
            System.out.println("5 - print all orders");
            System.out.println("6 - print all order details");
            System.out.println("7 - print all products");
            System.out.println("8 - print all product lines");
            System.out.println("X - stop");
            String command = scanner.nextLine();

            if(command.contains("X")){
                break;
            }

            this.manageCommand(command);
        }
    }

    public void manageCommand(String command){
        switch(command){
            case "1":
                ServiceBeanFactory.getOfficeService().readOffice("1");
                break;
            case "2":

                break;
            case "3":
                ServiceBeanFactory.getCustomerService().getAllCustomers();
                break;
            case "4":

                break;
            case "5":

                break;
            case "6":

                break;
            case "7":

                break;

        }
    }



}
