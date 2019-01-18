package com.griffen;

public class Kiwiland {
    private Graph graph;

    public Kiwiland() {
        this.graph = new Graph();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        

        Edge AB = new Edge(A, B, 5);
        Edge BC = new Edge(B, C, 4);
        Edge CD = new Edge(C, D, 8);
        Edge DC = new Edge(D, C, 8);
        Edge DE = new Edge(D, E, 6);
        Edge CE = new Edge(C, E, 2);
        Edge EB = new Edge(E, B, 3);
        Edge AE = new Edge(A, E, 7);
        Edge AD = new Edge(A, D, 5);



        graph
            .setEdge(AB)
            .setEdge(BC)
            .setEdge(CD)
            .setEdge(DC)
            .setEdge(DE)
            .setEdge(CE)
            .setEdge(EB)
            .setEdge(AD)
            .setEdge(AE);

    }

    public int requirement1() {
        PathFinder pathFinder = new ExactPath(this.graph);
        int pathAB = pathFinder.find("A", "B");
        int pathBC = pathFinder.find("B", "C");
        
        return pathAB + pathBC;
    }

    public int requirement2() {
        PathFinder pathFinder = new ExactPath(this.graph);

        return pathFinder.find("A", "D");
    }

    public int requirement3() {
        PathFinder pathFinder = new ExactPath(this.graph);
        int pathAD = pathFinder.find("A", "D");
        int pathDC = pathFinder.find("D", "C");
        
        return pathAD + pathDC;
    }

    public int requirement4() {
        PathFinder pathFinder = new ExactPath(this.graph);
        int pathAE = pathFinder.find("A", "E");
        int pathEB = pathFinder.find("E", "B");
        int pathBC = pathFinder.find("B", "C");
        int pathCD = pathFinder.find("C", "D");
        
        return pathAE + pathEB + pathBC + pathCD;
    }

    public String requirement5() {
        PathFinder pathFinder = new ExactPath(this.graph);
        int pathAE = pathFinder.find("A", "E");
        int pathED = pathFinder.find("E", "D");
        
        if (pathAE == 0 || pathED ==0) {
            return "NO SUCH ROUTE";
        } else {
            return "" + pathAE + pathED;
        }
    }
}