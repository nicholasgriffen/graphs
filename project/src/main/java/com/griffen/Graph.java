package com.griffen;

import java.util.HashMap;
import java.util.ArrayList;

public class Graph {
    //Map Node to edges starting at that node 
    private HashMap<Node, ArrayList<Edge>> edgesBySource;
    //Map node name to node 
    private HashMap<String, Node> nodes;

    public Graph() {
        this.edgesBySource = new HashMap<>();
        this.nodes = new HashMap<>();
    }

    public Node getNode(String name) {
        return this.nodes.get(name);
    }

    public void addEdge(Edge edge) {
        Node from = edge.getFrom();
        Node to = edge.getTo();

        this.nodes.putIfAbsent(from.getName(), from);
        this.nodes.putIfAbsent(to.getName(), to);
        
        if (this.edgesBySource.containsKey(from)) {
            this.edgesBySource.get(from).add(edge);
        } else {
            this.edgesBySource.put(from, new ArrayList<Edge>());
            this.edgesBySource.get(from).add(edge);
        }
    }

    public ArrayList<Edge> getNeighbors(Node source) {
        ArrayList<Edge> neighbors = this.edgesBySource.get(source);
        
        return neighbors;
    }
}
//containsKey
//containsValue