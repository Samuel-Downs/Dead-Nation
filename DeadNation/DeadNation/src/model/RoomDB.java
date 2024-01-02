package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameController;
import controller.GameException;
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
     * Method: getNextRoomID
     * Purpose: gets the next ID for a room
     * @return int
     */
    private ExitDB edb;
//    public int getNextRoomID() throws SQLException {
//        SQLiteDB sdb = null;
//        try {
//            sdb = new SQLiteDB();
//        }
//        catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        int next = sdb.getMaxValue("roomNumber", "room") + 1;
//        //Close the SQLiteDB connection since SQLite only allows one updater
//        sdb.close();
//        return next;
//    }

    /**
     * Method: getRoom
     * Purpose: Gets a room based upon the supplied ID
     * @param id
     * @return controller.Room
     * @throws SQLException
     */
    public Room getRoom(int id) throws SQLException, ClassNotFoundException, GameException {
        SQLiteDB sdb = new SQLiteDB();
        ExitDB exitDB = new ExitDB();
        Room rm = new Room();
        String sql = "Select * from Room WHERE roomNumber = " + id;
        ResultSet rs = sdb.queryDB(sql);
        if (rs.next()) {
            //System.out.println(rs.getInt("roomNumber"));
            int roomID = rs.getInt("roomID");
            rm.setRoomID(roomID);
            rm.setRoomName(rs.getString("roomName"));
            rm.setAlreadyVisitedText(rs.getString("Already_Visited_Text"));
            rm.setNewlyVisitedText(rs.getString("Newly_Visited_Text"));
            sdb.close();
            rm.setExits(edb.getExitsInformation(roomID));
        }
        else {
            throw new SQLException("Room " + id + " not found");
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return rm;
    }

    /**
     * Method: getAllRooms
     * Purpose: gets all rooms
     * @return ArrayList<controller.Room>
     * @throws SQLException
     */
    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException, GameException {
        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Integer> roomID = new ArrayList();
        SQLiteDB sdb = new SQLiteDB();
        String sql = "Select roomID from Room";
        ResultSet rs = sdb.queryDB(sql);
        //Each room has exit information which is gotten by querying the exit table
        //Because you need to close the connection, make an arraylist of all the roomIDs and get the room information with getRoom
        while (rs.next()){roomID.add(rs.getInt("roomID"));}
        sdb.close();
        for (int i = 0; i<=roomID.size()-1; i++){
            Room rm = getRoom((Integer)roomID.get(i));
            rooms.add(rm);
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return rooms;
    }
}