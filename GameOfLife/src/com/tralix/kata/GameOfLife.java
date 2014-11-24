package com.tralix.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GameOfLife {

	public Boolean[][] start(final Boolean[][] matrixInicial) {
		return IntStream
				.range(0, matrixInicial.length)
				.mapToObj(
						x -> IntStream
								.range(0, matrixInicial[x].length)
								.mapToObj(
										y -> getNewStatus(matrixInicial[x][y],
												countSurroundingLivingNeighbors(x, y, matrixInicial)))
								.toArray(Boolean[]::new)).toArray(Boolean[][]::new);
	}

	public Boolean[][] sameSizeArray(final Boolean[][] input) {
		return new Boolean[input.length][input[0].length];
	}

	private Boolean getNewStatus(final Boolean cel, final int aliveCells) {
		if (aliveCells == 3)
			return true;
		if (aliveCells > 3)
			return false;
		if (aliveCells >= 2)
			return cel;
		return false;
	}

	public int countSurroundingLivingNeighbors(final int i, final int j, final Boolean[][] matrix) {
		final int iInf = getInfRow(i);
		final int jInf = getInfRow(j);
		final int iSup = getSupRow(i, matrix.length);
		final int jSup = getSupRow(j, matrix[0].length);
		return (int) Arrays
				.stream(IntStream
						.rangeClosed(iInf, iSup)
						.mapToObj(
								x -> IntStream.rangeClosed(jInf, jSup)
										.mapToObj(y -> matrix[x][y] && !((x == i) && (y == j))).toArray(Boolean[]::new))
						.toArray(Boolean[][]::new)).flatMap(x -> Arrays.stream(x)).filter(x -> x.booleanValue())
				.count();
	}

	private int getInfRow(final int i) {
		return (i == 0) ? 0 : i - 1;
	}

	private int getSupRow(int i, int length) {
		return (i + 1 >= length) ? length - 1 : i + 1;
	}

}
