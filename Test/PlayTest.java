import junit.framework.Assert;
import org.junit.Test;
import Controller.*;
import static org.junit.Assert.*;

public class PlayTest {
    @Test
    public void getPlayer()
    {
        Play play = new Play();
        Player valueReturn0 = play.getPlayer();
        Assert.assertEquals(null, valueReturn0);
    }
    @Test
    public void getMenuLevelsSize()
    {
        Play play = new Play();
        int valueReturn0 = play.getMenuLevelsSize();
        Assert.assertEquals(3, valueReturn0);
    }
    @Test
    public void getElementMenu()
    {
        Play play = new Play();

        String valueReturn0 = play.getElementMenu(0);
        Assert.assertEquals("1. Easy", valueReturn0);

        String valueReturn1 = play.getElementMenu(1);
        Assert.assertEquals("2. Medium", valueReturn1);

        String valueReturn2 = play.getElementMenu(2);
        Assert.assertEquals("3. Hard", valueReturn2);
    }
    @Test
    public void getTime()
    {
        Play play = new Play();

        int valueReturn0 = play.getTime();
        Assert.assertEquals(0, valueReturn0);
    }
    @Test
    public void getWin()
    {
        Play play = new Play();

        boolean valueReturn0 = play.getWin();
        Assert.assertEquals(false, valueReturn0);
    }
    @Test
    public void setTime()
    {
        Play play = new Play();

        play.setTime(100);
        Assert.assertEquals(100, play.getTime());
    }
    @Test
    public void setWin()
    {
        Play play = new Play();

        play.setWin(true);
        Assert.assertEquals(true, play.getWin());
    }
    @Test
    public void setPlayer()
    {
        Play play = new Play();
        Player player = new Player();

        player.setNickName("player");
        play.setPlayer(player);
        Assert.assertEquals(player, play.getPlayer());
    }
    @Test
    public void setSelectedLevel() {
        Play play = new Play();

        int valueReturn0 = play.setSelectedLevel(-5); //no valid
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn1 = play.setSelectedLevel(5); //no valid
        Assert.assertEquals(-1, valueReturn1);

        int valueReturn2 = play.setSelectedLevel(0); //limit esquerre
        Assert.assertEquals(-1, valueReturn2);

        int valueReturn3 = play.setSelectedLevel(4); //limit dreta
        Assert.assertEquals(-1, valueReturn3);

        int valueReturn4 = play.setSelectedLevel(1); //frontera
        Assert.assertEquals(1, valueReturn4);

        int valueReturn5 = play.setSelectedLevel(3); //frontera
        Assert.assertEquals(1, valueReturn5);

        int valueReturn6 = play.setSelectedLevel(2); //valid i limit
        Assert.assertEquals(1, valueReturn6);
    }
}