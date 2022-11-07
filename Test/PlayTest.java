import junit.framework.Assert;
import org.junit.Test;
import Controller.Play;
import static org.junit.Assert.*;

public class PlayTest {
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