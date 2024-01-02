package view;

import controller.GameController;
import controller.GameException;

import java.sql.SQLException;

public class GameStateView {
    private GameController gc = new GameController();
    public void inRoom() {
        System.out.print("\nWelcome to DEAD NATION adventure game. You will proceed through rooms based upon your entries.\r\n" +
                "You can navigate by using the entire direction.\r\n" +
                "To exit(X) the game, enter X\r\n" +
                "");
        System.out.println("\nNow, you can type anything EXCEPT \"X\" to start the game");
        while (true){
            try {
                System.out.println(gc.printNavigatorUp("roomDesc"));

            } catch (SQLException | ClassNotFoundException | GameException e) {
                e.printStackTrace();
            }
        }
    }

    public void inCombat(int destinationRoomID) {

    }
}
