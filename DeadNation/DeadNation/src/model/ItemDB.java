package model;

import controller.GameException;
import controller.Item;
import controller.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    SQLiteDB sdb;

//    /**
//     * ItemDB constructor
//     */
//    public ItemDB() throws GameException {
//        // TODO - implement ItemDB.ItemDB
//        throw new UnsupportedOperationException();
//    }

    /**
     * Method getItem
     * Returns the Item requested by the ID. Only used in readRooms
     * @param id - the ID of the item requested.
     * @return void
     * @throws GameException if the item ID cannot be found
     */
    public Item getItem(int id) throws GameException {
        // TODO - implement ItemDB.getItem
        Item im = null;
        try {
            im = new Item();
            String sql = "Select * from Room WHERE roomID = " + id;
            ResultSet rs = sdb.queryDB(sql);

            if (rs.next()) {
                im.setItemID(rs.getInt("itemID"));
                im.setItemName(rs.getString("itemName"));
                im.setItemDescription(rs.getString("itemDescription"));
                im.setItemLocation(rs.getString("itemLocation"));
                im.setItemRoomLocation(rs.getInt("itemRoomLocation"));
                im.setItemUse(rs.getString("itemUse"));
                im.setItemAttributes(rs.getInt("itemAttributes"));
                im.setItemRestriction(rs.getString("item_restriction"));
                im.setItemCommand(rs.getString("itemCommand"));
                sdb.close();
                return im;
            }
            else {
                sdb.close();
                throw new GameException("item " + id + " not found");
            }
        }
        catch (SQLException e ) {throw new GameException("Item " + id + " not found");}
    }
    public Item getItemFromName(String itemName) throws GameException {
        try {
            Item item = new Item();
            String sql = "Select * from Room WHERE itemName = " + itemName;
            ResultSet rs = sdb.queryDB(sql);
            item.setItemID(rs.getInt("itemID"));
            item.setItemName(rs.getString("itemName"));
            item.setItemDescription(rs.getString("itemDescription"));
            item.setItemLocation(rs.getString("itemLocation"));
            item.setItemRoomLocation(rs.getInt("itemRoomLocation"));
            item.setItemUse(rs.getString("itemUse"));
            item.setItemAttributes(rs.getInt("itemAttributes"));
            item.setItemRestriction(rs.getString("item_restriction"));
            item.setItemCommand(rs.getString("itemCommand"));
            sdb.close();
            return item;
        }
        catch (SQLException e ) {throw new GameException(itemName + " not found");}
    }





    public String currentlyEquipped() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Item> getInventory() {

        throw new UnsupportedOperationException();
    }

    public void changeEquipment(String itemName) {
        PlayerDB playerDB = new PlayerDB();
        Player player = playerDB.getPlayer();
        Item currEqItem = player.getEquippedItem();
        /////////////Later: change the equipped item to inventory and the itemName item to equipped

    }

    public void medkit(String itemName) {
        try {
            PlayerDB playerDB = new PlayerDB();
            playerDB.healToFull();
            deleteItem(itemName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteItem(String itemName) {
        try {
            sdb.queryDB("UPDATE Item set itemLocation = 'd' where itemID = (Select TOP 1 itemID from Item where itemName = " + itemName + " and itemLocation = 'i'");
            sdb.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Item> itemIsInRoom(int roomID) {
        try {
            ArrayList<Item> itemsInRoom = new ArrayList();
            ResultSet items = sdb.queryDB("Select * from Item where itemRoomLocation = " + roomID);
            while (items.next()){
                Item item = new Item();
                item.setItemID(items.getInt("itemID"));
                item.setItemName(items.getString("itemName"));
                item.setItemDescription(items.getString("itemDescription"));
                item.setItemRoomLocation(items.getInt("itemLocation"));
                item.setItemRoomLocation(items.getInt("itemRoomLocation"));
                item.setItemUse(items.getString("itemUse"));
                item.setItemRestriction(items.getString("item_restriction"));
                item.setItemCommand(items.getString("itemCommand"));
                itemsInRoom.add(item);
            }
            sdb.close();
            return itemsInRoom;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void itemIntoInventory(int itemID) {
        try {
            sdb.updateDB("UPDATE Item set itemLocation = i where itemID = " + itemID);
            sdb.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
