package Controller;

import java.util.Arrays;
import java.util.List;

public class Play {
    private List<String> menuLevels = Arrays.asList(new String[]{"1. Easy", "2. Medium", "3. Hard"});
    protected Player player = null;
    int selectedLevel = 0;
    private int time = 0;
    private boolean win = false;

    public void Game()
    {
        //void
    }

    public Player getPlayer()
    {
        return player;
    }
    public int getMenuLevelsSize() { return menuLevels.size(); }
    public String getElementMenu(int i) { return menuLevels.get(i); }
    public int getSelectedLevel() { return selectedLevel; }
    public int getTime()
    {
        return time;
    }
    public boolean getWin() { return win; }
    public void setTime(int time)
    {
        this.time = time;
    }
    public void setWin(boolean b)
    {
        this.win = b;
    }
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    public int setSelectedLevel(int selectedLevel)
    {
        if ((selectedLevel < 1) || (selectedLevel > 3))
        {
            System.out.println("ERROR: Invalid level!!!");
            return -1;
        }
        else
        {
            this.selectedLevel = selectedLevel;
            return 1;
        }
    }

}
