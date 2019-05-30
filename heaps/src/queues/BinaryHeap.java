package queues;

public class BinaryHeap<T extends Comparable<T>>
{
    private static final int INITIAL_HEAP_SIZE = 10;

    public T[] heap;
    private int size;

    public BinaryHeap()
    {
        heap = (T[])new Comparable[INITIAL_HEAP_SIZE];
    }

    //assemble the array using the heapify routine
    public BinaryHeap(T[] inputElements)
    {
        //make just enough room...
        heap = (T[])new Comparable[inputElements.length + 1];

        //copy the elements over
        for (int i = 0; i < inputElements.length; i++)
        {
            heap[i + 1] = inputElements[i];
        }

        size = inputElements.length;

        //heapify!
        for (int i = inputElements.length / 2; i >= 1; i--)
        {
            sink(i);
        }
    }

    public void insert(T element)
    {
        //have we run out of room?
        if (size == heap.length - 1)
        {
            resize();
        }

        //where to place new element?
        size++;
        heap[size] = element;
        swim(size);
    }

    public void insert(T... elements)
    {
        for (int i = 0; i < elements.length; i++)
        {
            insert(elements[i]);
        }
    }

    private void swim(int current)
    {
        while (current > 1)
        {
            int parent = current / 2;

            //compare with parent and swap if out of order...
            if (heap[current].compareTo(heap[parent]) < 0)
            {
                //swap the smaller child with the larger parent
                swap(current, parent);
                current = parent;
            }
            else
            {
                return; //exit
            }
        }
    }

    private void swap(int first, int second)
    {
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private void resize()
    {
        T[] newHeap = (T[])new Comparable[heap.length * 2];

        for (int i = 1; i < heap.length; i++)
        {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }

    public T deleteMin()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Empty priority queue");
        }

        //save my result, move the "last" element to the root
        T saveResult = heap[1];
        heap[1] = heap[size];
        heap[size] = null;

        //decrement size and sink
        size--;
        sink(1);

        return saveResult;
    }

    private void sink(int current)
    {
        //loop until I reach a node without a child
        while (current <= size / 2)
        {
            int left = current * 2;
            int right = current * 2 + 1;

            //find the child to compare the parent with
            int smallestIndex = left;
            if (right <= size && heap[right].compareTo(heap[left]) < 0)
            {
                smallestIndex = right;
            }

            if (heap[current].compareTo(heap[smallestIndex]) > 0)
            {
                swap(current, smallestIndex);

                //move to the smaller of the two children...
                current = smallestIndex;
            }
            else
            {
                //short-circuit, both children are larger than the current element
                break;
            }
        }
    }

    public T peek()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Empty priority queue");
        }

        return heap[1];
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}
