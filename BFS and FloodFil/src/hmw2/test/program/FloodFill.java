package hmw2.test.program;

import hmw2.program.main;

//-----------------------------------------------------
// Title:floodfil
// Author: Abdusselam koç
// ID: 4931214741
// Section: 1
// Assignment: 2
// Description: this the floodFill class that have floodfil algorithm to calculate the cycles.
// these algorithm built base on https://titanwolf.org/Network/Articles/Article?AID=ca323e37-2937-4e93-96c7-371eee923b94
//
//-----------------------------------------------------
//
public class FloodFill {

    public int pathLength; // keeps the length of the path
    static int height= hmw2.program.main.height; // height from main class
    static int width= main.width; // width from main class



    public void RecursiveFF(int[][] maze, int column, int row) {
        //--------------------------------------------------------
// Summary: find cycles and calculates the length of the cycle, keeps the biggest ones length and returns it.
// name is given.
// Precondition: does the maze has a cycle or not is unknown.
// integer
// Postcondition: does the maze has a cycle is known if the cycle exist also it lengths is known.
//--------------------------------------------------------
        pathLength++;
        maze[column][row] = 4;

        for (int d = 0; d <= 7; d++) {
            int columnAfterMove = column + Moves[d][0];
            int rowAfterMove = row + Moves[d][1];
            if (range(columnAfterMove, rowAfterMove))
                if (maze[columnAfterMove][rowAfterMove] == 0) {

                    if (columnAfterMove == column || rowAfterMove == row)
                        RecursiveFF(maze, columnAfterMove, rowAfterMove);

                    else {
                        if (d == 2)
                            if (maze[column][row - 1] != 2 && maze[column + 1][row] != 2)
                                RecursiveFF(maze, columnAfterMove, rowAfterMove);


                        if (d == 0)
                            if (maze[column][row + 1] != 1 && maze[column + 1][row] != 1)
                                RecursiveFF(maze, columnAfterMove, rowAfterMove);


                        if (d == 5)
                            if (maze[column][row + 1] != 2 && maze[column - 1][row] != 2)
                                RecursiveFF(maze, columnAfterMove, rowAfterMove);
                        if (d == 7)
                            if (maze[column][row - 1] != 1 && maze[column - 1][row] != 1)
                                RecursiveFF(maze, columnAfterMove, rowAfterMove);
                    }
                }
        }

    }
    static boolean range(int column, int row) {
        //--------------------------------------------------------
// Summary: checks whether the direction is on the 2d maze array or not.
// name is given.
// Precondition: the program doesnt know whether the point is on the array or not.
// integer
// Postcondition: the program know whether the point is on the array or not.
//--------------------------------------------------------
        return ((0 <= column && column < height) && (0 <= row && row < width));
    }
    int[][] Moves = {{1, 1}, {-1, 0}, {1, -1}, {0, -1}, {0, 1}, {-1, 1}, {1, 0},
            {-1, -1}}; // all probabilities that program can visit during the cycle search.
}