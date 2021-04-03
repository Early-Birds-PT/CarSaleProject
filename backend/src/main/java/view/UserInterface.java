package view;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void start(){
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - read all");
            System.out.println("2 - read item");
            System.out.println("3 - create item");
            System.out.println("4 - update item");
            System.out.println("5 - delete item");
            System.out.println("X - exit program");
            String  command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            manageCommand(command);
        }
    }

    private static void manageCommand(String command){
        switch(command){
            case "1":
                new ReadAll_UI().managePrintAllCommand(scanner);
                break;
            case "2":
                new ReadItem_UI().managePrintItemCommand(scanner);
                break;
            case "3":
                new CreateItem_UI().manageCreateItemCommand(scanner);
                break;
            case "4":
                System.out.println("Not implemented yet, try again later");
                break;
            case "5":
                System.out.println("Not implemented yet, try again later");
                break;
        }
    }
}
