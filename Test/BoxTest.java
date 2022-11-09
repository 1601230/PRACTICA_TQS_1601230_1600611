import Controller.Board;
import Controller.*;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    @Test
    public void getMine() {
        Box box = new Box();

        boolean returnValue0 = box.getMine();
        Assert.assertEquals(false, returnValue0);
    }
    @Test
    public void getOpen() {
        Box box = new Box();

        boolean returnValue0 = box.getOpen();
        Assert.assertEquals(false, returnValue0);
    }
    @Test
    public void getContent() {
        Box box = new Box();

        String returnValue0 = box.getContent();
        Assert.assertEquals(" ", returnValue0);
    }
    @Test
    public void setMine() {
        Box box = new Box();

        box.setMine(true);
        Assert.assertEquals(true, box.getMine());
    }
    @Test
    public void setOpen() {
        Box box = new Box();

        box.setOpen(true);
        Assert.assertEquals(true, box.getOpen());
    }
    @Test
    public void setContent() {
        Box box = new Box();

        box.setContent("X");
        Assert.assertEquals("X", box.getContent());
    }

}