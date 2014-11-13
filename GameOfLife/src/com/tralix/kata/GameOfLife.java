package com.tralix.kata;

public class GameOfLife {

    private boolean[][] matrix;

    public boolean[][] start(final boolean[][] matrixInicial) {
        matrix = matrixInicial.clone();

        for (int i = 0; i < matrixInicial.length; i++) {
            for (int j = 0; j < matrixInicial[i].length; j++) {
                matrix[i][j] = countSurroundingLivingNeighbors(i, j, matrixInicial) >= 2 ? true : false;
            }
        }
        return matrixInicial;
    }

    public int countSurroundingLivingNeighbors(final int i, final int j, final boolean[][] matrix) {
        final int iInf = getInfRow(i);
        final int jInf = getInfRow(j);
        final int iSup = getSupRow(i, matrix.length);
        final int jSup = getSupRow(j, matrix[0].length);
        int count = 0;
        System.out.println("evaluate i = " + i + ", j = " + j);
        System.out.println(i + " " + j + " " + iInf + " " + iSup + " " + jInf + " " + jSup);
        for (int ii = iInf; ii <= iSup; ii++) {
            for (int jj = jInf; jj <= jSup; jj++) {
                System.out.print(matrix[ii][jj]);
                System.out.print(" " + i + " " + j + " " + ii + " " + jj + " " + !((ii == i) && (jj == j)));
                if (matrix[ii][jj] == true && !((ii == i) && (jj == j)))
                    count++;
            }
            System.out.println();
        }
        System.out.println("count = " + count);
        return count;
    }

    private int getInfRow(final int i) {
        return (i == 0) ? 0 : i - 1;
    }

    private int getSupRow(int i, int length) {
        System.out.println(i + " " + length);
        return (i + 1 >= length) ? length - 1 : i + 1;
    }

}
