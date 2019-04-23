package comparisons;

import java.util.Arrays;
import java.util.Random;

public class SortingPeople
{
    public static void main(String[] args)
    {
        Random random = new Random();

        String[] names = {"Lily", "Gendry", "Jerome", "Jamie", "Olivia"};
        String[] hairColors = {"Brunette", "Blonde", "Black", "White", "Gray", "Red"};

        Person[] people = new Person[30];

        for (int i = 0; i < people.length; i++)
        {
            people[i] = new Person(
                    names[random.nextInt(names.length)],
                    hairColors[random.nextInt(hairColors.length)],
                    random.nextInt(25) + 51 //50-75 inches
            );
        }

        //do something...
    }

    private static void printArray(Person[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        System.out.println();
    }
}