package Controller;

import java.util.ArrayList;
import java.util.List;

public class BoardMockE extends Board{
    public int inicialitzateBoard(int level)
    {
        List<Box> testList0 = new ArrayList<Box>();
        for (int j = 0; j < 10; j++)
        {
            Box testBox = new Box();
            testBox.setOpen(false);
            if (j == 0)
            {
                testBox.setMine(true);
            }
            testList0.add(testBox);
        }
        board.add(testList0);

        for (int i = 0; i < 6; i++)
        {
            List<Box> testList = new ArrayList<Box>();
            for (int j = 0; j < 10; j++)
            {
                Box testBox = new Box();
                testBox.setOpen(false);
                testList.add(testBox);
            }
            board.add(testList);
        }

        List<Box> testList1 = new ArrayList<Box>();
        for (int j = 0; j < 10; j++)
        {
            Box testBox = new Box();
            testBox.setOpen(false);
            if (j == 9)
            {
                testBox.setMine(true);
            }
            testList1.add(testBox);
        }
        board.add(testList1);

        return 1;
    }
}
