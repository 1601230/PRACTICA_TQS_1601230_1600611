package Controller;

public class PlayerMock extends Player{
    public String getNickName()
    {
        return nickName;
    }
    public int setNickName(String nickName)
    {
        this.nickName = nickName;
        return 1;
    }
}
