package com.griffen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;

public class PathFinder {
    private Graph graph;

    public PathFinder(Graph graph) {
        this.graph = graph;
    }
    //BFS - source (string), destination 
    public Path breadthFirstSearch(String source, String destination) {
          
        Node source = this.graph.getNode(source);
        Node destination = this.graph.getNode(destination);
        //Search queue: Nodes to search 
        LinkedList<Node> searchQueue = new LinkedList<>(); 
            //Add source 
        searchQueue.add(source);
            //Searched list: list of nodes that have been searched
        ArrayList<Node> searchedNodes = new ArrayList<>(); 
        HashMap<Node, Edge> sources = new HashMap<>();
        //while search queue
        while(!searchQueue.isEmpty()) {
            //remove item from queue
            Node currentNode = searchQueue.pollFirst();
            //if item hasn't been searched
            if (!searchedNodes.contains(currentNode)) {
                //if item is goal 
                if (currentNode.equals(destination)) {
                    //build list of edges 
                    //return path 
                    ArrayList<Edge> path = new ArrayList<>(); 
                    Edge step = sources.get(currentNode);
                    while (!step.getSource().equals(source)) {
                        path.add(step);
                        step = sources.get(step.getSource());
                    }
                    //source node is last in the list
                    path.add(step);
                    //Reverse to plot path from source to destination
                    Collections.reverse(path);
                    return new Path(path);
                } else {
                    ArrayList<Edge> neighbors = graph.getNeighbors(currentNode);
                    //expect null if node is not a source of any edges
                    if (neighbors == null) return new Path();
                    
                    for (Edge neighbor : neighbors) {
                        searchQueue.add(neighbor.getDestination());
                        sources.put(neighbor.getDestination(), neighbor);
                    }
                    //mark node as searched 
                    searchedNodes.add(currentNode);
                }
            }
        }
        return new Path();
    }
    //DIJKSTRA
    //DFS
}
