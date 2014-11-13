package com.tralix.kata;

import static org.junit.Assert.assertArrayEquals;

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
    public void tableroDe2x2_dosCelulasVivas_todasEstanMuertas() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { { T, T }, { F, F } };
        boolean[][] matrixEsperada = new boolean[][] { { F, F }, { F, F } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe2x2_tresCelulasVivas_todasEstanVivas() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { { T, T }, { T, F } };
        boolean[][] matrixEsperada = new boolean[][] { { T, T }, { T, T } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe2x2_todasLasCelulasVivas_todasSiguenVivas() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { { T, T }, { T, T } };
        boolean[][] matrixEsperada = new boolean[][] { { T, T }, { T, T } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe3x2_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { { T, T, T }, { F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { { F, T, F }, { F, T, F } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }
}
