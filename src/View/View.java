package View;

import Controller.*;
import Module.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class View
{
    public void printMenu(Menu menu)
    {
        System.out.println("----------------- Minesweeper ----------------");
        for (int i = 0; i < menu.getMenuOptionsSize(); i++)
        {
            System.out.println("   " + menu.getMenuOptionsElement(i));
        }
    }
    public void printLevels(Play play)
    {
        System.out.println("----------------- Select a level ----------------");
        for (int i = 0; i < play.getMenuLevelsSize(); i++)
        {
            System.out.println("   " + play.getElementMenu(i));
        }
    }
    public void printTable(Board board , int level)
    {
        for (int i = 0; i < board.getBoardRowSize(); i++)
        {
            if (level == 1)
            {
                System.out.print("|---------------------------------------|" + "\n");
            }
            else if (level == 2)
            {
                System.out.print("|-----------------------------------------------------------------------|" + "\n");
            }
            else
            {
                System.out.print("|-----------------------------------------------------------------------------------------------|" + "\n");
            }

            System.out.print("| ");
            for (int j = 0; j < board.getBoardColumnSize(); j++)
            {
                System.out.print(board.getBox(i, j).getContent() + " | ");
            }
            System.out.print("\n");
        }

        if (level == 1)
        {
            System.out.print("|---------------------------------------|" + "\n");
        }
        else if (level == 2)
        {
            System.out.print("|-----------------------------------------------------------------------|" + "\n");
        }
        else
        {
            System.out.print("|-----------------------------------------------------------------------------------------------|" + "\n");
        }
    }
    public void printPossibleMoves(Board board)
    {
        System.out.println("----------------- Possible Moves ----------------");
        for (int i = 0; i < board.getPossibleMovesSize(); i++)
        {
            if (board.getElementPossibleMoves(i) == "2. Put a flag")
            {
                System.out.println(board.getElementPossibleMoves(i) + " (Number of flags: " + board.getFlags() + ")");
            }
            else if (board.getElementPossibleMoves(i) == "3. Remove a flag")
            {
                System.out.println(board.getElementPossibleMoves(i) + " (Flags set: " + (board.getNumberMines() - board.getFlags()) + ")");
            }
            else
            {
                System.out.println(board.getElementPossibleMoves(i));
            }

        }
    }
    public void printRanking(Ranking ranking) throws IOException {
        BufferedReader buffer = DataBase.readFile(ranking.getPathRanking());

        if (buffer != null)
        {
            String rankingInfo;
            if ((rankingInfo = buffer.readLine()) == null)
            {
                System.out.println("(EMPTY RANKING)");
            }
            else
            {
                int numPrints = 0;
                //System.out.println("Position \t NickName \t Time(seconds) \t Result");
                System.out.println("Position | NickName | Time(seconds)");
                System.out.println("-----------------------------------");

                do
                {
                    System.out.println(rankingInfo);
                    numPrints =  numPrints + 1;
                } while(((rankingInfo = buffer.readLine()) != null) && (numPrints < ranking.getNumTop()));
            }
        }
        else
        {
            System.out.println("ERROR: There is no ranking file");
        }
    }

    public int userInputMenu()
    {
        int option;
        System.out.println("Select an option from the menu: ");
        Scanner input= new Scanner(System.in);

        if (input.hasNextInt())
        {
            option = input.nextInt();
        }
        else
        {
            option = -1;
        }
        return option;
    }
    public String userInputNickName()
    {
        System.out.println("Write your nickName for this game: ");
        Scanner input= new Scanner(System.in);
        String nickName = input.nextLine();
        return nickName;
    }
    public int userInputLevels()
    {
        int option;
        System.out.println("Select a level: ");
        Scanner input= new Scanner(System.in);
        if (input.hasNextInt())
        {
            option = input.nextInt();
        }
        else
        {
            option = -1;
        }

        return option;
    }
    public int userInputCoordinateX()
    {
        int coordinateX;
        System.out.println("Indicates the row where the box you want to select is located (1..): ");
        Scanner input= new Scanner(System.in);
        if (input.hasNextInt())
        {
            coordinateX = input.nextInt();
        }
        else
        {
            coordinateX = -1;
        }

        return coordinateX;
    }
    public int userInputCoordinateY()
    {
        int coordinateY;
        System.out.println("Indicates the column where the box you want to select is located (1..): ");
        Scanner input= new Scanner(System.in);
        if (input.hasNextInt())
        {
            coordinateY = input.nextInt();
        }
        else
        {
            coordinateY = -1;
        }

        return coordinateY;
    }
    public int userInputPossibleMoves()
    {
        int move;
        System.out.println("Enter your next move: ");
        Scanner input= new Scanner(System.in);
        if (input.hasNextInt())
        {
            move = input.nextInt();
        }
        else
        {
            move = -1;
        }

        return move;
    }
}
