package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameException;
import controller.Item;
import controller.Room;


/**
 * Class : RoomDB.java
 * @author: Team 1
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Nov 2, 2022
 * This class handles all of the DB interactions for Rooms
 */

public class RoomDB {



    /**
     * Method: getRoom
     * Purpose: Gets a room based upon the supplied ID
     * @param id
     * @return Room
     * @throws SQLException
     */
    public Room getRoom(int id) throws GameException {
    	Room rm = null;
    	try {
    	SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        rm = new Room();
        String sql = "Select * from Room WHERE roomID = "+ id;
        ResultSet rs = sdb.queryDB(sql);

        if (rs.next()) {
            rm.setRoomID(rs.getInt("roomID"));
            rm.setRoomName(rs.getString("roomName"));
            rm.setNotVisitedText(rs.getString("Already_Visited_Text"));
            rm.setNotVisitedText(rs.getString("Newly_Visited_Text"));
            
            ExitDB ex = new ExitDB();
            rm.setExits(ex.getExit(rm.getRoomID()));
            
            ItemDB it = new ItemDB();
            rm.setItem(it.getItem(rm.getRoomID()));
            
//            MonsterDB mt = new MonsterDB();
//            rm.setMonster(mt.getMonster(rm.getRoomID()));
//            		

            
            rm.setVisited(rs.getInt("visited"));
        }
        
        else {
            throw new GameException("Room " + id + " not found");
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    	}
    	catch (SQLException | ClassNotFoundException e ) {
    		throw new GameException("Room " + id + " not found");
    	}
        return rm;
    }

    /**
     * Method: getAllRooms
     * Purpose: gets all rooms
     * @return ArrayList<Room>
     * @throws SQLException
     */
    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException {
        ArrayList<Room> rooms = new ArrayList<Room>();
        SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        String sql = "Select * from Room";

        ResultSet rs = sdb.queryDB(sql);

        while (rs.next()) {
            Room rm = new Room();
            rm.setRoomID(rs.getInt("roomID"));
            rm.setRoomName(rs.getString("roomName"));
            rm.setNotVisitedText(rs.getString("Already_Visited_Text"));
            rm.setNotVisitedText(rs.getString("Newly_Visited_Text"));
            
            ExitDB ex = new ExitDB();
            rm.setExits(ex.getExit(rm.getRoomID()));
            
            ItemDB it = new ItemDB();
            rm.setItem(it.getItem(rm.getRoomID()));
            
            
            
            //get visited from room table
            rm.setVisited(rs.getInt("visited"));
            
            rooms.add(rm);
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return rooms;
    }

    
    /**
     * Method: updateRoom
     * Purpose: when player enter a valid command, it will update current room to the database
     * @throws SQLException, ClassNotFoundException, GameException
     */
    public void updateRoom(Room room) throws SQLException, ClassNotFoundException, GameException {
        SQLiteDB sdb = new SQLiteDB();
      //  room.getVisited() = 1;
        
        String sql = "UPDATE ROOM SET visited = " + room.getVisited() + " WHERE roomID =  " + room.getRoomID();
        boolean success = sdb.updateDB(sql);
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();	        
     
        
    }
    
    
    
    

}
