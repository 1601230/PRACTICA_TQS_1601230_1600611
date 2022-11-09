import Controller.BoardMock;
import Controller.Box;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import Controller.Board;

public class BoardTest {
    @Test
    public void getBoardRowSize()
    {
        Board board = new Board();

        int returnValue0 = board.getBoardRowSize();
        Assert.assertEquals(0, returnValue0);
    }
    @Test
    public void getBoardColumnSize()
    {
        Board board = new Board();

        int returnValue0 = board.getBoardColumnSize();
        Assert.assertEquals(-1, returnValue0);
    }
    @Test
    public void getBox()
    {
        Board board = new Board();

        Box returnValue0 = board.getBox(0,0);
        Assert.assertEquals(null, returnValue0);
    }
    @Test
    public void getPossibleMovesSize()
    {
        Board board = new Board();

        int returnValue0 = board.getPossibleMovesSize();
        Assert.assertEquals(5, returnValue0);
    }
    @Test
    public void getElementPossibleMoves()
    {
        Board board = new Board();

        String valueReturn0 = board.getElementPossibleMoves(0);
        Assert.assertEquals("1. Open the box", valueReturn0);

        String valueReturn1 = board.getElementPossibleMoves(1);
        Assert.assertEquals("2. Put a flag", valueReturn1);

        String valueReturn2 = board.getElementPossibleMoves(2);
        Assert.assertEquals("3. Remove a flag", valueReturn2);

        String valueReturn3 = board.getElementPossibleMoves(3);
        Assert.assertEquals("4. Cancel", valueReturn3);

        String valueReturn4 = board.getElementPossibleMoves(4);
        Assert.assertEquals("5. Exit from the game", valueReturn4);
    }
    @Test
    public void getNumberMines()
    {
        Board board = new Board();

        int returnValue0 = board.getNumberMines();
        Assert.assertEquals(0, returnValue0);
    }
    @Test
    public void getFlags()
    {
        Board board = new Board();

        int returnValue0 = board.getFlags();
        Assert.assertEquals(0, returnValue0);
    }
    @Test
    public void checkCoordinateX()
    {
        Board board = new BoardMock();

        int returnValue0 = board.checkCoordinateX(-5); //no valid
        Assert.assertEquals(-1, returnValue0);

        int returnValue1 = board.checkCoordinateX(20); //no valid
        Assert.assertEquals(-1, returnValue1);

        int returnValue2 = board.checkCoordinateX(0); //no valid i limit
        Assert.assertEquals(-1, returnValue2);

        int returnValue3 = board.checkCoordinateX(11); //no valid i limit
        Assert.assertEquals(-1, returnValue3);

        int returnValue4 = board.checkCoordinateX(5); //valid
        Assert.assertEquals(1, returnValue4);

        int returnValue5 = board.checkCoordinateX(2); //valid i limit
        Assert.assertEquals(1, returnValue5);

        int returnValue6 = board.checkCoordinateX(9); //valid i limit
        Assert.assertEquals(1, returnValue6);

        int returnValue7 = board.checkCoordinateX(1); //valid i frontera
        Assert.assertEquals(1, returnValue7);

        int returnValue8 = board.checkCoordinateX(10); //valid i frontera
        Assert.assertEquals(1, returnValue8);
    }
    @Test
    public void checkCoordinateY()
    {
        Board board = new BoardMock();

        int returnValue0 = board.checkCoordinateY(-5); //no valid
        Assert.assertEquals(-1, returnValue0);

        int returnValue1 = board.checkCoordinateY(20); //no valid
        Assert.assertEquals(-1, returnValue1);

        int returnValue2 = board.checkCoordinateY(0); //no valid i limit
        Assert.assertEquals(-1, returnValue2);

        int returnValue3 = board.checkCoordinateY(11); //no valid i limit
        Assert.assertEquals(-1, returnValue3);

        int returnValue4 = board.checkCoordinateY(5); //valid
        Assert.assertEquals(1, returnValue4);

        int returnValue5 = board.checkCoordinateY(2); //valid i limit
        Assert.assertEquals(1, returnValue5);

        int returnValue6 = board.checkCoordinateY(9); //valid i limit
        Assert.assertEquals(1, returnValue6);

        int returnValue7 = board.checkCoordinateY(1); //valid i frontera
        Assert.assertEquals(1, returnValue7);

        int returnValue8 = board.checkCoordinateY(10); //valid i frontera
        Assert.assertEquals(1, returnValue8);
    }
    @Test
    public void checkInputMove()
    {
        BoardMock board = new BoardMock();

        int returnValue0 = board.checkInputMove(-5); //no valid
        Assert.assertEquals(-1, returnValue0);

        int returnValue1 = board.checkInputMove(20); //no valid
        Assert.assertEquals(-1, returnValue1);

        int returnValue2 = board.checkInputMove(0); //no valid i limit
        Assert.assertEquals(-1, returnValue2);

        int returnValue3 = board.checkInputMove(6); //no valid i limit
        Assert.assertEquals(-1, returnValue3);

        board.setFlags(0);
        int returnValue4 = board.checkInputMove(2); //no valid i limit
        Assert.assertEquals(-1, returnValue4);

        int returnValue5 = board.checkInputMove(3); //valid
        Assert.assertEquals(1, returnValue5);

        board.setFlags(board.getNumberMines());
        int returnValue6 = board.checkInputMove(3); //no valid
        Assert.assertEquals(-1, returnValue6);

        int returnValue7 = board.checkInputMove(2); //valid
        Assert.assertEquals(1, returnValue7);

        int returnValue8 = board.checkInputMove(6); //no valid i limit
        Assert.assertEquals(-1, returnValue8);

        board.setFlags(9);
        int returnValue9 = board.checkInputMove(3); //valid
        Assert.assertEquals(1, returnValue9);

        int returnValue10 = board.checkInputMove(2); //valid i limit
        Assert.assertEquals(1, returnValue10);

        int returnValue11 = board.checkInputMove(4); //valid i limit
        Assert.assertEquals(1, returnValue11);

        int returnValue12 = board.checkInputMove(1); //valid i frontera
        Assert.assertEquals(1, returnValue12);

        int returnValue13 = board.checkInputMove(5); //valid i frontera
        Assert.assertEquals(1, returnValue13);
    }

}