package Controller;

public class Player {
    protected String nickName = null;

    public String getNickName()
    {
        return nickName;
    }
    public static boolean isNumeric(String cadena) {
        boolean result;

        try {
            Integer.parseInt(cadena);
            result = true;
        } catch (NumberFormatException excepcion) {
            result = false;
        }

        return result;
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

            boolean hasNumber = false;
            i = 0;

            while (( i < nickName.length()) && (hasNumber == false))
            {
                String s = "" + nickName.charAt(i);
                if (isNumeric(s) == true)
                {
                    hasNumber = true;
                }
                else
                {
                    i = i + 1;
                }
            }

            if ((espacios == true) || (nickName.length() < 4))
            {
                System.out.println("ERROR: The nickname is less than 4 characters long!!!");
                return -1;
            }
            else if (hasNumber == true)
            {
                System.out.println("ERROR: The nickname has numbers!!!");
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
