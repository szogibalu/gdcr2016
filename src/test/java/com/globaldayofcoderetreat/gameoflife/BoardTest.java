package com.globaldayofcoderetreat.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BoardTest {

    @Test
    public void shouldReturnWithTheNumberOfNeighbors() {
        Board board = new BoardImpl();

        int numberOfAliveCells = board.getAliveNeighborsOf(0, 0);

        assertThat(numberOfAliveCells).isEqualTo(1);
    }

}
