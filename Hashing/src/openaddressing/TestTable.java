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

        //add a number that we know will be in the table
        /*numberSet.add(12);

        //try to remove an element in the table and one that is not
        System.out.println("remove(12): " + numberSet.remove(12));
        System.out.println("remove(101): " + numberSet.remove(101));

        //print them out
        System.out.println(Arrays.toString(numberSet.getTable()));*/

        int count = 0;
        for (int number : numberSet)
        {
            System.out.println(count + ": " + number);
            count++;
        }
    }
}
