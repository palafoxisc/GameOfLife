package com.tralix.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GameOfLife {

	private Boolean[][] matrix;

	public Boolean[][] start(final Boolean[][] matrixInicial) {
		matrix = clone(matrixInicial);
		IntStream.range(0, matrix.length).forEach(
				x -> Arrays.setAll(matrix[x],
						y -> getNewStatus(matrixInicial[x][y], countSurroundingLivingNeighbors(x, y, matrixInicial))));
		return matrix;
	}

	public Boolean[][] clone(final Boolean[][] input) {
		// final Boolean[][] output = new Boolean[input.length][];
		// IntStream.range(0, input.length).forEach(x -> output[x] =
		// input[x].clone());
		return IntStream.range(0, input.length).mapToObj(x -> input[x].clone()).toArray(Boolean[][]::new);
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
