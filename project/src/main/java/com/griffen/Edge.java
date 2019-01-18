package com.griffen;

// import java.util.Objects;

public class Edge {
    private Node from;
    private Node to;
    private int weight;

    Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Node getFrom() {
        return this.from;
    }
    public Node getTo() {
        return this.to;
    }
    public int getWeight() {
        return this.weight;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Edge edge = (Edge) o;
    //     return weight == edge.weight &&
    //             from.equals(edge.from) &&
    //             to.equals(edge.to);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(from, to, weight);
    // }
}
