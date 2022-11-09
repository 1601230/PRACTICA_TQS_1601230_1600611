import junit.framework.Assert;
import org.junit.Test;
import Controller.*;
import View.*;

import java.io.IOException;
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
    @Test
    public void playGame() throws IOException {
        ViewMock view = new ViewMock();
        Menu menu = new Menu();
        Game game = new Game();

        view.setMenu(1);
        view.setNickName("player");
        view.setLevels(1);
        view.setX(1);
        view.setY(1);
        view.setMoves(5);
        int returnValue0 = game.playGame(menu, view);
        Assert.assertEquals(1, returnValue0);

        view.setMenu(2);
        int returnValue1 = game.playGame(menu, view);
        Assert.assertEquals(2, returnValue1);

        view.setMenu(3);
        int returnValue2 = game.playGame(menu, view);
        Assert.assertEquals(3, returnValue2);
    }
}