package openaddressing;

import java.util.Iterator;

public class HashTable<T> implements Iterable<T>
{
    private static final int INIT_TABLE_SIZE = 10;
    private static final double MAX_LOAD_FACTOR = 0.6;
    public static final double RESIZE_RATE = 1.5;

    private int size;
    private HashElement[] table;

    public HashTable()
    {
        table = new HashElement[INIT_TABLE_SIZE];
    }

    public HashElement[] getTable()
    {
        return table;
    }

    public boolean add(T element)
    {
        //did we exceed our load factor?
        double loadFactor = (double)size / table.length;
        if (loadFactor > MAX_LOAD_FACTOR)
        {
            resize();
        }

        //find the position in the table
        int hashCode = Math.abs(element.hashCode());
        int index = hashCode % table.length;

        //check for collisions
        while (table[index] != null)
        {
            if (table[index].data.equals(element))
            {
                if (table[index].active)
                {
                    return false;
                }
                else
                {
                    table[index].active = true;
                    return true;
                }
            }

            index = (index + 1) % table.length;
        }

        //place the element
        table[index] = new HashElement(element, true);
        size++;
        return true;
    }

    private void resize()
    {
        //save the data in the old table
        HashElement[] oldTable = table;

        //reset my housekeeping variables
        size = 0;

        //create a new array
        table = new HashElement[(int)(oldTable.length * RESIZE_RATE)];

        //copy elements into the new table
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null && oldTable[i].active)
            {
                add((T)oldTable[i].data);
            }
        }
    }

    public boolean contains(T element)
    {
        return false;
    }

    public int size()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    public boolean remove(T element)
    {
        return false;
    }

    public String toString()
    {
        return "";
    }

    private class HashElement<T>
    {
        private T data;
        private boolean active;

        public HashElement(T data, boolean active)
        {
            this.data = data;
            this.active = active;
        }

        public String toString()
        {
            if (!active)
            {
                return "inactive";
            }
            else
            {
                return data.toString();
            }
        }
    }
}
