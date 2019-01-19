package com.griffen;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.AbstractMap.SimpleEntry;

public class Dijkstra implements PathFinder {
    private Graph graph; 
    private PriorityQueue<HashMap.Entry<Node, Integer>> queue = new PriorityQueue<>(
        (a, b) -> Integer.compare(a.getValue(), b.getValue())
    );
    private HashMap<Node, Integer> distance = new HashMap<>();  
    private HashMap<Node, Node> sources = new HashMap<>();

    public Dijkstra(Graph graph) {
        this.graph = graph; 
    }

    @Override
    public int find(String sourceName, String destinationName) {
        boolean adjustedDistance = false;
        Collection<Node> allNodes = this.graph.getNodes();
        Node source = this.graph.getNode(sourceName);
        Node destination = this.graph.getNode(destinationName);
        
        for (Node node : allNodes) {
            distance.put(node, 100);
        }
        
        distance.put(source, 0);
        
        for (HashMap.Entry<Node, Integer> entry : distance.entrySet()) {
            queue.add(entry);
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll().getKey();
            
            for (Edge neighbor : this.graph.getNeighbors(currentNode)) {
                    int possibleWeight = distance.get(currentNode) + neighbor.getWeight();
                    if (possibleWeight < distance.get(neighbor.getDestination())) {
                        distance.put(neighbor.getDestination(), possibleWeight);
                        sources.put(neighbor.getDestination(), currentNode);
                        queue.add(new SimpleEntry<>(neighbor.getDestination(), possibleWeight));
                    }
                }
            
                if (source.equals(destination) && !adjustedDistance) {
                    distance.put(source, 100);
                    adjustedDistance = true;
                }
            }
        return distance.get(destination);
    };
}