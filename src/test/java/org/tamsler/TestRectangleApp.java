package org.tamsler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.tamsler.models.Point;
import org.tamsler.models.Rectangle;

public class TestRectangleApp {

    @Test
    public void testGetPointsFromCoordinateString() {

        RectangleApp rectangleApp = new RectangleApp();
        List<Point> points = rectangleApp.getPoints("1,2 4,4 -5,1 9,4");
        assertEquals(1, points.get(0).getX());
        assertEquals(2, points.get(0).getY());
        assertEquals(4, points.get(1).getX());
        assertEquals(4, points.get(1).getY());
        assertEquals(-5, points.get(2).getX());
        assertEquals(1, points.get(2).getY());
        assertEquals(9, points.get(3).getX());
        assertEquals(4, points.get(3).getY());
    }

    @Test
    public void testDetectRectangleRelationshipType() {

        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        RectangleApp rectangleApp = new RectangleApp();
        List<Point> points = rectangleApp.getPoints("1,2 4,4 -5,1 9,4");

        Rectangle rectangle1 = new Rectangle(points.get(0), points.get(1));
        Rectangle rectangle2 = new Rectangle(points.get(2), points.get(3));

        rectangleApp.detectRectangleRelationshipType(rectangle1, rectangle2);

        assertEquals("(1,2), (4,4) : (-5,1), (9,4)\n"
                + "Intersection (1,2) (4,4)\n"
                + "Containment\n"
                + "Not Adjacent", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testProcessFile() {
        
        RectangleApp rectangleApp = new RectangleApp();
        assertDoesNotThrow(() -> {
            rectangleApp.processFile(Main.INPUT_FILE);
        });
    }
}
