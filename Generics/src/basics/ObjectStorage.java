package basics;

public class ObjectStorage
{
    private Object data;

    public ObjectStorage(Object data)
    {
        this.data = data;
    }

    public Object getData()
    {
        return data;
    }

    public String toString()
    {
        return data.toString();
    }
}
