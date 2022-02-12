/**
 * This is the generic shape service interface defining specific 
 * operations in terms of 2 shapes positioning to one another
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler.services;

public interface ShapeServiceInterface<T> {

    /**
     * Determines if 2 shapes are intersecting
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return boolean true if the shapes are intersecting; false otherwise
     */
    public boolean hasIntersection(T shapeA, T shapeB);

    /**
     * If shape A and shape B are intersecting, return intersection coordinates(s)
     * 
     * @param shapeA shapeA Defines the first shape
     * @param shapeB shapeB Defines the second shape
     * @return String containing the intersection coordinates
     */
    public String getIntersectionCoordinates(T shapeA, T shapeB);

    /**
     * Determines if one shape contains the other one
     * - Does shapeA contain shapeB OR does shapeB contain shape A
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return boolean true if one shape contains the other one and vise versa;
     *         false otherwise
     */
    public boolean hasContainment(T shapeA, T shapeB);

    /**
     * Determines if one shape is adjacent to the other one and vice versa
     * It tests A | B and B | A for all types
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return AdjacencyResult Class containing all the various adjacency results
     */
    public AdjacencyResult hasAdjacency(T shapeA, T shapeB);

    /**
     * Uses shape operations methods to determine shape relationships
     * - Intersection results
     * -- Intersection
     * -- No Intersection
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return string Intersection result type
     */
    public String getIntersectionType(T shapeA, T shapeB);

    /**
     * Uses shape operations methods to determine shape relationships
     * - Containment
     * -- Containment
     * -- No Containment
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return string Containment result type
     */
    public String getContainmentType(T shapeA, T shapeB);

    /**
     * Uses shape operations methods to determine shape relationships
     * - Adjacency
     * -- Adjacent (Sub-line)
     * -- Adjacent (Proper)
     * -- Adjacent (Partial)
     * -- Not Adjacent
     * 
     * @param shapeA Defines the first shape
     * @param shapeB Defines the second shape
     * @return string Adjacency result type
     */
    public String getAdjacencyType(T shapeA, T shapeB);
}
