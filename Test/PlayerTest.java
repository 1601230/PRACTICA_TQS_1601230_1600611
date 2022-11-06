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

        int valueReturn1 = player.setNickName("aaaa");
        Assert.assertEquals(1, valueReturn1);
    }
}