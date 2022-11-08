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
    public boolean writeRanking(Play play) throws IOException
    {
        if(play.getWin() == true) {
            BufferedReader buffer = DataBase.readFile(pathRanking);

            if (buffer != null) {
                ranking.clear();
                String rankingInfo;

                while ((rankingInfo = buffer.readLine()) != null) {
                    ranking.add(rankingInfo);
                }

                FileWriter rankingWrite = new FileWriter(pathRanking);
                String input;

                if (ranking.size() == 0) {
                    input = "1 " + play.getPlayer().getNickName() + " " + play.getTime() + " seconds;";
                    rankingWrite.write(input);
                } else {
                    boolean find = false;
                    String[] rankingPartition;
                    int i = 0;

                    while ((find == false) && (i < ranking.size())) {
                        rankingPartition = ranking.get(i).split(" ");
                        if (play.getTime() < Integer.parseInt(rankingPartition[2])) {
                            input = "1 " + play.getPlayer().getNickName() + " " + play.getTime() + " seconds;";
                            ranking.add(i, input);
                            find = true;
                        } else {
                            i = i + 1;
                        }
                    }

                    if (find == false)
                    {
                        input = "1 " + play.getPlayer().getNickName() + " " + play.getTime() + " seconds;";
                        ranking.add(input);
                    }

                    for (i = 0; i < ranking.size(); i++)
                    {
                        rankingPartition = ranking.get(i).split(" ");
                        input = (i + 1) + " " + rankingPartition[1] + " " + rankingPartition[2] + " seconds;\n";
                        rankingWrite.write(input);
                    }
                }
                rankingWrite.close();
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
