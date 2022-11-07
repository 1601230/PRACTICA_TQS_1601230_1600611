import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import Controller.Board;

public class BoardTest {
    @Test
    public void checkCoordinateX()
    {
        Board board = new Board();

        int returnValue0 = board.checkCoordinateX(0);
        Assert.assertEquals(-1, returnValue0);
    }

    @Test
    public void checkCoordinateY()
    {

    }

    @Test
    public void checkInputMove()
    {

    }
}