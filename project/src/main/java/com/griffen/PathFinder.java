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
    public Path breadthFirstSearch(String from, String to) {
          
        Node source = this.graph.getNode(from);
        Node destination = this.graph.getNode(to);
        //Search queue: Nodes to search 
        LinkedList<Node> searchQueue = new LinkedList<>(); 
            //Add source 
        searchQueue.add(source);
            //Searched list: list of nodes that have been searched
        ArrayList<Node> searchedNodes = new ArrayList<>(); 
        HashMap<Node, Edge> parents = new HashMap<>();
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
                    Edge step = parents.get(currentNode);
                    while (!step.getFrom().equals(source)) {
                        path.add(step);
                        step = parents.get(step.getFrom());
                    }
                    path.add(step);
                    //Reverse so path is plotted from source to destination
                    Collections.reverse(path);
                    return new Path(path);
                } else {
                    ArrayList<Edge> neighbors = graph.getNeighbors(currentNode);
                    //expect null if node is not a source of any edges
                    if (neighbors == null) return new Path();
                    
                    for (Edge neighbor : neighbors) {
                        searchQueue.add(neighbor.getTo());
                        parents.put(neighbor.getTo(), neighbor);
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
    //plot path
}
