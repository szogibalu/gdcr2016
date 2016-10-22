package com.gdcr.gameoflife;

public class GameOfLife {

    boolean isAliveInTheNextGeneration(Board board, Position position) {
        boolean aliveCell = board.isAliveCell(position);
        int numberOfAliveNeighbor = board.numberOfAliveNeighbor(position);
        if (aliveCell) {
            return numberOfAliveNeighbor == 2 || numberOfAliveNeighbor == 3;
        } else {
            return numberOfAliveNeighbor == 3;
        }
    };

}
