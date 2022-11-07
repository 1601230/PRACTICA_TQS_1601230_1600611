package Controller;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> menuOptions = Arrays.asList(new String[]{"1. Play", "2. Ranking", "3. Exit"});
    private int selectedOption = 0;

    public void Menu()
    {
        //void
    }
    public int getMenuOptionsSize() { return menuOptions.size(); }
    public String getMenuOptionsElement(int i) { return menuOptions.get(i); }
    public int getSelectedOption()
    {
        return selectedOption;
    }
    public int setSelectedOption(int selectedOption) {
        return -1;
    }
}