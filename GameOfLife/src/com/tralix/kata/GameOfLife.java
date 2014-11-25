package com.tralix.kata;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GameOfLife {

	public Boolean[][] start(final Boolean[][] input) {
		return IntStream.range(0, input.length)
				.mapToObj(x -> process(x, input))
				.toArray(Boolean[][]::new);
	}

	private Boolean[] process(final int x, final Boolean[][] input) {
		return IntStream.range(0, input[x].length)
				.mapToObj(y -> new Celula(livingNeighbors(x, y , input), input[x][y]))
				.map(cel -> cel.newEstado())
				.toArray(Boolean[]::new);
	}
	
	public int livingNeighbors(final int i, final int j, final Boolean[][] matrix) {
		return (int) Arrays.stream(subMatrix(i, j, matrix))
				.flatMap(x -> Arrays.stream(x))
				.filter(x -> x.booleanValue())
				.count();
	}

	private Boolean[][] subMatrix(final int i, final int j, final Boolean[][] matrix) {
		return IntStream
				.rangeClosed(getInfRow(i), getSupRow(i, matrix.length))
				.mapToObj(x -> subArray(x, i, j, matrix))
				.toArray(Boolean[][]::new);
	}

	private Boolean[] subArray(int currentRow, final int i, final int j, final Boolean[][] matrix) {
		return IntStream
				.rangeClosed(getInfRow(j), getSupRow(j, matrix[currentRow].length))
				.mapToObj(currentCol -> matrix[currentRow][currentCol] && !((currentRow == i) && (currentCol == j)))
				.toArray(Boolean[]::new);
	}

	private int getInfRow(final int i) {
		return (i == 0) ? 0 : i - 1;
	}

	private int getSupRow(int i, int length) {
		return (i + 1 >= length) ? length - 1 : i + 1;
	}

	private class Celula {
		private final int vecinos;
		private final boolean estado;

		public Celula(final int vecinos, final boolean estado) {
			this.vecinos = vecinos;
			this.estado = estado;
		}

		public boolean newEstado() {
			if (vecinos == 3)
				return true;
			if (vecinos > 3)
				return false;
			if (vecinos >= 2)
				return estado;
			return false;
		}
		
	}
	
}
