package Maze;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;


public class DFSMaze {

    private Counter tileCounter = new Counter();
    private boolean[][] visited;
    private int[] destination;

    /**
     * TODO
     * Returns the distance of the path within the maze
     *
     * @param maze 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public Integer findPath(ArrayList<ArrayList<Tile>> maze) {
        // Validation
        if (maze.isEmpty())
            return null;


        int[][] startPos = new int[][]{{0, 0}, {0, 0}}; // Position de depart
        int count = 0;
        visited = new boolean[maze.size()][maze.get(0).size()];

        // Trouver un point de depart
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.get(i).size(); j++) {
                visited[i][j] = false;
                if (maze.get(i).get(j).equals(Tile.Exit)) {
                    startPos[count] = new int[]{i, j}; // i -> row, j -> column
                    count++;
                }
            }
        }

        // Validation
        if (count == 0)
            return null;

        destination = startPos[1];
        ArrayList<Integer> sortiesDist = new ArrayList<Integer>();
        DFS_VISIT(maze, startPos[0][0], startPos[0][1], 0, sortiesDist);
        return sortiesDist.get(0);
    }

    private boolean accessible(ArrayList<ArrayList<Tile>> maze, int i, int j) {
        return i >= 0 && i < maze.size() && j >= 0 && j < maze.get(0).size() && !maze.get(i).get(j).equals(Tile.Wall);
    }

    private boolean contains(int i, int j) {
        return visited[i][j];
    }


    private void DFS_VISIT(ArrayList<ArrayList<Tile>> maze, int i, int j, int depth, ArrayList<Integer> sortiesDist) {
        if (i == destination[0] && j == destination[1]) {
            sortiesDist.add(depth);
            return;
        }

        tileCounter.incrementTotalNodesTraversed();
        tileCounter.incrementTotalNodesAddedToStack();


        if (accessible(maze, i - 1, j) && !contains(i - 1, j)) {
            visited[i - 1][j] = true;
            DFS_VISIT(maze, i - 1, j, depth + 1, sortiesDist);
        }

        if (accessible(maze, i + 1, j) && !contains(i + 1, j)) {
            visited[i + 1][j] = true;
            DFS_VISIT(maze, i + 1, j, depth + 1, sortiesDist);
        }

        if (accessible(maze, i, j - 1) && !contains(i, j - 1)) {
            visited[i][j - 1] = true;
            DFS_VISIT(maze, i, j - 1, depth + 1, sortiesDist);
        }

        if (accessible(maze, i, j + 1) && !contains(i, j + 1)) {
            visited[i][j + 1] = true;
            DFS_VISIT(maze, i, j + 1, depth + 1, sortiesDist);
        }

    }

    public Counter getTileCounter() {
        return tileCounter;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}

