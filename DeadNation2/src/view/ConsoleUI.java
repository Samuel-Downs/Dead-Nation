package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.GameController;
import controller.GameException;

/**
 * Class : ConsoleUI.java
 * @author: Team 1
 * @version: 4.0
 * Course: ITEC 3860
 * Written: Oct 1, 2022
 * This class is the view component for the Console and player Interface
 */

public class ConsoleUI {
	private static GameController gc;

	
	public static void main(String[] args) throws GameException, ClassNotFoundException {

		gc = new GameController();
		gc.start();
		Scanner input = new Scanner(System.in);



	
		//create account
		//Right now I try to create account by add to Arraylist instead of on Database, sorry I do not have enough time
		// to write my demo for the game is better, I spend time with my teamate and help them write the game 
		// on IntelliJ and they could not compile the game, and I start wring the game on Eclipse.
		ArrayList<String> account = new ArrayList<String>(); 
		
		System.out.println("Enter 1 for create Account, 2 for logIn, 3 see the map, 4 for playing, 5 for exit the game, 6 for save game");
		int userInputNum = input.nextInt();
		
		String userInput;
		
		
		//loop throught every option
		while(userInputNum != 5) 
		{
			if(userInputNum == 1)
			{
				account = createAccount(account);
			}
			
			if(userInputNum == 2)
			{		
				String message = logIn(account);
			}
			
			if(userInputNum == 3)
			{
				printMap();

			}
			
			if(userInputNum == 4)
			{
				playGame();
			}
			
			
			System.out.println("\nEnter 1 for create Account, 2 for logIn, 3 see the map, 4 for playing, 5 for exit the game, 6 for save game");
			userInputNum = input.nextInt();

			
		}
		
	input.close();

	}

	private static void playGame() throws ClassNotFoundException {
		
		Scanner input= new Scanner(System.in);
		System.out.print("\nWelcome to my DeadNation adventure game. You will proceed through rooms based upon your entries.\r\n" + 
				"You can navigate by using the entire direction.\r\n" + 
				"To exit(X) the game, enter X\r\n" + 
				"");
		System.out.println("\nNow, you can type anything EXCEPT \"X\" to start the game");

		String userInput;
		// user input
		userInput = input.nextLine();
		
		
		while ((!userInput.equalsIgnoreCase("X"))) {
			try {
				System.out.println( getRoom(getCurrentRoom()));
				System.out.println("\nWhat would you like to do?");
				userInput = input.nextLine();
				if(userInput.equalsIgnoreCase("x")) {
					break;
				}
				checkRoom(userInput);

			} catch (GameException | SQLException e) {

				System.out.println(e.getMessage());
			}				
		}
		
	}

	/**
	 * Method: Create Account
	 */
	public static ArrayList<String> createAccount(ArrayList<String> account) {
		System.out.println("Enter your user name:  ");
		Scanner input = new Scanner(System.in);
		String command1 = input.nextLine();
		account.add(command1);
		
		System.out.println("Enter your password:");
		String command2 = input.nextLine();
		account.add(command2);
	
		System.out.println("Create account sucessfully");
		
		return account;
	}
	
	/**
	 * Method: login, just make the userInterface more like a game, player can skip log in
	 */
	public static String logIn(ArrayList<String> account) {
		Scanner input = new Scanner(System.in);
		String command = "";
		String userInputl1;
		String userInputl2;
		while(!command.equalsIgnoreCase("x")) 
		{
			System.out.println("Enter your user name: ");
			userInputl1 = input.nextLine();
			command = userInputl1;
			System.out.println("Enter your password: ");
			userInputl2 = input.nextLine();
			
			
			if(account.contains(userInputl1) && account.contains(userInputl2)) {
				System.out.println("LogIn successfully");
				break;
			}
			else 
			{
				System.out.println("Incorrect username or password, reenter your username and passwork \nYou can enter X to exit the game");
			
			}
		}
		
		return "LogIn successfully";
	}
	
	/**
	 * Method: Print the whole Map
	 */
	 public static void printMap() {
			// print all room
			try {
				System.out.println("This is the Map, You can look the Map before you play");
				printStrs(getAllRooms());
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Unbale to print the Room");
			}
			
			System.out.println();
	 }
	
	/**
	 * Method: getAllRooms Purpose: Retreieve all rooms from the database and return
	 * them as a List<String>
	 * 
	 * @param: None
	 * @return: ArrayList<String>
	 */
	private static ArrayList<String> getAllRooms() throws SQLException, ClassNotFoundException {
		return gc.getAllRoomsData();
	}

	/**
	 * Method: getRoom Purpose: Retreieve the room from the database and return it
	 * as a String
	 * 
	 * @param: room
	 * @return: String
	 */
	private static String getRoom(int room) throws GameException {
		return gc.getRoomData(room);
	}

	// call current room
	/**
	 * Method: getCurrentRoom Purpose: Retreieve the currentRoom from the database and return it
	 * as a String
	 * 
	 * @param: player
	 * @return: int
	 */
	private static int getCurrentRoom() throws SQLException, ClassNotFoundException {
		return gc.getCurrentRoomData();
	}
	
	
	
	
	
	/**
	 * Method: getCurrentRoom Purpose: Retreieve the currentRoom from the database and return it
	 * as a String
	 * 
	 * @param: player
	 * @return: int
	 */
	private static String checkRoom(String command) throws SQLException, ClassNotFoundException, GameException {
		return gc.processCommand(command);
	}



	/**
	 * Method: printStrs Purpose: Print the ArrayList of Strings
	 * 
	 * @param strs void
	 * @return void
	 */
	private static void printStrs(ArrayList<String> strs) {
		for (String str : strs) {
			System.out.println(str);
		}
	}




    

}
