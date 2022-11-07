import Controller.Player;
import junit.framework.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void setNickName()
    {
        Player player = new Player();

        int valueReturn0 = player.setNickName("b5b"); //Limit esquerre
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn1 = player.setNickName(""); //no valid
        Assert.assertEquals(-1, valueReturn1);

        int valueReturn2 = player.setNickName("aaa aa"); //no valid
        Assert.assertEquals(-1, valueReturn2);

        int valueReturn3 = player.setNickName("    "); //no valid
        Assert.assertEquals(-1, valueReturn3);

        int valueReturn4 = player.setNickName("tete2ete"); //valid
        Assert.assertEquals(1, valueReturn4);

        int valueReturn5 = player.setNickName("abab5"); //Limit dreta
        Assert.assertEquals(1, valueReturn5);

        int valueReturn6 = player.setNickName("abab"); //Frontera
        Assert.assertEquals(1, valueReturn6);
    }
}