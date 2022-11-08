package Controller;

public class Player {
    protected String nickName = null;

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
            System.out.println("ERROR: The nickname is less than 4 characters long!!!");
            return -1;
        }
        else
        {
            boolean espacios = false;
            int i = 0;
            while (( i < nickName.length()) && (espacios == false))
            {
                if(nickName.charAt(i) == ' ')
                {
                    System.out.println("ERROR: Invalid nickName!!! (the nickName has spaces)");
                    espacios =  true;
                }
                else
                {
                    i = i + 1;
                }
            }

            if ((espacios == true) || (nickName.length() < 4))
            {
                return -1;
            }
            else
            {
                this.nickName = nickName;
                return 1;
            }
        }
    }
}
