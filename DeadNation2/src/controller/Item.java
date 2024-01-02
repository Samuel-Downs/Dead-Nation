package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ExitDB;
import model.ItemDB;
import model.RoomDB;

/**
 * Class: Item
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
 * This class – Handles Items in the game.
 */


public class Item {
	private int itemID;
	private String itemName;
	private String itemDescription;
	
	private String itemLocation;
	private int itemRoomLocation;
	private String itemUse;
	private int itemAttributes;
	private String item_restriction;
	private String itemCommand;
	
    public Item getItem(int id) throws GameException {
        Item idb = new Item();
        return idb.getItem(id);
    }
	
    /**
     * Method: getAllExits
     * Purpose: gets all exit from the Exits table
     * @return ArrayList<Exit>
     * @throws SQLException
     */
    public ArrayList<Item> getAllItem() throws SQLException, ClassNotFoundException {
        ItemDB mdb = new ItemDB();
        return mdb.getAllItem();
    }
    
    
	/**
	 * @return the itemLocation
	 */
	public String getItemLocation() {
		return itemLocation;
	}

	/**
	 * @return the itemRoomLocation
	 */
	public int getItemRoomLocation() {
		return itemRoomLocation;
	}

	/**
	 * @return the itemUse
	 */
	public String getItemUse() {
		return itemUse;
	}

	/**
	 * @return the itemAttributes
	 */
	public int getItemAttributes() {
		return itemAttributes;
	}

	/**
	 * @return the item_restriction
	 */
	public String getItem_restriction() {
		return item_restriction;
	}

	/**
	 * @return the itemCommand
	 */
	public String getItemCommand() {
		return itemCommand;
	}

	/**
	 * @param itemLocation the itemLocation to set
	 */
	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}

	/**
	 * @param itemRoomLocation the itemRoomLocation to set
	 */
	public void setItemRoomLocation(int itemRoomLocation) {
		this.itemRoomLocation = itemRoomLocation;
	}

	/**
	 * @param itemUse the itemUse to set
	 */
	public void setItemUse(String itemUse) {
		this.itemUse = itemUse;
	}

	/**
	 * @param itemAttributes the itemAttributes to set
	 */
	public void setItemAttributes(int itemAttributes) {
		this.itemAttributes = itemAttributes;
	}

	/**
	 * @param item_restriction the item_restriction to set
	 */
	public void setItem_restriction(String item_restriction) {
		this.item_restriction = item_restriction;
	}

	/**
	 * @param itemCommand the itemCommand to set
	 */
	public void setItemCommand(String itemCommand) {
		this.itemCommand = itemCommand;
	}


	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * Method display
	 * This method returns the itemDescription which is the String that will be displayed in the game
	 * @return the String to display in the game
	 */
	public String display() {
		Room rm = new Room();
		if(itemRoomLocation == rm.getRoomID()) {
			return "\nYou see: " + itemName + " "  + itemDescription + " and you can "+ itemCommand;
		}else {
			return "This room does not have any item";
					
		}
	
	}



	
    /**
     * Method: toString
     * @return
     */
	@Override()
	public String toString() {

			return "\nYou see: " + itemName + " "  + itemDescription + " and you can "+ itemCommand;

					
		
	}

}