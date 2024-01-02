package controller;

import java.io.IOException;
/**
 * Class: GameException
 * @author Team 1
 * @version 1
 * Course: ITEC 3860 Fall 2022
 * Written: Nov, 2022
 * Handle exception when file can not be read
 */

public class GameException extends IOException{
	public GameException() {
		super();
	}
	
	public GameException(String msg) {
		super(msg);
	}

}
