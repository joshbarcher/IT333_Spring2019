package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
    private Node root;
    private int size;

    public BinarySearchTree()
    {
        //do something...
    }

    public void add(T... elements)
    {
        for (int i = 0; i < elements.length; i++)
        {
            add(elements[i]);
        }
    }

    public void add(T element)
    {
        root = add(root, element);
    }

    private Node add(Node current, T element)
    {
        //if we ever find an empty spot in the tree, we'll place
        //our element there! (base case)
        if (current == null)
        {
            size++; //increment when we add a new element
            return new Node(element);
        }

        //make a comparison
        int compare = element.compareTo(current.data);
        if (compare == 0)
        {
            //contain a duplicate
            return current;
        }
        else if (compare < 0)
        {
            current.left = add(current.left, element);
        }
        else //compare > 0
        {
            current.right = add(current.right, element);
        }
        return current;
    }

    public boolean contains(T element)
    {
        return contains(root, element);
    }

    private boolean contains(Node current, T element)
    {
        if (current == null)
        {
            return false;
        }

        int compare = current.data.compareTo(element);

        if (compare < 0) //go right
        {
            return contains(current.right, element);
        }
        else if (compare > 0) //go left
        {
            return contains(current.left, element);
        }
        else //compare == 0
        {
            //found it!
            return true;
        }
    }

    public void remove(T element)
    {
        root = remove(element, root);
    }

    private Node remove(T element, Node current)
    {
        //base case (not found)
        if (current == null)
        {
            return null; //exit
        }

        //search for the element
        int compare = element.compareTo(current.data);
        if (compare == 0)
        {
            //found it!
            if (current.left == null && current.right == null)
            {
                size--;
                return null;
            }
            else if (current.left == null) //left child
            {
                size--;
                return current.right;
            }
            else if (current.right == null)
            {
                size--;
                return current.left;
            }

            //two-children case...
            T replacement = findMax(current.left);
            current.data = replacement;
            remove(replacement, current.left);
        }
        else if (compare > 0)
        {
            current.right = remove(element, current.right);
        }
        else //compare < 0
        {
            current.left = remove(element, current.left);
        }
        return current;
    }

    private T findMin(Node current)
    {
        if (current.left == null)
        {
            return current.data;
        }
        return findMin(current.left);
    }

    private T findMax(Node current)
    {
        if (current.right == null)
        {
            return current.data;
        }
        return findMax(current.right);
    }

    public int size()
    {
        return size;
    }

    public List<T> inOrder()
    {
        List<T> results = new ArrayList<>();

        inOrder(root, results);

        return results;
    }

    private void inOrder(Node current, List<T> results)
    {
        if (current == null)
        {
            return; //exit
        }

        //left, node, right
        inOrder(current.left, results);
        results.add(current.data);
        inOrder(current.right, results);
    }

    @Override
    public Iterator<T> iterator()
    {
        return new NaiveIterator();
    }

    private class NaiveIterator implements Iterator<T>
    {
        private List<T> elements;
        private int nextElement = 0;

        public NaiveIterator()
        {
            elements = inOrder();
        }

        @Override
        public boolean hasNext()
        {
            return nextElement < size;
        }

        @Override
        public T next()
        {
            return elements.get(nextElement++);
        }
    }

    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data = data;
        }

        public Node(T data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}