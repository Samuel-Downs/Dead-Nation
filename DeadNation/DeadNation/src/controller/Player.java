package controller;


import model.PlayerDB;

import java.util.ArrayList;

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

    private int curRoom;
    private Item equippedItem;
    private int playerHealth;

    public int getCurRoom() {
        return this.curRoom;
    }

    public void setCurRoom(int curRoom) {
        this.curRoom = curRoom;
    }



    public int getPlayerHealth() {return playerHealth;}

    public void setPlayerHealth(int playerHealth) {this.playerHealth = playerHealth;}

    public Item getEquippedItem() {return equippedItem;}
    public void setEquippedItem(Item equippedItem) {this.equippedItem = equippedItem;}


    /**
     * Method Player
     * Constructor for the Player class
     * Creates a new player and sets that player's ID to the first room
     */
    public Player getPlayer() {
        PlayerDB playerDB = new PlayerDB();
        return playerDB.getPlayer();
    }

    /**
     * Method addItem
     * Adds an item to the player's inventory
     * @param it - the Item to add to the inventory
     */
    protected void addItem(Item it) throws GameException {
        // TODO - implement Player.addItem
        throw new UnsupportedOperationException();
    }

    /**
     * Method removeItem
     * Removes an item from the player's inventory
     * @param it - the Item to remove from the inventory
     */
    protected void removeItem(Item it) throws GameException {
        // TODO - implement Player.removeItem
        throw new UnsupportedOperationException();
    }

    /**
     * Method printInventory
     * Returns the String of all items in the player's inventory
     * @return String - the String of the player's inventory
     */
    protected String printInventory() throws GameException {
        ArrayList<Item> inventory = getInventory();
        String inventoryString = "List of Items in Inventory";
        for (int i = 0; i <= inventory.size()-1; i++){inventoryString = inventoryString+inventory.get(i)+"\n";}
        return inventoryString;
    }

    /**
     * Method getInventory
     * @return the ArrayList of the current Items in the player's inventory
     */
    protected ArrayList<Item> getInventory() throws GameException {
        Item item = new Item();
        return item.currentInventory();
    }

}