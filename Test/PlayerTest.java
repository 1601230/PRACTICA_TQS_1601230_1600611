import Controller.Player;
import junit.framework.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void getNickName()
    {
        Player player = new Player();

        String valueReturn0 = player.getNickName();
        Assert.assertEquals(null, valueReturn0);
    }
    @Test
    public void isNumeric()
    {
        Player player = new Player();

        boolean valueReturn0 = player.isNumeric("a"); //valor no vàlid
        Assert.assertEquals(false, valueReturn0);

        boolean valueReturn1 = player.isNumeric("1"); //valor vàlid
        Assert.assertEquals(true, valueReturn1);

        boolean valueReturn2 = player.isNumeric(""); //valor no vàlid
        Assert.assertEquals(false, valueReturn2);

        boolean valueReturn3 = player.isNumeric("&"); //valor no vàlid
        Assert.assertEquals(false, valueReturn3);
    }
    @Test
    public void setNickName()
    {
        Player player = new Player();

        int valueReturn0 = player.setNickName("b5b"); //Limit esquerre, no valid
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn1 = player.setNickName(""); //no valid, evita loop testing simple
        Assert.assertEquals(-1, valueReturn1);

        int valueReturn2 = player.setNickName("aaa aa"); //no valid
        Assert.assertEquals(-1, valueReturn2);

        int valueReturn3 = player.setNickName("    "); //no valid
        Assert.assertEquals(-1, valueReturn3);

        int valueReturn4 = player.setNickName("player1"); //no valid
        Assert.assertEquals(-1, valueReturn4);

        int valueReturn5 = player.setNickName("tetetete"); //valid
        Assert.assertEquals(1, valueReturn5);

        int valueReturn6 = player.setNickName("ababb"); //Limit dreta, valid
        Assert.assertEquals(1, valueReturn6);

        int valueReturn7 = player.setNickName("abab"); //Frontera, valid
        Assert.assertEquals(1, valueReturn7);

        int valueReturn8 = player.setNickName(" abab"); //1 passada pel bucle
        Assert.assertEquals(-1, valueReturn8);

        int valueReturn9 = player.setNickName("a bab"); //2 passades pel bucle
        Assert.assertEquals(-1, valueReturn9);

        int valueReturn10 = player.setNickName("aba78 59bg"); //m passades pel bucle
        Assert.assertEquals(-1, valueReturn10);

        int valueReturn11 = player.setNickName("1qwer"); //1 passada pel bucle
        Assert.assertEquals(-1, valueReturn11);

        int valueReturn12 = player.setNickName("u8opuy"); //2 passades pel bucle
        Assert.assertEquals(-1, valueReturn12);

        int valueReturn13 = player.setNickName("abat6yubg"); //m passades pel bucle
        Assert.assertEquals(-1, valueReturn13);

        int valueReturn14 = player.setNickName("abaretubg"); //n passades pel bucle
        Assert.assertEquals(1, valueReturn14);
    }

}