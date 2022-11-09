import Controller.Player;
import junit.framework.Assert;
import org.junit.Test;

public class PlayerTest {
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

        int valueReturn4 = player.setNickName("tete2ete"); //valid
        Assert.assertEquals(1, valueReturn4);

        int valueReturn5 = player.setNickName("abab5"); //Limit dreta, valid
        Assert.assertEquals(1, valueReturn5);

        int valueReturn6 = player.setNickName("abab"); //Frontera, valid
        Assert.assertEquals(1, valueReturn6);

        int valueReturn7 = player.setNickName(" abab"); //1 passada pel bucle
        Assert.assertEquals(-1, valueReturn7);

        int valueReturn8 = player.setNickName("a bab"); //2 passades pel bucle
        Assert.assertEquals(-1, valueReturn8);

        int valueReturn9 = player.setNickName("aba78 59bg"); //m passades pel bucle
        Assert.assertEquals(-1, valueReturn9);

        int valueReturn10 = player.setNickName("aba7859bg"); //n passades pel bucle
        Assert.assertEquals(1, valueReturn10);
    }
    @Test
    public void getNickName()
    {
        Player player = new Player();

        String valueReturn0 = player.getNickName();
        Assert.assertEquals(null, valueReturn0);
    }
}