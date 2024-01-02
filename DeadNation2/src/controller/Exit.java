package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ExitDB;

/**
 * Class: Exit
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov 2, 2022
 *
 * This class – contains the Exit information. Allows the user to build an exit to be added to the controller.Room
 */




public class Exit {
    private int exitID;
    private int roomID;
    private String direction;
    private int destination;
    
    private int exitBlock;
	private String directionText;
    private String directionPuzzleText;
    
    
 
    /**
	 * @return the exitBock
	 */
	public int getExitBock() {
		return exitBlock;
	}

	/**
	 * @param exitBock the exitBock to set
	 */
	public void setExitBock(int exitBock) {
		this.exitBlock = exitBock;
	}




    
    
    
    /**
	 * @return the directionText
	 */
	public String getDirectionText() {
		return directionText;
	}

	/**
	 * @return the directionPuzzleText
	 */
	public String getDirectionPuzzleText() {
		return directionPuzzleText;
	}

	/**
	 * @param directionText the directionText to set
	 */
	public void setDirectionText(String directionText) {
		this.directionText = directionText;
	}

	/**
	 * @param directionPuzzleText the directionPuzzleText to set
	 */
	public void setDirectionPuzzleText(String directionPuzzleText) {
		this.directionPuzzleText = directionPuzzleText;
	}

	/**
     * Constructor: Exits
     */
    public Exit() {
    	ExitDB mdb = new ExitDB();
        try {
        	exitID = mdb.getNextExitsID();
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
    }
    
    /**
     * Method: getExit
     * Purpose: Gets a specified exits from the Exits table
     * @param id
     * @return Exit
     * @throws SQLException, ClassNotFoundException
     */
    public Exit getExit(int id) throws SQLException, ClassNotFoundException {
    	Exit mdb = new Exit();
        return mdb.getExit(id);
    }
    
    /**
     * Method: getAllExits
     * Purpose: gets all exit from the Exits table
     * @return ArrayList<Exit>
     * @throws SQLException
     */
    public ArrayList<Exit> getAllExits() throws SQLException, ClassNotFoundException {
        ExitDB mdb = new ExitDB();
        return mdb.getAllExits();
    }
    

	/**
	 * @return the existID
	 */
	public int getExistID() {
		return exitID;
	}

	/**
	 * @return the roomID
	 */
	public int getRoomID() {
		return roomID;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @return the destination
	 */
	public int getDestination() {
		return destination;
	}

	/**
	 * @param existID the existID to set
	 */
	public void setExistID(int existID) {
		this.exitID = existID;
	}

	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(int destination) {
		this.destination = destination;
	}
	

	
    /**
     * Method: toString
     * Purpose: Returns a String of the Exist class
     * @return
     */
	@Override
	public String toString() {
		return direction + "\n" + checkExitBlock();
	}



	
	/// Handdle the exit and the Puzzle
	public String checkExitBlock()
	{
		System.out.println();
		if(exitBlock == 1)
		{
			return "Puzzle Room: "+ directionPuzzleText;
		}
		else {
			return "";
		}
	}
	

    
    
}
