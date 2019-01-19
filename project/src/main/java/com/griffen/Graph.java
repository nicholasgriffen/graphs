package com.griffen;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class Graph {
    //Map Node to edges starting at that node 
    private HashMap<Node, ArrayList<Edge>> edgesBySource;
    //Map node name to node 
    private HashMap<String, Node> nodesByName;

    public Graph() {
        this.edgesBySource = new HashMap<>();
        this.nodesByName = new HashMap<>();
    }
    
    public Collection<Node> getNodes() {
        return this.nodesByName.values();
    }
    
    public Node getNode(String name) {
        return this.nodesByName.get(name);
    }
    
    public ArrayList<Edge> getNeighbors(Node source) {
        ArrayList<Edge> neighbors = this.edgesBySource.get(source);
        return neighbors;
    }
    
    public Graph setEdge(Edge edge) {
        this.addNodesAndEdge(edge);
        return this;
    }
    
    private void addNodesAndEdge(Edge edge) {
        this.addNodes(edge);
        this.addEdge(edge);
    }
    
    private void addNodes(Edge edge) {
        Node source = edge.getSource();
        Node destination = edge.getDestination();
        
        this.nodesByName.putIfAbsent(source.getName(), source);
        this.nodesByName.putIfAbsent(destination.getName(), destination);
    }
    
    private void addEdge(Edge edge) {
        Node source = edge.getSource();
        
        this.edgesBySource.putIfAbsent(source, new ArrayList<Edge>());
        this.edgesBySource.get(source).add(edge);
    }
}
