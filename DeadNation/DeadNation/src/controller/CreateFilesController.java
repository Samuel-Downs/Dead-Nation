package controller;

import java.sql.SQLException;

import model.GameDBCreate;

/**
 * Class : CreateFilesController.java
 * @author: Team 1
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Nov 2, 2022
 * This class calls into the model to build the database if it doesn't exist.
 */
public class CreateFilesController {

    /**
     * Method: createFile
     * Purpose: Create the database for GameDB
     * @return void
     */
    public void createFile() throws GameException{
        try {
            GameDBCreate sdb = new GameDBCreate();
            sdb.buildTables();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("Creation failed");
        }
    }
    /**
     * Method: createFile
     * Purpose: Create the database for GameDB
     * @return void
     */
    public void createFile(String dbName) throws GameException{
        try {
            GameDBCreate sdb = new GameDBCreate(dbName);
            sdb.buildTables();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("Creation failed");
        }
    }


}

