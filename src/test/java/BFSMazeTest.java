import Maze.DFSMaze;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import Maze.BFSMaze;
import Maze.Tile;

public class BFSMazeTest {
    private ArrayList<ArrayList<Tile>> readInput(String problemNumber) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/Maze/inputs/input" + problemNumber + ".csv"));

        ArrayList<ArrayList<Tile>> maze = new ArrayList<>();
        Tile[] mazeTiles = Tile.values();

        while (scanner.hasNextLine()) {
            String listString = scanner.nextLine();
            List<Tile> row = Arrays
                    .stream(listString.split(","))
                    .map(Integer::parseInt)
                    .map(i -> mazeTiles[i])
                    .collect(Collectors.toList());

            maze.add(new ArrayList<>(row));
        }

        return maze;
    }

    @Test
    void inputsValidity() {
        BFSMaze bfsMaze = new BFSMaze();

        assertNull(bfsMaze.findPath(new ArrayList<>()));

        ArrayList<ArrayList<Tile>> noEntranceMaze = new ArrayList<>(List.of(
                new ArrayList<>(List.of(Tile.Wall, Tile.Wall, Tile.Wall)),
                new ArrayList<>(List.of(Tile.Wall, Tile.Wall, Tile.Wall)),
                new ArrayList<>(List.of(Tile.Wall, Tile.Wall, Tile.Wall))
        ));
        assertNull(bfsMaze.findPath(noEntranceMaze));

        ArrayList<ArrayList<Tile>> noExitMaze = new ArrayList<>(List.of(
                new ArrayList<>(List.of(Tile.Wall, Tile.Wall, Tile.Wall)),
                new ArrayList<>(List.of(Tile.Floor, Tile.Floor, Tile.Wall)),
                new ArrayList<>(List.of(Tile.Wall, Tile.Wall, Tile.Wall))
        ));
        assertNull(bfsMaze.findPath(noExitMaze));
    }



    @Test
    void input00() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("00");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(91, shortestPathDistance);
    }

    @Test
    void input01() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("01");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(56, shortestPathDistance);
    }

    @Test
    void input02() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("02");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(96, shortestPathDistance);
    }

    @Test
    void input03() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("03");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(107, shortestPathDistance);
    }

    @Test
    void input04() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("04");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(134, shortestPathDistance);
    }

    @Test
    void input05() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("05");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(142, shortestPathDistance);
    }

    @Test
    void input06() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("06");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(172, shortestPathDistance);
    }

    @Test
    void input07() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("07");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(254, shortestPathDistance);
    }

    @Test
    void input08() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("08");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(646, shortestPathDistance);
    }

    @Test
    void input09() throws FileNotFoundException {
        ArrayList<ArrayList<Tile>> maze = readInput("09");
        BFSMaze bfsMaze = new BFSMaze();
        Integer shortestPathDistance = bfsMaze.findPath(maze);

        assertNotNull(shortestPathDistance);
        assertEquals(684, shortestPathDistance);
    }
}
