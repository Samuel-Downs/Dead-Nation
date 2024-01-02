package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.Exit;

/**
 * Class: DB
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
* Written: Oct 1, 2022
 * This class is the Exit class handling business logic for the Exit class
 
 */



public class ExitDB {
	
    /**
     * Method: getNextExitID
     * Purpose: Gets the id for the next exit.
     * @return int
     */
    public int getNextExitsID() throws SQLException {
        SQLiteDB sdb = null;
        try {
            sdb = new SQLiteDB("DeadNation.db");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        int next = sdb.getMaxValue("ExitDBID", "ExitDB") + 1;
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return next;
    }
    
    /**
     * Method: getExit
     * Purpose: handles db interactions to retrieve a single Exit
     * @param id
     * @return Exit
     * @throws SQLException
     */
    public ArrayList<Exit> getExit(int id) throws SQLException, ClassNotFoundException {
        SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        String sql = "Select * from ExitDB WHERE ExitDB_RoomID = " + id;
        ResultSet rs = sdb.queryDB(sql);
        ArrayList<Exit> exits = new ArrayList<>();
        while (rs.next()) {
            Exit exi = new Exit();
            exi.setExistID(rs.getInt("ExitDBID"));
            exi.setRoomID(rs.getInt("ExitDB_RoomID"));
            exi.setDirection(rs.getString("Direction"));
            exi.setDestination(rs.getInt("DestinationID"));
            
            exi.setExitBock(rs.getInt("ExitDB_Blocked"));
            exi.setDirectionText(rs.getString("DirectionText"));
            exi.setDirectionPuzzleText(rs.getString("DirectionPuzzleText"));
            exits.add(exi);
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return exits;
    }

    
    /**
     * Method: getAllExits
     * Purpose: Handles the DB interactions to retrieve all Exits
     * @return ArrayList<Exit>
     * @throws SQLException
     */
    public ArrayList<Exit> getAllExits() throws SQLException, ClassNotFoundException {
        ArrayList<Exit> exits = new ArrayList<Exit>();
        SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        String sql = "Select * from ExitDB";

        ResultSet rs = sdb.queryDB(sql);

        while (rs.next()) {
        	Exit exi = new Exit();
            exi.setExistID(rs.getInt("ExitDBID"));
            exi.setRoomID(rs.getInt("ExitDB_RoomID"));
            exi.setDirection(rs.getString("Direction"));
            exi.setDestination(rs.getInt("DestinationID"));
            
            exi.setExitBock(rs.getInt("ExitDB_Blocked"));
            exi.setDirectionText(rs.getString("DirectionText"));
            exi.setDirectionPuzzleText(rs.getString("DirectionPuzzleText"));

            exits.add(exi);
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return exits;
    }


    

}
