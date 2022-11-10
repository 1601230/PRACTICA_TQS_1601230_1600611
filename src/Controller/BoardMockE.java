package Controller;

import java.util.ArrayList;
import java.util.List;

public class BoardMockE extends Board{
    public int inicialitzateBoard(int level)
    {
        List<Box> testList = new ArrayList<Box>();


        for (int i = 0; i < 7; i++)
        {
            Box testBox1 = new Box();
            testBox1.setOpen(false);
            testList.add(testBox1);

            Box testBox2 = new Box();
            testBox2.setOpen(false);
            testList.add(testBox2);

            Box testBox3 = new Box();
            testBox3.setOpen(false);
            testList.add(testBox3);

            Box testBox4 = new Box();
            testBox4.setOpen(false);
            testList.add(testBox4);

            Box testBox5 = new Box();
            testBox5.setOpen(false);
            testList.add(testBox5);

            Box testBox6 = new Box();
            testBox6.setOpen(false);
            testList.add(testBox6);

            Box testBox7 = new Box();
            testBox7.setOpen(false);
            testList.add(testBox7);

            Box testBox8 = new Box();
            testBox8.setOpen(false);
            testList.add(testBox8);

            Box testBox9 = new Box();
            testBox9.setOpen(false);
            testList.add(testBox9);

            Box testBox10 = new Box();
            testBox10.setOpen(false);
            testList.add(testBox10);
            board.add(testList);
        }

        testList.clear();
        Box testBox1 = new Box();
        testBox1.setOpen(false);
        testList.add(testBox1);

        Box testBox2 = new Box();
        testBox2.setOpen(false);
        testList.add(testBox2);

        Box testBox3 = new Box();
        testBox3.setOpen(false);
        testList.add(testBox3);

        Box testBox4 = new Box();
        testBox4.setOpen(false);
        testList.add(testBox4);

        Box testBox5 = new Box();
        testBox5.setOpen(false);
        testList.add(testBox5);

        Box testBox6 = new Box();
        testBox6.setOpen(false);
        testList.add(testBox6);

        Box testBox7 = new Box();
        testBox7.setOpen(false);
        testList.add(testBox7);

        Box testBox8 = new Box();
        testBox8.setOpen(false);
        testList.add(testBox8);

        Box testBox9 = new Box();
        testBox9.setOpen(false);
        testList.add(testBox9);

        Box testMine = new Box();
        testMine.setOpen(false);
        testMine.setMine(true);
        testList.add(testMine);
        board.add(testList);

        return 1;
    }

    public List<List<Box>> expectedOutput()
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


        for (int i = 0; i < 6; i++)
        {
            board.add(testList);
        }

        testList.clear();
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);

        Box testContentOne1 = new Box();
        testContentOne1.setOpen(true);
        testContentOne1.setContent("1");
        testList.add(testContentOne1);

        Box testContentOne2 = new Box();
        testContentOne2.setOpen(true);
        testContentOne2.setContent("1");
        testList.add(testContentOne2);
        board.add(testList);

        testList.clear();
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);
        testList.add(testBox);

        Box testContentOne3 = new Box();
        testContentOne3.setOpen(true);
        testContentOne3.setContent("1");
        testList.add(testContentOne3);

        Box testMine = new Box();
        testMine.setOpen(false);
        testMine.setMine(true);
        testList.add(testMine);
        board.add(testList);

        return board;
    }
}
