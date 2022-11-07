import Controller.Menu;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class MenuTest {
    @Test
    public void setSelectedOption(){
        Menu menu = new Menu();

        int valueReturn0 = menu.setSelectedOption(-5); //no valid
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn1 = menu.setSelectedOption(5); //no valid
        Assert.assertEquals(-1, valueReturn1);

        int valueReturn2 = menu.setSelectedOption(0); //limit esquerre
        Assert.assertEquals(-1, valueReturn2);

        int valueReturn3 = menu.setSelectedOption(4); //limit dreta
        Assert.assertEquals(-1, valueReturn3);

        int valueReturn4 = menu.setSelectedOption(1); //frontera
        Assert.assertEquals(1, valueReturn4);

        int valueReturn5 = menu.setSelectedOption(3); //frontera
        Assert.assertEquals(1, valueReturn5);

        int valueReturn6 = menu.setSelectedOption(2); //valid i limit
        Assert.assertEquals(1, valueReturn6);

    }
}