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
    private String monsterDescription;
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
     */
    public Monster getMonster(int id) throws SQLException, ClassNotFoundException {
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

    public int getMonsterID() {
        return monsterID;
    }
    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }
    public String getMonsterName() {
        return monsterName;
    }
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    public String getMonsterDescription() {
        return monsterDescription;
    }
    public void setMonsterDescription(String monsterDescription) {
        this.monsterDescription = monsterDescription;
    }
    public int getMonsterHealth() {
        return monsterHealth;
    }
    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }
    public int getMonsterDamage() {
        return monsterDamage;
    }
    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }
    public int getMonsterLocationID() {
        return monsterLocationID;
    }
    public void setMonsterLocationID(int monsterLocationID) {
        this.monsterLocationID = monsterLocationID;
    }
    public void setMonsterDefeated(int monsterDefeated) {
        if(monsterDefeated == 1) {
          this.monsterDefeated = true;
        }
        else
            this.monsterDefeated = false;
    }



    public boolean isMonsterDefeated() {
        return monsterDefeated;
    }



    public boolean isMonsterInRoom(int destinationRoomID) {
        return true;
    }

    public void monsterController(String input, int roomID) {

    }

    public void playerHitMonster(int playerDamage, int monsterID) {

    }

    public void monsterIsDead(int monsterID) {

    }

    public void monsterAttack(int monsterDamage) {

    }
}