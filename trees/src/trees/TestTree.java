package trees;

import java.util.Arrays;
import java.util.Collections;

public class TestTree
{
    public static void main(String[] args)
    {
        BinarySearchTree<Character> letterTree = new BinarySearchTree<>();
        letterTree.add('m', 'h', 'r', 'a', 'j', 'p', 't', 'l', 'n', 's', 'k', 'o');

        //practice removing elements
        System.out.println(letterTree.size());
        letterTree.remove('o'); //no child
        System.out.println(letterTree.size());
        letterTree.remove('t'); //one child
        System.out.println(letterTree.size());
        letterTree.remove('m'); //two children
        System.out.println(letterTree.size());

        //System.out.println(letterTree.inOrder());

        for (char letter : letterTree)
        {
            System.out.println(letter);
        }
    }
}
