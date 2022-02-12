/**
 * Implementing Rectangle Service
 * Uses singleton pattern for accessing this service via getInstance()
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler.services;

import org.tamsler.models.Point;
import org.tamsler.models.Rectangle;

public class RectangleServiceImpl extends AbstractShapeService<Rectangle> {

    // Singleton instance
    private static RectangleServiceImpl instance = new RectangleServiceImpl();

    // Making default constructor private to enforce singleton pattern
    private RectangleServiceImpl() {
    };

    /**
     * Accessing singleton Rectangle Service instance
     * 
     * @return RectangleService Instance
     */
    public static RectangleServiceImpl getInstance() {
        return instance;
    }

    /**
     * @see AbstractShapeService
     */
    @Override
    protected boolean isIn(Rectangle r1, Rectangle r2) {
        if (r1.getBottomLeft().getX() <= r2.getBottomLeft().getX()
                && r1.getTopRight().getX() >= r2.getTopRight().getX()
                && r1.getBottomLeft().getY() <= r2.getBottomLeft().getY()
                && r1.getTopRight().getY() >= r2.getTopRight().getY()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @see ShapeServiceInterface
     */
    @Override
    public boolean hasIntersection(Rectangle r1, Rectangle r2) {

        if (r1.getTopRight().getX() < r2.getBottomLeft().getX()
                || r1.getBottomLeft().getX() > r2.getTopRight().getX()) {
            return false;
        }

        if (r1.getTopRight().getY() < r2.getBottomLeft().getY()
                || r1.getBottomLeft().getY() > r2.getTopRight().getY()) {
            return false;
        }

        return true;
    }

    /**
     * @see ShapeServiceInterface
     */
    @Override
    public String getIntersectionCoordinates(Rectangle r1, Rectangle r2) {

        int bottomLeftX = Math.max(r1.getBottomLeft().getX(), r2.getBottomLeft().getX());
        int bottomLeftY = Math.max(r1.getBottomLeft().getY(), r2.getBottomLeft().getY());
        int topRightX = Math.min(r1.getBottomRight().getX(), r2.getBottomRight().getX());
        int topRightY = Math.min(r1.getTopLeft().getY(), r2.getTopLeft().getY());

        Point intersection1 = new Point(bottomLeftX, bottomLeftY);
        Point intersection2 = new Point(topRightX, topRightY);

        // Point Intersection -> return one point
        if (intersection1.equals(intersection2)) {
            return intersection1.toString();
        }
        // Crossing Intersection -> return 4 points
        else if (isCrossIntersecting(r1, r2) || isCrossIntersecting(r2, r1)) {

            Rectangle rectangle = new Rectangle(intersection1, intersection2);
            return rectangle.getBottomLeft() + " " + rectangle.getBottomRight() + " " + rectangle.getTopRight() + " "
                    + rectangle.getTopLeft();

        } else {
            // Border & Overlapping Intersection -> return 2 points
            return new Point(bottomLeftX, bottomLeftY) + " " + new Point(topRightX, topRightY);
        }
    }

    /**
     * @see ShapeServiceInterface
     */
    @Override
    public boolean hasContainment(Rectangle r1, Rectangle r2) {

        return (isIn(r1, r2) || isIn(r2, r1)) ? true : false;
    }

    /**
     * @see ShapeServiceInterface
     */
    @Override
    public AdjacencyResult hasAdjacency(Rectangle r1, Rectangle r2) {

        AdjacencyResult adjacencyResult = new AdjacencyResult();
        // Check adjacency: r1 and r2 have a common side in the X plane

        if (r1.getBottomRight().getX() == r2.getBottomLeft().getX()
                || r2.getBottomRight().getX() == r1.getBottomLeft().getX()) {

            // Proper adjacency
            hasProperAdjacencyY(r1, r2, adjacencyResult);

            // Sub-line adjacency
            hasSubLineAdjacencyY(r1, r2, adjacencyResult);

            // Partial adjacency
            hasPartialAdjacencyY(r1, r2, adjacencyResult);

            return adjacencyResult;
        }
        // Check adjacency: r1 and r2 have a common side in the Y plane
        else if (r1.getTopLeft().getY() == r2.getBottomLeft().getY()
                || r2.getTopLeft().getY() == r1.getBottomLeft().getY()) {

            // Proper adjacency
            hasProperAdjacencyX(r1, r2, adjacencyResult);

            // Sub-line adjacency
            hasSubLineAdjacencyX(r1, r2, adjacencyResult);

            // Partial adjacency
            hasPartialAdjacencyX(r1, r2, adjacencyResult);

            return adjacencyResult;
        } else {

            return adjacencyResult;
        }
    }

    /**
     * Adjacency methods
     */

    // ProperAdjacency
    protected void hasProperAdjacencyY(Rectangle r1, Rectangle r2, AdjacencyResult adjacencyResult) {
        adjacencyResult.hasProperAdjacencyY = (r1.getTopRight().getY() == r2.getTopLeft().getY()
                && r1.getBottomRight().getY() == r2.getBottomLeft().getY()) ? true : false;
    }

    protected void hasProperAdjacencyX(Rectangle r1, Rectangle r2, AdjacencyResult adjacencyResult) {
        adjacencyResult.hasProperAdjacencyX = (r1.getTopRight().getX() == r2.getBottomRight().getX()
                && r1.getTopLeft().getX() == r2.getBottomLeft().getX()) ? true : false;
    }

    // SubLineAdjacency
    protected void hasSubLineAdjacencyY(Rectangle r1, Rectangle r2, AdjacencyResult adjacencyResult) {
        adjacencyResult.hasSubLineAdjacencyY = ((r1.getTopRight().getY() >= r2.getTopLeft().getY()
                && r1.getBottomRight().getY() < r2.getBottomLeft().getY())
                ||
                (r1.getBottomRight().getY() <= r2.getBottomLeft().getY()
                        && r1.getTopRight().getY() > r2.getBottomLeft().getY()))
                && (!adjacencyResult.hasProperAdjacencyY) ? true : false;
    }

    protected void hasSubLineAdjacencyX(Rectangle r1, Rectangle r2, AdjacencyResult adjacencyResult) {
        adjacencyResult.hasSubLineAdjacencyX = ((r1.getTopRight().getX() >= r2.getBottomRight().getX()
                && r1.getTopLeft().getX() < r2.getBottomLeft().getX())
                ||
                (r1.getTopLeft().getX() <= r2.getBottomLeft().getX()
                        && r1.getTopRight().getX() > r2.getBottomRight().getX()))
                && (!adjacencyResult.hasProperAdjacencyX) ? true : false;
    }

    // PartialAdjacency
    protected void hasPartialAdjacencyY(Rectangle r1, Rectangle r2, AdjacencyResult adjacencyResult) {
        adjacencyResult.hasPartialAdjacencyY = (r1.getTopRight().getY() < r2.getTopLeft().getY()
                || r1.getBottomRight().getY() > r2.getBottomLeft().getY()) ? true : false;
    }

    protected void hasPartialAdjacencyX(Rectangle r1, Rectangle r2, AdjacencyResult adjacencyResult) {
        adjacencyResult.hasPartialAdjacencyX = (r1.getTopLeft().getX() > r2.getBottomLeft().getX()
                || r1.getTopRight().getX() < r2.getBottomRight().getX()) ? true : false;
    }

    // Cross Intersection detection
    protected boolean isCrossIntersecting(Rectangle r1, Rectangle r2) {

        return (r2.getBottomLeft().getX() < r1.getBottomLeft().getX()
                && r1.getTopRight().getX() < r2.getTopRight().getX()
                && r1.getBottomLeft().getY() < r2.getBottomLeft().getY()
                && r2.getTopRight().getY() < r1.getTopRight().getY());
    }
}
