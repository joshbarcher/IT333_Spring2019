package inclass;

/**
 * Represents a points in a cartesian coordinate system.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Point
{
    private double x, y;

    /**
     * Creates a new points with the provided components.
     *
     * @param x the x component
     * @param y the y component
     */
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the x component.
     * @return the x value
     */
    public double getX()
    {
        return x;
    }

    /**
     * Retrieves the y component.
     * @return the y value
     */
    public double getY()
    {
        return y;
    }

    /**
     * Reports whether this points is located at the origin.
     *
     * @return true if this points is at (0,0), or false otherwise
     */
    public boolean isAtOrigin()
    {
        return x == 0 && y == 0;
    }

    /**
     * Calculates the distance between two points.
     *
     * @param other another points to compare against
     * @return the distance between this points and other
     */
    public double distance(Point other)
    {
        return Math.sqrt(Math.pow(x - other.x, 2) +
                         Math.pow(y - other.y, 2));
    }

    /**
     * Reports whether this points is in the input quadrant. The
     * quadrant must be a value with the range [1,4]
     * @param quadrant the quadrant to search within
     * @throws IllegalArgumentException this is thrown if the input quadrant
     * is outside of the range [1,4]
     *
     * @return true if this points is within the input quadrant, or false otherwise
     */
    public boolean isInQuadrant(int quadrant)
    {
        switch (quadrant)
        {
            case 1:
                return x > 0 && y > 0;
            case 2:
                return x < 0 && y > 0;
            case 3:
                return x < 0 && y < 0;
            case 4:
                return x > 0 && y < 0;
            default:
                throw new IllegalArgumentException(
                        "Unknown quadrant");
        }
    }

    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}


