/**
 * This class represents a rectangle in a 2D coordinate system
 * A rectangle can be created via 2 points : bottom left (x,y) and top right (x,y)
 * or via one point and width and height : bottom left (x,y), width, height
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler.models;

import lombok.Getter;

public class Rectangle {

    final static public String NULL_ARGUMENT_EXCEPTION_MESSAGE = "Null constructor arguments value(s)";
    final static public String INVALID_ARGUMENT_EXCEPTION_MESSAGE = "First argument is not bottom left point, and second argument is not top right point";
    final static public String SAME_POINT_EXCEPTION_MESSAGE = "Bottom left and top right coordinates are the same and thus do not define a rectangle";

    @Getter
    private Point bottomLeft;
    @Getter
    private Point bottomRight;
    @Getter
    private Point topRight;
    @Getter
    private Point topLeft;

    /**
     * Rectangle constructor
     * 
     * @param bottomLeft Defines the bottom left point of the rectangle
     * @param topRight   Defines the top right point of the rectangle
     * @throws IllegalArgumentException
     */
    public Rectangle(Point bottomLeft, Point topRight) throws IllegalArgumentException {

        // Check method arguments for null
        if (null == bottomLeft || null == topRight) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }

        /**
         * Validation of bottom left and top right coordinate relationship
         * Also making sure that it's a proper rectangle and not just a line in
         * the X or Y plane
         */
        if (bottomLeft.getX() >= topRight.getX() || bottomLeft.getY() >= topRight.getY()) {
            System.err.println(String.format("EXCEPTION: bottomLeft : %s ; topRight : %s", bottomLeft, topRight));
            throw new IllegalArgumentException(INVALID_ARGUMENT_EXCEPTION_MESSAGE);
        }

        // Validate bottom left and top right are not a point in the X|Y plane
        if (bottomLeft.equals(topRight)) {
            System.err.println(String.format("EXCEPTION: bottomLeft : %s ; topRight : %s", bottomLeft, topRight));
            throw new IllegalArgumentException(SAME_POINT_EXCEPTION_MESSAGE);
        }

        this.bottomLeft = bottomLeft;
        this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
        this.topRight = topRight;
        this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
    }

    /**
     * Rectangle constructor
     * 
     * @param bottomLeft Defines the bottom left point of the rectangle
     * @param width      Defines the width of the rectangle along the x-plane
     * @param height     Defines the height of the rectangle along the y-plane
     * @throws IllegalArgumentException
     */
    public Rectangle(Point bottomLeft, int width, int height) throws IllegalArgumentException {

        if (null == bottomLeft || width <= 0 || height <= 0) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }

        this.bottomLeft = bottomLeft;
        this.bottomRight = new Point(bottomLeft.getX() + width, bottomLeft.getY());
        this.topRight = new Point(this.bottomRight.getX(), this.bottomRight.getY() + height);
        this.topLeft = new Point(bottomLeft.getX(), bottomLeft.getY() + height);
    }

    /**
     * Returns the string representation of the rectangle
     * 
     * @return string The rectangle string representation
     */
    public String toString() {

        // return bottomLeft + ", " + bottomRight + ", " + topRight + ", " + topLeft;
        return bottomLeft + ", " + topRight;

    }
}
