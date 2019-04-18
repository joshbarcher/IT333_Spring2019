package inclass;

import org.junit.Assert;
import org.junit.Test;

/**
 * A set of tests for the Point class.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class PointTest
{

    public static final int TEST_Y = 20;
    public static final int TEST_X = 10;

    /**
     * Verifies that the Point constructor works.
     */
    @Test
    public void constructorTest()
    {
        //arrange and act
        Point myPoint = new Point(TEST_X, TEST_Y);

        //assert (verify)
        Assert.assertEquals("The Point() constructor does not assign the x component to the input parameter",
                TEST_X, myPoint.getX(), 0.0);
        Assert.assertEquals("The Point() constructor does not assign the y component to the input parameter",
                TEST_Y, myPoint.getY(), 0.0);
    }

    /**
     * Verifies that the isAtOrigin() method correctly detects the origin.
     */
    @Test
    public void originDetectionTest()
    {
        //create a few test points of interest
        Point point1 = new Point(0, 0);
        Point point2 = new Point(TEST_X, 0);
        Point point3 = new Point(0, TEST_Y);
        Point point4 = new Point(TEST_X, TEST_Y);

        //verify that isAtOrigin() works correctly
        Assert.assertTrue("(0,0) should return true, but is not", point1.isAtOrigin());
        Assert.assertFalse("(" + TEST_X + ",0) should return false, but is not", point2.isAtOrigin());
        Assert.assertFalse("(0," + TEST_Y + ") should return false, but is not", point3.isAtOrigin());
        Assert.assertFalse("(" + TEST_X + "," + TEST_Y + ") should return false, but is not",
                point4.isAtOrigin());
    }

    /**
     * Verifies that the isInQuadrant() method is working.
     */
    @Test
    public void quadrantTest()
    {
        Point[] points = {
            new Point(TEST_X, TEST_Y),
            new Point(-TEST_X, TEST_Y),
            new Point(-TEST_X, -TEST_Y),
            new Point(TEST_X, -TEST_Y)
        };

        //verifying matches to a quadrant
        for (int i = 0; i < points.length; i++)
        {
            int correctQuadrant = i + 1;
            Assert.assertTrue(points[i].toString() + " is not recognized in quadrant " + correctQuadrant,
                    points[i].isInQuadrant(correctQuadrant));

            //verify that there are no false positives
            for (int currentQuadrant = 1; currentQuadrant <= 4; currentQuadrant++)
            {
                if (currentQuadrant != correctQuadrant)
                {
                    Assert.assertFalse(points[i].toString() + " is recognized in quadrant " + currentQuadrant,
                            points[i].isInQuadrant(currentQuadrant));
                }
            }
        }
    }
}
