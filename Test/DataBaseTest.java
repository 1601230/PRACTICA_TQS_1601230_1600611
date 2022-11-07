import junit.framework.Assert;
import org.junit.Test;
import Module.DataBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import static org.junit.Assert.*;

public class DataBaseTest {

    @Test
    public void readFile() throws IOException {

        BufferedReader valueReturn0 = DataBase.readFile(""); //no valid
        Assert.assertEquals(null, valueReturn0);

        BufferedReader valueReturn1 = DataBase.readFile("src/Module/Easy level 1.txt");// valid
        Assert.assertEquals("0 0 0 0 0 0 0 0 0 0", valueReturn1.readLine());

        BufferedReader valueReturn2 = DataBase.readFile("src/Easy level 1.txt");//no valid
        Assert.assertEquals(null, valueReturn2);

        BufferedReader valueReturn3 = DataBase.readFile("src/Module");// no valid
        Assert.assertEquals(null, valueReturn3);
    }
}