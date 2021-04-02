package view;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start(){
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - read all");
            System.out.println("2 - read item");
            System.out.println("3 - update item");
            System.out.println("4 - delete item");
            System.out.println("X - exit program");
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            this.manageCommand(command);
        }
    }

    private void manageCommand(String command){
        switch(command){
            case "1":
                new ReadAll_UI().handlePrintAllCommands(scanner);
                break;
            case "2":
                new ReadItem_UI().handlePrintItemCommands(scanner);
                break;
            case "3":
                System.out.println("Not implemented yet, try later");
                break;
            case "4":
                System.out.println("Not implemented yet, try later");
                break;
        }
    }
}
