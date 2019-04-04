package data_structures;

public class Bag<T extends Number>
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
        if (size == data.length)
        {
            throw new IllegalStateException("This bag is full...");
        }

        data[size] = element;
        size++;
    }

    public void remove(T element)
    {

    }
}
