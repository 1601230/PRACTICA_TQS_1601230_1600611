package View;

public class ViewMock extends View{
    private int menu;
    private String nickName;
    private int levels;
    private int x;
    private int y;
    private int moves;

    public void setMenu(int menu) {
        this.menu = menu;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setLevels(int levels) {
        this.levels = levels;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setMoves(int moves) {
        this.moves = moves;
    }


    public int userInputMenu()
    {
        return menu;
    }
    public String userInputNickName()
    {
        return nickName;
    }
    public int userInputLevels()
    {
        return levels;
    }
    public int userInputCoordinateX()
    {
        return x;
    }
    public int userInputCoordinateY()
    {
        return y;
    }
    public int userInputPossibleMoves()
    {
        return moves;
    }
}
