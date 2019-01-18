package com.griffen;

import java.util.ArrayList;

public class Path {
    private int weight;
    private ArrayList<Edge> edges;
    private Node source; 
    private Node destination;

    Path() {
        this.weight = 0;
    }

    Path(ArrayList<Edge> edges)  {
        for (Edge edge : edges) {
            this.weight += edge.getWeight();
        }
        this.edges = edges;
        this.source = edges.get(0).getFrom();
        this.destination = edges.get(edges.size() - 1).getTo();
    }

    public int getWeight() {
        return this.weight;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public ArrayList<String> getNodeNames() {
        ArrayList<String> nodes = new ArrayList<>();
        for (Edge edge : this.edges) {
            String nodeName = edge.getFrom().getName();
            if (!nodes.contains(nodeName)) {
                nodes.add(nodeName);
            }
        }
        nodes.add(this.destination.getName());
        return nodes;
    }
}