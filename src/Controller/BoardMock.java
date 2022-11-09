package Controller;

import java.util.ArrayList;
import java.util.List;

public class BoardMock extends Board{
    private int numberMines = 10;
    private int flags = 9;
    private boolean win;

    public int getBoardRowSize() { return 10; }
    public int getBoardColumnSize() { return 10; }
    public int getPossibleMovesSize() { return 5; }
    public int getNumberMines() { return numberMines; }
    public int getFlags() { return flags; }
    public void setFlags(int flags) { this.flags = flags; }
    public int makeMove(int move, List<Integer> coordinates, int level)
    {
        return 0;
    }
    public void setWin(boolean win) { this.win = win; }
    public boolean win()
    {
        return win;
    }

    public int inicialitzateBoard(int level)
    {
        for (int i = 0; i < 8; i++)
        {
            List<Box> testList = new ArrayList<Box>();
            Box testBox = new Box();

            testBox.setOpen(true);
            testList.add(testBox);

            testBox.setOpen(false);
            testBox.setMine(true);
            testList.add(testBox);

            testBox.setOpen(true);
            testBox.setContent("F");
            testList.add(testBox);

            testBox.setMine(false);
            testBox.setContent(" ");
            testList.add(testBox);

            testList.add(testBox);

            testList.add(testBox);

            testList.add(testBox);

            testBox.setOpen(true);
            testList.add(testBox);

            testBox.setOpen(false);
            testBox.setMine(true);
            testList.add(testBox);

            testBox.setMine(false);
            testBox.setContent("F");
            testList.add(testBox);

            board.add(testList);
        }
        return 1;
    }

}
