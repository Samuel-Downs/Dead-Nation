package controller;

import exceptions.ExitBlockedException;
import model.ExitDB;
import model.PlayerDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private Boolean exitBlock;

    private String directionText;

    private String DirectionPuzzleTet;

    public int getExitID() {return exitID;}

    public void setExitID(int exitID) {this.exitID = exitID;}

    public int getRoomID() {return roomID;}

    public void setRoomID(int roomID) {this.roomID = roomID;}

    public String getDirection() {return direction;}

    public void setDirection(String direction) {this.direction = direction;}

    public int getDestination() {return destination;}

    public void setDestination(int destination) {this.destination = destination;}

    public boolean getExitBlock() {return exitBlock;}

    public void setExitBlock(int exitBlock) {
        if (exitBlock == 0){this.exitBlock = false;}
        else{this.exitBlock = true;}
    }

    public String getDirectionText() {return directionText;}

    public void setDirectionText(String directionText) {this.directionText = directionText;}

    public String getDirectionPuzzleTet() {return DirectionPuzzleTet;}

    public void setDirectionPuzzleTet(String directionPuzzleTet) {DirectionPuzzleTet = directionPuzzleTet;}


    @Override
    public String toString() {
        return "Exit{" +
                "exitID=" + exitID +
                ", roomID=" + roomID +
                ", direction='" + direction + '\'' +
                ", destination=" + destination +
                ", exitBlock=" + exitBlock +
                ", directionText='" + directionText + '\'' +
                ", DirectionPuzzleTet='" + DirectionPuzzleTet + '\'' +
                '}';
    }

    /**
     * Method buildExit
     * Builds an Exit from the String provided
     * throws an exception for an invalid exit
     * You can replace this with a constructor that takes a String and parses into the Exit.
     * @param ex - String containing the information for the exit
     */
    public void buildExit(String ex) throws GameException {
        // TODO - implement Exit.buildExit
        throw new UnsupportedOperationException();
    }

    public ArrayList<String> getPossibleDirection(Room room) throws GameException {
        ExitDB exitDB = new ExitDB();
        ArrayList<Exit> exits = exitDB.getExitsInformation(room.getRoomID());
        ArrayList<String> possibleDirections = new ArrayList<>();
        for(Exit e: exits){
            possibleDirections.add(e.getDirection());
        }
        return possibleDirections;
    }

    public String validMove(String direction, Room room) throws GameException, ExitBlockedException, SQLException, ClassNotFoundException {
        if (getPossibleDirection(room).contains(direction)){
            ExitDB exitDB = new ExitDB();
            Exit exit = exitDB.getExit(direction, room);
            if (!exit.getExitBlock()){
                Monster monster = new Monster();
                if (monster.isMonsterInRoom(exit.getDestination())){
                    return "Combat" + exit.getDestination();
                }
                else{
                    PlayerDB playerDB = new PlayerDB();
                    playerDB.changeRoom(exit.getDestination());
                    return exit.getDirectionText();
                }
            }
            else {return exit.getDirectionPuzzleTet();}
            }
        else{throw new GameException("Invalid Direction");}
        }
    }
