package Module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
The DataBase class is the class that has the function of reading files and returning the resulting read
buffer to the method that requested the read
 */
public class DataBase {
    public static BufferedReader readFile(String pathFile) throws FileNotFoundException {
        BufferedReader buffer = null;
        File existFile = new File(pathFile);

        if (!existFile.exists()) /*Check if path exists*/
        {
            System.out.println("ERROR: The file don't exist!!\n");
        }
        else if (existFile.isFile()) /*Check if path is of a txt ficher*/
        {
            FileReader readFile = new FileReader(pathFile);
            buffer = new BufferedReader(readFile);
        }
        else
        {
            System.out.println("ERROR:The path is not from a file!!\n");
        }

        return buffer;
    }
}
