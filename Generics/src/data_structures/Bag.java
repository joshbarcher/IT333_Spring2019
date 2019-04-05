package data_structures;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>
{
    //store all elements in our data structure in a fixed size array
    private T[] data;
    private int size; //number of elements in the bag

    public Bag(int capacity)
    {
        //if size is not positive
        if (capacity <= 0)
        {
            throw new IllegalArgumentException("Size must be positive: " + capacity);
        }

        data = (T[])new Number[capacity];
    }

    public void add(T element)
    {
        //is the bag full?
        if (isFull())
        {
            throw new IllegalStateException("This bag is full...");
        }

        data[size] = element;
        size++;
    }

    public boolean contains(T element)
    {
        for (int i = 0; i < size; i++)
        {
            if (data[i].equals(element))
            {
                return true;
            }
        }
        return false;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == data.length;
    }

    public void remove(T element)
    {

    }

    @Override
    public Iterator<T> iterator()
    {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T>
    {
        private int positionOfNextElement;

        public BagIterator()
        {
            positionOfNextElement = 0;
        }

        @Override
        public boolean hasNext()
        {
            return positionOfNextElement < size;
        }

        @Override
        public T next()
        {
            //prepare the next value to return
            T next = data[positionOfNextElement];

            //move to the next index
            positionOfNextElement++;

            //return the next element
            return next;
        }
    }
}
