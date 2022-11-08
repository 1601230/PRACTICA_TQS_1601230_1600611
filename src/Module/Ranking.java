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

            if (buffer != null)
            {
                ranking.clear();
                String rankingInfo;
                while ((rankingInfo = buffer.readLine()) != null) {
                    ranking.add(rankingInfo);
                }

                FileWriter rankingWrite = new FileWriter(pathRanking);
                String input;
                input = "1 " + play.getPlayer().getNickName() + " " + play.getTime() + " seconds;";
                if (ranking.size() == 0) {
                    rankingWrite.write(input);
                } else {
                    ranking.add(input);
                    int pos = ranking.size() - 1;
                    int i = 0;
                    boolean find = false;
                    String[] rankingPartition;

                    while ((find == false) && (i < ranking.size())) {
                        rankingPartition = ranking.get(i).split(" ");
                        if (play.getTime() < Integer.parseInt(rankingPartition[2])) {
                            pos = i;
                            find = true;
                        } else {
                            i = i + 1;
                        }
                    }

                    for (i = 0; i < ranking.size() - 1; i++) {
                        if (i == pos)
                        {
                            input = (pos + 1) + " " + play.getPlayer().getNickName() + " " + play.getTime() + " seconds;\n";
                            if (i != ranking.size()-1)
                            {
                                rankingWrite.write(input);
                                rankingPartition = ranking.get(i).split(" ");
                                input = (Integer.parseInt(rankingPartition[0]) + 1) + " " + rankingPartition[1] + " " + rankingPartition[2] + " seconds;\n";
                            }
                        } else
                        {
                            if (i < pos)
                            {
                                input = ranking.get(i) + "\n";
                            } else
                            {
                                rankingPartition = ranking.get(i).split(" ");
                                input = (Integer.parseInt(rankingPartition[0]) + 1) + " " + rankingPartition[1] + " " + rankingPartition[2] + " seconds;\n";
                            }
                        }
                        rankingWrite.write(input);
                    }

                    if (pos == ranking.size() - 1)
                    {
                        input = (pos + 1) + " " + play.getPlayer().getNickName() + " " + play.getTime() + " seconds;\n";
                        rankingWrite.write(input);
                    }
                }

                rankingWrite.close();
            }
            else
            {
                System.out.println("ERROR: Ranking could not be displayed");
                return false;
            }
        }
        return true;
    }
}
