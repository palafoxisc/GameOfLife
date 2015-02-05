package com.tralix.kata;

import static org.junit.Assert.assertArrayEquals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

import org.junit.Before;
import org.junit.Ignore;
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
        Boolean[][] matrixInicial = new Boolean[][]{
                {F, F},
                {F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F},
                {F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe2x2_unaCelulaViva_todasEstanMuertas() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {T, F},
                {F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F},
                {F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe2x2_dosCelulasVivas_todasEstanMuertas() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {T, T},
                {F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F},
                {F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe2x2_tresCelulasVivas_todasEstanVivas() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {T, T},
                {T, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {T, T},
                {T, T}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe2x2_todasLasCelulasVivas_todasSiguenVivas() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {T, T},
                {T, T}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {T, T},
                {T, T}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe3x2_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {T, T, T},
                {F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, T, F},
                {F, T, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe3x3_LasCelulasDeLaPrimerFilaVivas_dosQuedanVivas() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {T, T, T},
                {F, F, F},
                {F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, T, F},
                {F, T, F},
                {F, F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe4x4_stillLifes_block() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {F, F, F, F},
                {F, T, T, F},
                {F, T, T, F},
                {F, F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F, F, F},
                {F, T, T, F},
                {F, T, T, F},
                {F, F, F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe5x5_oscillators_blinker() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {F, F, F, F, F},
                {F, F, F, F, F},
                {F, T, T, T, F},
                {F, F, F, F, F},
                {F, F, F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F, F, F, F},
                {F, F, T, F, F},
                {F, F, T, F, F},
                {F, F, T, F, F},
                {F, F, F, F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe5x5_oscillators_blinker2() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {F, F, F, F, F},
                {F, F, T, F, F},
                {F, F, T, F, F},
                {F, F, T, F, F},
                {F, F, F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F, F, F, F},
                {F, F, F, F, F},
                {F, T, T, T, F},
                {F, F, F, F, F},
                {F, F, F, F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe6x6_oscillators_beacon() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {F, F, F, F, F, F},
                {F, T, T, F, F, F},
                {F, T, F, F, F, F},
                {F, F, F, F, T, F},
                {F, F, F, T, T, F},
                {F, F, F, F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F, F, F, F, F},
                {F, T, T, F, F, F},
                {F, T, T, F, F, F},
                {F, F, F, T, T, F},
                {F, F, F, T, T, F},
                {F, F, F, F, F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe6x6_oscillators_beacon2() throws Exception {
        Boolean[][] matrixInicial = new Boolean[][]{
                {F, F, F, F, F, F},
                {F, T, T, F, F, F},
                {F, T, T, F, F, F},
                {F, F, F, T, T, F},
                {F, F, F, T, T, F},
                {F, F, F, F, F, F}};
        Boolean[][] matrixEsperada = new Boolean[][]{
                {F, F, F, F, F, F},
                {F, T, T, F, F, F},
                {F, T, F, F, F, F},
                {F, F, F, F, T, F},
                {F, F, F, T, T, F},
                {F, F, F, F, F, F}};
        Boolean[][] matrixFinal = game.nextGen(matrixInicial);
        assertArrayEquals(matrixEsperada, matrixFinal);
    }

    @Test
    public void tableroDe6x6_oscillators_beacon_loadFromFile() throws Exception {
        Boolean[][] matrix = loadFromFile("GameOfLife/test/resources/input");
        Boolean[][] expected = loadFromFile("GameOfLife/test/resources/expected");
        Boolean[][] matrixFinal = game.nextGen(matrix);
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
        while (scanner.hasNext() && i < rows) {
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

    @Ignore
    @Test
    public void functionalTest() throws Exception {

        class PanelImagen extends JPanel {

            private static final long serialVersionUID = 3021002827327520771L;

            private final ImageIcon imageIcon;

            private final Image imagen;

            public PanelImagen(final LayoutManager layout, final String image) {
                super(layout);
                imageIcon = new ImageIcon(image);
                imagen = imageIcon.getImage();
            }

            @Override
            public void paint(final Graphics g) {
                super.paint(g);
                g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }

        class Ventana extends JFrame {

            private static final long serialVersionUID = -3186299787704089181L;

            private final JPanel jPanel;

            public Ventana(final int filas, final int columnas) {
                jPanel = new PanelImagen(new GridLayout(filas, columnas, 0, 0), "test/resources/earth.jpg");
                this.add(jPanel);
                setSize(columnas * 15, filas * 15);
            }

            public void setMatriz(final Boolean[][] matriz) {
                jPanel.removeAll();
                for (final Boolean[] array : matriz) {
                    for (final Boolean isAlive : array) {
                        JLabel jLabel = new JLabel();
                        jLabel.setOpaque(isAlive);
                        jLabel.setBackground(isAlive ? Color.YELLOW : Color.BLACK);
                        jPanel.add(jLabel);
                    }
                }
                this.revalidate();
            }

        }

        Boolean[][] matrix = loadFromFile("test/resources/chelis");
        Ventana ventana = new Ventana(matrix.length, matrix[0].length);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setMatriz(matrix);
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            ventana.setMatriz(matrix = game.nextGen(matrix));
        }
    }

}
