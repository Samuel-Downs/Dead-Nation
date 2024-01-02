package view;

import controller.Account;
import controller.GameController;
import exceptions.AccountInputException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AccountView{
    private GameController gc = new GameController();
    private Scanner input = new Scanner(System.in);

    public String createAccount() {
        try {
            System.out.println("Please enter a username");
            String userName = input.nextLine();
            System.out.println("Please enter a password");
            String password = input.nextLine();
            return gc.accountNavigator("createNewAccount", userName, password);
        }catch (AccountInputException e){
            System.out.println("Would you like to try again or go to login screen\nYes: try again\nNo: Login Screen");
            if (input.nextLine().equalsIgnoreCase("no")){return "@";}
            else{return createAccount();}
        }
    }

    public String login() {
        try {
            System.out.println("Account Creation\nPlease enter a username");
            String userName = input.nextLine();
            System.out.println("Please enter a password");
            String password = input.nextLine();
            System.out.println(gc.accountNavigator("validLogin", userName, password));
            return userName;
        }catch (AccountInputException e){
            System.out.println("Would you like to try again or go to login screen\nYes: try again\nNo: Login Screen");
            if (input.nextLine().equalsIgnoreCase("no")){return "@";}
            else{return login();}
        }
    }


    public String loginScreen(){
        System.out.println("Do you want to Create Account or login?");
        String userInput = input.nextLine();
        while(true) {
            if (userInput.equalsIgnoreCase("Create Account")) {
                String accountCreation = createAccount();
                if (accountCreation.contains("@")){return loginScreen();}
                else{System.out.println(accountCreation);}
                return loginScreen();
            }
            if (userInput.equalsIgnoreCase("Login")) {
                String login = login();
                if (login.contains("@")){return loginScreen();}
                else{return login;}
            }
            else{return loginScreen();}
        }
    }
}
