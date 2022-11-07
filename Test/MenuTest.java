import Controller.Menu;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
public class MenuTest {
    @Test
    public void setSelectedOption(){
        Menu menu = new Menu();

        int valueReturn0 = menu.setSelectedOption(0);
        Assert.assertEquals(-1, valueReturn0);

        int valueReturn1 = menu.setSelectedOption(1);
        Assert.assertEquals(1, valueReturn1);
    }
}