/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacial;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author KOKE
 */
public class Traslacion {
    
    public static Image aplicarLienzoAoriginal(Image imagenOriginal, int nxn) {

        //aqui creamos el lienzo
        BufferedImage biNegro = new BufferedImage(nxn, nxn, BufferedImage.TYPE_INT_RGB);
        for (int n = 0; n < biNegro.getHeight(); n++) {
            for (int n1 = 0; n1 < biNegro.getWidth(); n1++) {
                Color color = new Color(0, 0, 0);
                biNegro.setRGB(n, n, color.getRGB());
            }
        }

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);
        Color color;

        int x, y, aux;
        for (y = 0; y < bi.getHeight(); y++) {
            for (x = 0; x < bi.getWidth(); x++) {
                color = new Color(bi.getRGB(x, y));

                try {
                    biNegro.setRGB(x, y, color.getRGB());
                } catch (Exception e) {
                }

            }
        }
        return herramientas.HerramientasImagen.toImage(biNegro);

    }
    
    public static Image aplicarTraslacion(int trasladaX, int trasladaY, Image imagenOriginal, int nxn) {

        //aqui creamos el lienzo
        BufferedImage biNegro = new BufferedImage(nxn, nxn, BufferedImage.TYPE_INT_RGB);
        for (int n = 0; n < biNegro.getHeight(); n++) {
            for (int n1 = 0; n1 < biNegro.getWidth(); n1++) {
                Color color = new Color(0, 0, 0);
                biNegro.setRGB(n, n, color.getRGB());
            }
        }

        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagenOriginal);        
        Color color;

        int x, y, aux;
        for (y = 0; y < bi.getHeight(); y++) {
            for (x = 0; x < bi.getWidth(); x++) {
                color = new Color(bi.getRGB(x, y));

                try {
                    biNegro.setRGB(x+trasladaX, y+trasladaY, color.getRGB());
                } catch (Exception e) {
                }

            }
        }
        return herramientas.HerramientasImagen.toImage(biNegro);

    }

}
