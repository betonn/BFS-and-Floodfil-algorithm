package hmw1;
//-----------------------------------------------------
// Title:graph
// Author: Abdusselam koç

// Section: 1
// Assignment: 2
// Description: implementation of the graph class
//-----------------------------------------------------

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;


    public Graph(int V) {
        //--------------------------------------------------------
        // Summary: constructor to create graph
        // name is given.
        // Precondition: the graph object not been created
        // Postcondition: the graph object been created.
        //--------------------------------------------------------
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }


    public int V() {
        return V;
    }


    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        //--------------------------------------------------------
// Summary: add undirected edge
// name is given.
// Precondition:there is no edge.
// Postcondition: there is an edge between v and w
//--------------------------------------------------------
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


    public Bag<Integer> adj(int v) {

        return adj[v];
    }


}
