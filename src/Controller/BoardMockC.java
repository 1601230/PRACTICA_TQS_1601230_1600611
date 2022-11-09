package Controller;

import java.util.ArrayList;
import java.util.List;

public class BoardMockC extends Board{

    public void setFlags(int flags) { this.flags = flags; }
    public int inicialitzateBoard(int level)
    {
        List<Box> testList = new ArrayList<Box>();

        Box testBox1 = new Box();
        testBox1.setOpen(true);
        testList.add(testBox1);

        Box testBox2 = new Box();
        testBox2.setMine(true);
        testList.add(testBox2);

        Box testBox3 = new Box();
        testBox3.setOpen(true);
        testBox3.setContent("F");
        testList.add(testBox3);

        Box testBox4 = new Box();
        testList.add(testBox4);

        Box testBox5 = new Box();
        testList.add(testBox5);

        Box testBox6 = new Box();
        testList.add(testBox6);

        Box testBox7 = new Box();
        testList.add(testBox7);

        Box testBox8 = new Box();
        testList.add(testBox8);

        Box testBox9 = new Box();
        testBox9.setOpen(true);
        testList.add(testBox9);

        Box testBox10 = new Box();
        testBox10.setMine(true);
        testList.add(testBox10);

        for (int i = 0; i < 8; i++)
        {
            board.add(testList);
        }
        return 1;
    }
}
