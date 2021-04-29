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

    public static Image aplicarConvolucion(Image imagen,int[][] mascara, int div, int offset){

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        // recorres el buffer
        for(int x=0; x < bi.getWidth();x++){
            for(int y=0; y < bi.getHeight();y++){
            int rgb = calcularNuevoTono(x,y,bi,mascara, div, offset);
            bnuevo.setRGB(x, y, rgb);
            }
        }
        return herramientas.HerramientasImagen.toImage(bnuevo);
    }

    private static int calcularNuevoTono(int x, int y, BufferedImage bi, int[][] mascara, int div, int offset) {

        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        int k = 0;
        for (int i = 0, r = x - 1; i < mascara.length; i++, r++) {
            for (int j = 0, c = y - 1; j < mascara[0].length; j++, c++) {

                if (mascara[i][j] != 0) {
                    try {
                        int rgb = bi.getRGB(r, c);
                        k++;
                        color = new Color(rgb);

                        auxR += color.getRed() * mascara[i][j];
                        auxG += color.getGreen() * mascara[i][j];
                        auxB += color.getBlue() * mascara[i][j];

                    } catch (Exception e) {

                    }
                }
            }
        }

        if (k != 0) {
            auxR /= div;
            auxG /= div;
            auxB /= div;
            
        }
        color = new Color(verificar(auxR+offset),verificar(auxG+offset),verificar(auxB+offset));
        //System.out.println("R "+color.getRed()+"   G "+color.getGreen()+"   B "+color.getBlue());
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
