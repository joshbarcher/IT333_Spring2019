package openaddressing;

import java.util.Arrays;
import java.util.Random;

public class TestTable
{
    public static void main(String[] args)
    {
        Random numberGen = new Random();
        HashTable<Integer> numberSet = new HashTable<>();

        //add a few elements
        for (int i = 0; i < 50; i++)
        {
            numberSet.add(numberGen.nextInt(100));
        }

        //print them out
        System.out.println(Arrays.toString(numberSet.getTable()));
    }
}
