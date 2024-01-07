import Maze.BFSMaze;
import Maze.DFSMaze;
import Maze.Tile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter("maze_results.csv"))) {
            // En-tête du fichier CSV
            csvWriter.println("ProblemNumber,BFS_PathLength,BFS_NodesTraversed,BFS_MaxStackSize,DFS_PathLength,DFS_NodesTraversed,DFS_MaxStackSize");

            // Itération sur tous les fichiers CSV de 00 à 09
            for (int i = 0; i < 10; i++) {
                String problemNumber = String.format("%02d", i);
                String filePath = "src/test/resources/Maze/inputs/input" + problemNumber + ".csv";

                try {
                    ArrayList<ArrayList<Tile>> maze = readMazeFromFile(filePath);

                    // Exécution de BFS et DFS
                    BFSMaze bfsMaze = new BFSMaze();
                    DFSMaze dfsMaze = new DFSMaze();
                    Integer bfsShortestPathDistance = bfsMaze.findPath(maze);
                    Integer dfsShortestPathDistance = dfsMaze.findPath(maze);

                    // Écrire les résultats dans le fichier CSV
                    csvWriter.println(problemNumber + ","
                            + bfsShortestPathDistance + ","
                            + bfsMaze.getTileCounter().getTotalNodesTraversed() + ","
                            + bfsMaze.getTileCounter().getMaxStackSize() + ","
                            + dfsShortestPathDistance + ","
                            + dfsMaze.getTileCounter().getTotalNodesTraversed() + ","
                            + dfsMaze.getTileCounter().getMaxStackSize());
                } catch (FileNotFoundException e) {
                    System.err.println("Fichier non trouvé : " + filePath);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier CSV : " + e.getMessage());
        }
    }

    private static ArrayList<ArrayList<Tile>> readMazeFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<ArrayList<Tile>> maze = new ArrayList<>();
        Tile[] mazeTiles = Tile.values();

        while (scanner.hasNextLine()) {
            String listString = scanner.nextLine();
            String[] tileNumbers = listString.split(",");
            ArrayList<Tile> row = new ArrayList<>();

            for (String tileNumber : tileNumbers) {
                int tileIndex = Integer.parseInt(tileNumber);
                row.add(mazeTiles[tileIndex]);
            }

            maze.add(row);
        }
        scanner.close();
        return maze;
    }
}
