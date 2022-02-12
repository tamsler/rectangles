package org.tamsler.services;

import org.junit.jupiter.api.Test;
import org.tamsler.models.Point;
import org.tamsler.models.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAbstractShapeService {

    @Test
    public void testRectangleHasIntersection() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(4, 5));

        assertEquals("Intersection (1,1) (3,4)", rectangleService.getIntersectionType(r1, r2));

        Rectangle r3 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r4 = new Rectangle(new Point(2, -1), new Point(4, 2));

        assertEquals("Intersection (2,1) (3,2)", rectangleService.getIntersectionType(r3, r4));
    }

    @Test
    public void testRectangleHasNoIntersection() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(-4, 0), new Point(-2, 1));

        assertEquals("No Intersection", rectangleService.getIntersectionType(r1, r2));
    }

    @Test
    public void testRectangleHasContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(2, 3));

        assertEquals("Containment", rectangleService.getContainmentType(r1, r2));
        assertEquals("Containment", rectangleService.getContainmentType(r2, r1));
    }

    @Test
    public void testRectangleHasNoContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(2, -1), new Point(4, 2));

        assertEquals("Intersection - No Containment", rectangleService.getContainmentType(r1, r2));

        Rectangle r3 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r4 = new Rectangle(new Point(-1, -3), new Point(0, -1));

        assertEquals("No Containment", rectangleService.getContainmentType(r3, r4));

    }
}
