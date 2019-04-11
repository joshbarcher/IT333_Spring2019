package run;

import pp.FileIterable;

public class TestIterators
{
    public static void main(String[] args)
    {
        FileIterable iter = new FileIterable("my_file.txt");
        FileIterable iter2 = new FileIterable("my_file.txt");

        for (String line : iter)
        {
            for (String line2 : iter2)
            {
                System.out.println(line2);
            }
            System.out.println(line);
        }

        for (String line : iter)
        {
            System.out.println(line);
        }
    }
}
