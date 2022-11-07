import junit.framework.Assert;
import org.junit.Test;
import Controller.Play;
import static org.junit.Assert.*;

public class PlayTest {
    @Test
    public void setSelectedLevel() {
        Play play = new Play();

        int valueReturn0 = play.setSelectedLevel(0);
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn1 = play.setSelectedLevel(1);
        Assert.assertEquals(1, valueReturn1);
    }
}