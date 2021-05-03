/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;
import java.awt.Color;

/**
 *
 * @author KOKE
 */
public class Convolucion {

    private static int[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
    private static int[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
    private static int[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
    private static int[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
    private static int[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
    private static int[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
    private static int[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
    private static int[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
    public static int[][][] arregloMascarasKIRCH = {kirsch1, kirsch2, kirsch3, kirsch4, kirsch5, kirsch6, kirsch7, kirsch8};

    public static Image aplicarConvolucion(Image imagen, int[][] mascara, int div, int offset) {

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
        // recorres el buffer
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                int rgb = calcularNuevoTono(x, y, bi, mascara, div, offset);
                bnuevo.setRGB(x, y, rgb);
            }
        }
        return herramientas.HerramientasImagen.toImage(bnuevo);
    }

    public static Image aplicarConvolucionKIRCH(Image imagen) {

        Image nueva = null;
        int tamMASK = arregloMascarasKIRCH[0][1].length;
        int[][] mascaraAUX = new int[tamMASK][tamMASK];
        for (int mascaraN = 0; mascaraN < arregloMascarasKIRCH.length; mascaraN++) {

            for (int x = 0; x < tamMASK; x++) {
                for (int y = 0; y < tamMASK; y++) {
                    mascaraAUX[x][y] = arregloMascarasKIRCH[mascaraN][x][y];
                    System.out.print(mascaraAUX[x][y] + " ");
                }
                System.out.println(" ");
            }
            System.out.println(" ");
            nueva = aplicarConvolucion(imagen, mascaraAUX, 0, 0);
            mascaraAUX = new int[tamMASK][tamMASK];
        }

        return nueva;
    }

    public static int calcularNuevoTono(int x, int y, BufferedImage original, int[][] mascara, int div, int offset) {
        int auxx = 0, auxy = 0;
        if (mascara.length == 3) {
            auxx = x - 1;
            auxy = y - 1;
        } else if (mascara.length == 5) {
            auxx = x - 2;
            auxy = y - 2;
        }
        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        for (int i = 0; i < mascara.length; i++) {
            for (int j = 0; j < mascara.length; j++) {
                try {
                    if (mascara[i][j] != 0) {
                        color = new Color(original.getRGB(auxx, auxy));
                        auxR += color.getRed() * mascara[i][j];
                        auxG += color.getGreen() * mascara[i][j];
                        auxB += color.getBlue() * mascara[i][j];
                    }
                } catch (Exception e) {

                }
                auxy++;
            }
            auxx++;
            if (mascara.length == 3) {
                auxy = y - 1;
            } else if (mascara.length == 5) {
                auxy = y - 2;
            }
        }
        if (div != 0) {
            auxR /= div;
            auxG /= div;
            auxB /= div;
        }
        color = new Color(verificar(auxR + offset), verificar(auxG + offset), verificar(auxB + offset));
        return color.getRGB();
    }

    public static int verificar(int valor) {
        if (valor > 255) {
            return 255;
        }
        if (valor < 0) {
            return 0;
        }
        return valor;
    }


}
