package Controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import View.*;
import Module.*;

public class Game {
    public List<Integer> logicOfTheGame(Board board, Play play, View view)
    {
        int error;
        List<Integer> returnValue = new ArrayList<Integer>();
        returnValue.add(0);
        returnValue.add(0);

        error = 1;
        int coordinateX;
        do{
            coordinateX = view.userInputCoordinateX();
            error = board.checkCoordinateX(coordinateX);
        } while(error == -1);

        error = 1;
        int coordinateY;
        do{
            coordinateY = view.userInputCoordinateY();
            error = board.checkCoordinateY(coordinateY);
        } while(error == -1);
        List<Integer> coordinates = new ArrayList<Integer>();
        coordinates.add(coordinateX);
        coordinates.add(coordinateY);
        view.printPossibleMoves(board);

        error = 1;
        do{
            returnValue.set(0,view.userInputPossibleMoves());
            error = board.checkInputMove(returnValue.get(0));
        } while(error == -1);

        if (returnValue.get(0) != 5)
        {
            returnValue.set(1, board.makeMove(returnValue.get(0), coordinates, play.getSelectedLevel()));
            if (board.win() ==  true)
            {
                play.setWin(board.win());
                returnValue.set(1, 1);
            }
        }

        return returnValue;
    }

    public int playGame(Menu menu, View view) throws IOException {
        view.printMenu(menu);
        int error = 1;
        do
        {
            int option = view.userInputMenu();
            error = menu.setSelectedOption(option);
        } while(error == -1);

        Ranking ranking = new Ranking();
        switch(menu.getSelectedOption())
        {
            case 1:
                LocalDateTime initialTime = LocalDateTime.now();

                Player player = new Player();
                error = 1;
                do{
                    String nickName = view.userInputNickName();
                    error = player.setNickName(nickName);
                } while(error == -1);

                Play play = new Play();
                play.setPlayer(player);
                view.printLevels(play);
                error = 1;
                do{
                    int option = view.userInputLevels();
                    error = play.setSelectedLevel(option);
                } while(error == -1);

                Board board = new Board();
                board.inicialitzateBoard(play.getSelectedLevel());
                if (board.getBoardRowSize() != 0)
                {
                    view.printTable(board, play.getSelectedLevel());

                    List<Integer> returnValue = new ArrayList<Integer>();
                    returnValue.add(-1);
                    returnValue.add(0);
                    while ((returnValue.get(1) != 1) && (returnValue.get(0) != 5) && ((returnValue.get(1) != -2)))
                    {
                        returnValue = logicOfTheGame(board, play, view);
                    }

                    LocalDateTime finalTime = LocalDateTime.now();
                    play.setTime(Math.toIntExact(Duration.between(initialTime, finalTime).toSeconds()));
                    ranking.writeRanking(play);
                    view.printRanking(ranking);
                }

                break;
            case 2:
                view.printRanking(ranking);

                break;
            case 3:
                System.out.println("Thank you, bye bye!!!");

                break;
        }

        return menu.getSelectedOption();
    }
}
