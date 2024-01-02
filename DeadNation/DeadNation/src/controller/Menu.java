package controller;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> MAIN_MENU_COMMAND =
            Arrays.asList(new String[] {"NEW GAME", "LOAD GAME", "CREATE ACCOUNT", "EXIT"});
    private final List<String> PAUSE_MENU_COMMAND =
            Arrays.asList(new String[] {"EQUIPMENT", "INVENTORY", "SAVE", "EXIT"});
    private final List<String> GAME_OVER_COMMAND =
            Arrays.asList(new String[] {"NEW GAME", "LOAD GAME", "MAIN MENU"});
    private final List<String> INVENTORY_MENU_COMMAND =
            Arrays.asList(new String[] {"EXAMINE", "USE", "EQUIP"});

    public void mainMenuInput(String input) {

    }

    public void pauseMenu(String input) {

    }

    public void gameOver(String input) {

    }
    public void inventoryMenu(String input) {

    }
}
