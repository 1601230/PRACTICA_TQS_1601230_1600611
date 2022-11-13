import Controller.BoardMockA;
import Controller.Box;
import View.ViewMock;
import junit.framework.Assert;
import org.junit.Test;
import Controller.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardTest {
    private boolean inRange(int randomValue, int level)
    {
        Board board = new Board();
        if ((randomValue < 1) || (randomValue > board.getListLevelsSize(level)))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    private List<List<Box>> expectedOutput()
    {
        List<List<Box>> board = new ArrayList<List<Box>>();

        List<Box> testList0 = new ArrayList<Box>();
        for (int j = 0; j < 10; j++)
        {
            Box testBox = new Box();
            testBox.setOpen(true);
            if (j == 0)
            {
                testBox.setOpen(false);
                testBox.setMine(true);
            }
            else if (j == 1)
            {
                testBox.setContent(String.valueOf(1));
            }
            else
            {
                testBox.setContent(String.valueOf(0));
            }
            testList0.add(testBox);
        }
        board.add(testList0);

        List<Box> testList1 = new ArrayList<Box>();
        for (int j = 0; j < 10; j++)
        {
            Box testBox = new Box();
            testBox.setOpen(true);
            if ((j == 0) || (j == 1))
            {
                testBox.setContent(String.valueOf(1));
            }
            else
            {
                testBox.setContent(String.valueOf(0));
            }
            testList1.add(testBox);
        }
        board.add(testList1);

        for (int i = 0; i < 4; i++)
        {
            List<Box> testList = new ArrayList<Box>();
            for (int j = 0; j < 10; j++)
            {
                Box testBox = new Box();
                testBox.setOpen(true);
                testBox.setContent(String.valueOf(0));
                testList.add(testBox);
            }
            board.add(testList);
        }

        List<Box> testList2 = new ArrayList<Box>();
        for (int j = 0; j < 10; j++)
        {
            Box testBox = new Box();
            testBox.setOpen(true);
            if (j > 7)
            {
                testBox.setContent(String.valueOf(1));
            }
            else
            {
                testBox.setContent(String.valueOf(0));
            }
            testList2.add(testBox);
        }
        board.add(testList2);

        List<Box> testList3 = new ArrayList<Box>();
        for (int j = 0; j < 10; j++)
        {
            Box testBox = new Box();
            testBox.setOpen(true);
            if (j == 8)
            {
                testBox.setContent(String.valueOf(1));
            }
            else if (j == 9)
            {
                testBox.setOpen(false);
                testBox.setMine(true);
            }
            else
            {
                testBox.setContent(String.valueOf(0));
            }
            testList3.add(testBox);
        }
        board.add(testList3);

        return board;
    }
    private boolean equalBoard(List<List<Box>> boardA, List<List<Box>> boardB)
    {
        if (boardA.size() != boardB.size())
        {
            return false;
        }
        else if (boardA.get(0).size() != boardB.get(0).size())
        {
            return false;
        }
        else
        {
            int i = 0;
            boolean equals = true;

            while ((i < boardA.size()) && (equals == true))
            {
                int j = 0;
                while ((j < boardA.size()) && (equals == true))
                {
                    if (boardA.get(i).get(j).getOpen() != boardB.get(i).get(j).getOpen())
                    {
                        equals = false;
                    }
                    else if (boardA.get(i).get(j).getMine() != boardB.get(i).get(j).getMine())
                    {
                        equals = false;
                    }
                    else if (boardA.get(i).get(j).getContent().equals(boardB.get(i).get(j).getContent()) == false)
                    {
                        equals = false;
                    }
                    else
                    {
                        j = j + 1;
                    }
                }
                i = i + 1;
            }

            return equals;
        }
    }
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
    public void randomBoard()
    {
        Board board = new Board();

        int returnValue0 = board.randomBoard(0);
        Assert.assertEquals(true, inRange(returnValue0, 0));

        int returnValue1 = board.randomBoard(1);
        Assert.assertEquals(true, inRange(returnValue1, 1));

        int returnValue2 = board.randomBoard(2);
        Assert.assertEquals(true, inRange(returnValue2, 2));
    }
    @Test
    public void inicialitzateBoard() throws IOException {
        Board board = new Board();

        int returnValue0 = board.inicialitzateBoard(1);
        Assert.assertEquals(1, returnValue0);

        int returnValue1 = board.inicialitzateBoard(2);
        Assert.assertEquals(1, returnValue1);

        int returnValue2 = board.inicialitzateBoard(3);
        Assert.assertEquals(1, returnValue2);

        board.setPathListLevel(0, "/newPath");
        int returnValue3 = board.inicialitzateBoard(1);
        Assert.assertEquals(-1, returnValue3);

        board.setPathListLevel(1, "/newPath");
        int returnValue4 = board.inicialitzateBoard(2);
        Assert.assertEquals(-1, returnValue4);

        board.setPathListLevel(2, "/newPath");
        int returnValue5 = board.inicialitzateBoard(3);
        Assert.assertEquals(-1, returnValue5);
    }
    @Test
    public void checkCoordinateX()
    {
        Board board = new BoardMockA();

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
        Board board = new BoardMockA();

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
        BoardMockA board = new BoardMockA();

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
    @Test
    public void win()
    {
        BoardMockC board = new BoardMockC();

        board.inicialitzateBoard(1);
        boolean returnValue0 = board.win();
        Assert.assertEquals(false, returnValue0);

        board.setFlags(1);
        boolean returnValue1 = board.win();
        Assert.assertEquals(false, returnValue1);

        BoardMockD board2 = new BoardMockD();
        board2.inicialitzateBoard(1);
        boolean returnValue2 = board2.win();
        Assert.assertEquals(true, returnValue2);
    }
    @Test
    public void makeMove() throws IOException {

        BoardMockB board = new BoardMockB();
        board.inicialitzateBoard(1);
        ViewMock view = new ViewMock();
        List<Integer> coordinates = new ArrayList<Integer>();
        coordinates.add(1);
        coordinates.add(3);

        int returnValue0 = board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(-1, returnValue0);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(1);

        int returnValue1 = board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(-1, returnValue1);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(2);

        int returnValue2 = board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(-2, returnValue2);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(4);

        int returnValue3 = board.makeMove(2,coordinates,1, view);
        Assert.assertEquals(0, returnValue3);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(3);

        int returnValue4 = board.makeMove(2,coordinates,1, view);
        Assert.assertEquals(-1, returnValue4);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(3);

        int returnValue5 = board.makeMove(3,coordinates,1, view);
        Assert.assertEquals(0, returnValue5);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(5);

        int returnValue6 = board.makeMove(3,coordinates,1, view);
        Assert.assertEquals(-1, returnValue6);

        int returnValue7 = board.makeMove(4,coordinates,1, view);
        Assert.assertEquals(0, returnValue7);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(7);

        int returnValue8 = board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(1, returnValue8);

        int returnValue9 = board.makeMove(-1,coordinates,1, view);
        Assert.assertEquals(-1, returnValue9);

        int returnValue10 = board.makeMove(7,coordinates,1, view);
        Assert.assertEquals(-1, returnValue10);

        coordinates.clear();
        coordinates.add(-5);
        coordinates.add(-5);
        int returnValue11 = board.makeMove(-1,coordinates,10, view);
        Assert.assertEquals(-1, returnValue11);

        coordinates.clear();
        coordinates.add(40);
        coordinates.add(40);
        int returnValue12 = board.makeMove(1,coordinates,10, view);
        Assert.assertEquals(-1, returnValue12);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(-5);
        int returnValue13 = board.makeMove(1,coordinates,10, view);
        Assert.assertEquals(-1, returnValue13);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(40);
        int returnValue14 = board.makeMove(1,coordinates,10, view);
        Assert.assertEquals(-1, returnValue14);

        coordinates.add(1);
        coordinates.add(1);
        int returnValue15 = board.makeMove(1,coordinates,10, view);
        Assert.assertEquals(-1, returnValue15);

        coordinates.clear();
        coordinates.add(-5);
        coordinates.add(-5);
        int returnValue16 = board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(-1, returnValue16);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(1);
        int returnValue17 = board.makeMove(1,coordinates,-1, view);
        Assert.assertEquals(-1, returnValue17);

        coordinates.clear();
        coordinates.add(1);
        coordinates.add(1);
        int returnValue18 = board.makeMove(1,coordinates,10, view);
        Assert.assertEquals(-1, returnValue18);
    }
    @Test
    public void openBoxANDopenBoxRecursive() throws IOException {
        ViewMock view = new ViewMock();
        Board board = new BoardMockE();
        board.inicialitzateBoard(1);

        List<List<Box>> expectedBoard = new ArrayList<List<Box>>();
        expectedBoard = expectedOutput();

        List<Integer> coordinates = new ArrayList<Integer>();
        coordinates.add(1);
        coordinates.add(3);

        board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(true, equalBoard(expectedBoard, board.getBoardList()));

        coordinates.clear();
        coordinates.add(3);
        coordinates.add(1);

        board.makeMove(1,coordinates,1, view);
        Assert.assertEquals(true, equalBoard(expectedBoard, board.getBoardList()));

    }

}