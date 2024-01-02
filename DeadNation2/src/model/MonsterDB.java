package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.GameException;
import controller.Monster;

/**
 * Class : MonsterDB.java
 * @author: Team 1
 * @version: 1.0
 * Course: ITEC 3860
 * Written: Nov 2, 2022
 * This class handles all database access for the Monster class
 */
public class MonsterDB {
    /**
     * Method: getNextMonsterID
     * Purpose: Gets the id for the next monster.
     * @return int
     */
    public int getNextMonsterID() throws SQLException {
        SQLiteDB sdb = null;
        try {
            sdb = new SQLiteDB();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        int next = sdb.getMaxValue("MonsterID", "Monster") + 1;
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return next;
    }

    /**
     * Method: getMonster
     * Purpose: handles db interactions to retrieve a single Monster
     * @param id
     * @return Monster
     * @throws SQLException
     * @throws GameException 
     */
    public Monster getMonster(int id) throws SQLException, ClassNotFoundException, GameException {
		Monster mt = null;
    	try {
    	SQLiteDB sdb = new SQLiteDB("DeadNation.db");
        mt = new Monster();
        String sql = "Select * from Room WHERE MonsterID = "+ id;
        ResultSet rs = sdb.queryDB(sql);
        

       if (rs.next()) {
           mt.setMonsterID(rs.getInt("monsterID"));
           mt.setMonsterName(rs.getString("monsterName"));
           mt.setMonsterHealth(rs.getInt("monsterHealth"));
           mt.setMonsterDamage(rs.getInt("maxDamage"));
           mt.setMonsterLocationID(rs.getInt("monsterLocationID"));
           if(rs.getInt("isDefeated")<1)
           {
           	mt.setMonsterDefeated(false);
           }
           else {
           	mt.setMonsterDefeated(true);
           }
            
       }
            
            
            else {
                throw new GameException("Monster " + id + " not found");
            }
            //Close the SQLiteDB connection since SQLite only allows one updater
            sdb.close();
        	}
        	catch (SQLException | ClassNotFoundException e ) {
        		throw new GameException("Monster " + id + " not found");
        	}
            return mt;
        }            

    /**
     * Method: getAllMonsters
     * Purpose: Handles the DB interactions to retrieve all monsters
     * @return ArrayList<Monster>
     * @throws SQLException
     */
    public ArrayList<Monster> getAllMonsters() throws SQLException, ClassNotFoundException {
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        SQLiteDB sdb = new SQLiteDB();
        String sql = "Select * from Monster";

        ResultSet rs = sdb.queryDB(sql);

        while (rs.next()) {
            Monster mon = new Monster();
            mon.setMonsterID(rs.getInt("monsterID"));
            mon.setMonsterName(rs.getString("monsterName"));
            mon.setMonsterHealth(rs.getInt("monsterHealth"));
            mon.setMonsterDamage(rs.getInt("maxDamage"));
            mon.setMonsterLocationID(rs.getInt("monsterLocationID"));
            if(rs.getInt("isDefeated")<1)
            {
            	mon.setMonsterDefeated(false);
            }
            else {
            	mon.setMonsterDefeated(true);
            }
            monsters.add(mon);
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return monsters;
    }
}
