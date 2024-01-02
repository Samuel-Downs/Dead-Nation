package controller;



import exceptions.AccountInputException;
import exceptions.ExitBlockedException;
import model.AccountDB;
import model.RoomDB;
import view.MenuView;

import model.RoomDB;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class: GameController
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov, 2022
 * This class – Is the UI to controller interface for mini game 3
 * All user interactions will be sent to this class to be sent on for further processing.
 */
public class GameController {

//    private final List<String> VALID_DIRECTIONS =
//            Arrays.asList(new String[] {"WEST", "NORTH", "SOUTH", "EAST", "UP", "DOWN"});
    public static final int FIRST_ROOM = 1;


    private Player player;

    /**
     * Method GameController
     * Constructor for the GameController class
     * Instatiates the Commands object for the game
     */
    public GameController() {
        // TODO - implement GameController.GameController
        player = new Player();
    }

    public void start() throws GameException {
        // TODO - implement GameController.start
        File dbFile = new File("DeadNation.db");
        if (!dbFile.exists()) {
            CreateFilesController cfc = new CreateFilesController();
            cfc.createFile("dmlFiles/DeadNation.db");
        }
    }

    /**
     * Method displayFirstRoom
     * Retrieves the String for the first room
     * @return - the first room display String
     * @throws GameException - if the first room is not found.
     */
    public String displayFirstRoom() throws GameException, SQLException, ClassNotFoundException {
        // TODO - implement GameController.displayFirstRoom
        Room rm = new Room();
        rm = rm.getRoom(FIRST_ROOM);
        return rm.toString();
    }

    /**
     * Method executeCommand
     * Handles the user input from Adventure
     * Sends the user's command to Commands for processing
     * throws an exception if the command is not valid
     * @param cmd - String
     * @return String - the result from the command
     * @throws GameException if the command is invalid
     */
    public String executeCommand(String cmd) throws GameException {
        // TODO - implement GameController.executeCommand
        throw new UnsupportedOperationException();
    }

    /**
     * Method printMap
     * Handles the print map command from Adventure
     * Builds a  String representation of the current map
     * @return String - the String of the current map
     * @throws GameException if one of the files is not found or has an error
     */
//    public String printMap() throws GameException {
//        // TODO - implement GameController.printMap
//        throw new UnsupportedOperationException();
//    }

    /**
     * Method: getAllRoomsData
     * Purpose: Gets all rooms and returns an ArrayList<String> of all of the rooms
     * @return ArrayList<String>
     * @throws SQLException

     */
    public ArrayList<String> getAllRoomsData() throws SQLException, ClassNotFoundException, GameException {
        ArrayList<Room> rooms = null;
        Room rm = new Room();
        rooms = rm.getAllRooms();
        ArrayList<String> roomStrs = new ArrayList<String>();
        for (Room room : rooms) {
            roomStrs.add(room.toString());
        }
        return roomStrs;
    }

    /**
     * Method: getNexttRoom
     * Purpose: Get the room id for the next room if player enter a valild enter
     * @return Integer
     * @throws SQLException
     */
    public int getNexttRoom() throws SQLException, ClassNotFoundException {
        Player pl = new Player();
        int cur = pl.getCurRoom();
        return cur;
    }
    /**
     * @param input
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws GameException
     * @throws ExitBlockedException
     */
    public String userInput(String input) throws SQLException, ClassNotFoundException, GameException, ExitBlockedException {
        //String inputLower = input.toLowerCase();
        if (input.equalsIgnoreCase("menu")){
            MenuView menuView = new MenuView();
            menuView.pauseMenu();
            return "";
        }
        if ((input.substring(0, 7)).equalsIgnoreCase("Pick Up")){
            Item item = new Item();
            return item.pickUpItem(input.substring(8));
        }
        else{
            Room room = new Room();
            return room.navigation(input);
        }
    }

//    public void printNavigator(String str) {
//
//    }
//
    public String printNavigatorUp(String str) throws SQLException, ClassNotFoundException, GameException {
        if (str.equals("inventory")){
            Item item = new Item();
            return item.currentInventoryToString();
        }
        if (str.equals("roomDesc")){
            Room room = new Room();
            return room.display();
        }
        if (str.contains("monsterDesc")){
            Monster monster = new Monster();
            monster = monster.getMonster(Integer.parseInt(str.substring(10)));
            return monster.getMonsterDescription() + "\nA " + monster.getMonsterName() + " appeared.";
        }
        if (str.equals("playerHealth")){
            Item item = new Item();
            return item.currentInventoryToString();
        }
        else{throw new GameException("request not found :(");}
    }

    public String accountNavigator(String action, String username, String password) throws AccountInputException {
        Account account = new Account();
        if (action.equalsIgnoreCase("createNewAccount")){
            account.createNewAccount(username, password);
            return "Account Created Successfully";
        }
        if (action.equalsIgnoreCase("validLogin")){
            if(account.validateLogin(username, password)){
                return username+".db";
            }
            else{throw new AccountInputException("Invalid username or password");}
        }
        else{return "invalid command";}
    }

    public void menuNavigator(String menu, String input) {
        Menu menu1 = new Menu();
        if (menu.equalsIgnoreCase("Pause")){menu1.pauseMenu(input);}
        if (menu.equalsIgnoreCase("Main")){menu1.mainMenuInput(input);}
        if (menu.equalsIgnoreCase("Game Over")){menu1.gameOver(input);}
        if (menu.equalsIgnoreCase("Inventory")){menu1.inventoryMenu(input);}
    }

//    public void printNavigatorDown(String str) {
//
//    }
//
//    public void monsterNavigator(String str, int in) {
//
//    }

    public void monsterNavigatorDown(int i) {

    }




    /**
     * Method: getRoomData
     * Purpose: gets room data and returns a String containing it
     * @return String
     * @throws SQLException
     * @throws GameException
     */
    public String getRoomData(int roomID) throws GameException, SQLException, ClassNotFoundException {
        Room rm = new Room();
        rm = rm.getRoom(roomID);
        return rm.toString();
    }

    /**
     * Method: getCurrentRoomData
     * Purpose: gets current room from the Player table and returns a Integer
     * @return Int
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int getCurrentRoomData() throws SQLException, ClassNotFoundException {
        int cur = player.getCurRoom();
        return cur;
    }


}