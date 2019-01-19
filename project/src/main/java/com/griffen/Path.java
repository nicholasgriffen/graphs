package com.griffen;

import java.util.ArrayList;

public class Path {
    private ArrayList<Edge> edges;

    Path(Edge edge) {
        this.edges = new ArrayList<>();
        this.addEdge(edge);
    }

    Path(ArrayList<Edge> edges)  {
        this.edges = edges;
    }

    public Path copy() {
        ArrayList<Edge> edgesCopy = (ArrayList<Edge>) this.getEdges().clone();
        return new Path(edgesCopy);
    }

    public Path addEdge(Edge edge) {
        edges.add(edge);
        return this;
    }

    public int getCount() {
        return this.getEdges().size();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Edge edge : this.getEdges()) {
            out.append("[" + edge.getSource().getName() + "->" + edge.getDestination().getName() + " " + edge.getWeight() + "]");
        }
        out.append("   " + this.getWeight());

        return out.toString();
    }

    public Node getSource() {
        return edges.get(0).getSource();
    }

    public Node getDestination() {
        return edges.get(edges.size() - 1).getDestination();
    }

    public int getWeight() {
        int weight = 0;
        for (Edge edge : edges) {
            weight += edge.getWeight();
        }
        return weight;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }
}
