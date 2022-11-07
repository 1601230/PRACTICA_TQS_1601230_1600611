package Module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataBase {
    public static BufferedReader readFile(String pathFile) throws FileNotFoundException {
        BufferedReader buffer;
        File existFile = new File(pathFile);

        if (!existFile.exists())
        {
            System.out.println("The file with path " + pathFile + " don't exist!!\n");
            buffer = null;
        }
        else if (pathFile == "")
        {
            System.out.println("The path is empty!!\n");
            buffer = null;
        }
        else
        {
            FileReader rankingRead = new FileReader(pathFile);
            buffer = new BufferedReader(rankingRead);
        }

        return buffer;
    }
}
