package org.tamsler.services;

import org.junit.jupiter.api.Test;
import org.tamsler.models.Point;
import org.tamsler.models.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAbstractShapeService {

    // Test Intersection : Intersection
    @Test
    public void testRectangleIntersection() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(4, 5));

        assertEquals("Intersection (1,1) (3,4)", rectangleService.getIntersectionType(r1, r2));
    }

    // Test Intersection: No Intersection
    @Test
    public void testNoIntersection() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(-4, 0), new Point(-2, 1));

        assertEquals("No Intersection", rectangleService.getIntersectionType(r1, r2));
    }

    // Test Containment: Containment
    @Test
    public void testHasContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(2, 3));

        assertEquals("Containment", rectangleService.getContainmentType(r1, r2));
        assertEquals("Containment", rectangleService.getContainmentType(r2, r1));
    }

    // Test Containment: No Containment
    @Test
    public void testNoContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r3 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r4 = new Rectangle(new Point(-1, -3), new Point(0, -1));

        assertEquals("No Containment", rectangleService.getContainmentType(r3, r4));
    }

    // Test Containment: Intersection - No Containment
    @Test
    public void testHasNoContainment() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(2, -1), new Point(4, 2));

        assertEquals("Intersection - No Containment", rectangleService.getContainmentType(r1, r2));
    }

    // Test Adjacency: Adjacency (Sub-line)
    @Test
    public void testAdjacencySubLine() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(1, -1), new Point(2, 0));

        assertEquals("Adjacency (Sub-line)", rectangleService.getAdjacencyType(r1, r2));
    }

    // Test Adjacency: Adjacency (Proper)
    @Test
    public void testAdjacencyProper() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(3, 2));
        Rectangle r2 = new Rectangle(new Point(3, 0), new Point(6, 2));

        assertEquals("Adjacency (Proper)", rectangleService.getAdjacencyType(r1, r2));
    }

    // Test Adjacency: Adjacency (Partial)
    @Test
    public void testAdjacencyPartial() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(-1, -1), new Point(1, 1));
        Rectangle r2 = new Rectangle(new Point(0, 1), new Point(2, 2));

        assertEquals("Adjacency (Partial)", rectangleService.getAdjacencyType(r1, r2));
    }

    // Test Adjacency: Not Adjacent
    @Test
    public void testAdjacencyNotAdjacent() {

        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(2, 1));
        Rectangle r2 = new Rectangle(new Point(3, 2), new Point(5, 5));

        assertEquals("Not Adjacent", rectangleService.getAdjacencyType(r1, r2));
    }

    // FIXME
    @Test
    public void testFoo() {
        RectangleServiceImpl rectangleService = RectangleServiceImpl.getInstance();

        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(3, 4));
        Rectangle r2 = new Rectangle(new Point(-4, 0), new Point(-2, 1));

        System.out.println("Fooo 1");
        assertEquals("Not Adjacent", rectangleService.getAdjacencyType(r1, r2));
    }
}
