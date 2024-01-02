package controller;

import exceptions.AccountInputException;
import model.AccountDB;

public class Account {
    private String userID;
    private String password;
    private Boolean exists;
    private AccountDB accountDB;
    public Boolean getExists() {return exists;}
    public void setExists(Boolean exists) {this.exists = exists;}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createNewAccount(String username, String userPassword) throws AccountInputException {
        if (username.charAt(0)=='@'){throw new AccountInputException("UserName cannot start with @");}
        if (!checkExistAccount(username)){
            accountDB.updateUNPW(username, password);
        }
        else{throw new AccountInputException("Username already exists");}
    }

    public boolean checkExistAccount(String username) {return accountDB.getAccount(username).getExists();}

    public boolean validateLogin(String username, String userPassword) throws AccountInputException {
        Account account = accountDB.getAccount(username);
        if (account.getExists()){
            if (account.getPassword().equals(userPassword)){return true;}
            else{throw new AccountInputException("Wrong Password");}
        }
        else{throw new AccountInputException("Wrong UserName");}
    }
}
