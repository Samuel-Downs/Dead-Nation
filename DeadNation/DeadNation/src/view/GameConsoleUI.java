package view;

import controller.GameController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.GameController;
import controller.GameException;
import controller.Player;
import controller.Room;

public class GameConsoleUI {
    private GameController gc;
    private Scanner input;
    private AccountView accountView;
    private GameStateView gameStateView;

    private GameConsoleUI(){
        this.gc = new GameController();
        this.input = new Scanner(System.in);
        this.accountView = new AccountView();
        this.gameStateView = new GameStateView();
    }

    public static void main(String[] args) throws GameException {
        GameConsoleUI game = new GameConsoleUI();

        //String db = game.accountView.loginScreen();
        //Now you need to load the right database according to db, but I don't know how to do that rn
        try {
            game.gc.getAllRoomsData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Come to the Game


        // user input

    }


//            while ((!userInput.equalsIgnoreCase("X"))) {
//            try {
//                System.out.println( getRoom(getCurrentRoom()));
//                System.out.println("\nWhat would you like to do?");
//                userInput = input.nextLine();
//                if(userInput.equalsIgnoreCase("x")) {
//                    break;
//                }
//                checkRoom(userInput);
//
//            } catch (GameException | SQLException | ClassNotFoundException e) {
//
//                System.out.println(e.getMessage());
//
//            }

//    }



    /**
     * Method: printStrs Purpose: Print the ArrayList of Strings
     *
     * @param strs void
     * @return void
     */
    private void printStrs(ArrayList<String> strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }

    /**
     * Method: getAllRooms Purpose: Retreieve all rooms from the database and return
     * them as a List<String>
     *
     * @param: None
     * @return: ArrayList<String>
     */
    private ArrayList<String> getAllRooms() throws SQLException, ClassNotFoundException, GameException {
        return gc.getAllRoomsData();
    }



    /**
     * Method: getRoom Purpose: Retreieve the room from the database and return it
     * as a String
     *
     * @param: room
     * @return: String
     */
    private String getRoom(int room) throws GameException, SQLException, ClassNotFoundException {
        return gc.getRoomData(room);
    }





}
