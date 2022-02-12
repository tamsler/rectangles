package org.tamsler.services;

import org.junit.jupiter.api.Test;
import org.tamsler.models.Point;
import org.tamsler.models.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRectangleServiceImpl {

    // Test isIn
    @Test
    public void testSecondIsInFirstTrue() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(2, 3));

        assertTrue(rectangleService.isIn(r1, r2));
    }

    // Test isIn
    @Test
    public void testIsInFalse() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(2, 5));

        assertFalse(rectangleService.isIn(r1, r2));
    }

    // Test hasIntersection
    @Test
    public void testHasIntersection() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-3, -2), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(-2, -5), new Point(-1, -1));

        assertTrue(rectangleService.hasIntersection(r1, r2));
    }

    // Test hasIntersection
    @Test
    public void testHasNoIntersectionInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-3, -2), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(2, 5), new Point(4, 6));

        assertFalse(rectangleService.hasIntersection(r1, r2));
        assertFalse(rectangleService.hasIntersection(r2, r1));
    }

    // Test hasIntersection
    @Test
    public void testHasNoIntersectionY() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-3, -2), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(0, 5), new Point(4, 6));

        assertFalse(rectangleService.hasIntersection(r1, r2));
        assertFalse(rectangleService.hasIntersection(r2, r1));
    }

    // Test getIntersectionCoordinates
    @Test
    public void getIntersectionCoordinatesCase1() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(2, 2));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(3, 4));

        String intersectionCoordinates = rectangleService.getIntersectionCoordinates(r1, r2);
        assertEquals("(1,1) (2,2)", intersectionCoordinates);
    }

    // Test getIntersectionCoordinates
    @Test
    public void getIntersectionCoordinatesCase2() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(0, 2), new Point(3, 5));
        Rectangle r2 = new Rectangle(new Point(2, 0), new Point(4, 3));

        String intersectionCoordinates = rectangleService.getIntersectionCoordinates(r2, r1);
        assertEquals("(2,2) (3,3)", intersectionCoordinates);
    }

    // Test hasContainment
    @Test
    public void testHasContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-2, -2), new Point(2, 2));
        Rectangle r2 = new Rectangle(new Point(-1, -1), new Point(1, 1));

        assertTrue(rectangleService.hasContainment(r1, r2));
    }

    // Test hasContainment
    @Test
    public void testHasInterchangeableContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(-2, -2), new Point(2, 2));

        assertTrue(rectangleService.hasContainment(r1, r2));
    }

    // Test hasAdjacency
    @Test
    public void testHasPartialAdjacencyInY() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(1, 0), new Point(2, 2));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasPartialAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasPartialAdjacencyInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(0, 1), new Point(2, 2));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasPartialAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasNoProperAdjacencyInY() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(1, -1), new Point(2, 0));

        assertFalse(rectangleService.hasAdjacency(r1, r2).hasProperAdjacency());
        assertFalse(rectangleService.hasAdjacency(r2, r1).hasProperAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasProperAdjacencyInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, 0), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(-1, -1), new Point(1, 0));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasProperAdjacency());
        assertTrue(rectangleService.hasAdjacency(r2, r1).hasProperAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasNoProperAdjacencyInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, 0), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(-1, -1), new Point(0, 0));

        assertFalse(rectangleService.hasAdjacency(r1, r2).hasProperAdjacency());
        assertFalse(rectangleService.hasAdjacency(r2, r1).hasProperAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasSubLineAdjacencyBottomInY() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(1, -1), new Point(2, 0));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasSubLineAdjacency()
                || rectangleService.hasAdjacency(r2, r1).hasSubLineAdjacency());
    }

    @Test
    public void testHasSubLineAdjacencyMiddleInY() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-2, -2), new Point(0, 2));
        Rectangle r2 = new Rectangle(new Point(0, -1), new Point(1, 1));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasSubLineAdjacency()
                || rectangleService.hasAdjacency(r2, r1).hasSubLineAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasSubLineAdjacencyTopInY() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(1, 0), new Point(2, 1));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasSubLineAdjacency()
                || rectangleService.hasAdjacency(r2, r1).hasSubLineAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasSubLineAdjacencyLeftInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-2, -2), new Point(2, 2));
        Rectangle r2 = new Rectangle(new Point(-2, 2), new Point(0, 3));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasSubLineAdjacency()
                || rectangleService.hasAdjacency(r2, r1).hasSubLineAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasSubLineAdjacencyMiddleInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-2, -2), new Point(2, 2));
        Rectangle r2 = new Rectangle(new Point(-1, 2), new Point(1, 3));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasSubLineAdjacency()
                || rectangleService.hasAdjacency(r2, r1).hasSubLineAdjacency());
    }

    // Test hasAdjacency
    @Test
    public void testHasSubLineAdjacencyRightInX() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-2, -2), new Point(2, 2));
        Rectangle r2 = new Rectangle(new Point(0, 2), new Point(2, 3));

        assertTrue(rectangleService.hasAdjacency(r1, r2).hasSubLineAdjacency()
                || rectangleService.hasAdjacency(r2, r1).hasSubLineAdjacency());
    }
}
