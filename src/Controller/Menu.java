package Controller;

import java.util.Arrays;
import java.util.List;

/*
Menu class functionality is to contain the options menu that will be displayed in
the user after starting the game and saving the selected option for the game.
 */
public class Menu {
    private List<String> menuOptions = Arrays.asList(new String[]{"1. Play", "2. Ranking", "3. Exit"});
    private int selectedOption = 0;

    public int getMenuOptionsSize() { return menuOptions.size(); }
    public String getMenuOptionsElement(int i) { return menuOptions.get(i); }
    public int getSelectedOption()
    {
        return selectedOption;
    }
    public int setSelectedOption(int selectedOption) {
        if ((selectedOption < 1) || (selectedOption > 3))
        {
            System.out.println("ERROR: Invalid option!!!");
            return -1;
        }
        else
        {
            this.selectedOption = selectedOption;
            return 1;
        }
    }
}