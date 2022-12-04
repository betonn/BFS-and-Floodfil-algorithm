package hmw1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//-----------------------------------------------------
// Title:main
// Author: Abdusselam koç

// Section: 1
// Assignment: 2
// Description: this is the main class to create graph and search for the shortest path.
//-----------------------------------------------------




public class main {
    Graph g = new Graph(10000);

    public void addVertex() {
//--------------------------------------------------------
// Summary: create a chained graph according to inputs
// name is given.
// Precondition: there is no graph
// Postcondition: the graph been created.
//--------------------------------------------------------

        for (int i = 0; i < 10000; i++) {
            if (i % 10 == 9) {
                g.addEdge(i, i - 9);
                g.addEdge(i, i - 1);


            }
            if (i % 10 == 0) {
                g.addEdge(i, i + 1);
                g.addEdge(i, i + 9);


            }
            if (i % 10 < 9 && i % 10 > 0) {
                g.addEdge(i, i + 1);
                g.addEdge(i, i - 1);

            }
            if (i / 10 != 0 && (i / 10) % 10 == 0) {

                g.addEdge(i, i + 10);
                g.addEdge(i, i + 90);
            }
            if (i / 10 != 0 && (i / 10) % 10 == 9) {
                g.addEdge(i, i - 90);
                g.addEdge(i, i - 10);
            }

            if (i / 10 != 0 && (i / 10) % 10 < 9 && (i / 10) % 10 > 0) {
                g.addEdge(i, i + 10);
                g.addEdge(i, i - 10);
            }


            if (i / 100 != 0 && (i / 100) % 10 == 0) {

                g.addEdge(i, i + 100);
                g.addEdge(i, i + 900);
            }

            if (i / 100 != 0 && (i / 100) % 10 == 9) {
                g.addEdge(i, i - 900);
                g.addEdge(i, i - 100);
            }

            if (i / 100 != 0 && (i / 100) % 10 > 0 && (i / 100) % 10 < 9) {
                g.addEdge(i, i + 100);
                g.addEdge(i, i - 100);
            }

            if (i / 1000 != 0 && (i / 1000) % 10 == 0) {

                g.addEdge(i, i + 1000);
                g.addEdge(i, i + 9000);

            }
            if (i / 1000 != 0 && (i / 1000) % 10 == 9) {
                g.addEdge(i, i - 9000);
                g.addEdge(i, i - 1000);
            }
            if (i / 1000 != 0 && (i / 1000) % 10 > 0 && (i / 1000) % 10 < 9) {
                g.addEdge(i, i + 1000);
                g.addEdge(i, i - 1000);


            }

        }


    }


    public void findPath(int[] arr, int startP, int endP) {

//--------------------------------------------------------
// Summary: finds path from a vertex to another vertex. if there is no vertex returns -1.
// name is given.
// Precondition: the length of the shortest path is not known.
// Postcondition: found the shortest path.
//--------------------------------------------------------
        BreadthFirstPaths bfs = new BreadthFirstPaths(g, startP, arr);


        if (bfs.hasPathTo(endP)) {
            System.out.println(bfs.distTo(endP));
        } else {
            System.out.println(-1);
        }


    }

    public ArrayList<String> reader(String path) {

        //--------------------------------------------------------
// Summary: reader method to read a file and convert it according to our use
// name is given.
// Precondition: the file is not read yet.
// integer
// Postcondition: file is read and the numbers in the file returned as strings
//--------------------------------------------------------


        ArrayList<String> list = new ArrayList<>();


        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a = "";
                for (int i = 0; i < data.length(); i++) {

                    char b = ' ';
                    if (data.charAt(i) == b) { // checks to delete the spaces from input document


                    } else {
                        a = a + data.charAt(i);
                    }
                }
                list.add(a); // adds number from the input document to the list.

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return list;
    }


    public static void main(String[] args) {
//--------------------------------------------------------
// Summary: Create a main object and run the program
// name is given.
// Precondition: the program is not running.
// integer
// Postcondition: the program is running.
//--------------------------------------------------------



        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine(); // to get the file path



        main m = new main(); //main object


        int[] arr; // to keep numbers that been returned from reader.


        m.addVertex(); // calling to vertex method to create graph.
        ArrayList<String> list = m.reader(path);
        arr = new int[Integer.parseInt(list.get(2))];
        for (
                int i = 0;
                i < arr.length; i++) {
            arr[i] = Integer.parseInt(list.get(i + 3));

        }


        m.findPath(arr, Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1))); // find paths and returns the result.


    }


}


