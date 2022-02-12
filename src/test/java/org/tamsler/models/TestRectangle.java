package org.tamsler.models;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestRectangle {

    @Test
    public void testRectangleWithTwoPoints() {

        Point bottomLeft = new Point(1, 1);
        Point topRight = new Point(3, 4);
        Rectangle r = new Rectangle(bottomLeft, topRight);
        assertTrue(r.getBottomLeft().equals(bottomLeft));
        assertTrue(r.getBottomRight().equals(new Point(3, 1)));
        assertTrue(r.getTopRight().equals(topRight));
        assertTrue(r.getTopLeft().equals(new Point(1, 4)));
    }

    @Test
    public void testRectangleWithOnePointAndWidthAndHeight() {

        Point bottomLeft = new Point(1, 1);
        int width = 2;
        int height = 3;
        Rectangle r = new Rectangle(bottomLeft, width, height);
        assertTrue(r.getBottomLeft().equals(bottomLeft));
        assertTrue(r.getBottomRight().equals(new Point(3, 1)));
        assertTrue(r.getTopRight().equals(new Point(3, 4)));
        assertTrue(r.getTopLeft().equals(new Point(1, 4)));
    }

    @Test
    public void testRectangleConstructorsNullAndPoint() {

        // Illegal first method argument
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(null, new Point(1, 1));
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRectangleConstructorsPointAndNull() {

        // Illegal second method argument
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(new Point(3, -1), null);
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRectangleConstructorsNullAndNull() {

        // Illegal first and second method arguments
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(null, null);
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRectangleConstructorsNullNumberNumber() {

        // Illegal first method argument
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(null, 3, 1);
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRectangleConstructorsPointZeroNumber() {

        // Illegal second method argument
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(new Point(3, 4), 0, 5);
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRectangleConstructorsPointNumberZero() {

        // Illegal third method argument
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(new Point(3, 4), 3, 0);
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRectangleConstructorsNullZeroZero() {

        // Illegal first, second, and third method arguments
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(null, 0, 0);
        });

        String expectedMessage = Rectangle.NULL_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testInvalidRectangleDimensions() {

        // Define invalid line instead of rectangle
        Point bottomLeft = new Point(0, 0);
        Point topRight = new Point(0, 1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Rectangle r = new Rectangle(bottomLeft, topRight);
        });

        String expectedMessage = Rectangle.INVALID_ARGUMENT_EXCEPTION_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
