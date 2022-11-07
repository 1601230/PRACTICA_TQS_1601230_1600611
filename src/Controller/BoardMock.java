package Controller;

public class BoardMock extends Board{

    public int getBoardRowSize() { return 10; }
    public int getBoardColumnSize() { return 10; }
    public int getPossibleMovesSize() { return 5; }

    public int checkCoordinateX(int coordinateX)
    {
        return -1;
    }
    public int checkCoordinateY(int coordinateY)
    {
        return -1;
    }
    public int checkInputMove(int move)
    {
        return -1;
    }
}
