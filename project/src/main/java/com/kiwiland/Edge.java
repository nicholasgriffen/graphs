package com.kiwiland;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
                source.equals(edge.source) &&
                destination.equals(edge.destination);
        }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.getWeight(), e.getWeight());
    }
}
