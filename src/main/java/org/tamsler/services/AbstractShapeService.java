/**
 * This is the generic shape service abstract class that outputs 
 * shape comparison types in terms of the shapes' relationship result
 * Operations:
 * 
 * - Intersection results
 * -- Intersection
 * -- No Intersection
 * - Containment
 * -- Containment
 * -- No Containment
 * -- Intersection - No Containment
 * - Adjacency
 * -- Adjacent (Sub-line)
 * -- Adjacent (Proper)
 * -- Adjacent (Partial)
 * -- Not Adjacent
 * 
 * It separates concerns in terms of shape operation result interpretations going
 * from boolean values to strings
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */
package org.tamsler.services;

public abstract class AbstractShapeService<T> implements ShapeServiceInterface<T> {

    /**
     * Abstract helper shape method to determine if shapeB is in shapeA
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return boolean true if shapeB is in shapeA; false otherwise
     */
    abstract protected boolean isIn(T shapeA, T shapeB);

    /**
     * @see ShapeServiceInterface
     */
    public String getIntersectionType(T shapeA, T shapeB) {
        if (hasIntersection(shapeA, shapeB)) {
            return "Intersection " + getIntersectionCoordinates(shapeA, shapeB);
        } else {
            return "No Intersection";
        }
    }

    /**
     * @see ShapeServiceInterface
     */
    public String getContainmentType(T shapeA, T shapeB) {
        if (hasContainment(shapeA, shapeB)) {
            return "Containment";
        } else if (hasIntersection(shapeA, shapeB)) {
            return "Intersection - No Containment";
        } else {
            return "No Containment";
        }
    }

    /**
     * @see ShapeServiceInterface
     */
    public String getAdjacencyType(T shapeA, T shapeB) {
        AdjacencyResult result1 = hasAdjacency(shapeA, shapeB);
        AdjacencyResult result2 = hasAdjacency(shapeB, shapeA);
        if (result1.hasSubLineAdjacency() || result2.hasSubLineAdjacency()) {
            return "Adjacency (Sub-line)";
        } else if (result1.hasPartialAdjacency()) {
            return "Adjacency (Partial)";
        } else if (result1.hasProperAdjacency()) {
            return "Adjacency (Proper)";
        } else {
            return "Not Adjacent";
        }
    }
}
