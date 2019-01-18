package com.griffen;

public class Application {

    public static void main(String... args) {
        Graph graph = new Graph();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node W = new Node("W");
        Node F = new Node("F");
        

        Edge BC = new Edge(B, C, 2);
        Edge CB = new Edge(C, B, 5);
        Edge CA = new Edge(C, A, 5);
        Edge DA = new Edge(D, A, 2);
        Edge DF = new Edge(D, F, 6);
        Edge FW = new Edge(F, W, 9);
        Edge BD = new Edge(B, D, 9);

        graph
            .setEdge(BC)
            .setEdge(CA)
            .setEdge(CB)
            .setEdge(DA)
            .setEdge(DF)
            .setEdge(FW)
            .setEdge(BD);

        PathFinder pathFinder = new PathFinder(graph);
        Path path = pathFinder.breadthFirstSearch("B", "A");
        if (path.getWeight() == 0) {
            System.out.print("No such path");
        } else {
            System.out.print(path.getWeight());
            System.out.print(path.getNodeNames());
        }        
    }
}

