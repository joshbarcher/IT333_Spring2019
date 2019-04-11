package pp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class FileIterable implements Iterable<String>
{
    private String path;

    public FileIterable(String path)
    {
        this.path = path;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new FileIterator();
    }

    private class FileIterator implements Iterator<String>
    {
        private Scanner reader;

        public FileIterator()
        {
            try
            {
                reader = new Scanner(new FileInputStream(path));
            }
            catch (FileNotFoundException e)
            {
                throw new IllegalStateException("File not found: " + e.getMessage());
            }
        }

        @Override
        public boolean hasNext()
        {
            return reader.hasNextLine();
        }

        @Override
        public String next()
        {
            return reader.nextLine();
        }
    }
}
