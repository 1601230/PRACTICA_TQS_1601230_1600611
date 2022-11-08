import Controller.*;
import junit.framework.Assert;
import org.junit.Test;
import Module.Ranking;

import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class RankingTest {

    private boolean isEqual(String pathFile1, String pathFile2) throws IOException {

        /*File file1 = new File(pathFile1);
        File file2 = new File(pathFile2);*/
        BufferedReader bufferFile1 = new BufferedReader(new FileReader(pathFile1));
        BufferedReader bufferFile2 = new BufferedReader(new FileReader(pathFile2));

        int numberOfLinesFile1 = 0;
        while (bufferFile1.readLine() !=null) {
            numberOfLinesFile1++;
        }

        int numberOfLinesFile2 = 0;
        while (bufferFile2.readLine() !=null) {
            numberOfLinesFile2++;
        }

        /*if (Files.size(file1.toPath()) != Files.size(file2.toPath()))
        {
            return false;
        }*/
        if (numberOfLinesFile1 != numberOfLinesFile2)
        {
            return false;
        }
        else
        {
            boolean same = true;
            bufferFile1 = new BufferedReader(new FileReader(pathFile1));
            bufferFile2 = new BufferedReader(new FileReader(pathFile2));

            String line1 = bufferFile1.readLine();;
            String line2 = bufferFile2.readLine();

            while((line1 != null || line2 != null) && same)
            {
                if(line1.equals(line2) == false)
                {
                    same = false;
                }

                line1 = bufferFile1.readLine();
                line2 = bufferFile2.readLine();
            }

            return same;
        }

    }
    @Test
    public void writeRanking() throws IOException {
        Play play = new PlayMock();
        Player player = new PlayerMock();

        player.setNickName("Joel");
        play.setTime(351);
        play.setPlayer(player);
        Ranking ranking = new Ranking();
        ranking.writeRanking(play);
        boolean returnValue0 = isEqual("src/Module/Ranking.txt", "Test/RankingTest/RankingTest1.txt");
        Assert.assertEquals(true, returnValue0);

        player.setNickName("Ahmed");
        play.setTime(352);
        play.setPlayer(player);
        ranking.writeRanking(play);
        boolean returnValue1 = isEqual("src/Module/Ranking.txt", "Test/RankingTest/RankingTest2.txt");
        Assert.assertEquals(true, returnValue1);

        player.setNickName("Toni");
        play.setTime(350);
        play.setPlayer(player);
        ranking.writeRanking(play);
        boolean returnValue2 = isEqual("src/Module/Ranking.txt", "Test/RankingTest/RankingTest3.txt");
        Assert.assertEquals(true, returnValue2);

        player.setNickName("Xavier");
        play.setTime(351);
        play.setPlayer(player);
        ranking.writeRanking(play);
        boolean returnValue3 = isEqual("src/Module/Ranking.txt", "Test/RankingTest/RankingTest4.txt");
        Assert.assertEquals(true, returnValue3);

        player.setNickName("");
        play.setTime(0);
        play.setPlayer(player);
        ranking.setPathRanking("src/Module");
        boolean returnValue5 = ranking.writeRanking(play);
        Assert.assertEquals(false, returnValue5);

        player.setNickName("");
        play.setTime(0);
        play.setPlayer(player);
        ranking.setPathRanking("");
        boolean returnValue6 = ranking.writeRanking(play);
        Assert.assertEquals(false, returnValue6);

        BufferedWriter emptyContentsOfFile = new BufferedWriter(new FileWriter("src/Module/Ranking.txt"));
        emptyContentsOfFile.write("");
        emptyContentsOfFile.close();

    }
}