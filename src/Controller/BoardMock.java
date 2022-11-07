package Controller;

public class BoardMock extends Board{

    public int getBoardRowSize() { return 10; }
    public int getBoardColumnSize() { return 10; }
    public int getPossibleMovesSize() { return 5; }
    public int getNumberMines() { return 10; }
    public int getFlags() { return 9; }

    public int checkCoordinateX(int coordinateX)
    {
        if ((coordinateX > getBoardRowSize()) || (coordinateX < 1))
        {
            System.out.println("ERROR: The row must be a value greater than 1 and less than " + getBoardRowSize() + " inclusive.");
            return -1;
        }
        else
        {
            return 1;
        }
    }
    public int checkCoordinateY(int coordinateY)
    {
        if ((coordinateY > getBoardColumnSize()) || (coordinateY < 1))
        {
            System.out.println("ERROR: The column must be a value greater than 1 and less than " + getBoardColumnSize() + " inclusive.");
            return -1;
        }
        else
        {
            return 1;
        }
    }
    public int checkInputMove(int move)
    {
        if ((move < 1) || (move > getPossibleMovesSize()))
        {
            System.out.println("ERROR: The selected option must be a value between 1 and " + getPossibleMovesSize() + " .");
            return -1;
        }
        else
        {
            if ((move == 2) && (getFlags() == 0))
            {
                System.out.println("ERROR: All flags are set, if you want to set another flag you will have to remove some of the flags set.");
                return -1;
            }
            else if ((move == 3) && (getFlags() == getNumberMines()))
            {
                System.out.println("ERROR: There is no flag on.");
                return -1;
            }
            else
            {
                return 1;
            }
        }
    }
}
