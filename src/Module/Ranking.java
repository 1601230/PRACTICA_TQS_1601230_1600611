package Module;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Controller.Play;
import Module.DataBase;
public class Ranking {
    private String pathRanking = "src/Module/Ranking.txt";
    private List<String> ranking = new ArrayList<String>();
    private int numTop = 10;

    public void Ranking()
    {
        //void;
    }

    public String getPathRanking() { return pathRanking; }
    public void setPathRanking(String pathRanking) { this.pathRanking = pathRanking; }
    public int getNumTop() { return numTop; }
    public void writeRanking(Play play) throws IOException {
        //void
    }

}
