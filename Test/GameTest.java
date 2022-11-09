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
        Board board = new BoardMock();
        Play play = new PlayMock();
        ViewMock view = new ViewMock();

        List<Integer> solucioEsperada = new ArrayList<Integer>();

        view.setX(1);
        view.setY(1);
        view.setMoves(1);
        List<Integer> returnValue0 = game.logicOfTheGame(board, play, view);
        solucioEsperada.add(1);
        solucioEsperada.add(0);
        Assert.assertEquals(solucioEsperada, returnValue0);
    }
}