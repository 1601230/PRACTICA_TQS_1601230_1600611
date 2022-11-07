package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<List<Box>> board = new ArrayList<List<Box>>();
    private List<List<String>> listLevels = Arrays.asList(Arrays.asList(new String[]{"src/Module/Easy level 1.txt", "src/Module/Easy level 2.txt"}),
            Arrays.asList(new String[]{"src/Module/Medium level 1.txt", "src/Module/Medium level 2.txt"}),
            Arrays.asList(new String[]{"src/Module/Hard level 1.txt",  "src/Module/Hard level 2.txt"}));
    private List<String> possibleMoves = Arrays.asList(new String[]{"1. Open the box", "2. Put a flag", "3. Remove a flag", "4. Cancel", "5. Exit from the game"});

    private int numberMines = 0;
    private int flags = 0;

    public void Board()
    {
        //void;
    }

    public int getBoardRowSize() { return board.size(); }
    public int getBoardColumnSize() { return board.get(0).size(); }
    public Box getBox(int i, int j) { return board.get(i).get(j); }
    public int getPossibleMovesSize() { return possibleMoves.size(); }
    public String getElementPossibleMoves(int i) { return possibleMoves.get(i); }
    public int getNumberMines() { return numberMines; }
    public int getFlags() { return flags; }

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
