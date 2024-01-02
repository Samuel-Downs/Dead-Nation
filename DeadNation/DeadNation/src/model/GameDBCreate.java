package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

import controller.GameController;
import controller.GameException;

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
    SQLiteDB sdb;
    private String dbName;

    public GameDBCreate() {
        dbName = "DeadNation.db";
    }

    public GameDBCreate(String dbName) {
        this.dbName = dbName;
    }

    /**
     * Method: buildTables
     * Purpose: Build all tables
     * @return void
     * @throws SQLException
     */
    public void buildTables() throws SQLException, ClassNotFoundException, GameException {
        buildRoom();
        buildPuzzleItem();
        buildPlayer();
        buildMonster();
        buildItem();
        buildExitDB();
    }

    /**
     * Method: buildRoom
     * Purpose: Build the controller.Room table and load data
     * @return void
     * @throws SQLException
     */
    public void buildRoom() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);

        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/Room.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }
    public void buildPuzzleItem() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);

        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/PuzzleItem.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }


    public void buildPlayer() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);

        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/Player.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }


    public void buildMonster() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);
        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/Monster.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }


    public void buildItem() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);

        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/Item.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }

    public void buildExitDB() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);

        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/ExitDB.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }

    public void buildAccount() throws SQLException, ClassNotFoundException, GameException {
        sdb =  new SQLiteDB(dbName);

        FileReader fr;
        try {
            fr = new FileReader("dmlFiles/Account.txt");
            Scanner inFile = new Scanner(fr);
            while (inFile.hasNextLine()) {
                String sql = inFile.nextLine();
                sdb.updateDB(sql);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new GameException("room.txt was not found");
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
    }












    }