package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Exit;
import controller.GameException;
import controller.Item;
import controller.Room;

/**
 * Class: ItemDB
 * @author Team 1
 * @version 1.0
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
 * This class – Item Database class for mini game 3.
 * This allows the other classes to request these items.
 */


public class ItemDB {



	/**
	 * Method getItem
	 * Returns the Item requested by the ID. Only used in readRooms
	 * @param id - the ID of the item requested.
	 * @return void
	 * @throws GameException if the item ID cannot be found
	 */
	public ArrayList<Item> getItem(int id) throws SQLException, ClassNotFoundException{
        SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        String sql = "Select * from Item WHERE itemID = " + id;
        ResultSet rs = sdb.queryDB(sql);
        ArrayList<Item> item = new ArrayList<>();
        while (rs.next()) {
        	Item it = new Item();
            it.setItemID(rs.getInt("itemID"));
            it.setItemName(rs.getString("itemName"));
            it.setItemDescription(rs.getString("itemDescription"));
            

            it.setItemLocation(rs.getString("itemLocation"));
            it.setItemRoomLocation(rs.getInt("itemRoomLocation"));
            it.setItemUse(rs.getString("itemUse"));
            it.setItemAttributes(rs.getInt("itemAttributes"));
            it.setItem_restriction(rs.getString("item_restriction"));
            it.setItemCommand(rs.getString("itemCommand"));
            item.add(it);

        }
        sdb.close();
        return item; 	
    }
	
	
    /**
     * Method: getAllItem
     * Purpose: gets all item in a Room
     * @return ArrayList<Room>
     * @throws SQLException
     */
    public ArrayList<Item> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> item = new ArrayList<Item>();
        SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        String sql = "Select * from Item";

        ResultSet rs = sdb.queryDB(sql);

        while (rs.next()) {
            Item it = new Item();
            it.setItemID(rs.getInt("itemID"));
            it.setItemName(rs.getString("itemName"));
            it.setItemDescription(rs.getString("itemDescription"));
            

            it.setItemLocation(rs.getString("itemLocation"));
            it.setItemRoomLocation(rs.getInt("itemRoomLocation"));
            it.setItemUse(rs.getString("itemUse"));
            it.setItemAttributes(rs.getInt("itemAttributes"));
            it.setItem_restriction(rs.getString("item_restriction"));
            it.setItemCommand(rs.getString("itemCommand"));
            
            item.add(it);
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return item;
    }

	
	
}