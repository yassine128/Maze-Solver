package Maze;

public class Counter {
    public int totalNodesTraversed = 0;
    public int stackedNodes = 0;
    public int maxStackSize = 0;
    public Counter() {
        this.totalNodesTraversed = 0;
        this.stackedNodes = 0;
        this.maxStackSize = 0;
    }

    public void incrementTotalNodesTraversed() {
        this.totalNodesTraversed++;
    }
    public void incrementTotalNodesAddedToStack() {
        stackedNodes++;
        maxStackSize = Math.max(maxStackSize, stackedNodes);
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    public int getTotalNodesTraversed() {
        return totalNodesTraversed;
    }

    public int getStackedNodes() {
        return stackedNodes;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }
}
