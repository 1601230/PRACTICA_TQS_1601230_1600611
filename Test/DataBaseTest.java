import junit.framework.Assert;
import org.junit.Test;
import Module.DataBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

public class DataBaseTest {

    @Test
    public void readFile() throws FileNotFoundException {

        BufferedReader valueReturn0 = DataBase.readFile(""); //no valid
        Assert.assertEquals(null, valueReturn0);

        BufferedReader valueReturn1 = DataBase.readFile("src/Module/Easy level 1.txt"); // valid
        Assert.assertEquals(new BufferedReader(new FileReader("src/Module/Easy level 1.txt")), valueReturn1);
    }
}