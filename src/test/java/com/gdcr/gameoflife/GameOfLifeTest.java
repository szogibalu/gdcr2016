package com.gdcr.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameOfLifeTest {

    GameOfLife sut;

    @Mock
    Board board;

    @Mock
    Position position;

    @Before
    public void init() {
        sut = new GameOfLife();
    }

    @Test()
    public void shouldThrowIllegalArgumentExceptionWhenNotValidPositonGiven() {
        when(board.isAliveCell(any())).thenThrow(IllegalArgumentException.class);

        assertThatThrownBy(() -> sut.isAliveInTheNextGeneration(board, position))
                .isInstanceOf(IllegalArgumentException.class);

        verify(board).isAliveCell(any());
    }

    @Test
    public void shouldDeadCellReproduceOnlyWhenThereAreExactlyThreeNeighbors() {
        when(board.isAliveCell(any())).thenReturn(false);

        when(board.numberOfAliveNeighbor(any())).thenReturn(3);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(true);
    }

    @Test
    public void shouldAliveCellDieByOverPopulationWhenItHasMoreThanThreeNeighbor() {
        when(board.isAliveCell(any())).thenReturn(true);
        when(board.numberOfAliveNeighbor(any())).thenReturn(4);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(false);

        verify(board).isAliveCell(any());
        verify(board).numberOfAliveNeighbor(any());
    }

    @Test
    public void shouldDeadCellRemainDeadWhenItHasNotExactlyThreeNeighbors() {
        when(board.isAliveCell(any())).thenReturn(false);

        when(board.numberOfAliveNeighbor(any())).thenReturn(5);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(false);
    }

    @Test
    public void shouldLiveCellDieWhenItHasLessTwoNeighbors() {
        when(board.isAliveCell(any())).thenReturn(true);

        when(board.numberOfAliveNeighbor(any())).thenReturn(1);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(false);

        verify(board).isAliveCell(any());
        verify(board).numberOfAliveNeighbor(any());
    }

    @Test
    public void shouldLiveCellSurviveWhenItHasTwoNeighbors() {
        when(board.isAliveCell(any())).thenReturn(true);

        when(board.numberOfAliveNeighbor(any())).thenReturn(2);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(true);

        verify(board).isAliveCell(any());
        verify(board).numberOfAliveNeighbor(any());
    }

    @Test
    public void shouldLiveCellDieWhenItHasZeroNeighbors() {
        when(board.isAliveCell(any())).thenReturn(true);

        when(board.numberOfAliveNeighbor(any())).thenReturn(0);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(false);

        verify(board).isAliveCell(any());
        verify(board).numberOfAliveNeighbor(any());
    }

    @Test
    public void shouldLiveCellSurviveWhenItHasThreeNeighbors() {
        when(board.isAliveCell(any())).thenReturn(true);

        when(board.numberOfAliveNeighbor(any())).thenReturn(3);

        assertThat(sut.isAliveInTheNextGeneration(board, position)).isEqualTo(true);

        verify(board).isAliveCell(any());
        verify(board).numberOfAliveNeighbor(any());
    }

}
