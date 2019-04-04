package basics;

public class TestGenerics
{
    public static void main(String[] args)
    {
        ObjectStorage storeString = new ObjectStorage("Hello world!");
        ObjectStorage storeNumber = new ObjectStorage(10);

        System.out.println(storeString);
        System.out.println(storeNumber);

        String string = (String)storeString.getData();
        int number = (Integer) storeNumber.getData();

        System.out.println(string);
        System.out.println(number);

        DataStorage<String> storeString2 = new DataStorage<String>("Hello world!");
        DataStorage<Integer> storeNumber2 = new DataStorage<Integer>(10);

        System.out.println(storeString2.getData().toUpperCase());
        System.out.println(storeNumber2.getData());

        DataStorage<Comparable> storeComparable = new DataStorage<Comparable>(10);
    }
}
