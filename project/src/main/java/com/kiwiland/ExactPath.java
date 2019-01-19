package com.kiwiland;

import java.util.ArrayList;

public class ExactPath implements PathFinder {
    private Graph graph;

    public ExactPath(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int find(String sourceName, String destinationName) {
        Node source = graph.getNode(sourceName);
        Node destination = graph.getNode(destinationName);

        ArrayList<Edge> neighbors = graph.getNeighbors(source);
        try {
                for (Edge neighbor : neighbors) {
                    if (neighbor.getDestination().equals(destination)) {
                        return neighbor.getWeight();
                    }
                }
            } catch (NullPointerException ex) {
                //expect null if node is not a source of any edges
                ex.printStackTrace();
            }
        //not found
        return 0;
    }
}