/**
 * Class that processes the input file containing rectangle data
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.tamsler.models.Point;
import org.tamsler.models.Rectangle;
import org.tamsler.services.RectangleServiceImpl;
import org.tamsler.services.ShapeServiceInterface;

public class RectangleApp {

    /**
     * Process input file reading one line at a time and processing it.
     * Then process each line and detect rectangle relationship as outlined
     * by the program's requirements.
     * 
     * @throws FileNotFoundException
     * @throws IllegalArgumentException
     */
    protected void processFile(String fileName) throws FileNotFoundException, IllegalArgumentException {

        Scanner linReader = new Scanner(new File(fileName));

        while (linReader.hasNext()) {

            String line = linReader.nextLine();
            List<Point> points = getPoints(line);

            // Check if coordinate points got read from file. If not, we skip it.
            if (null == points) {
                continue;
            }

            Rectangle rectangle1 = null;
            Rectangle rectangle2 = null;

            try {

                rectangle1 = new Rectangle(points.get(0), points.get(1));
                rectangle2 = new Rectangle(points.get(2), points.get(3));
                detectRectangleRelationshipType(rectangle1, rectangle2);
            } catch (IllegalArgumentException exception) {

                exception.printStackTrace();
            }
        }

        linReader.close();
    }

    /**
     * Method that processed a line from the data file
     * If coordinates cannot be read (illegal input), we skip it
     * 
     * @param coordinates string in the form of: "-2,0 0,2 0,0 2,4"
     * @return List A list of Points, one for each of the 4 (x,y) coordinates
     * @throws IllegalArgumentException
     */
    protected List<Point> getPoints(String coordinates) throws IllegalArgumentException {

        if (null == coordinates || "".equals(coordinates)) {
            throw new IllegalArgumentException("Invalid method argument");
        }

        List<Point> points = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(coordinates, " ");

        while (tokenizer.hasMoreElements()) {

            String[] pointXY = tokenizer.nextToken().split(",");

            try {

                points.add(new Point(Integer.parseInt(pointXY[0]), Integer.parseInt(pointXY[1])));
            } catch (NumberFormatException exception) {

                System.err.println(String.format("EXCEPTION : Coordinates %s", coordinates));
                exception.printStackTrace();
                // Resetting points
                points = null;
                break;
            }
        }
        return points;
    }

    /**
     * Method that compares rectangles and prints result
     * 
     * @param rectangle1 First rectangle to compare
     * @param rectangle2 Second rectangle to compare
     * @throws IllegalArgumentException
     */
    protected void detectRectangleRelationshipType(Rectangle rectangle1, Rectangle rectangle2)
            throws IllegalArgumentException {

        if (null == rectangle1 || null == rectangle2) {
            throw new IllegalArgumentException("Invalid method argument");
        }

        ShapeServiceInterface<Rectangle> shapeOperationsInterface = RectangleServiceImpl.getInstance();

        System.out.println(rectangle1 + " : " + rectangle2);
        System.out.println(shapeOperationsInterface.getIntersectionType(rectangle1, rectangle2));
        System.out.println(shapeOperationsInterface.getContainmentType(rectangle1, rectangle2));
        System.out.println(shapeOperationsInterface.getAdjacencyType(rectangle1, rectangle2)+ "\n");
    }
}
