package com.tralix.kata;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

	private GameOfLife game;

	private static final boolean T = true;

	private static final boolean F = false;

	@Before
	public void setUp() {
		game = new GameOfLife();
	}

	@Test
	public void tableroDe2x2_todasLasCelulasMuertas_todasSiguenMuertas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { F, F }, { F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F }, { F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_unaCelulaViva_todasEstanMuertas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { T, F }, { F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F }, { F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_dosCelulasVivas_todasEstanMuertas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { T, T }, { F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F }, { F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_tresCelulasVivas_todasEstanVivas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { T, T }, { T, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { T, T }, { T, T } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_todasLasCelulasVivas_todasSiguenVivas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { T, T }, { T, T } };
		Boolean[][] matrixEsperada = new Boolean[][] { { T, T }, { T, T } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe3x2_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { T, T, T }, { F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, T, F }, { F, T, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe3x3_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { T, T, T }, { F, F, F }, { F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, T, F }, { F, T, F }, { F, F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe4x4_stillLifes_block() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { F, F, F, F }, { F, T, T, F }, { F, T, T, F }, { F, F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F, F, F }, { F, T, T, F }, { F, T, T, F }, { F, F, F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe5x5_oscillators_blinker() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { F, F, F, F, F }, { F, F, F, F, F }, { F, T, T, T, F },
				{ F, F, F, F, F }, { F, F, F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F, F, F, F }, { F, F, T, F, F }, { F, F, T, F, F },
				{ F, F, T, F, F }, { F, F, F, F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe5x5_oscillators_blinker2() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { F, F, F, F, F }, { F, F, T, F, F }, { F, F, T, F, F },
				{ F, F, T, F, F }, { F, F, F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F, F, F, F }, { F, F, F, F, F }, { F, T, T, T, F },
				{ F, F, F, F, F }, { F, F, F, F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe6x6_oscillators_beacon() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { F, F, F, F, F, F }, { F, T, T, F, F, F }, { F, T, F, F, F, F },
				{ F, F, F, F, T, F }, { F, F, F, T, T, F }, { F, F, F, F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F, F, F, F, F }, { F, T, T, F, F, F },
				{ F, T, T, F, F, F }, { F, F, F, T, T, F }, { F, F, F, T, T, F }, { F, F, F, F, F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe6x6_oscillators_beacon2() throws Exception {
		Boolean[][] matrixInicial = new Boolean[][] { { F, F, F, F, F, F }, { F, T, T, F, F, F }, { F, T, T, F, F, F },
				{ F, F, F, T, T, F }, { F, F, F, T, T, F }, { F, F, F, F, F, F } };
		Boolean[][] matrixEsperada = new Boolean[][] { { F, F, F, F, F, F }, { F, T, T, F, F, F },
				{ F, T, F, F, F, F }, { F, F, F, F, T, F }, { F, F, F, T, T, F }, { F, F, F, F, F, F } };
		Boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe6x6_oscillators_beacon_loadFromFile() throws Exception {
		Boolean[][] matrix = loadFromFile("test/input");
		Boolean[][] expected = loadFromFile("test/expected");
		Boolean[][] matrixFinal = game.start(matrix);
		assertArrayEquals(expected, matrixFinal);
	}

	private Boolean[][] loadFromFile(final String file) throws Exception {
		Scanner scanner = new Scanner(new File(file));
		String charForLivingCell = scanner.next();
		Integer rows = scanner.nextInt();
		Integer cols = scanner.nextInt();
		scanner.nextLine();
		Boolean[][] matrix = new Boolean[rows][cols];
		int i = 0;
		while (scanner.hasNext()) {
			matrix[i++] = asBooleanArray(charForLivingCell, scanner.nextLine());
		}
		scanner.close();
		return matrix;
	}

	private Boolean[] asBooleanArray(String alive, String nextLine) {
		String[] split = nextLine.trim().split("\\s+");
		Boolean[] ret = new Boolean[split.length];
		int i = 0;
		for (String str : split) {
			ret[i++] = str.equals(alive);
		}
		return ret;
	}

	private void printMatrix(Boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

}
