package com.griffen;

import java.util.ArrayList;
import java.util.function.Predicate;

class Constrained implements PathFinder {
    private Graph graph;
    private Predicate<Path> constraint;
    private Predicate<Path> shouldKeep;

    public Constrained(Graph graph, Predicate<Path> constraint) {
        this(graph, constraint, constraint);
    }

    public Constrained(Graph graph, Predicate<Path> constraint, Predicate<Path> shouldKeep) {
        this.graph = graph;
        this.constraint = constraint;
        this.shouldKeep = shouldKeep;
    }

    @Override
    public int find(String sourceName, String destinationName) {
        Node source = graph.getNode(sourceName);
        
        ArrayList<Path> constrainedPaths = new ArrayList<>();

        ArrayList<Path> possiblePaths = new ArrayList<>();
        
        for (Edge edge : graph.getNeighbors(source)) {
            possiblePaths.add(new Path(edge));
        }

        while (!possiblePaths.isEmpty()) {
            ArrayList<Path> pathsCopy = (ArrayList<Path>) possiblePaths.clone(); 
            for (Path path : pathsCopy) {
                Node destination = path.getDestination();
                ArrayList<Edge> neighbors = graph.getNeighbors(destination);

                possiblePaths.remove(path);
                for (Edge neighbor : neighbors) {
                    Path candidatePath = path.copy().addEdge(neighbor);
                    
                    if (this.constraint.test(candidatePath) && candidatePath.getDestination().getName() == destinationName) {
                        possiblePaths.add(candidatePath);
                        constrainedPaths.add(candidatePath);                    
                    } else if (this.shouldKeep.test(candidatePath)) {
                        possiblePaths.add(candidatePath);
                    }
                }
            }
        }
        return constrainedPaths.size();
    }
}