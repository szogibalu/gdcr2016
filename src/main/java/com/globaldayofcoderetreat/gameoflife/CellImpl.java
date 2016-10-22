package com.globaldayofcoderetreat.gameoflife;

public class CellImpl implements Cell {

    private final boolean isAlive;

    private CellImpl(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public static Cell deadCell() {
        return new CellImpl(false);
    }

    public static Cell aliveCell() {
        return new CellImpl(true);
    }

}
