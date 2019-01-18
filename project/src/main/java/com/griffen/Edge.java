package com.griffen;

public class Edge {
    private Node source;
    private Node destination;
    private int weight;

    Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() {
        return this.source;
    }
    public Node getDestination() {
        return this.destination;
    }
    public int getWeight() {
        return this.weight;
    }
}
