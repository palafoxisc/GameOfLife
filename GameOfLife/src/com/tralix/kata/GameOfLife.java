package com.tralix.kata;

public class GameOfLife {

    private boolean[][] matrix;

    public boolean[][] start(final boolean[][] matrixInicial) {
        matrix = new boolean[matrixInicial.length][matrixInicial[0].length];
        for (int i = 0; i < matrixInicial.length; i++) {
            for (int j = 0; j < matrixInicial[i].length; j++) {
                matrix[i][j] = getNewStatus(matrixInicial[i][j], countSurroundingLivingNeighbors(i, j, matrixInicial));
            }
        }
        return matrix;
    }

    private boolean getNewStatus(final boolean cel, final int aliveCells) {
        if (aliveCells == 3)
            return true;
        if (aliveCells > 3)
            return false;
        if (aliveCells >= 2)
            return cel;
        return false;
    }

    public int countSurroundingLivingNeighbors(final int i, final int j, final boolean[][] matrix) {
        final int iInf = getInfRow(i);
        final int jInf = getInfRow(j);
        final int iSup = getSupRow(i, matrix.length);
        final int jSup = getSupRow(j, matrix[0].length);
        int count = 0;
        for (int ii = iInf; ii <= iSup; ii++) {
            for (int jj = jInf; jj <= jSup; jj++) {
                if (matrix[ii][jj] == true && !((ii == i) && (jj == j)))
                    count++;
            }
        }
        return count;
    }

    private int getInfRow(final int i) {
        return (i == 0) ? 0 : i - 1;
    }

    private int getSupRow(int i, int length) {
        return (i + 1 >= length) ? length - 1 : i + 1;
    }

}
