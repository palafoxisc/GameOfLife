package com.nestor.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GameOfLife {

    public Boolean[][] nextGen(final Boolean[][] matrix) {
        return IntStream.range(0, matrix.length)
                .mapToObj(i -> process(i, matrix))
                .toArray(Boolean[][]::new);
    }

    private Boolean[] process(final int i, final Boolean[][] matrix) {
        return IntStream.range(0, matrix[i].length)
                .mapToObj(j -> new Cell(livingNeighbors(i, j, matrix), matrix[i][j]))
                .map(Cell::isAlive)
                .toArray(Boolean[]::new);
    }

    private int livingNeighbors(final int i, final int j, final Boolean[][] matrix) {
        return (int) Arrays.stream(subMatrix(i, j, matrix))
                .flatMap(Arrays::stream)
                .filter(x -> x)
                .count();
    }

    private Boolean[][] subMatrix(final int i, final int j, final Boolean[][] matrix) {
        return IntStream.rangeClosed(getInfRow(i), getSupRow(i, matrix.length))
                .mapToObj(row -> subArray(row, i, j, matrix))
                .toArray(Boolean[][]::new);
    }

    private Boolean[] subArray(int row, final int i, final int j, final Boolean[][] matrix) {
        return IntStream.rangeClosed(getInfRow(j), getSupRow(j, matrix[row].length))
                .mapToObj(col -> matrix[row][col] && !((row == i) && (col == j)))
                .toArray(Boolean[]::new);
    }

    private int getInfRow(final int i) {
        return (i == 0) ? 0 : i - 1;
    }

    private int getSupRow(final int i, final int length) {
        return (i + 1 >= length) ? length - 1 : i + 1;
    }

    private final class Cell {
        private final int neighbors;
        private final boolean status;

        public Cell(final int neighbors, final boolean status) {
            this.neighbors = neighbors;
            this.status = status;
        }

        public boolean isAlive() {
            if (neighbors == 3)
                return true;
            if (neighbors > 3)
                return false;
            if (neighbors >= 2)
                return status;
            return false;
        }
    }
}
