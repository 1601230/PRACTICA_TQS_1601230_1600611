package Controller;

import java.util.ArrayList;
import java.util.List;

public class BoardMockD extends Board{

    public int inicialitzateBoard(int level)
    {
        List<Box> testList = new ArrayList<Box>();

        Box testBox = new Box();
        testBox.setOpen(true);

        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);


        for (int i = 0; i < 8; i++)
        {
            board.add(testList);
        }
        return 1;
    }
}
