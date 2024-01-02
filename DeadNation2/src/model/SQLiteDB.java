/**
 * Class : SQLiteDB.java
 *
 * @author: Rick Price
 * @version: 1.0
 * Course: ITEC 3860
 * Written: June 22, 2021
 * This class the base interface to the SQLite database
 * Purpose: Execute queries and updates in the SQLite database
 */
package model;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class : GameDBCreate
 * @author: Team 1
 * @version: 1.0
 * Course:
 * Written: Nov 2, 2022
 * This class – creates the wrapper around SQLite specific initializations.
 */

public class SQLiteDB extends DB {

    /** Constructor: SQLiteDB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public SQLiteDB() throws SQLException, ClassNotFoundException {
        //Build the connection String
        sJdbc = "jdbc:sqlite";
        sDriverName = "org.sqlite.JDBC";
        // register the driver
        Class.forName(sDriverName);
        sDbUrl = sJdbc + ":" + dbName;
        conn = DriverManager.getConnection(sDbUrl);
    }

    /** Constructor: SQLiteDB
     * @param dbName
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public SQLiteDB(String dbName) throws SQLException, ClassNotFoundException {
        //Build the connection String
        sJdbc = "jdbc:sqlite";
        sDriverName = "org.sqlite.JDBC";
        // register the driver
        Class.forName(sDriverName);
        sDbUrl = sJdbc + ":" + dbName;

        this.dbName = dbName;
        conn = DriverManager.getConnection(sDbUrl);
    }
    
    //modify oringal file
    /** Method: close
     * Purpose: Close the database connection
     * @throws SQLException
     * @return void
     */
    public void close() throws SQLException {
        conn.close();
    }
}
