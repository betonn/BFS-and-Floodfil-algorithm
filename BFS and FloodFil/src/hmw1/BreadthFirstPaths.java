package hmw1;


//-----------------------------------------------------
// Title:BreadthFirstPaths
// Author: Abdusselam koç
// Section: 1
// Assignment: 2
// Description: this class is includes bfs algorithm
//-----------------------------------------------------







public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path


    public BreadthFirstPaths(Graph G, int s,int[]arr ) {
//--------------------------------------------------------
// Summary: constructor for the algorithm
// name is given.
// Precondition: there is no working bfs algorithm
// Postcondition: bfs algorithm worked and returned a result
//--------------------------------------------------------

        setArr(arr); //setting the forbidden numbers into bfs
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];


        bfs(G, s); // calling bfs method


    }




    public int[] arr;

    public void setArr(int[] arr1) {
        //--------------------------------------------------------
// Summary: copy the forbidden numbers' array to another array
// name is given.

//--------------------------------------------------------

        arr = new int[arr1.length];
        System.arraycopy(arr1,0,arr,0,arr1.length);

    }

    private void bfs(Graph G, int s) {
        //--------------------------------------------------------
// Summary: bfs to calculate shortest path but i added a forbidden number array and it checks it in every step.
// name is given.
// Precondition: there is no working bfs algorithm
// Postcondition: bfs algorithm worked and returned a result
//--------------------------------------------------------
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w] && check(arr, w)) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    int counter = 0;

    public boolean check(int[] arr, int w) {
        //--------------------------------------------------------
// Summary: checks whether the current number is forbidden or not.
// name is given.
// Precondition: program doesnt know whether current number is forbidden or not.
// Postcondition: program know whether current number is forbidden or not.
//--------------------------------------------------------

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == w)
                return false;

        }

        return true;

    }




    public boolean hasPathTo(int v) {

        return marked[v];
    }


    public int distTo(int v) {

        return distTo[v];
    }


}


