package comparisons;

import java.util.Comparator;

public class Person
{
	private String fullName;
	private String hairColor;
	private int heightInInches;

	public Person(String fullName, String hairColor, int heightInInches)
	{
		this.fullName = fullName;
		this.hairColor = hairColor;
		this.heightInInches = heightInInches;
	}

	public String getFullName()
	{
		return fullName;
	}

	public String getHairColor()
	{
		return hairColor;
	}

	public int getHeightInInches()
	{
		return heightInInches;
	}

	public String toString()
	{
		return "(" + fullName + "," + heightInInches + ")";
	}

	public static class NameComparator implements Comparator<Person>
	{
		@Override
		public int compare(Person first, Person last)
		{
			return first.fullName.compareTo(last.fullName);
		}
	}

	public static class HairComparator implements Comparator<Person>
	{
		@Override
		public int compare(Person first, Person last)
		{
			return first.hairColor.compareTo(last.hairColor);
		}
	}

	public static class HeightComparator implements Comparator<Person>
	{
		@Override
		public int compare(Person first, Person last)
		{
			return first.heightInInches - last.heightInInches;
		}
	}
}



