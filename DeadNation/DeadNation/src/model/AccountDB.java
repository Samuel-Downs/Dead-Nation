package model;

import controller.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDB {
    public void updateUNPW(String username, String password) {
        try {
            SQLiteDB sqLiteDB = new SQLiteDB();
            sqLiteDB.updateDB("INSERT INTO Account(useName, password) Values(" + username +", " + password+")");
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void copyDB() {

    }

    public Account getAccount(String userName){
        Account rAccount = new Account();
        try {
            SQLiteDB sqLiteDB = new SQLiteDB();
            ResultSet account = sqLiteDB.queryDB("Select * from Account where userName= " + userName);
            rAccount.setUserID(account.getString("userName"));
            rAccount.setPassword(account.getString("password"));
            rAccount.setExists(true);
            sqLiteDB.close();
            return rAccount;
        }
        catch (Exception e){
            rAccount.setExists(false);
            return rAccount;
        }
    }
}
