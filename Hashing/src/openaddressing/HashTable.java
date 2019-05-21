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
        double loadFactor = (double) size / table.length;
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
                //is this a duplicate?
                if (table[index].active)
                {
                    return false;
                }
                else
                {
                    table[index].active = true;
                    size++;
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
        table = new HashElement[(int) (oldTable.length * RESIZE_RATE)];

        //copy elements into the new table
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null && oldTable[i].active)
            {
                add((T) oldTable[i].data);
            }
        }
    }

    public boolean contains(T element)
    {
        int index = find(element);
        if (index != -1)
        {
            return table[index].active;
        }
        return false;
    }

    private int find(T element)
    {
        int hashCode = Math.abs(element.hashCode());
        int index = hashCode % table.length;

        while (table[index] != null)
        {
            if (table[index].data.equals(element))
            {
                return index;
            }

            index = (index + 1) % table.length;
        }
        return -1;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean remove(T element)
    {
        int index = find(element);

        //did we find it?
        if (index != -1 && table[index].active)
        {
            table[index].active = false;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new HashTableIterator(table);
    }

    public String toString()
    {
        return "";
    }

    private class HashTableIterator implements Iterator<T>
    {
        private HashElement[] table;
        private int nextIndex = -1;

        public HashTableIterator(HashElement[] table)
        {
            this.table = table;
            findNext();
        }

        //find the index of the next available element, or -1 if there is none
        private void findNext()
        {
            for (int i = nextIndex + 1; i < table.length; i++)
            {
                if (table[i] != null && table[i].active)
                {
                    nextIndex = i;
                    return;
                }
            }
            nextIndex = -1; //not found
        }

        @Override
        public boolean hasNext()
        {
            return nextIndex != -1;
        }

        @Override
        public T next()
        {
            T result = (T)table[nextIndex].data;
            findNext();
            return result;
        }
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
