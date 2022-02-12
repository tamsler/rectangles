/**
 * Calls that old the various Adjacency results 
 * 
 * @author Thomas Amsler
 * @version 1.0.0
 * @since 2022-02-12
 */

package org.tamsler.services;

public class AdjacencyResult {

    public boolean hasSubLineAdjacencyY = false;
    public boolean hasSubLineAdjacencyX = false;
    public boolean hasProperAdjacencyY = false;
    public boolean hasProperAdjacencyX = false;
    public boolean hasPartialAdjacencyY = false;
    public boolean hasPartialAdjacencyX = false;

    public boolean hasSubLineAdjacency() {
        return (hasSubLineAdjacencyX || hasSubLineAdjacencyY) ? true : false;
    }

    public boolean hasPartialAdjacency() {
        return (hasPartialAdjacencyX || hasPartialAdjacencyY) ? true : false;
    }

    public boolean hasProperAdjacency() {
        return (hasProperAdjacencyX || hasProperAdjacencyY) ? true : false;
    }
}
