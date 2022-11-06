import Controller.Player;
import junit.framework.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void setNickName()
    {
        Player player = new Player();

        int valueReturn0 = player.setNickName("");
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn2 = player.setNickName("    ");
        Assert.assertEquals(-1, valueReturn2);

        int valueReturn3 = player.setNickName("bb");
        Assert.assertEquals(-1, valueReturn3);

        int valueReturn4 = player.setNickName("aaaa");
        Assert.assertEquals(1, valueReturn4);

        int valueReturn5 = player.setNickName("1111");
        Assert.assertEquals(1, valueReturn5);

        int valueReturn6 = player.setNickName("abababab");
        Assert.assertEquals(1, valueReturn6);

    }
}