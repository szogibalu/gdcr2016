package com.gdcr.gameoflife;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RuleEngineTest {

    @Mock
    private Board board;

    private RuleEngine ruleEngine;

    @Before
    public void setUp() {
        this.ruleEngine = new RuleEngine();
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenPositionIsOutOfBoardBounds() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenThrow(new IllegalArgumentException("Position is out of bounds!"));

        Assertions.assertThatThrownBy(() -> ruleEngine.isAliveOnNextGeneration(board, -1, 100))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Position is out of bounds");

    }

    @Test
    public void shoudlReturnFalseWhenItHasLessThanTwoNeighborsAndItIsAlive() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(1);

        Mockito.when(board.isAliveCell(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(true);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(false);

    }

    @Test
    public void shouldReturnFalseWhenThereAreNoNeighbors() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(0);

        Mockito.when(board.isAliveCell(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(true);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(false);
    }

    @Test
    public void shouldReturnTrueWhenThereAreTWoNeighbors() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(2);

        Mockito.when(board.isAliveCell(anyInt(), Mockito.anyInt()))
                .thenReturn(true);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(true);

        verify(board).getNumberOfAliveNeighbors(anyInt(), anyInt());
        verify(board).isAliveCell(anyInt(), anyInt());

    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeNeighbors() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(3);

        Mockito.when(board.isAliveCell(anyInt(), Mockito.anyInt()))
                .thenReturn(true);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(true);

        verify(board).getNumberOfAliveNeighbors(anyInt(), anyInt());
        verify(board).isAliveCell(anyInt(), anyInt());
    }

    @Test
    public void shouldReturnFalseWhenMoreThanThreeNeighbors() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(4);

        Mockito.when(board.isAliveCell(anyInt(), Mockito.anyInt()))
                .thenReturn(true);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(false);

        verify(board).getNumberOfAliveNeighbors(anyInt(), anyInt());
        verify(board).isAliveCell(anyInt(), anyInt());
    }

    @Test
    public void shouldReturnTrueWhenThereAreExactlyThreeNeighborsAndTheCellWasDead() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(3);

        Mockito.when(board.isAliveCell(anyInt(), Mockito.anyInt()))
                .thenReturn(false);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfTheCellIsDeadAndDoesNotHaveExacltyThreeNeighbors() {
        Mockito.when(board.getNumberOfAliveNeighbors(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(3);

        Mockito.when(board.isAliveCell(anyInt(), Mockito.anyInt()))
                .thenReturn(false);

        Assertions.assertThat(ruleEngine.isAliveOnNextGeneration(board, 0, 0)).isEqualTo(false);
    }

}
