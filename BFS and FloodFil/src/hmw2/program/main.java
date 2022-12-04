package hmw2.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//-----------------------------------------------------
// Title:main
// Author: Abdusselam koç
// Section: 1
// Assignment: 2
// Description: this is the main class that split the file create maze and returns the cycles and their length.
// these algorithm built base on https://titanwolf.org/Network/Articles/Article?AID=ca323e37-2937-4e93-96c7-371eee923b94
//
//-----------------------------------------------------
//
public class main {


    public static int width; //  width of the 2d array
    public static int height;//height of the 2d array
    static ArrayList<String> list = new ArrayList<>(); // arraylist to keep slashes.

    public void reader(String source) {
        //--------------------------------------------------------
// Summary: reads the file sets the length and width of the 2d array. and save the file inputs to the list.
// name is given.
// Precondition: the file is not read.
//this scanner is been taken from geeksforgeek.com
// Postcondition: the file is read and processed.
//--------------------------------------------------------

        try {
            File myObj = new File(source);
            Scanner myReader = new Scanner(myObj);
            width = myReader.nextInt();
            height = myReader.nextInt();
            while (myReader.hasNextLine()) {
                String data = myReader.next();

                list.add(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public void CreateMaze(int[][] Maze) {
        //--------------------------------------------------------
// Summary: creates the maze according to given index of the list.
// name is given.
// Precondition:  the 2d maze array is not filled
// integer
// Postcondition: the 2d maze array is filled.
//--------------------------------------------------------
        for (int a = 0; a < height; a++) {
            String currentString = list.get(a); // get current index
            currentString.split(""); // split
            for (int i = 0; i < width; i++) {
                if (currentString.charAt(i) == '/') {  // think four square that stays together
                    Maze[a * 2][i * 2] = 0;  // 1th one is zero
                    Maze[a * 2][i * 2 + 1] = 1; // 2rd one is 1
                    Maze[a * 2 + 1][i * 2 + 1] = 0; // 3rd one is 0
                    Maze[a * 2 + 1][i * 2] = 1; // 4rd one 1
                } else {
                    Maze[a * 2][i * 2] = 2;
                    Maze[a * 2 + 1][i * 2 + 1] = 2;
                    Maze[a * 2][i * 2 + 1] = 0;
                    Maze[a * 2 + 1][i * 2] = 0;
                }
            }
        }

    }


    public void boundry(int[][] Maze) {
        //--------------------------------------------------------
// Summary: handles the zeros around the 2d maze array matrix.
// name is given.
// Precondition:  the  zeros around 2d maze array is not handled.
// integer
// Postcondition:  the  zeros around 2d maze array is not handled.
//--------------------------------------------------------
        height *= 2;
        width *= 2;
        for (int i = 0; i < height; i++)
            for (int a = 0; a < width; a++)
                if (Maze[i][a] == 0)
                    if (i == 0 || a == 0 || i == (height - 1)
                            || a == (width - 1)) {
                        FloodFill ff = new FloodFill();
                        ff.RecursiveFF(Maze, i, a);
                    }
    }


    public void result(int[][] Maze) {

        //--------------------------------------------------------
// Summary: takes the proccesed 2d maze array and returns the number and the length of the biggest cycle if exist.
// name is given.
// Precondition:  the cycles not detected.
// integer
// Postcondition:  the cycles are detected.
//--------------------------------------------------------

        int maxLength = 0, cycles = 0;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (Maze[i][j] == 0) {
                    cycles++;
                    FloodFill cycle = new FloodFill();
                    cycle.pathLength = 0;
                    cycle.RecursiveFF(Maze, i, j);

                    if (maxLength < cycle.pathLength)
                        maxLength = cycle.pathLength;
                }
        if (maxLength != 0) {
            System.out.println(cycles + " Cycles; the longest has length " + maxLength + ".");
        }
        if (maxLength == 0) {
            System.out.println("There are no cycles.");
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine().trim(); // input file
        main m = new main(); // main object
        m.reader(source); // reader to split the file
        int Maze[][] = new int[height * 2][width * 2]; // 2d array initizaliation
        m.CreateMaze(Maze); // maze creating
        m.boundry(Maze); // boundary handling
        m.result(Maze); // results


    }
}