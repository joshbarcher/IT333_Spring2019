package queues;

import java.util.Arrays;
import java.util.Random;

public class TestHeap
{
    public static void main(String[] args)
    {
        testBuildHeap();
    }

    private static void testBuildHeap()
    {
        BinaryHeap<Integer> numbersHeap = new BinaryHeap<>(
            new Integer[] {13, 2, 15, 7, 0, -10, 5, 6, -20}
        );

        while (!numbersHeap.isEmpty())
        {
            System.out.println(numbersHeap.deleteMin());
        }
    }

    private static void stressTest()
    {
        Random random = new Random();
        BinaryHeap<Integer> numbersHeap = new BinaryHeap<>();

        for (int i = 0; i < 1000; i++)
        {
            numbersHeap.insert(random.nextInt(10000));
        }

        while (!numbersHeap.isEmpty())
        {
            System.out.println(numbersHeap.deleteMin());
        }
    }

    private static void testDeleteMin()
    {
        //build a heap
        BinaryHeap<Integer> numbersHeap = new BinaryHeap<>();
        numbersHeap.insert(21, 5, 0, 3, 14);

        //call delete min a few times and verify
        System.out.println(numbersHeap.deleteMin());
        System.out.println(numbersHeap.deleteMin());
        System.out.println(numbersHeap.deleteMin());
    }

    private static void testInsert()
    {
        BinaryHeap<Integer> numbersHeap = new BinaryHeap<>();
        Random random = new Random();

        //add a few elements
        for (int i = 0; i < 15; i++)
        {
            numbersHeap.insert(random.nextInt(20));
        }

        //print out the heap
        System.out.println(Arrays.toString(numbersHeap.heap));
    }
}
