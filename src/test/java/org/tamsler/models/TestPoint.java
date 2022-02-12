package org.tamsler.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestPoint {

    @Test
    public void testPointCoordinates() {
        Point p = new Point(1, 2);
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void testEqualReference() {
        Point p = new Point(3, 1);
        assertTrue(p.equals(p));
    }

    @Test
    public void testEqualValue() {
        Point p1 = new Point(-4, 5);
        Point p2 = new Point(-4, 5);

        assertTrue(p1.equals(p2));
    }
}
