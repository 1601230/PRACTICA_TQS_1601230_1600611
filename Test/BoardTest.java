import Controller.BoardMock;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import Controller.Board;

public class BoardTest {
    @Test
    public void checkCoordinateX()
    {
        Board board = new BoardMock();

        int returnValue0 = board.checkCoordinateX(0); //no valid
        Assert.assertEquals(-1, returnValue0);

        int returnValue1 = board.checkCoordinateX(5); //valid
        Assert.assertEquals(1, returnValue1);
    }

    @Test
    public void checkCoordinateY()
    {
        Board board = new BoardMock();

        int returnValue0 = board.checkCoordinateY(0); //no valid
        Assert.assertEquals(-1, returnValue0);

        int returnValue1 = board.checkCoordinateY(5); //valid
        Assert.assertEquals(1, returnValue1);
    }

    @Test
    public void checkInputMove()
    {
        Board board = new BoardMock();

        int returnValue0 = board.checkInputMove(0); //no valid
        Assert.assertEquals(-1, returnValue0);

        int returnValue1 = board.checkInputMove(4); //valid
        Assert.assertEquals(1, returnValue1);
    }
}