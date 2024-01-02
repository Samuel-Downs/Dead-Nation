package view;

import controller.GameController;

import java.util.Scanner;

public class MenuView{
    GameController gc;
    Scanner input;
    public void mainMenu() {
        System.out.print("Do you want play \'New Game\' or \'Load Game\' or \'Create Account\' or \'Exit\' ");
        String userInput = input.nextLine();
        gc.menuNavigator("Main", userInput);
    }

    public void pauseMenu() {
        System.out.print("What do you want to do? \'Inventory\' or \'Save\' or \'Exit\'");
        String userInput = input.nextLine();
        gc.menuNavigator("Pause", userInput);
    }

    public void gameOver() {
        System.out.println("You have died");

        System.out.println("You can \'Load Game\' or \'New Game' \'Main Menu'");
        String userInput = input.nextLine();

        gc.menuNavigator("Game Over", userInput);
    }

    public void inventoryMenu() {
        System.out.println();
        System.out.println("You can \'Examine\' or  \'Use\', or \'Equip\' any of the items above");
        String userInput = input.nextLine();
        gc.menuNavigator("Inventory", userInput);

    }
}
