package model;

import controller.Exit;
import controller.GameException;
import controller.Room;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ExitDB {

    public ArrayList<Exit> getExitsInformation(int roomID){
        try {
            SQLiteDB sqLiteDB = new SQLiteDB();
            ResultSet exitIDs = sqLiteDB.queryDB("select ExitID from ExitDB where ExitDB_RoomID = \"" + roomID + "\"");
            ArrayList exitIDList = new ArrayList();
            while (exitIDs.next()){exitIDList.add(exitIDs.getInt("exitID"));}
            sqLiteDB.close();
            ArrayList<Exit> exitList = new ArrayList<>();
            for (int i = 0; i < exitIDList.size(); i++){
                Exit exit = new Exit();
                ResultSet exitInformation = sqLiteDB.queryDB("Select * from ExitDB where exitID = \"" + (Integer)exitIDList.get(i) + "\"");
                exit.setRoomID(exitInformation.getInt("ExitDB_RoomID"));
                exit.setDirection(exitInformation.getString("Direction"));
                exit.setDestination(exitInformation.getInt("DestinationID"));
                exit.setExitID(exitInformation.getInt("ExitDBID"));
                exit.setExitBlock(exitInformation.getInt("ExitDB_Blocked"));
                exit.setDirectionText(exitInformation.getString("DirectionText"));
                exit.setDirectionPuzzleTet(exitInformation.getString("DirectionPuzzleText"));
                exitList.add(exit);
                sqLiteDB.close();
            }
            return exitList;
        }
        catch (Exception e){
        }
        throw new UnsupportedOperationException();
    }

    public void exitUnblocked(int exitID){


    }
    public Exit getExit(String direction, Room room) throws GameException {
        try {
            SQLiteDB sqLiteDB = new SQLiteDB();
            Exit exit = new Exit();
            ResultSet exitInformation = sqLiteDB.queryDB("Select * from ExitDB where direction = " + direction + " and ExitDB_RoomID = "+ room.getRoomID());
            exit.setRoomID(exitInformation.getInt("ExitDB_RoomID"));
            exit.setDirection(exitInformation.getString("Direction"))
            ;
            exit.setDestination(exitInformation.getInt("DestinationID"));
            exit.setExitID(exitInformation.getInt("ExitDBID"));
            exit.setExitBlock(exitInformation.getInt("ExitDB_Blocked"));
            exit.setDirectionText(exitInformation.getString("DirectionText"));
            exit.setDirectionPuzzleTet(exitInformation.getString("DirectionPuzzleText"));
            sqLiteDB.close();
            return exit;
        }
        catch (Exception e){
            throw new GameException();
        }

    }

}
