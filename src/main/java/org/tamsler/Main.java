/**
 * The Rectangle program performs various operations comparing 2 rectangles with
 * respect to their positioning. It checks for:
 * - Intersection
 * - Containment
 * - Adjacency
 * 
 * It reads a file from standard input which has the following format:
 * x1,y1 x2,y2 x3,y3 x4,y4
 * 
 * 1,2 2,2 -2,3 3,-1
 * 1,2 4,4 -5,1 9,-4
 * -1,2 1,4 2,-1 9,-4
 * 
 * Per line, there are 4 point coordinates, which will be used to construct two
 * rectangles to compare against each other
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler;

import java.io.FileNotFoundException;

/**
 * Main class which runs the program
 */
public class Main {

    final protected static String INPUT_FILE = "dataFile.txt";

    public static void main(String[] args) {

        RectangleApp rectangleApp = new RectangleApp();

        try {

            rectangleApp.processFile(INPUT_FILE);
        } catch (FileNotFoundException exception) {

            System.err.println("EXCEPTION: Input file not found: " + INPUT_FILE);
            exception.printStackTrace();
        } catch (Exception exception) {

            // Catching all other exceptions
            exception.printStackTrace();
        }
    }
}