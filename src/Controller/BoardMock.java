package Controller;

import View.View;

import java.util.ArrayList;
import java.util.List;

public class BoardMock extends Board {
    private int numberMines = 10;
    private int flags = 9;
    private boolean win;

    public int getBoardRowSize() { return 10; }
    public int getBoardColumnSize() { return 10; }
    public int getPossibleMovesSize() { return 5; }
    public int getNumberMines() { return numberMines; }
    public int getFlags() { return flags; }
    public void setFlags(int flags) { this.flags = flags; }
    public int makeMove(int move, List<Integer> coordinates, int level, View view) { return 0; }
    public void setWin(boolean win) { this.win = win; }
    public boolean win() { return win; }
}