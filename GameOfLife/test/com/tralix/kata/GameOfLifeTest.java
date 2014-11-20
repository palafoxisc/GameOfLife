package com.tralix.kata;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

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
	public void tableroDe2x2_todasLasCelulasMuertas_todasSiguenMuertas()
			throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { F, F }, { F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F }, { F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_unaCelulaViva_todasEstanMuertas() throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { T, F }, { F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F }, { F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_dosCelulasVivas_todasEstanMuertas()
			throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { T, T }, { F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F }, { F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_tresCelulasVivas_todasEstanVivas()
			throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { T, T }, { T, F } };
		boolean[][] matrixEsperada = new boolean[][] { { T, T }, { T, T } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe2x2_todasLasCelulasVivas_todasSiguenVivas()
			throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { T, T }, { T, T } };
		boolean[][] matrixEsperada = new boolean[][] { { T, T }, { T, T } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe3x2_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas()
			throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { T, T, T }, { F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, T, F }, { F, T, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe3x3_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas()
			throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { T, T, T }, { F, F, F },
				{ F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, T, F },
				{ F, T, F }, { F, F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe4x4_stillLifes_block() throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { F, F, F, F },
				{ F, T, T, F }, { F, T, T, F }, { F, F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F, F, F },
				{ F, T, T, F }, { F, T, T, F }, { F, F, F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe5x5_oscillators_blinker() throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { F, F, F, F, F },
				{ F, F, F, F, F }, { F, T, T, T, F }, { F, F, F, F, F },
				{ F, F, F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F, F, F, F },
				{ F, F, T, F, F }, { F, F, T, F, F }, { F, F, T, F, F },
				{ F, F, F, F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe5x5_oscillators_blinker2() throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { F, F, F, F, F },
				{ F, F, T, F, F }, { F, F, T, F, F }, { F, F, T, F, F },
				{ F, F, F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F, F, F, F },
				{ F, F, F, F, F }, { F, T, T, T, F }, { F, F, F, F, F },
				{ F, F, F, F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe6x6_oscillators_beacon() throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { F, F, F, F, F, F },
				{ F, T, T, F, F, F }, { F, T, F, F, F, F },
				{ F, F, F, F, T, F }, { F, F, F, T, T, F },
				{ F, F, F, F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F, F, F, F, F },
				{ F, T, T, F, F, F }, { F, T, T, F, F, F },
				{ F, F, F, T, T, F }, { F, F, F, T, T, F },
				{ F, F, F, F, F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe6x6_oscillators_beacon2() throws Exception {
		boolean[][] matrixInicial = new boolean[][] { { F, F, F, F, F, F },
				{ F, T, T, F, F, F }, { F, T, T, F, F, F },
				{ F, F, F, T, T, F }, { F, F, F, T, T, F },
				{ F, F, F, F, F, F } };
		boolean[][] matrixEsperada = new boolean[][] { { F, F, F, F, F, F },
				{ F, T, T, F, F, F }, { F, T, F, F, F, F },
				{ F, F, F, F, T, F }, { F, F, F, T, T, F },
				{ F, F, F, F, F, F } };
		boolean[][] matrixFinal = game.start(matrixInicial);
		assertArrayEquals(matrixEsperada, matrixFinal);
	}

	@Test
	public void tableroDe6x6_oscillators_beacon_loadFromFile() throws Exception {
		boolean[][] matrix = loadFromFile("test/input");
		boolean[][] expected = loadFromFile("test/expected");
		boolean[][] matrixFinal = game.start(matrix);
		assertArrayEquals(expected, matrixFinal);
	}

	private boolean[][] loadFromFile(final String file) throws Exception {
		Scanner scanner = new Scanner(new File(file));
		String alive = scanner.next();
		Integer rows = scanner.nextInt();
		Integer cols = scanner.nextInt();
		scanner.nextLine();
		boolean[][] matrix = new boolean[rows][cols];
		int i = 0;
		while (scanner.hasNext()) {
			matrix[i++] = asBooleanArray(alive, scanner.nextLine());
		}
		scanner.close();
		return matrix;
	}

	private boolean[] asBooleanArray(String alive, String nextLine) {
		String[] split = nextLine.trim().split("\\s+");
		boolean[] ret = new boolean[split.length];
		int i = 0;
		for (String str : split) {
			ret[i++] = str.equals(alive);
		}
		return ret;
	}

	private void printMatrix(boolean[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			for (int j2 = 0; j2 < matrix[j].length; j2++) {
				System.out.print(matrix[j][j2] + " ");
			}
			System.out.println();
		}
	}

}
