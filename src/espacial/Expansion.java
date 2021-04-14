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
 * @author koke
 */
public class Expansion {

    public static Image Expande(Image imagen, int r1, int r2) {
        Image nueva = null;
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(imagen);
        Color color;
        Color aux;
        //  System.out.println(jSlider1.getValue());
        for (int j = 0; j < bi.getWidth(); j++) {
            for (int m = 0; m < bi.getHeight(); m++) {
                color = new Color(bi.getRGB(j, m));

                int r = verificar((color.getRed() - r1) * (255 / r2 - r1)); // (0-255)
                int g = verificar((color.getGreen() - r1) * (255 / r2 - r1)); // (0-255)
                int b = verificar((color.getBlue() - r1) * (255 / r2 - r1)); // (0-255)
                //int med = (r + g + b) / 3
                aux = new Color(r, g, b);
                bi.setRGB(j, m, aux.getRGB());

            }
        }
        nueva = herramientas.HerramientasImagen.toImage(bi);
        return nueva;
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
