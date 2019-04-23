package comparisons;

import java.util.Arrays;

public class SortingMovies
{
    public static void main(String[] args)
    {
        Movie[] movies = {
            new Movie("Power Rangers", 91, 1996),
            new Movie("The Fellowship of the Ring", 160, 2010),
            new Movie("Power Rangers", 124, 2017),
            new Movie("Avengers", 140, 2015)
        };

        //print out the unsorted array
        printArray(movies);

        //print out the sorted array
        Arrays.sort(movies);
        printArray(movies);
    }

    private static void printArray(Object[] array)
    {
        for (Object element : array)
        {
            System.out.println(element);
        }
        System.out.println();
    }
}
