import junit.framework.Assert;
import org.junit.Test;
import Controller.*;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    public void logicOfTheGame() {
        Game game = new Game();
        BoardMock board = new BoardMock();
        Play play = new PlayMock();
        ViewMock view = new ViewMock();

        List<Integer> solucioEsperada = new ArrayList<Integer>();

        view.setX(1);
        view.setY(1);
        view.setMoves(1);
        board.setWin(false);
        List<Integer> returnValue0 = game.logicOfTheGame(board, play, view);
        solucioEsperada.add(1);
        solucioEsperada.add(0);
        Assert.assertEquals(solucioEsperada, returnValue0);

        view.setY(2);
        view.setMoves(2);
        board.setWin(true);
        List<Integer> returnValue1 = game.logicOfTheGame(board, play, view);
        solucioEsperada.clear();
        solucioEsperada.add(2);
        solucioEsperada.add(1);
        Assert.assertEquals(solucioEsperada, returnValue1);

        view.setMoves(5);
        board.setWin(false);
        List<Integer> returnValue2 = game.logicOfTheGame(board, play, view);
        solucioEsperada.clear();
        solucioEsperada.add(5);
        solucioEsperada.add(0);
        Assert.assertEquals(solucioEsperada, returnValue2);
    }
}