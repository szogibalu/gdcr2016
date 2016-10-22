package com.gdcr.gameoflife;

public class RuleEngine {

    boolean isAliveOnNextGeneration(Board board, int x, int y) {
        boolean isCurrentCellAlive = board.isAliveCell(x, y);
        int aliveNeighbors = board.getNumberOfAliveNeighbors(x, y);

        switch (aliveNeighbors) {
        case 0:
        case 1:
            return false;
        case 2:
            return true;
        case 3:
            return true;
        default:
            return false;
        }

    }

    private boolean isAliveCellSurvive(int aliveNeighbors) {
        switch (aliveNeighbors) {
        case 0:
        case 1:
            return false;
        case 2:
            return true;
        case 3:
            return true;
        default:
            return false;
        }
    }

    private boolean isAliveCellDie(int aliveNeighbors) {
        switch (aliveNeighbors) {
        case 0:
        case 1:
            return false;
        case 2:
            return true;
        case 3:
            return true;
        default:
            return false;
        }
    }

}
