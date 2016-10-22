package com.gdcr.gameoflife;

public interface Board {

    int getNumberOfAliveNeighbors(int x, int y);

    boolean isAliveCell(int x, int y);

}
