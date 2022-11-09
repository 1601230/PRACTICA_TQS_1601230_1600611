import Controller.Game;
import Controller.Menu;
import View.View;

import java.io.IOException;

public class Minesweeper {
    public static void main (String[] args) throws IOException {
        Game game =  new Game();
        Menu menu = new Menu();
        View view = new View();
        int endGame = 0;

        do
        {
            endGame = game.playGame(menu, view);
        } while(endGame != 3);

    }
}