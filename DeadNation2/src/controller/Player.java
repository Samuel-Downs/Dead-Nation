package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import model.ExitDB;
import model.PlayerDB;
import model.RoomDB;
import model.SQLiteDB;

/**
 * Class: Player
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
 *
 * This class – handles the Player object. This is concerned with tracking inventory and current room
 * for this implementation
 */

public class Player {
	private int playerID;
	private String playerName;
	private int currentRoom;
	
	private int playerHealth;
	
	//if have time to do item in ArrayList
	private int playerEquippedItem;
	



    /**
	 * @return the playerhealth
	 */
	public int getPlayerHealth() {
		return playerHealth;
	}


	/**
	 * @param playerhealth the playerhealth to set
	 */
	public void setPlayerhealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}




	/**
	 * @return the playerEquippedItem
	 */
	public int getPlayerEquippedItem() {
		return playerEquippedItem;
	}


	/**
	 * @param playerEquippedItem the playerEquippedItem to set
	 */
	public void setPlayerEquippedItem(int playerEquippedItem) {
		this.playerEquippedItem = playerEquippedItem;
	}


	/**
     * Constructor: Room
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public Player() {
 
    	playerName = "Fred";
    	currentRoom = 1;
    	playerID = 1;
    	
    	playerHealth = 20;
    	
//    	this.playerEquippedItem= playerEquippedItem;
    	
    }




	/**
     * Method: currentRoomFromDatabase
     * Purpose: Retrieves a current based upon the supplied
     * @return Integger
     * @throws SQLException
     */
	public int currentRoomFromDatabase() throws SQLException, ClassNotFoundException {

        return currentRoom;
    }
    
	/**
	 * Method: getPlayerID
	 * @return the playerID
	 */
	public int getPlayerID() {
		return playerID;
	}

	/**
	 * Method: getPlayerName
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Method: getCurrentRoom
	 * @return the currentRoom
	 */
	public int getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Method: setPlayerID
	 * @param playerID the playerID to set
	 */
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	/**
	 * Method: setPlayerName
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	
	/**
	 * Method setCurrentRoom
	 * @param  update the currentRoom when player enter a valid command.
	 * @throws SQLException 
	 * @throws GameException 
	 * @throws ClassNotFoundException 
	 */
	public void setCurrentRoom(int currentRoom) throws GameException {
		this.currentRoom = currentRoom;
		PlayerDB pdb = new PlayerDB();
		pdb.updateRoom(this);
	}
	
	
	



    
    
        
}
