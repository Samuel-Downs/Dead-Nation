package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Exit;
import controller.GameController;
import controller.GameException;
import controller.Player;
import controller.Room;




/**
 * Class: DB
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
* Written: Oct 1, 2022
 * This class handles all of the DB interactions for Player
 */
public class PlayerDB {
	

	   
	   //update current room to Data base
	    /**
	     * Method: updateRoom
	     * Purpose: update current room to Data base
	     */
	    public void updateRoom(Player play) throws GameException {
	    	try {
	        SQLiteDB sdb = new SQLiteDB();
	        String sql = "UPDATE PLAYER SET playerID =  " +
	        		play.getPlayerID() + ", playerName = '" + play.getPlayerName() + "', currentRoom = " 
	        		+ play.getCurrentRoom() + ", playerHealth = " + play.getPlayerHealth()+ 
	        		", equipped_ItemID = " + play.getPlayerEquippedItem() +
	        		" WHERE playerID = " + play.getPlayerID();
	        boolean success = sdb.updateDB(sql);
	        //Close the SQLiteDB connection since SQLite only allows one updater
	        sdb.close();	     
	    	}catch (SQLException | ClassNotFoundException e) {
	    		throw new GameException("Problem updating player in DB");
	    	}
	     
	        
	    }






   

	
	
}
