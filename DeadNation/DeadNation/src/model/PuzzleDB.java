package model;

import controller.Puzzle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuzzleDB {

    public Boolean validatePuzzleSolved(Puzzle puzzle, String itemName){
        try {
            SQLiteDB sqLiteDB = new SQLiteDB();
            ResultSet itemNames = sqLiteDB.queryDB("select itemName from Item where itemID in (select itemID in PuzzleItem where exitID = \"" + puzzle.getExitID() + "\"");
            ArrayList<String> itemNameList = new ArrayList<>();
            while (itemNames.next()){itemNameList.add(itemNames.getString("itemName"));}
            if (itemNameList.contains(itemName)){return true;}
            else{return false;}
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e){throw new RuntimeException(e);}
    }
}
