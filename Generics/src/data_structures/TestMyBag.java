package data_structures;

import java.util.Random;

public class TestMyBag
{
    private static final Random RANDOM = new Random();

    public static void main(String[] args)
    {
        Bag<Integer> bagOfNumbers = new Bag<>(3);

        //make sure my bag is initially empty
        System.out.println("Bag is empty - " + bagOfNumbers.isEmpty());

        while (!bagOfNumbers.isFull())
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
        }
    }
}
