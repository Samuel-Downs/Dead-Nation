package model;

import controller.GameController;
import controller.GameException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class : GameDBCreate
 * @author: Team 1
 * @version: 1.0
 * Course:
 * Written: Nov 2, 2022
 * This class creates the Game db if it doesn't exist
 * Purpose: Allows the Game test program to create a DB if not there
 */

public class GameDBCreate {
	String miniDB = "DeadNation.db";
    SQLiteDB sdb;

    /**
     * Method: buildTables
     * Purpose: Build all tables
     *
     * @return void
     * @throws SQLException
     */
    public void buildTables() throws GameException {
        buildRoom();        
        buildPuzzleItem();
        buildPlayer();       
        buildMonster();
        
        buildItem();
        buildExitDB();
    }

    /**
     * Method: buildRoom
     * Purpose: Build the Room table and load data
     *
     * @return void
     * @throws SQLException
     */
    public void buildRoom() throws GameException {
        try {
            sdb = new SQLiteDB(miniDB);

            FileReader fr;
            try {
                fr = new FileReader("src/Room.txt");
                Scanner inFile = new Scanner(fr);
                while (inFile.hasNextLine()) {
                    String sql = inFile.nextLine();
                    sdb.updateDB(sql);
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating table Room");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    
    /**
     * Method: buildRoom
     * Purpose: Build the Room table and load data
     *
     * @return void
     * @throws SQLException
     */
    public void buildPuzzleItem() throws GameException {
        try {
            sdb = new SQLiteDB(miniDB);

            FileReader fr;
            try {
                fr = new FileReader("src/PuzzleItem.txt");
                Scanner inFile = new Scanner(fr);
                while (inFile.hasNextLine()) {
                    String sql = inFile.nextLine();
                    sdb.updateDB(sql);
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating table PuzzleItem");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    
    
    /**
     * Method: buildRoom
     * Purpose: Build the Room table and load data
     *
     * @return void
     * @throws SQLException
     */
    public void buildPlayer() throws GameException {
        try {
            sdb = new SQLiteDB(miniDB);

            FileReader fr;
            try {
                fr = new FileReader("src/Player.txt");
                Scanner inFile = new Scanner(fr);
                while (inFile.hasNextLine()) {
                    String sql = inFile.nextLine();
                    sdb.updateDB(sql);
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating table Player");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    
    
    public void buildMonster() throws GameException {
        try {
            sdb = new SQLiteDB(miniDB);

            FileReader fr;
            try {
                fr = new FileReader("src/Monster.txt");
                Scanner inFile = new Scanner(fr);
                while (inFile.hasNextLine()) {
                    String sql = inFile.nextLine();
                    sdb.updateDB(sql);
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating table Monster");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    
    
    
    
    
    public void buildItem() throws GameException {
        try {
            sdb = new SQLiteDB(miniDB);

            FileReader fr;
            try {
                fr = new FileReader("src/Item.txt");
                Scanner inFile = new Scanner(fr);
                while (inFile.hasNextLine()) {
                    String sql = inFile.nextLine();
                    sdb.updateDB(sql);
                }
                inFile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //Close the SQLiteDB connection since SQLite only allows one updater
        } catch (SQLException | ClassNotFoundException ex) {
            throw new GameException("Error creating Item");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    
    
    
    

    /**
     * Method: buildExit
     * Purpose: Build the Item table and load data
     *
     * @return void
     * @throws SQLException
     */
    public void buildExitDB() throws GameException {
        FileReader fr;
        try {
            fr = new FileReader("src/ExitDB.txt");
            sdb = new SQLiteDB(miniDB);
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
            throw new GameException("Error creating table ExitBD");
        }
        finally {
            if (sdb != null) {
                try {
                    //Close the SQLiteDB connection since SQLite only allows one updater
                    sdb.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    /**
     * Method: buildPlayer
     * Purpose: Builds the Player table and loads a phantom record
     *
     * @return void
     * @throws GameException
     */
//    public void buildPlayer() throws GameException {
//        try {
//            sdb = new SQLiteDB(miniDB);
//            String sql = "CREATE TABLE Player(playerID int not Null, playerName text not null, currentRoom int not null)";
//            sdb.updateDB(sql);
//            sql = "INSERT INTO Player(playerID, playerName, currentRoom) Values(1, 'Fred', 1)";
//            sdb.updateDB(sql);
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            throw new GameException("Error creating table Player");
//        }
//        finally {
//            if (sdb != null) {
//                try {
//                    //Close the SQLiteDB connection since SQLite only allows one updater
//                    sdb.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
}
