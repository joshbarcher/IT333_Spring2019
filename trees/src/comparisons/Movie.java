package comparisons;

public class Movie implements Comparable<Movie>
{
    private String title;
    private double length;
    private int yearReleased;

    public Movie(String title, double length, int yearReleased)
    {
        this.title = title;
        this.length = length;
        this.yearReleased = yearReleased;
    }

    public String getTitle()
    {
        return title;
    }

    public double getLength()
    {
        return length;
    }

    public int getYearReleased()
    {
        return yearReleased;
    }

    @Override
    public int compareTo(Movie other)
    {
        int difference = this.title.compareTo(other.title);

        if (difference == 0)
        {
            return this.yearReleased - other.yearReleased;
        }
        return difference;
    }

    public String toString()
    {
        return "(" + title + "," + length + "," + yearReleased + ")";
    }
}
