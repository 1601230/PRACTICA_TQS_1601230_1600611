package Controller;

public class BoardMock extends Board{
    private int numberMines = 10;
    private int flags = 9;

    public int getBoardRowSize() { return 10; }
    public int getBoardColumnSize() { return 10; }
    public int getPossibleMovesSize() { return 5; }
    public int getNumberMines() { return numberMines; }
    public int getFlags() { return flags; }
    public void setFlags(int flags) { this.flags = flags; }
}
