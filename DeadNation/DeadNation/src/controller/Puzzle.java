package controller;

import model.ExitDB;
import model.PuzzleDB;

public class Puzzle {
    private int exitID;
    private int itemID;
    public int getExitID() {return exitID;}
    public void setExitID(int exitID) {this.exitID = exitID;}
    public int getItemID() {return itemID;}
    public void setItemID(int itemID) {this.itemID = itemID;}
    @Override
    public String toString() {
        return "Puzzle{" +
                "exitID=" + exitID +
                ", itemID=" + itemID +
                '}';
    }
    public boolean validPuzzleSolved(String itemName) {
        PuzzleDB puzzleDB = new PuzzleDB();
        if (puzzleDB.validatePuzzleSolved(this, itemName)){
            puzzleSolve();
            return true;
        }
        else{return false;}
    }

    public void puzzleSolve() {
        ExitDB exitDB = new ExitDB();
        exitDB.exitUnblocked(getExitID());
    }
}
