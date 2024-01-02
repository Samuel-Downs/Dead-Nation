package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.PlayerDB;
import model.RoomDB;
import controller.Item;

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
    private int roomID;
    private String roomName;
//    private String roomDescription; 
    private ArrayList<Exit> exits;  
    private int visited;

    private String notVisitedText;
    private String visitedText;
    
    private ArrayList<Item> item;

    private Monster monster;



	/**
	 * @return the monster
	 */
	public Monster getMonster() {
		return monster;
	}

	/**
	 * @param monster the monster to set
	 */
	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	/**
	 * @return the item
	 */
	public ArrayList<Item> getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	/**
	 * @return the notVisitedText
	 */
	public String getNotVisitedText() {
		return notVisitedText;
	}

	/**
	 * @return the visitedText
	 */
	public String getVisitedText() {
		return visitedText;
	}

	/**
	 * @param notVisitedText the notVisitedText to set
	 */
	public void setNotVisitedText(String notVisitedText) {
		this.notVisitedText = notVisitedText;
	}

	/**
	 * @param visitedText the visitedText to set
	 */
	public void setVisitedText(String visitedText) {
		this.visitedText = visitedText;
	}

	/**
     * Constructor: Room
     */
    public Room() {
    	exits = new ArrayList<>();
    	item = new ArrayList<>();
    	monster = new Monster();
    }
    


    /**
     * Method: getRoom
     * Purpose: Retrieves a room based upon the supplied ID
     * @param id
     * @return Room
     * @throws SQLException
     */
    public Room getRoom(int id) throws GameException {
        RoomDB rdb = new RoomDB();
        Room rm = rdb.getRoom(id);
        return rm;
    }
    
    /** Method: getAllRooms
    * Purpose: Retrieves all room from database
    * @param id
    * @return Room
    * @throws SQLException
    */
    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException {
        RoomDB rdb = new RoomDB();
        return rdb.getAllRooms();
    }

    
    
    /**
     * Method: getRoomID
     * @return the roomID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * Method: setRoomID
     * @param roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * Method: getRoomName
     * @return the roonavigatemName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Method: setRoomName
     * @param roomName the roomName to set
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Method: getRoomDescription
     * @return the roomDescription
     */


    /**
     * Method: getExits
     * @return the exits
     */
    public ArrayList<Exit> getExits() {
        return exits;
    }

    /**
     * Method: setExits
     * @param exits the exits to set
     */
    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }
    
    
    /**
     * Method: getVisited
	 * @return the visited
	 */
	public int getVisited() {
		return visited;
	}

	/**
	 * Method: setVisited
	 * @param visited the visited to set
	 */
	public void setVisited(int visited) {
		this.visited = visited;
	}

    /**
     * Method: getNewString
     * This method to modify the toString method to print out to the 
     * modify toString roomDescribtion
	 * @return the newString
	 */
    public String getNewString()
    {    	
    	String newString = "";
    	String[] splitStr = notVisitedText.split("\\|");
    	for(String st : splitStr)
    	{
    		newString += st + "\n";
    	}
    
    	return newString;
    	
    	
  
    }
    
    /**
     * Method: modifyExitToString
     * This method to modify the toString method to print out to the 
     * modify toString exits
	 * @return the newString
	 */
    public String modifyExitToString(ArrayList<Exit> exits)
    {
    	String newString = "You can go " ;
    	if(exits.size()==1) {
    		newString += exits.get(0);
    		return newString;
    	}
    	else {
    		for(int i = 0; i <exits.size(); i++)
    		{
    			if(i < exits.size()-1) {
    			newString += exits.get(i) + "or ";
    			}
    			else {
    				newString += exits.get(i);
    			}
    		}
    		return newString;
    	}

    
    	
    }
    
    
    //modify the visited room or not
    /**
     * Method: isVisited
     * This method to modify the toString method to print out to the 
     * modify toString if the player was been in the room or not
	 * @return the newString
	 */
    public String isVisited(String roomName)
    {
    	String newString = "";
    	
    	if(visited < 1){
    		newString = roomName + " Not Visited";
    	}
    	else {
    		newString = roomName + " Visited";
    	}
    
    	return newString;
    }
    
    


    
   
    /**
     * Method: toString
     * @return
     */
    @Override
    public String toString() {

		return "ID = " + roomID + "\n" + isVisited(roomName) + "\n" + getNewString()
        + modifyExitToString(exits) + "\n" +item + "\n" + monster;
        
    }

    


	/// Check the room is avaible in Room class
    /**
     * Method: navigataion
     * @param move
     * @return a Room if the player enter a valid command
     * @throws GameException
     */
    public Room navigation(String move) throws GameException {

    	Room current = this;
    	boolean found = false;
    	


    	for (Exit exit : exits)     	
    	{	
    		if (exit.getDirection().equalsIgnoreCase(move)) {
    			found = true;
    			//set current to new room call DB to get destination room
    			current = getRoom(exit.getDestination());
    			
    		} 
    	}
    	
    	if (!found) {
    		throw new GameException("Invalid direction entered");
    	}
    	return current;
    }

    
    
   



    /**
     * Method: updateRoom
     * Purpose: when player enter a valid command, it will update current room to the database 
     * and update visited flag
     * @throws SQLException, ClassNotFoundException, GameException
     */
	public void updateRoom() throws SQLException, ClassNotFoundException, GameException {
    	
    	RoomDB rdb = new RoomDB();
    	if(roomID == 1) { //this will be update the visited for room 1 because the player start playing at room 1.
    		visited = 2;
        	rdb.updateRoom(this);
    	}
    	

    	visited += 1;
    	rdb.updateRoom(this);
        
        
    }




}    



