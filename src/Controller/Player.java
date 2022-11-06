package Controller;

public class Player {
    private String nickName = null;

    public void Player()
    {
        //void
    }

    public String getNickName()
    {
        return nickName;
    }
    public int setNickName(String nickName)
    {
        if (nickName == "")
        {
            System.out.println("ERROR: Invalid nickName!!!");
            return -1;
        }
        else if (nickName.length() < 4)
        {
            System.out.println("ERROR: The nickname is less than 4 characters long!!!");
            return -1;
        }
        else
        {
            this.nickName = nickName;
            return 1;
        }
    }
}
