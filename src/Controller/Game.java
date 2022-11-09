package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import View.*;

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

    public int playGame(Menu menu, View view) {
        return -1;
    }
}
