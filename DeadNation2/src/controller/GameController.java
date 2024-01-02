package controller;


import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SQLiteDB;

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
	// attributes
	private Player player;
	
	/**
	 * Constructor
	 * @param player
	 */
	public GameController() {
		player = new Player();
	}
	
    public void start() throws GameException {
        File dbFile = new File("DeadNation.db");
        if (!dbFile.exists()) {
            CreateFilesController cfc = new CreateFilesController();
            cfc.createFile("DeadNation.db");
        }
     }
    //accept command
    /**
     * Method: processCommand
     * Purpose: Check the userInput is valid or invalid
     * @return String
     * @throws ClassNotFoundException 
     * @throws SQLException
     */
    public String processCommand(String command) throws GameException, ClassNotFoundException, SQLException {
  	
    	int curRoom;
    	boolean found = false;
    	Room rm = new Room();
    	rm = rm.getRoom(player.getCurrentRoom());
    	rm = rm.navigation(command);
    	
    	curRoom = rm.getRoomID();
    	updateCurrentRoom(curRoom);
 
   	
    	return rm.toString();
    	
    }
    
    /**
     * Method: getRoomData
     * Purpose: gets room data and returns a String containing it
     * @return String
     * @throws SQLException
     * @throws GameException 
     */
    public String getRoomData(int roomID) throws GameException {
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
        int cur = player.currentRoomFromDatabase();
        return cur;
    }
    
    /**
     * Method: getAllRoomsData
     * Purpose: Gets all rooms and returns an ArrayList<String> of all of the rooms
     * @return ArrayList<String>
     * @throws SQLException
     */
    public ArrayList<String> getAllRoomsData() throws SQLException, ClassNotFoundException {
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
        int cur = pl.getCurrentRoom();
        return cur;
    }
    
    /**
     * Method: updateCurrentRoom
     * Purpose: when player enter a valid command, it will update current room to the database
     * @return 
     * @throws ClassNotFoundException 
     * @throws SQLException
     */
    public void updateCurrentRoom(int roomID) throws GameException, ClassNotFoundException, SQLException {

        player.setCurrentRoom(roomID);
        Room rm = new Room();
        rm = rm.getRoom(roomID);
        rm.updateRoom();        

    }
    
  
    
}
