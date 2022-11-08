package Controller;

public class PlayMock extends Play{

    protected Player player = new PlayerMock();

    public boolean getWin() { return true; }

    public Player getPlayer()
    {
        return player;
    }

    public int getTime()
    {
        return 351;
    }


}
