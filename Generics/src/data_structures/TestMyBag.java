package data_structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class TestMyBag
{
    private static final Random RANDOM = new Random();

    public static void main(String[] args)
    {
        Bag<Integer> bagOfNumbers = new Bag<>(15);

        //make sure my bag is initially empty
        System.out.println("Bag is empty - " + bagOfNumbers.isEmpty());

        for (int i = 0; i < 10; i++)
        {
            bagOfNumbers.add(RANDOM.nextInt(5));
        }

        System.out.println("Bag is empty - " + bagOfNumbers.isEmpty());
        System.out.println("Bag size - " + bagOfNumbers.size());

        for (int i = 0; i < 5; i++)
        {
            System.out.println("contains(" + i + ") - " + bagOfNumbers.contains(i));
        }

        for (int number : bagOfNumbers)
        {
            System.out.println(number);
            bagOfNumbers.add(0);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        for (int number : numbers)
        {
            System.out.println(number);
            numbers.add(0);
        }
    }
}
