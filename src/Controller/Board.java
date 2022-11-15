package Controller;

import Module.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import View.*;

/* The Board class's functionality is to represent the minesweeper and
contains the methods necessary to perform the game's main features.
 */
public class Board {
    protected List<List<Box>> board = new ArrayList<List<Box>>();
    private List<List<String>> listLevels = Arrays.asList(
            Arrays.asList(new String[]{"src/Module/Easy level 1.txt", "src/Module/Easy level 2.txt"}),
            Arrays.asList(new String[]{"src/Module/Medium level 1.txt", "src/Module/Medium level 2.txt"}),
            Arrays.asList(new String[]{"src/Module/Hard level 1.txt",  "src/Module/Hard level 2.txt"}));
    private List<String> possibleMoves = Arrays.asList(new String[]{"1. Open the box", "2. Put a flag", "3. Remove a flag", "4. Cancel", "5. Exit from the game"});

    private int numberMines = 0;
    protected int flags = 0;

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
    public List<List<Box>> getBoardList() { return board; }
    public void setPathListLevel(int i, String newPath)
    {
        for (int j = 0; j < listLevels.get(j).size(); j++)
        {
            listLevels.get(i).set(j, newPath);
        }
    }

    public int randomBoard(int level) /*Generate a random numeric value within the list component range to choose a
                                        random game table*/
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
            if (board.size() != 0)
            {
                board.clear();
            }
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
        boolean win =  true;
        int i = 0;
        int j = 0;

        if (flags == 0)
        {
            while ((i < board.size()) && (win == true))
            {
                j = 0;
                while ((j < board.get(i).size()) && (win == true))
                {
                    if (board.get(i).get(j).getOpen() == false)
                    {
                        win = false;
                    }
                    j = j + 1;
                }
                i = i + 1;
            }
        }
        else
        {
            win = false;
        }

        return win;
    }
    public void openBox(List<Integer> coordinates)
    {
        int i = coordinates.get(0) - 1;
        int j = coordinates.get(1) - 1;
        int mineCounter = 0;

        i = i - 1;
        j = j - 1;

        for (int y = 0; y < 3; y++)
        {
            if ((i >= 0) && (i < board.size()))
            {
                for (int z = 0; z < 3; z++)
                {
                    if ((j >= 0) && (j < board.get(0).size()))
                    {
                        if (board.get(i).get(j).getMine() == true)
                        {
                            mineCounter = mineCounter + 1;
                        }
                    }
                    j = j + 1;
                }
            }
            j = coordinates.get(1) - 1;
            j = j - 1;
            i = i + 1;
        }

        board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setContent(String.valueOf(mineCounter));
        if (mineCounter == 0)
        {
            openBoxRecursive(coordinates);
        }
    }
    public void openBoxRecursive(List<Integer> coordinates)
    {
        List<Integer> newCoordinates = new ArrayList<Integer>();
        int i = coordinates.get(0) - 1;
        int j = coordinates.get(1) - 1;

        //Left - up
        j = j - 1;
        i = i - 1;
        if ((j >= 0) && (j < board.get(0).size()) && (i >= 0) && (i < board.size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
            newCoordinates.remove(1);
            newCoordinates.remove(0);
        }

        //Left
        i = i + 1;
        if ((j >= 0) && (j < board.get(0).size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
            newCoordinates.remove(1);
            newCoordinates.remove(0);
        }

        //Left - down
        i = i + 1;
        if ((j >= 0) && (j < board.get(0).size()) && (i >= 0) && (i < board.size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
            newCoordinates.remove(1);
            newCoordinates.remove(0);
        }

        //Down
        j = j + 1;
        if ((i >= 0) && (i < board.size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
            newCoordinates.remove(1);
            newCoordinates.remove(0);
        }

        //Right - Down
        j = j + 1;
        if ((j >= 0) && (j < board.get(0).size()) && (i >= 0) && (i < board.size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
            newCoordinates.remove(1);
            newCoordinates.remove(0);
        }

        //Right
        i = i - 1;
        if ((j >= 0) && (j < board.get(0).size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
            newCoordinates.remove(1);
            newCoordinates.remove(0);
        }

        //Right - up
        i = i - 1;
        if ((i >= 0) && (i < board.size()) && (j >= 0) && (j < board.get(0).size()))
        {
            newCoordinates.add(i + 1);
            newCoordinates.add(j + 1);
            if (board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).getOpen() == false)
            {
                board.get(newCoordinates.get(0) - 1).get(newCoordinates.get(1) - 1).setOpen(true);
                openBox(newCoordinates);
            }
        }
    }
    public int makeMove(int move, List<Integer> coordinates, int level, View view) //-1: LOSE; 0: CONTINUE; 1: WIN
    {
        /*The first 'if' conditionals serve for pairwise testing, just as the program is done we are sure that the
        parameters will always be valid values*/
        if ((move < 1) || (move > possibleMoves.size()))  { return -1; }
        else if ((coordinates.get(0) < 1) || ((coordinates.get(0) > board.size())) || (coordinates.get(1) < 1) || (coordinates.get(1) > board.get(0).size()))  { return -1; }
        else if ((level < 1) || (level > 3)) { return -1; }
        else
        {
            switch(move)
            {
                case 1:
                    if (board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).getContent() == "F")
                    {
                        System.out.println("ERROR: This box has a flag set.");
                        return -1;
                    }
                    else if (board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).getOpen() == true)
                    {
                        System.out.println("ERROR: This box is open.");
                        return -1;
                    }
                    else
                    {
                        board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setOpen(true);
                        if (board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).getMine() == true)
                        {
                            System.out.println(":( There is a mine in this box");
                            board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setContent("X");
                            //printTable(level);
                            view.printTable(this, level);
                            return -2;
                        }
                        else
                        {
                            openBox(coordinates);
                            view.printTable(this, level);
                            if (win() ==  true)
                            {
                                return 1;
                            }
                        }
                    }
                    break;

                case 2:
                    if (board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).getOpen() == false)
                    {
                        board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setContent("F");
                        board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setOpen(true);
                        flags = flags - 1;
                        view.printTable(this, level);
                    }
                    else
                    {
                        System.out.println("ERROR: the box is already open.");
                        return -1;
                    }

                    break;

                case 3:
                    if (board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).getContent() == "F")
                    {
                        board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setContent(" ");
                        board.get(coordinates.get(0) - 1).get(coordinates.get(1) - 1).setOpen(false);
                        flags = flags + 1;
                        view.printTable(this, level);
                    }
                    else
                    {
                        System.out.println("ERROR: This box has no flag set.");
                        return -1;
                    }

                    break;

                case 4:

                    break;
            }

            return 0;
        }
    }
}
