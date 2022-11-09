package Controller;

import Module.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {
    protected List<List<Box>> board = new ArrayList<List<Box>>();
    private List<List<String>> listLevels = Arrays.asList(
            Arrays.asList(new String[]{"src/Module/Easy level 1.txt", "src/Module/Easy level 2.txt"}),
            Arrays.asList(new String[]{"src/Module/Medium level 1.txt", "src/Module/Medium level 2.txt"}),
            Arrays.asList(new String[]{"src/Module/Hard level 1.txt",  "src/Module/Hard level 2.txt"}));
    private List<String> possibleMoves = Arrays.asList(new String[]{"1. Open the box", "2. Put a flag", "3. Remove a flag", "4. Cancel", "5. Exit from the game"});

    private int numberMines = 0;
    private int flags = 0;

    public int getBoardRowSize() { return board.size(); }
    public int getBoardColumnSize() {
        if (board.size() == 0)
        {
            return -1;
        }
        return board.get(0).size();
    }
    public Box getBox(int i, int j) {
        if (board.size() == 0)
        {
            return null;
        }
        return board.get(i).get(j);
    }
    public int getPossibleMovesSize() { return possibleMoves.size(); }
    public String getElementPossibleMoves(int i) { return possibleMoves.get(i); }
    public int getNumberMines() { return numberMines; }
    public int getFlags() { return flags; }
    public int getListLevelsSize(int i)
    {
        return listLevels.get(i).size();
    }
    public void setPathListLevel(int i, String newPath)
    {
        for (int j = 0; j < listLevels.get(j).size(); j++)
        {
            listLevels.get(i).set(j, newPath);
        }
    }
    public int randomBoard(int level)
    {
        Random random = new Random();
        int randomBoard = random.nextInt((listLevels.get(level).size() - 1) + 1) + 1;
        return randomBoard;
    }
    public int inicialitzateBoard(int level) throws IOException
    {
        int randomBoard = randomBoard(level - 1);
        String pathBoard = listLevels.get(level - 1).get(randomBoard - 1);
        BufferedReader buffer = DataBase.readFile(pathBoard);

        if (buffer != null)
        {
            String rowTableInfo;
            while ((rowTableInfo = buffer.readLine()) != null) {
                List<String> rowTablePartition = Arrays.asList(rowTableInfo.split(" "));
                List<Box> rowTable = new ArrayList<Box>();

                for (int i = 0; i < rowTablePartition.size(); i++) {
                    Box box = new Box();
                    if (Integer.parseInt(rowTablePartition.get(i)) == 1) {
                        box.setMine(true);
                        numberMines = numberMines + 1;
                    }
                    rowTable.add(box);
                }
                board.add(rowTable);
            }
            flags = numberMines;

            return 1;
        }
        else
        {
            System.out.println("ERROR: Minesweeper table not created");
            return -1;
        }
    }
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
    public int checkInputMove(int move) {
        if ((move < 1) || (move > getPossibleMovesSize())) {
            System.out.println("ERROR: The selected option must be a value between 1 and " + getPossibleMovesSize() + " .");
            return -1;
        } else {
            if ((move == 2) && (getFlags() == 0)) {
                System.out.println("ERROR: All flags are set, if you want to set another flag you will have to remove some of the flags set.");
                return -1;
            } else if ((move == 3) && (getFlags() == getNumberMines())) {
                System.out.println("ERROR: There is no flag on.");
                return -1;
            } else {
                return 1;
            }
        }
    }

    public boolean win()
    {
        return true;
    }
    public int makeMove(int move, List<Integer> coordinates, int level)
    {
        return -1;
    }
}
