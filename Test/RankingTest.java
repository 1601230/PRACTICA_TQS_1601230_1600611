import Controller.*;
import junit.framework.Assert;
import org.junit.Test;
import Module.Ranking;

import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class RankingTest {

    private boolean isEqual(String pathFile1, String pathFile2) throws IOException {

        File file1 = new File(pathFile1);
        File file2 = new File(pathFile2);

        if (Files.size(file1.toPath()) != Files.size(file2.toPath()))
        {
            return false;
        }
        else
        {
            boolean same = true;
            BufferedReader bufferFile1 =new BufferedReader(new FileReader(pathFile1));
            BufferedReader bufferFile2 =new BufferedReader(new FileReader(pathFile2));

            String line1 = "";
            String line2 = "";
            int cont1 = 0;
            int cont2 = 0;

            while((line1 != null || line2 != null) && same)
            {
                line1 = bufferFile1.readLine();
                line2 = bufferFile2.readLine();

                if(line1!=line2)
                {
                    same = false;
                }
            };

            return same;
        }

    }
    @Test
    public void writeRanking() throws IOException {
        Play play = new PlayMock();
        Player player = new PlayerMock();
        play.setPlayer(player);

        Ranking ranking = new Ranking();
        ranking.writeRanking(play);
        boolean returnValue0 = isEqual("src/Module/Ranking.txt", "Test/RankingTest/RankingTest1.txt");
        Assert.assertEquals(true, returnValue0);

        play.setTime(352);
        player.setNickName("Ahmed");
        play.setPlayer(player);
        ranking.writeRanking(play);
        boolean returnValue1 = isEqual("src/Module/Ranking.txt", "Test/RankingTest/RankingTest2.txt");
        Assert.assertEquals(true, returnValue1);
    }
}