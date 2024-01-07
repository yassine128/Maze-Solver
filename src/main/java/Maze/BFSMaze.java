package Maze;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Deque;
import java.util.ArrayDeque;

/** TODO
 ** Implement BFS algorithm to solve the maze.
 */
public class BFSMaze {
    /** TODO
     * Returns the distance of the shortest path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */

    private Counter tileCounter = new Counter();
    private boolean[][] visited;

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

        return BFS_VISIT(maze, startPos[0][0], startPos[0][1], startPos[1][0], startPos[1][1]);
    }

    private boolean accessible(ArrayList<ArrayList<Tile>> maze, int i, int j) {
        return i >= 0 && i < maze.size() && j >= 0 && j < maze.get(0).size() && !maze.get(i).get(j).equals(Tile.Wall);
    }

    private boolean contains(int i, int j) {
        return visited[i][j];
    }

    private int BFS_VISIT(ArrayList<ArrayList<Tile>> maze, int i, int j, int k, int l) {

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j, 0}); // row, column, depth
        visited[i][j] = true;
        tileCounter.incrementTotalNodesTraversed();
        tileCounter.incrementTotalNodesAddedToStack();
        int countExit = 0;

        while (!q.isEmpty()) {
            for (int z = 0; z < q.size(); z++) {
                int[] node = q.removeFirst();
                int jNode = node[1];
                int iNode = node[0];
                int depth = node[2];

                if (maze.get(iNode).get(jNode).equals(Tile.Exit))
                    if (++countExit >= 2) return depth;


                if (accessible(maze, iNode + 1, jNode) && !contains(iNode + 1, jNode)) {
                    q.add(new int[]{iNode + 1, jNode, depth + 1});
                    visited[iNode + 1][jNode] = true;
                    tileCounter.incrementTotalNodesTraversed();
                    tileCounter.incrementTotalNodesAddedToStack();
                }
                if (accessible(maze, iNode, jNode + 1) && !contains(iNode, jNode + 1)) {
                    q.add(new int[]{iNode, jNode + 1, depth + 1});
                    visited[iNode][jNode + 1] = true;
                    tileCounter.incrementTotalNodesTraversed();
                    tileCounter.incrementTotalNodesAddedToStack();

                }
                if (accessible(maze, iNode - 1, jNode) && !contains(iNode - 1, jNode)) {
                    q.add(new int[]{iNode - 1, jNode, depth + 1});
                    visited[iNode - 1][jNode] = true;
                    tileCounter.incrementTotalNodesTraversed();
                    tileCounter.incrementTotalNodesAddedToStack();
                }
                if (accessible(maze, iNode, jNode - 1) && !contains(iNode, jNode - 1)) {
                    q.add(new int[]{iNode, jNode - 1, depth + 1});
                    visited[iNode][jNode - 1] = true;
                    tileCounter.incrementTotalNodesTraversed();
                    tileCounter.incrementTotalNodesAddedToStack();
                }
                tileCounter.setMaxStackSize(Math.max(tileCounter.getMaxStackSize(), q.size()));

            }
        }
        return 0;
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
