package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MonsterDB;

/**
 * Class : Monster.java
 * @author: Team 1
 * @version: 1
 * Course: ITEC 3860
 * Written: Nov 2, 2022
 * This class is the Monster class handling business logic for the Monster class
 */

public class Monster {
	   private int monsterID;
	    private String monsterName;
	    private int monsterHealth;
	    private int monsterDamage;
	    private int monsterLocationID;
	    private boolean monsterDefeated;

	    /**
	     * Constructor: Monster
	     */
	    public Monster() {
	        MonsterDB mdb = new MonsterDB();
	        try {
	            monsterID = mdb.getNextMonsterID();
	        } catch (SQLException sqe) {
	            System.out.println(sqe.getMessage());
	        }
	    }

	    /**
	     * Method: getMonster
	     * Purpose: Gets a specified monster from the Monster table
	     * @param id
	     * @return Monster
	     * @throws SQLException
	     * @throws GameException 
	     */
	    public Monster getMonster(int id) throws SQLException, ClassNotFoundException, GameException {
	        MonsterDB mdb = new MonsterDB();
	        return mdb.getMonster(id);
	    }

	    /**
	     * Method: getAllMonsters
	     * Purpose: gets all monsters from the Monster table
	     * @return ArrayList<Monster>
	     * @throws SQLException
	     */
	    public ArrayList<Monster> getAllMonsters() throws SQLException, ClassNotFoundException {
	        MonsterDB mdb = new MonsterDB();
	        return mdb.getAllMonsters();
	    }

		/**
		 * @return the monsterID
		 */
		public int getMonsterID() {
			return monsterID;
		}

		/**
		 * @return the monsterName
		 */
		public String getMonsterName() {
			return monsterName;
		}

		/**
		 * @return the monsterHealth
		 */
		public int getMonsterHealth() {
			return monsterHealth;
		}

		/**
		 * @return the monsterDamage
		 */
		public int getMonsterDamage() {
			return monsterDamage;
		}

		/**
		 * @return the monsterLocationID
		 */
		public int getMonsterLocationID() {
			return monsterLocationID;
		}

		/**
		 * @return the monsterDefeated
		 */
		public boolean isMonsterDefeated() {
			return monsterDefeated;
		}

		/**
		 * @param monsterID the monsterID to set
		 */
		public void setMonsterID(int monsterID) {
			this.monsterID = monsterID;
		}

		/**
		 * @param monsterName the monsterName to set
		 */
		public void setMonsterName(String monsterName) {
			this.monsterName = monsterName;
		}

		/**
		 * @param monsterHealth the monsterHealth to set
		 */
		public void setMonsterHealth(int monsterHealth) {
			this.monsterHealth = monsterHealth;
		}

		/**
		 * @param monsterDamage the monsterDamage to set
		 */
		public void setMonsterDamage(int monsterDamage) {
			this.monsterDamage = monsterDamage;
		}

		/**
		 * @param monsterLocationID the monsterLocationID to set
		 */
		public void setMonsterLocationID(int monsterLocationID) {
			this.monsterLocationID = monsterLocationID;
		}

		/**
		 * @param monsterDefeated the monsterDefeated to set
		 */
		public void setMonsterDefeated(boolean monsterDefeated) {
			this.monsterDefeated = monsterDefeated;
		}

		@Override
		public String toString() {
			Room rm = new Room();
			if(rm.getRoomID() == monsterLocationID) 
			{
			return "You have to fight the monster " + monsterName + " in room "
					+ monsterLocationID + "\n";
			}
			else {
				return "No monster room";
			}
		}

	
		
		
}
