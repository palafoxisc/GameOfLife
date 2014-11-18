package com.tralix.kata;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    @Test
    public void tableroDe3x3_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { { T, T, T }, { F, F, F }, { F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { { F, T, F }, { F, T, F }, { F, F, F } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe4x4_stillLifes_block() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { { F, F, F, F }, { F, T, T, F }, { F, T, T, F }, { F, F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { { F, F, F, F }, { F, T, T, F }, { F, T, T, F }, { F, F, F, F } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe5x5_oscillators_blinker() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { 
                { F, F, F, F, F }, 
                { F, F, F, F, F }, 
                { F, T, T, T, F },
                { F, F, F, F, F }, 
                { F, F, F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { 
                { F, F, F, F, F }, 
                { F, F, T, F, F }, 
                { F, F, T, F, F },
                { F, F, T, F, F }, 
                { F, F, F, F, F } };
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }
    
    @Test
    public void tableroDe5x5_oscillators_blinker2() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { 
                { F, F, F, F, F }, 
                { F, F, T, F, F }, 
                { F, F, T, F, F },
                { F, F, T, F, F }, 
                { F, F, F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { 
                { F, F, F, F, F }, 
                { F, F, F, F, F }, 
                { F, T, T, T, F },
                { F, F, F, F, F }, 
                { F, F, F, F, F } }; 
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }
    
    @Test
    public void tableroDe6x6_oscillators_beacon() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { 
                { F, F, F, F, F, F }, 
                { F, T, T, F, F, F }, 
                { F, T, F, F, F, F },
                { F, F, F, F, T, F },
                { F, F, F, T, T, F },
                { F, F, F, F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { 
                { F, F, F, F, F, F }, 
                { F, T, T, F, F, F }, 
                { F, T, T, F, F, F },
                { F, F, F, T, T, F },
                { F, F, F, T, T, F },
                { F, F, F, F, F, F } }; 
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }
    
    @Test
    public void tableroDe6x6_oscillators_beacon2() throws Exception {
        boolean[][] matrixInicial = new boolean[][] { 
                { F, F, F, F, F, F }, 
                { F, T, T, F, F, F }, 
                { F, T, T, F, F, F },
                { F, F, F, T, T, F },
                { F, F, F, T, T, F },
                { F, F, F, F, F, F } };
        boolean[][] matrixEsperada = new boolean[][] { 
                { F, F, F, F, F, F }, 
                { F, T, T, F, F, F }, 
                { F, T, F, F, F, F },
                { F, F, F, F, T, F },
                { F, F, F, T, T, F },
                { F, F, F, F, F, F } }; 
        boolean[][] matrixFinal = game.start(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }
    
//    @Test
//    public void readInputFromFile() throws Exception {
//        File input = new File("test/input");
//        Scanner scanner = new Scanner(input);
//        
//        String alive = scanner.next();
//        String dead = scanner.next();
//        Integer rows = scanner.nextInt();
//        Integer cols = scanner.nextInt();
//        
//        boolean[][] matrix = new boolean[rows][cols]; 
//        int i = 0;
//        while (scanner.hasNext()) {
//            String nextLine = scanner.nextLine();
//            matrix[i] = asBooleanArray(nextLine);
//        }
//        
//        scanner.nextLine();
//        System.out.println(alive);
//        System.out.println(dead);
//        System.out.println(rows);
//        System.out.println(cols);
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());
//    }
//
//    private boolean[] asBooleanArray(String alive, String dead, String nextLine) {
//        
//        return null;
//    }
    
    //private boolean[] asArray()
    
    
}

