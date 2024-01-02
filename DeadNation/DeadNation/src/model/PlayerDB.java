package model;



import controller.GameException;
import controller.Item;
import controller.Player;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayerDB {
    private SQLiteDB sdb;

    public Player getPlayer() {
        try {
            Player player = new Player();
            ResultSet currPlayer = sdb.queryDB("Select * from Player");
            player.setPlayerHealth(currPlayer.getInt("player_Health"));
            player.setCurRoom(currPlayer.getInt("current_Room"));
            int itemID = currPlayer.getInt("equipped_ItemID");
            ItemDB itemDB = new ItemDB();
            sdb.close();
            player.setEquippedItem(itemDB.getItem(itemID));
            sdb.close();
            return player;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (GameException e) {
            throw new RuntimeException(e);
        }
    }
    public void changeEquipItem(Item itemToEquip) {
        try {
            sdb.updateDB("UPDATE Player set equipped_ItemID = " + itemToEquip.getItemID());
            sdb.close();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    public void healToFull() {
        try {
            sdb.updateDB("UPDATE Player set player_Health = 20");
            sdb.close();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
    }
    public void reducePlayerHealth(int monsterDamage) {
        try {
            PlayerDB playerDB = new PlayerDB();
            Player player = playerDB.getPlayer();
            int reducedHealth = player.getPlayerHealth()-monsterDamage;
            sdb.updateDB("UPDATE Player set player_Health = " + reducedHealth);
            sdb.close();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
    }

    public void changeRoom(int roomID) {
        try {
            sdb.updateDB("UPDATE Player set current_Room = " + roomID);
            sdb.close();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
    }
}
