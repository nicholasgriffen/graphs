package com.griffen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;

public class BreadthFirst implements PathFinder {
    private Graph graph;
    
    public BreadthFirst(Graph graph) {
        this.graph = graph;
    }

    @Override
    public int find(String sourceName, String destinationName) {
          
    Node source = this.graph.getNode(sourceName);
    Node destination = this.graph.getNode(destinationName);
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
                if (searchedNodes.size() == 0) {
                    ArrayList<Edge> neighbors = graph.getNeighbors(currentNode);
                try {
                    for (Edge neighbor : neighbors) {
                    searchQueue.add(neighbor.getDestination());
                    sources.put(neighbor.getDestination(), neighbor);
                    }
                    //mark node as searched 
                    searchedNodes.add(currentNode);
                } catch (NullPointerException ex) {
                    //expect null if node is not a source of any edges
                    ex.printStackTrace();
                    //continue program execution
                    return 0;    
                }
                continue;
                }
                //build list of edges 
                //return path 
                ArrayList<Edge> path = new ArrayList<>(); 
                Edge step = sources.get(currentNode);
                while (!step.getSource().equals(source)) {
                    path.add(step);
                    step = sources.get(step.getSource());
                }
                path.add(step);
                Collections.reverse(path);
                //Reverse to plot path from source to destination
                return new Path(path).getWeight();
            } else {
                ArrayList<Edge> neighbors = graph.getNeighbors(currentNode);
                try {
                    for (Edge neighbor : neighbors) {
                    searchQueue.add(neighbor.getDestination());
                    sources.put(neighbor.getDestination(), neighbor);
                    }
                    //mark node as searched 
                    searchedNodes.add(currentNode);
                } catch (NullPointerException ex) {
                    //expect null if node is not a source of any edges
                    ex.printStackTrace();
                    //continue program execution
                    return 0;    
                }
            }
        }
    }
    return 0;
    }
}