package controller;

import model.ItemDB;

import java.util.ArrayList;

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

    private String itemRestriction;

    private String itemCommand;
    private ItemDB idb = new ItemDB();


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

    public String getItemLocation() {return itemLocation;}

    public void setItemLocation(String itemLocation) {this.itemLocation = itemLocation;}

    public int getItemRoomLocation() {return itemRoomLocation;}

    public void setItemRoomLocation(int itemRoomLocation) {this.itemRoomLocation = itemRoomLocation;}

    public String getItemUse() {return itemUse;}

    public void setItemUse(String itemUse) {this.itemUse = itemUse;}

    public int getItemAttributes() {return itemAttributes;}

    public void setItemAttributes(int itemAttributes) {this.itemAttributes = itemAttributes;}

    public String getItemRestriction() {return itemRestriction;}

    public void setItemRestriction(String itemRestriction) {this.itemRestriction = itemRestriction;}

    public String getItemCommand() {return itemCommand;}

    public void setItemCommand(String itemCommand) {this.itemCommand = itemCommand;}

    /**
     * Method display
     * This method returns the itemDescription which is the String that will be displayed in the game
     * @return the String to display in the game
     */
    public String display() {
        // TODO - implement Item.display
        throw new UnsupportedOperationException();
    }

//    @Override()
//    public String toString() {
//        // TODO - implement Item.toString
//        throw new UnsupportedOperationException();
//    }


    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemLocation='" + itemLocation + '\'' +
                ", itemRoomLocation=" + itemRoomLocation +
                ", itemUse='" + itemUse + '\'' +
                ", itemAttributes=" + itemAttributes +
                ", itemRestriction='" + itemRestriction + '\'' +
                ", itemCommand='" + itemCommand + '\'' +
                '}';
    }

    public ArrayList<Item> currentInventory() {
        return null;
    }

    public String currentInventoryToString() {
        return "";
    }

    public ArrayList<Item> itemsInCurrRoom(Room room){
        return idb.itemIsInRoom(room.getRoomID());
    }

    public void currentEquipment() {

    }

    public void changeCurrentEquipment(String item) {

    }

    public void userItem(String itemName, String input) {

    }

    public void exileItem(String itemName) {

    }

    public void currentEquipmentToString() {

    }

    public String pickUpItem(String item) {
        return "";
    }

    public ArrayList<Item> getItemInRoom(int roomID) {
        return null;
    }

    public void putItemInInventory(int itemID) {

    }


}
