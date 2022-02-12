/**
 * This class represents a point in a 2D coordinate system
 * A point can be created by providing the points x and y coordinate values (x,y)
 *
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler.models;

import lombok.Getter;

public class Point {

    @Getter
    final private int x;
    @Getter
    final private int y;

    /**
     * Point constructor
     * (x,y) coordinate values can be either negative or positive integers
     * 
     * @param x Defines the x value of the point (x,y)
     * @param y Defines the y value of the point (x,y)
     */
    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /**
     * Returns the string representation of the point
     * 
     * @return string The point string representation
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Checks if two points are equals in terms of their values
     * 
     * @param obj The reference object with which to compare
     * @return boolean true if this object is the same as the obj argument; false
     *         otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Point)) {
            return false;
        }

        Point p = (Point) obj;

        return (x == p.getX() && y == p.getY()) ? true : false;
    }
}
