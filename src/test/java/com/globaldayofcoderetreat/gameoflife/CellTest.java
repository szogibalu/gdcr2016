package com.globaldayofcoderetreat.gameoflife;

import static com.globaldayofcoderetreat.gameoflife.CellImpl.aliveCell;
import static com.globaldayofcoderetreat.gameoflife.CellImpl.deadCell;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CellTest {

    @Test
    public void shoudldReturnTrueWhenTheCellIsAlive() {
        Cell underTest = aliveCell();

        boolean isAlive = underTest.isAlive();

        assertThat(isAlive).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenTheCellIsDead() {
        Cell underTest = deadCell();

        boolean isAlive = underTest.isAlive();

        assertThat(isAlive).isFalse();
    }

}
