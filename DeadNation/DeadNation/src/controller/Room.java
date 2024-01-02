package controller;

import exceptions.ExitBlockedException;
import model.PlayerDB;
import model.RoomDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.SQLException;


/**
 * Class: Room
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
 * This class – handles the Room interactions. This class contains the roomID, name, description
 * ArrayList Exit as well as a boolean value to determine if the user has visited the room.
 * Items are retrieved in RoomDB and not maintained in the Room.
 * Exits are retrieved in RoomDB and are maintained in the Room class for performance reasons.
 */
public class Room {
    private RoomDB rdb;
    private int roomID;
    private String roomName;
    private String alreadyVisitedText;
    private String newlyVisitedText;
    private Collection<Exit> exits;
    private boolean visited;
    public String getAlreadyVisitedText() {return alreadyVisitedText;}
    public void setAlreadyVisitedText(String alreadyVisitedText) {this.alreadyVisitedText = alreadyVisitedText;}
    public String getNewlyVisitedText() {return newlyVisitedText;}
    public void setNewlyVisitedText(String newlyVisitedText) {this.newlyVisitedText = newlyVisitedText;}
    public int getRoomID() {return this.roomID;}
    public void setRoomID(int roomID) {this.roomID = roomID;}
    public String getRoomName() {return roomName;}
    public void setRoomName(String roomName) {this.roomName = roomName;}
    public Collection<Exit> getExits() {return exits;}
    public void setExits(Collection<Exit> exits) {this.exits = exits;}
    public boolean isVisited() {return this.visited;}
    public void setVisited(int visited) {
        if (visited == 0){this.visited = false;}
        else{this.visited = true;}}



    /**
     * Method Room
     * Constructor for the Room class
     * Initializes exits and items ArrayLists and gets the current map.
     */
    public Room() throws GameException {
//        // TODO - implement Room.Room
//        exits = new ArrayList<>();
//        throw new UnsupportedOperationException();
    }

    /**
     * Room constructor
     * constructs the room object with the given ID
     * @param id id of the room to be constructed
     */
    public Room(int id) throws GameException {
        this.roomID = id;
        // TODO - implement Room.Room
        throw new UnsupportedOperationException();
    }

    /**
     * Method retrieveByID
     * Retrieves the requested Room from RoomDB. Sets its values into the current Room and returns it
     * @param id ID of the room to retrieve
     * @return Room - the requested Room
     * @throws GameException if the room cannot be found
     */
    public Room getRoom(int id) throws GameException, SQLException, ClassNotFoundException {
        return rdb.getRoom(id);
    }

    /** Method: getAllRooms
     * Purpose: Retrieves all room from database
     * @return Room
     * @throws SQLException
     */
    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException, GameException {
        RoomDB rdb = new RoomDB();
        return rdb.getAllRooms();
    }

    /**
     * Method display
     * Builds a String representation of the current room
     * Calls buildItems, buildDescription, and displayExits to build this String
     * @return String - the current room display String
     * @throws GameException if the Item String cannot be built
     */
    public String display() throws GameException {
        try {
            Player player = new Player();
            Room room = getRoom(player.getPlayer().getCurRoom());
            return buildDescription(room) + "\n" + buildItems(room) + "\n" + displayExits(room);
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new GameException("There's no description for the current room?");
        }
    }

    /**
     * Method buildDescription
     * Builds a String of the description
     * @return String - the current room description text
     */
    private String buildDescription(Room room) {
        return room.getRoomName() + "\n" + modifyVisitedText(room.isVisited());
    }

    /**
     * Method buildItems
     * Builds a String of the items in the room
     * @return String - the current room items text
     * @throws GameException if an error retrieving items
     */
    private String buildItems(Room room) throws GameException {
        String itemsInRoom = "";
        ArrayList<Item> itemsInRoomList = getRoomItems(room);
        if (itemsInRoomList.size() != 0) {
            itemsInRoom = "The list of items in the current room are: ";
            for (Item i : itemsInRoomList) {
                itemsInRoom += "\n" + i;
            }
        }
        return itemsInRoom;
    }

    /**
     * Method removeItem
     * Removes an item from the room. Removes it and calls updateRoom to save the changes
     * @param item - the Item to remove
     */
    public void removeItem(Item item) throws GameException {
        // TODO - implement Room.removeItem
        throw new UnsupportedOperationException();
    }


    /**
     * Method displayExits
     * Builds a String of the exits in the room
     * @return String - the current room exits text
     */
    private String displayExits(Room room) {
        String exitsString = "The list of directions you can go are: ";
        Collection<Exit> exitsInRoom = room.getExits();
        for (Exit e:exitsInRoom){
            exitsString += "\n" + e.getDirection();
        }
        return exitsString;
    }


    /**
     * Method: getRoomItems
     * This method calls RoomDB to get the items that are in the current room.
     * @return ArrayList Item - the items in the room
     * @throws GameException if the list of items cannot be built
     */
    public ArrayList<Item> getRoomItems(Room room) throws GameException {
        Item item = new Item();
        return item.itemsInCurrRoom(room);
    }


    public String modifyVisitedText(boolean visited){
        if(!visited){ return newlyVisitedText; }
        else { return alreadyVisitedText; }
    }

    public String navigation(String input) throws SQLException, ClassNotFoundException, GameException, ExitBlockedException {
        Player player = new Player();
        Exit exit = new Exit();
        return exit.validMove(input, getRoom(player.getCurRoom()));
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomID=" + roomID +
                ", name='" + roomName + '\'' +
                modifyVisitedText(visited) + '\'' +
                ", exits=" + exits +
                ", visited=" + visited +
                ", rdb=" + rdb +
                '}';
    }




}
