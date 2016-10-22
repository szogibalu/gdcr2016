package com.gdcr.gameoflife;

public interface Board {

    boolean isAliveCell(Position position);

    int numberOfAliveNeighbor(Position position);

}
